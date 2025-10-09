package com.demoproduct.controller;


import com.demoproduct.entities.Product;
import com.demoproduct.repository.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.List;
@Controller
public class ProductController {

    ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    public String getAllProducts(Model model){
       List<Product> products = productRepository.findAll();
       model.addAttribute("productList" ,products );
       return "products";
    }

    @DeleteMapping("/delete")
    public String deleteProduct(Long id){
        productRepository.deleteById(id);
        return "redirect:/products";
    }


}
