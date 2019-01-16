package com.lendos.onlinestore.repos;

import com.lendos.onlinestore.domain.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepo extends CrudRepository<Order, Long> {
}
