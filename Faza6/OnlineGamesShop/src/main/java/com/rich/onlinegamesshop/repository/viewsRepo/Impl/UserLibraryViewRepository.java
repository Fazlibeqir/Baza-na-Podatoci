package com.rich.onlinegamesshop.repository.viewsRepo.Impl;

import com.rich.onlinegamesshop.model.views.UserLibraryView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserLibraryViewRepository extends JpaRepository<UserLibraryView,String> {

    @Query(value = "SELECT * FROM userlibraryview", nativeQuery = true)
    List<UserLibraryView> findAll();
}
