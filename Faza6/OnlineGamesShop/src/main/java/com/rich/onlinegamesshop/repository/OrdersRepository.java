package com.rich.onlinegamesshop.repository;

import com.rich.onlinegamesshop.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer>{
}
