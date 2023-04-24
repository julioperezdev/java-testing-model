package dev.julioperez.usingMocks.mapper;

import dev.julioperez.usingMocks.dto.PublicInformationProduct;
import dev.julioperez.usingMocks.entity.ProductEntity;
import dev.julioperez.usingMocks.model.ProductModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProductMapper {

    public List<ProductModel> toProductModelList(List<ProductEntity> productEntities){
        return productEntities
                .stream()
                .map(this::toProductModel)
                .toList();
    }

    public List<ProductEntity> toProductEntityList(List<ProductModel> productModels){
        return productModels
                .stream()
                .map(this::toProductEntity)
                .toList();
    }

    public List<UUID> uuidToProductEntity(List<PublicInformationProduct> publicInformationProductUUIDS){
        return publicInformationProductUUIDS
                .stream()
                .map(PublicInformationProduct::getProductId)
                .toList();
    }

    private ProductModel toProductModel(ProductEntity productEntity){
        return new ProductModel(
                productEntity.getId(),
                productEntity.getName(),
                productEntity.getPrice(),
                productEntity.getQuantity(),
                productEntity.getProvider());
    }
    private ProductEntity toProductEntity(ProductModel productModel){
        return new ProductEntity(productModel.getId(),
                productModel.getName(),
                productModel.getPrice(),
                productModel.getQuantity(),
                productModel.getProvider());
    }
}
