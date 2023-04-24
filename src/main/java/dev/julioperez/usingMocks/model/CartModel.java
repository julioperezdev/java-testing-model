package dev.julioperez.usingMocks.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CartModel {
    private UUID id;
    private Long totalPrice;
    private Date createdAt;
    private List<ProductModel> products;
}
