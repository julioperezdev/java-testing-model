package dev.julioperez.usingMocks.service;


import dev.julioperez.usingMocks.dto.PublicInformationProduct;
import dev.julioperez.usingMocks.model.ProductModel;

import java.util.List;

public interface ProductService {
    List<ProductModel> getProductsByIdList(List<PublicInformationProduct> publicInformationProductIdList);
    List<ProductModel> createProducts(List<ProductModel> newProducts);
}
