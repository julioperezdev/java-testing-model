package dev.julioperez.usingMocks.service.implementation;

import dev.julioperez.usingMocks.entity.CartEntity;
import dev.julioperez.usingMocks.entity.ProductEntity;
import dev.julioperez.usingMocks.repository.CartRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.UUID;


import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
class CartServiceImplementationTest {

    @Mock
    private CartRepository cartRepository;

    @InjectMocks
    private CartServiceImplementation underTest;

    private List<CartEntity> cartEntityList;

    @BeforeEach
    void setup(){

        ProductEntity javaProductEntity = ProductEntity.builder()
                .id(UUID.randomUUID())
                .name("java")
                .price(218L)
                .provider("oracle")
                .quantity(3L)
                .build();
        ProductEntity cSharpProductEntity = ProductEntity.builder()
                .id(UUID.randomUUID())
                .name("c#")
                .price(102L)
                .provider("microsoft")
                .quantity(4L)
                .build();
        CartEntity cartEntityWithJavaProduct = CartEntity.builder()
                .id(UUID.randomUUID())
                .totalPrice(javaProductEntity.getPrice())
                .createdAt(Date.from(Instant.now()))
                .products(List.of(javaProductEntity))
                .build();
        CartEntity cartEntityWithCSharpProduct = CartEntity.builder()
                .id(UUID.randomUUID())
                .totalPrice(cSharpProductEntity.getPrice())
                .createdAt(Date.from(Instant.now()))
                .products(List.of(cSharpProductEntity))
                .build();
        cartEntityList = List.of(cartEntityWithJavaProduct, cartEntityWithCSharpProduct);
    }

    @Nested
    public class createCartsCases{
        @Test
        void itShouldCreateCartsHappyCase(){
            //given
            //when
            //then
        }
    }

}