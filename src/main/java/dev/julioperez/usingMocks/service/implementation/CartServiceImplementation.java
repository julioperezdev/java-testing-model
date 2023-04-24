package dev.julioperez.usingMocks.service.implementation;


import dev.julioperez.usingMocks.dto.PublicInformationCart;
import dev.julioperez.usingMocks.mapper.CartMapper;
import dev.julioperez.usingMocks.repository.CartRepository;
import dev.julioperez.usingMocks.service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class CartServiceImplementation implements CartService {

    private final CartRepository cartRepository;
    private final CartMapper cartMapper;


    @Override
    public List<PublicInformationCart> createCarts(List<PublicInformationCart> cartsList) {
        return null;
    }
}
