package dev.julioperez.usingMocks.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Builder
@Getter
@AllArgsConstructor
public class PublicInformationProduct {
    private UUID productId;
    private String productName;
    private Long productPrice;
}
