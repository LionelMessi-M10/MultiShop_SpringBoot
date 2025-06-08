package com.multishop.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "order_status_logs")
@Getter
@Setter
public class OrderStatusLog extends Base {
    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    private String statusLog;
    private String note;
}
