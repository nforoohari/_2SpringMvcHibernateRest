package ir.digixo.controller;


import ir.digixo.entity.Product;
import ir.digixo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class C02ProductRestController {


    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable(name = "id")  Long id)
    {
       return productService.findById(id);

    }


    @GetMapping
    public List<Product> ListOfProducts()
    {
        List<Product> products = productService.findAll();
        return products;
    }


    @PostMapping
    public Product saveProduct(@RequestBody Product product)
    {
        productService.save(product);
        return product;
    }


    //todo: update
    @PutMapping
   public Product updateProduct(@RequestBody Product product)
   {
       productService.save(product);
       return product;
   }


    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable(name = "id") Long id)
    {
       productService.delete(id);
        return "product deleted";
    }

}
