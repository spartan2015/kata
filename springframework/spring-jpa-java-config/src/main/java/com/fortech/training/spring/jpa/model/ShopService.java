package com.fortech.training.spring.jpa.model;

import java.util.List;

public interface ShopService {
    
    public Shop create(Shop shop);
    public Shop delete(int id) throws ShopNotFound;
    public List<Shop> findAll();
    public Shop update(Shop shop) throws ShopNotFound;
    public Shop findById(int id);
 
}