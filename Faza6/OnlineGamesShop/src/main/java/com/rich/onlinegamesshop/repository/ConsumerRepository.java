package com.rich.onlinegamesshop.repository;

import com.rich.onlinegamesshop.model.Costumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumerRepository extends JpaRepository<Costumer, Long>{
}
