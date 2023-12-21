package com.rich.onlinegamesshop.model.views;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.View;

@Data
@Entity
@Immutable
@Table(name = "storeview")
@NoArgsConstructor
@AllArgsConstructor
public class StoreView {

    @Id
    private Integer id_game;
    private String title;
    private String genre;
    private String publisher_name;
    private String website;
    private String platform_name;
    private String manufacturer;
}
