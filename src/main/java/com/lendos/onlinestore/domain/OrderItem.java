package com.lendos.onlinestore.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class OrderItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ManyToOne(targetEntity = Order.class)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "item_id")
    private Item item;
    private int amount;
    private BigDecimal purchasePrice;

    public OrderItem() {
    }

    public OrderItem(Long id, Item item, int amount, BigDecimal purchaseprice) {
        this.id = id;
        this.item = item;
        this.amount = amount;
        this.purchasePrice = purchaseprice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public BigDecimal getPurchaseprice() {
        return purchasePrice;
    }

    public void setPurchaseprice(BigDecimal purchaseprice) {
        this.purchasePrice = purchaseprice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(id, orderItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
