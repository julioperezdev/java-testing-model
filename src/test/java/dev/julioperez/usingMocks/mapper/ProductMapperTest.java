package dev.julioperez.usingMocks.mapper;

import dev.julioperez.usingMocks.dto.PublicInformationProduct;
import dev.julioperez.usingMocks.entity.ProductEntity;
import dev.julioperez.usingMocks.model.ProductModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;
@ExtendWith(MockitoExtension.class)
class ProductMapperTest {

    @InjectMocks
    private ProductMapper productMapper;
    private List<ProductEntity> productEntityList;

    @BeforeEach
    void setup(){
        List<UUID> uuidList = List.of(UUID.randomUUID(), UUID.randomUUID());
        PublicInformationProduct javaPublicInformationProduct = PublicInformationProduct.builder()
                .productId(uuidList.get(0))
                .productName("java")
                .productPrice(218L)
                .build();
        PublicInformationProduct cSharpPublicInformationProduct = PublicInformationProduct.builder()
                .productId(uuidList.get(1))
                .productName("c#")
                .productPrice(102L)
                .build();
        ProductEntity javaProductEntity = ProductEntity.builder()
                .id(javaPublicInformationProduct.getProductId())
                .name(javaPublicInformationProduct.getProductName())
                .price(javaPublicInformationProduct.getProductPrice())
                .provider("oracle")
                .quantity(3L)
                .build();
        ProductEntity cSharpProductEntity = ProductEntity.builder()
                .id(cSharpPublicInformationProduct.getProductId())
                .name(cSharpPublicInformationProduct.getProductName())
                .price(cSharpPublicInformationProduct.getProductPrice())
                .provider("microsoft")
                .quantity(4L)
                .build();
        productEntityList = List.of(javaProductEntity, cSharpProductEntity);
    }


    @Test
    void itShouldMapToProductModelHappyCase(){
        //given
        //when
        List<ProductModel> result = productMapper.toProductModelList(productEntityList);
        //then
        assertThat(productEntityList.size()).isEqualTo(2);
        assertThat(result).isNotNull();
        assertThat(result).isNotEmpty();
        assertThat(result.size()).isEqualTo(2);
    }

}