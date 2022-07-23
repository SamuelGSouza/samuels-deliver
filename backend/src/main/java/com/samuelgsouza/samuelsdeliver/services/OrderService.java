package com.samuelgsouza.samuelsdeliver.services;

import com.samuelgsouza.samuelsdeliver.dto.OrderDTO;
import com.samuelgsouza.samuelsdeliver.dto.ProductDTO;
import com.samuelgsouza.samuelsdeliver.entities.Order;
import com.samuelgsouza.samuelsdeliver.entities.OrderStatus;
import com.samuelgsouza.samuelsdeliver.entities.Product;
import com.samuelgsouza.samuelsdeliver.repositories.OrderRepository;
import com.samuelgsouza.samuelsdeliver.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<OrderDTO> findAll() {
        List<Order> list = repository.findOrdersWithProducts();
        return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
    }

    @Transactional
    public OrderDTO insert(OrderDTO dto){
        Order order = new Order(null, dto.getAddress(), dto.getLatitude(), dto.getLongitude(), Instant.now(), OrderStatus.PENDING);

        for (ProductDTO p: dto.getProducts()){
            Product product = productRepository.getById(p.getId());
            order.getProducts().add(product);
        }

        order = repository.save(order);

        return new OrderDTO(order);
    }

    @Transactional
    public OrderDTO setDelivered(Long id){
        Order order = repository.getOne(id);
        order.setStatus(OrderStatus.DELIVERED);
        order = repository.save(order);
        return new OrderDTO(order);
    }
}
