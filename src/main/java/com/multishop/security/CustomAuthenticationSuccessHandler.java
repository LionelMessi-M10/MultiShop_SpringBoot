package com.multishop.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import java.io.IOException;
import java.util.Collection;

public class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (GrantedAuthority authority : authorities) {
            String authorityName = authority.getAuthority();
            // Kiểm tra từng vai trò và thực hiện chuyển hướng tương ứng
            switch (authorityName) {
                case "ROLE_CUSTOMER" -> {
                    getRedirectStrategy().sendRedirect(request, response, "/shop/home");
                    return;
                }
                case "ROLE_ADMIN" -> {
                    getRedirectStrategy().sendRedirect(request, response, "/admin");
                    return;
                }
                case "ROLE_SELLER" -> {
                    getRedirectStrategy().sendRedirect(request, response, "/seller");
                    return;
                }
            }
        }
        // Nếu không khớp với bất kỳ vai trò nào, bạn có thể chuyển hướng đến một trang mặc định hoặc xử lý khác
        getRedirectStrategy().sendRedirect(request, response, "/shop/login?error");
    }
}

