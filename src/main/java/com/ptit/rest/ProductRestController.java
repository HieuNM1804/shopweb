package com.ptit.rest;

import com.ptit.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ptit.service.ProductService;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/products")
public class ProductRestController {
    @Autowired
    ProductService productService;

    @GetMapping
    public List<Object> getAll() {
        return productService.findAllDTO();
    }

    @GetMapping("{id}")
    public Object getOne(@PathVariable("id") Integer id) {
        return productService.findDTOById(id);
    }

    @PostMapping
    public Product create(@RequestBody Object dto) {
        return productService.createFromDTO(dto);
    }

    @PutMapping("{id}")
    public Product update(@PathVariable("id") Integer id, @RequestBody Object dto) {
        return productService.updateFromDTO(dto);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id) {
        productService.delete(id);
    }
}
