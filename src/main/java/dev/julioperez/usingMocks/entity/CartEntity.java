package dev.julioperez.usingMocks.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Entity
@Table(name = "CART")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CartEntity {

    @Id
    private UUID id;
    @Column(name="TOTAL_PRICE")
    private Long totalPrice;
    @Column(name="CREATED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "CART_PRODUCT",
            joinColumns = @JoinColumn(name = "CART_ID"),
            inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID"))
    private List<ProductEntity> products = new ArrayList<>();
}
