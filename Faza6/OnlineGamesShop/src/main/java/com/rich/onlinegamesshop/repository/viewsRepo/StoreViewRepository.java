package com.rich.onlinegamesshop.repository.viewsRepo;

import com.rich.onlinegamesshop.model.views.StoreView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreViewRepository extends JpaRepository<StoreView, Long>{

    @Modifying
    @Query(value = "SELECT * FROM onlinegameshop.storeview", nativeQuery = true)
    List<StoreView> findAll();
}
