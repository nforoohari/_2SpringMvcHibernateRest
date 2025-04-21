package ir.digixo.controller;

import ir.digixo.entity.Product;
import ir.digixo.service.ProductService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class C02ProductRestController {

    private final ProductService productService;

    public C02ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> ListOfProducts() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable(name = "id") Long id) {
        return productService.findById(id);
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product product) {
        productService.save(product);
        return product;
    }

    @PutMapping
    public Product updateProduct(@RequestBody Product product) {
        productService.save(product);
        return product;
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable(name = "id") Long id) {
        productService.delete(id);
        return "product deleted";
    }

}
