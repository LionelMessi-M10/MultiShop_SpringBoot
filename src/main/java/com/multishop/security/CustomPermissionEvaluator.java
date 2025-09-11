package com.multishop.security;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.multishop.entity.Shop;
import com.multishop.entity.User;
import com.multishop.repository.ShopRepository;
import com.multishop.repository.UserRepository;
import com.multishop.repository.UserShopPermissionRepository;

import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CustomPermissionEvaluator implements PermissionEvaluator {
    private final UserRepository userRepository;
    private final ShopRepository shopRepository;
    private final UserShopPermissionRepository shopPermissionRepository;

    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        // Not used with @PreAuthorize(hasPermission(...))
        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
        String username = authentication.getName();
        Optional<User> userOptional = userRepository.findByEmail(username);

        if (!userOptional.isPresent()) {
            return false;
        }
        User user = userOptional.get();

        if (authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            return true;
        }

        if ("shop".equalsIgnoreCase(targetType) && targetId instanceof Long) {
            Optional<Shop> shopOptional = shopRepository.findById((Long) targetId);
            if (!shopOptional.isPresent()) {
                return false;
            }
            Shop shop = shopOptional.get();

            // Kiểm tra tài khoản chính
            if (user.isMainAccount() && shop.getSeller().getId().equals(user.getId())) {
                return true;
            }

            // Kiểm tra quyền của tài khoản phụ
            return shopPermissionRepository.findByUserAndShopAndPermissionName(user, shop, (String) permission).isPresent();
        }

        return false;
    }
}