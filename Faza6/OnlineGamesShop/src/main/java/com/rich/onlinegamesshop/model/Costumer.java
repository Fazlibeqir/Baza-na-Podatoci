package com.rich.onlinegamesshop.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Costumer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_costumer;

    @Column(nullable = false)
    String username;

    @Column(nullable = false)
    String email;

    @Column(nullable = false)
    String password;

    public Costumer(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
