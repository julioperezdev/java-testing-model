package dev.julioperez.usingMocks.mapper;

import dev.julioperez.usingMocks.dto.PublicInformationProduct;
import dev.julioperez.usingMocks.entity.ProductEntity;

import java.util.List;

public class PublicInformationProductMapper {

    public List<PublicInformationProduct> toPublicInformationProductList(List<ProductEntity> productEntities){
        return productEntities
                .stream()
                .map(this::toPublicInformationProduct)
                .toList();
    }

    private PublicInformationProduct toPublicInformationProduct(ProductEntity productEntity){
        return new PublicInformationProduct(productEntity.getId(), productEntity.getName(), productEntity.getPrice());
    }

}
