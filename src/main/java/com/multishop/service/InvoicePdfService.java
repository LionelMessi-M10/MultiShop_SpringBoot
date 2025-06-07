package com.multishop.service;

import java.io.File;

import com.multishop.entity.OrderEntity;

public interface InvoicePdfService {

	File generateInvoicePdf(OrderEntity order) throws Exception;
}
