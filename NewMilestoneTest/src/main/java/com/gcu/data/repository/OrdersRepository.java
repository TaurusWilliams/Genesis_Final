package com.gcu.data.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gcu.data.entity.ProductEntity;

public interface OrdersRepository extends MongoRepository<ProductEntity, String>
{
    ProductEntity getOrderById(String id);
}
