package dev.julioperez.usingMocks.controller;

import dev.julioperez.usingMocks.dto.PublicInformationProduct;
import dev.julioperez.usingMocks.entity.ProductEntity;
import dev.julioperez.usingMocks.model.ProductModel;
import dev.julioperez.usingMocks.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/test2")
    public List<ProductModel> getProductsByIdList(){
        List<ProductModel> productsByIdList = productService.getProductsByIdList(fakeProductModelWithUUID());
        productsByIdList.addAll(productsByIdList);
        return productsByIdList;
    }
    @GetMapping("/test")
    public List<ProductModel> createProduct(){
        List<ProductModel> productModels = fakeProductModel();
        return productService.createProducts(productModels);
    }

    private List<PublicInformationProduct> fakeProductModelWithUUID(){
        List<UUID> uuids = List.of(UUID.fromString("7365d2f4-0609-43d7-b1b1-51e9f33a0882"), UUID.fromString("e78cf942-577c-4d03-8b87-a0004bf5944d"));
        PublicInformationProduct productModelA = new PublicInformationProduct(uuids.get(0), "java", 444L);
        PublicInformationProduct productModelB = new PublicInformationProduct(uuids.get(1), "python", 111L);
        return List.of(productModelA, productModelB);
    }

    private List<ProductModel> fakeProductModel(){
        List<UUID> uuids = List.of(UUID.fromString("7365d2f4-0609-43d7-b1b1-51e9f33a0882"), UUID.fromString("e78cf942-577c-4d03-8b87-a0004bf5944d"));
        ProductModel productModelA = new ProductModel(uuids.get(0), "java", 444L, 3L, "oracle");
        ProductModel productModelB = new ProductModel(uuids.get(1), "python", 111L, 4L, "openai");
        return List.of(productModelA, productModelB);
    }
}
