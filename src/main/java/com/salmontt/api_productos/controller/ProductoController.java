package com.salmontt.api_productos.controller;


import com.salmontt.api_productos.model.Producto;
import com.salmontt.api_productos.repository.ProductoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoRepository repo;

    public ProductoController(ProductoRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Producto> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public Producto create(@RequestBody Producto p) {
        return repo.save(p);
    }
}
