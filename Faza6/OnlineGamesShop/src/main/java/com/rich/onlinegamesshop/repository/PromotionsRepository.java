package com.rich.onlinegamesshop.repository;

import com.rich.onlinegamesshop.model.Promotions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionsRepository extends JpaRepository<Promotions, Long> {
}
