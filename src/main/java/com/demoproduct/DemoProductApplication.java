package com.demoproduct;

import com.demoproduct.dtos.ProductDTO;
import com.demoproduct.entities.Category;
import com.demoproduct.entities.Product;
import com.demoproduct.mapper.ProductMapperImpl;
import com.demoproduct.repository.CategoryRepository;
import com.demoproduct.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
//@SpringBootApplication
public class DemoProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoProductApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepository productRepository , CategoryRepository categoryRepository,
                            ProductMapperImpl productMapper) {
        return args -> {
            Category category1= Category.builder().name("electronics").build();
            categoryRepository.save(category1);
          Product product1 = Product.builder().name("TV").price(3000).quantity(100).category(category1)
            .build();
          productRepository.save(product1);
          Product product2 = Product.builder().name("PC").price(6000).quantity(50).category(category1)
                  .build();
          productRepository.save(product2);

            List<Product> products = productRepository.findAll();
//            productMapper.fromProductToProductDTO(products);
            products.forEach((prod) -> {
               ProductDTO p = productMapper.fromProductToProductDTO(prod);
                System.out.println(p);
            } );


        };
    }

}
