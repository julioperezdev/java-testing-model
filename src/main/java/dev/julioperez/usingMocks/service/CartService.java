package dev.julioperez.usingMocks.service;

import dev.julioperez.usingMocks.dto.PublicInformationCart;

import java.util.List;

public interface CartService {
    List<PublicInformationCart> createCarts(List<PublicInformationCart> cartsList);
}
