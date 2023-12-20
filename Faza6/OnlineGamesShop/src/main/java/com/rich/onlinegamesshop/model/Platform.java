package com.rich.onlinegamesshop.model;

import com.rich.onlinegamesshop.model.relations.GamesSupportsPlatform;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Platform {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_platform;

    private String name;

    private String manufacturer;

    private LocalDate releaseDate;

    @OneToMany(mappedBy = "id_platform")
    private List<GamesSupportsPlatform> supportedGames;

    public Platform(String name, String manufacturer, LocalDate releaseDate) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.releaseDate = releaseDate;
    }
}
