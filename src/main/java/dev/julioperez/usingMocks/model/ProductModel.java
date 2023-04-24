package dev.julioperez.usingMocks.model;


import dev.julioperez.usingMocks.entity.CartEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ProductModel {
    private UUID id;
    private String name;
    private Long price;
    private Long quantity;
    private String provider;
}
