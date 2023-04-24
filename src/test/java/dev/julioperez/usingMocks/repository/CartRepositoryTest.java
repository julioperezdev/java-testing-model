package dev.julioperez.usingMocks.repository;

import dev.julioperez.usingMocks.entity.CartEntity;
import dev.julioperez.usingMocks.entity.ProductEntity;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
class CartRepositoryTest {

    @Autowired
    private CartRepository underTest;

    @Nested
    public class createPublicInformationCartCases {
        @Test
        void itShouldCreateCartHappyCase(){
            //given
            ProductEntity javaProduct = ProductEntity.builder()
                    .id(UUID.randomUUID())
                    .name("java")
                    .price(218L)
                    .provider("oracle")
                    .quantity(3L)
                    .build();
            ProductEntity cSharpProduct = ProductEntity.builder()
                    .id(UUID.randomUUID())
                    .name("c#")
                    .price(102L)
                    .provider("microsoft")
                    .quantity(4L)
                    .build();
            CartEntity cartWithJavaProduct = CartEntity.builder()
                    .id(UUID.randomUUID())
                    .totalPrice(javaProduct.getPrice())
                    .createdAt(Date.from(Instant.now()))
                    .products(List.of(javaProduct))
                    .build();
            CartEntity cartWithCSharpProduct = CartEntity.builder()
                    .id(UUID.randomUUID())
                    .totalPrice(cSharpProduct.getPrice())
                    .createdAt(Date.from(Instant.now()))
                    .products(List.of(cSharpProduct))
                    .build();
            List<CartEntity> cartEntityList = List.of(cartWithJavaProduct, cartWithCSharpProduct);
            //when
            List<CartEntity> cartEntitiesResult = underTest.saveAll(cartEntityList);
            //then
            assertThat(cartEntitiesResult).isNotNull();
            assertThat(cartEntitiesResult.isEmpty()).isFalse();
            assertThat(cartEntitiesResult.size()).isEqualTo(2);
            assertThat(cartEntitiesResult.stream().findFirst()).get().isExactlyInstanceOf(cartWithJavaProduct.getClass());
            assertThat(cartEntitiesResult.get(0).getId()).isEqualTo(cartWithJavaProduct.getId());
        }
    }
}