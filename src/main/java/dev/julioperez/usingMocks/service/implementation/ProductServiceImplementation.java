package dev.julioperez.usingMocks.service.implementation;


import dev.julioperez.usingMocks.dto.PublicInformationProduct;
import dev.julioperez.usingMocks.mapper.ProductMapper;
import dev.julioperez.usingMocks.entity.ProductEntity;
import dev.julioperez.usingMocks.model.ProductModel;
import dev.julioperez.usingMocks.repository.ProductRepository;
import dev.julioperez.usingMocks.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class ProductServiceImplementation implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;


    @Override
    public List<ProductModel> getProductsByIdList(List<PublicInformationProduct> publicInformationProductIdList) {
        List<UUID> productEntityUUIDs = productMapper.uuidToProductEntity(publicInformationProductIdList);
        List<ProductEntity> productEntities = productRepository.findAllById(productEntityUUIDs);
        List<ProductModel> productModels = productMapper.toProductModelList(productEntities);
        log.debug(productModels.toString());
        return productModels;
    }

    @Override
    public List<ProductModel> createProducts(List<ProductModel> newProducts) {
        //List<UUID> uuids = productMapper.uuidToProductEntity(newProduct);
        //getProductsByIdList()
        List<ProductEntity> productEntities = productMapper.toProductEntityList(newProducts);
        List<ProductEntity> productEntitiesResponse = productRepository.saveAll(productEntities);
        return productMapper.toProductModelList(productEntitiesResponse);
    }

}
