package com.demoproduct.controller;


import com.demoproduct.entities.Product;
import com.demoproduct.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


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

    @GetMapping("/delete")
    public String deleteProduct(@RequestParam Long id){
        productRepository.deleteById(id);
        return "redirect:/products";
    }

    @GetMapping("/addProduct")
    public String addProduct(Product product, Model model){
        model.addAttribute(product);
        return "new-product";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(@Valid Product product , BindingResult bindingResult , Model model){
        if(bindingResult.hasErrors()){
//            model.addAttribute("Recheck the informations");
            return "new-product";
        }
        productRepository.save(product);
        return "redirect:/products";
    }


}
