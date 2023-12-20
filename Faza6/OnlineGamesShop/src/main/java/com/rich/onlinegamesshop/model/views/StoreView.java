package com.rich.onlinegamesshop.model.views;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.Data;
import org.hibernate.annotations.Immutable;

@Data
@Entity
@Immutable
public class StoreView {

    @Transient
    @Id
    private Long id;
    private Integer id_game;
    private String title;
    private String genre;
    private String publisher_name;
    private String website;
    private String platform_name;
    private String manufacturer;
}
