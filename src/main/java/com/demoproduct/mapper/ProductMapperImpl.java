package com.demoproduct.mapper;

import com.demoproduct.dtos.CategoryDTO;
import com.demoproduct.dtos.ProductDTO;
import com.demoproduct.entities.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ProductMapperImpl {
    public Product fromProductDTOTOProduct (ProductDTO productDTO){
//        if(productDTO == null) return null;
        Product product = new Product();
        BeanUtils.copyProperties(productDTO, product);
        return product;

    }
    /*public ProductDTO fromProductToProductDTO (Product product){
        ProductDTO productDTO = new ProductDTO();
        BeanUtils.copyProperties(product, productDTO);
        return productDTO;
    }*/

    public ProductDTO fromProductToProductDTO(Product product) {
        if (product == null) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();

        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        productDTO.setQuantity(product.getQuantity());

        // Handle the Category (nested object)
        if (product.getCategory() != null) {
            CategoryDTO categoryDTO = new CategoryDTO();
            categoryDTO.setName(product.getCategory().getName());
            productDTO.setCategoryDTO(categoryDTO);
        }

        return productDTO;
    }
}
