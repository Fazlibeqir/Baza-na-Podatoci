package com.rich.onlinegamesshop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long publisherId;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String website;

    @Column(nullable = false)
    String country;

    public Publisher(String name, String website, String country) {
        this.name = name;
        this.website = website;
        this.country = country;
    }
}
