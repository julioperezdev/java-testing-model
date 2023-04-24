package dev.julioperez.usingMocks.service.implementation;

import dev.julioperez.usingMocks.dto.PublicInformationProduct;
import dev.julioperez.usingMocks.mapper.ProductMapper;
import dev.julioperez.usingMocks.entity.ProductEntity;
import dev.julioperez.usingMocks.model.ProductModel;
import dev.julioperez.usingMocks.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;
@ExtendWith(MockitoExtension.class)
class ProductServiceImplementationTest {

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductMapper productMapper;

    @InjectMocks
    private ProductServiceImplementation underTest;

    private List<UUID> uuidList;
    private List<PublicInformationProduct> publicInformationProductList;
    private List<ProductEntity> productEntityList;
    private List<ProductModel> productModelList;

    @BeforeEach
    void setup(){
        uuidList = List.of(UUID.randomUUID(), UUID.randomUUID());
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
        ProductModel javaProductModel = ProductModel.builder()
                .id(javaProductEntity.getId())
                .name(javaProductEntity.getName())
                .price(javaProductEntity.getPrice())
                .provider(javaProductEntity.getProvider())
                .quantity(javaProductEntity.getQuantity())
                .build();
        ProductModel cSharpProductModel = ProductModel.builder()
                .id(cSharpProductEntity.getId())
                .name(cSharpProductEntity.getName())
                .price(cSharpProductEntity.getPrice())
                .provider(cSharpProductEntity.getProvider())
                .quantity(cSharpProductEntity.getQuantity())
                .build();
        publicInformationProductList = List.of(javaPublicInformationProduct, cSharpPublicInformationProduct);
        productEntityList = List.of(javaProductEntity, cSharpProductEntity);
        productModelList = List.of(javaProductModel, cSharpProductModel);
    }

    @Nested
    public class getProductsByIdListCases{
        @Test
        void itShouldGetProductsByIdListHappyCase(){
            //given
            given(productMapper.uuidToProductEntity(publicInformationProductList)).willReturn(uuidList);
            given(productRepository.findAllById(uuidList)).willReturn(productEntityList);
            given(productMapper.toProductModelList(productEntityList)).willReturn(productModelList);
            //when
            List<ProductModel> result = underTest.getProductsByIdList(publicInformationProductList);
            //then
            assertThat(uuidList.size()).isEqualTo(2);
            assertThat(publicInformationProductList.size()).isEqualTo(2);
            assertThat(productEntityList.size()).isEqualTo(2);
            assertThat(productModelList.size()).isEqualTo(2);
            assertThat(result).isNotNull();
            assertThat(result.size()).isEqualTo(2);
            assertThat(result).isNotEmpty();
            verify(productMapper, atMostOnce()).uuidToProductEntity(anyList());
            verify(productRepository, atMostOnce()).findAllById(anyList());
            verify(productMapper, atMostOnce()).toProductModelList(productEntityList);
        }
    }
}