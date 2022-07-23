package com.samuelgsouza.samuelsdeliver.services;

import com.samuelgsouza.samuelsdeliver.dto.ProductDTO;
import com.samuelgsouza.samuelsdeliver.entities.Product;
import com.samuelgsouza.samuelsdeliver.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public List<ProductDTO> findAll() {
        List<Product> list = repository.findAllByOrderByNameAsc();
        return list.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
    }
}
