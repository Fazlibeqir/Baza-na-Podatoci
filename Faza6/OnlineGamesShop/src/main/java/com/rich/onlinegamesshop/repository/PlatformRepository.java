package com.rich.onlinegamesshop.repository;

import com.rich.onlinegamesshop.model.Platform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatformRepository extends JpaRepository<Platform, Integer>{
}
