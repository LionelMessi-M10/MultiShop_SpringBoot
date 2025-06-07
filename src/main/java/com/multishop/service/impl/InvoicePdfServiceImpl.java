package com.multishop.service.impl;

import java.io.File;

import org.springframework.stereotype.Service;

import com.multishop.entity.OrderEntity;
import com.multishop.service.InvoicePdfService;

@Service
public class InvoicePdfServiceImpl implements InvoicePdfService {

	@Override
	public File generateInvoicePdf(OrderEntity order) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
