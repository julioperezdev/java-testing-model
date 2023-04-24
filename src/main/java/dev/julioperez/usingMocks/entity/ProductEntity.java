package dev.julioperez.usingMocks.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "PRODUCT")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ProductEntity {
    @Id
    private UUID id;
    private String name;
    private Long price;
    private Long quantity;
    private String provider;
    @ManyToMany(mappedBy = "products")
    private List<CartEntity> cart = new ArrayList<>();

    public ProductEntity(UUID id, String name, Long price, Long quantity, String provider) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.provider = provider;
    }
}
