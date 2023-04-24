package dev.julioperez.usingMocks.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Builder
public class PublicInformationCart {
    private UUID cartId;
    private List<PublicInformationProduct> publicInformationProducts;
    private Long totalPrice;
}
