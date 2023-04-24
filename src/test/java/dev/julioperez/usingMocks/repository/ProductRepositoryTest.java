package dev.julioperez.usingMocks.repository;

import dev.julioperez.usingMocks.entity.ProductEntity;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository underTest;


    @Nested
    public class createProductsCases{
        @Test
        void itShouldCreateMultiplesProductHappyCase(){
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

            List<ProductEntity> productEntities = List.of(javaProduct, cSharpProduct);
            //when
            List<ProductEntity> result = underTest.saveAll(productEntities);
            //then
            assertThat(result).isNotNull();
            assertThat(result.isEmpty()).isFalse();
            assertThat(result).contains(javaProduct);
            assertThat(result).contains(cSharpProduct);
            assertThat(result.size()).isEqualTo(2);
        }
    }

    @Nested
    public class getProductsByIdListCases{
        @Test
        void itShouldGetProductsByIdListHappyCase(){
            //given
            List<UUID> uuids = List.of(UUID.randomUUID(), UUID.randomUUID());
            ProductEntity javaProduct = ProductEntity.builder()
                    .id(uuids.get(0))
                    .name("java")
                    .price(218L)
                    .provider("oracle")
                    .quantity(3L)
                    .build();
            ProductEntity cSharpProduct = ProductEntity.builder()
                    .id(uuids.get(1))
                    .name("c#")
                    .price(102L)
                    .provider("microsoft")
                    .quantity(4L)
                    .build();

            List<ProductEntity> productEntities = List.of(javaProduct, cSharpProduct);
            //List<ProductEntity> productEntitiesSaved = underTest.saveAll(productEntities);
            underTest.saveAll(productEntities);
            //when
            List<ProductEntity> result = underTest.findAllById(uuids);
            //then
            assertThat(result).isNotNull();
            assertThat(result.isEmpty()).isFalse();
            assertThat(result).contains(javaProduct);
            assertThat(result).contains(cSharpProduct);
            assertThat(result.size()).isEqualTo(2);
        }
        @Test
        void itShouldGetExistsProductsByIdListThatHaveOneUUIDThatDoesNotExist(){
            //given
            UUID uuidThatDoesNotExist = UUID.randomUUID();
            List<UUID> uuids = List.of(UUID.randomUUID(), UUID.randomUUID(), uuidThatDoesNotExist);
            ProductEntity javaProduct = ProductEntity.builder()
                    .id(uuids.get(0))
                    .name("java")
                    .price(218L)
                    .provider("oracle")
                    .quantity(3L)
                    .build();
            ProductEntity cSharpProduct = ProductEntity.builder()
                    .id(uuids.get(1))
                    .name("c#")
                    .price(102L)
                    .provider("microsoft")
                    .quantity(4L)
                    .build();

            List<ProductEntity> productEntities = List.of(javaProduct, cSharpProduct);
            underTest.saveAll(productEntities);
            //when
            List<ProductEntity> result = underTest.findAllById(uuids);
            //then
            assertThat(result).isNotNull();
            assertThat(result.isEmpty()).isFalse();
            assertThat(result).contains(javaProduct);
            assertThat(result).contains(cSharpProduct);
            assertThat(result.size()).isEqualTo(2);
            assertThat(result.stream().anyMatch(productEntityResult ->
                    productEntityResult.getId().equals(uuidThatDoesNotExist)))
                    .isFalse();
        }
    }

}