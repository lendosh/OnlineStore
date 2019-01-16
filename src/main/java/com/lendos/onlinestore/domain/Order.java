package com.lendos.onlinestore.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@EqualsAndHashCode(of = {"id"})
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime creationTime;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "orderitem_id")
    private Set<OrderItem> orderItems = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User customer;

    public Order() {
    }

    public Order(Long id, LocalDateTime creationTime, Set<OrderItem> orderItems, User user) {
        this.id = id;
        this.creationTime = creationTime;
        this.orderItems = orderItems;
        this.customer = user;
    }

    public Long getOrderid() {
        return id;
    }

    public void setOrderid(Long orderid) {
        this.id = orderid;
    }

    public LocalDateTime getCreationtime() {
        return creationTime;
    }

    public void setCreationtime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public Set<OrderItem> getOrderitems() {
        return orderItems;
    }

    public void setOrderitems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public Long getOrderId() {
        return id;
    }

    public void setOrderId(Long orderId) {
        this.id = orderId;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
