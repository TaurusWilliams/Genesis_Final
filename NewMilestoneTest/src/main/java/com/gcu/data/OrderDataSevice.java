package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.ProductEntity;
import com.gcu.data.repository.OrdersRepository;

@Service
public class OrderDataSevice implements DataAccessInterface<ProductEntity> {
    
    @Autowired
    private OrdersRepository ordersRepository;
    
    public OrderDataSevice(OrdersRepository ordersRepository) 
    {
        this.ordersRepository = ordersRepository;
    }
    
    @Override
    public List<ProductEntity> findAll() {
        List<ProductEntity> orders = new ArrayList<ProductEntity>();
        try 
        {
            Iterable<ProductEntity> ordersIterable = ordersRepository.findAll();
            
            orders = new ArrayList<ProductEntity>();
            ordersIterable.forEach(orders::add);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        return orders;
    }

    @Override
    public ProductEntity findById(String id) {
        return ordersRepository.getOrderById(id);
    }

    @Override
    public boolean create(ProductEntity order) {
        try 
        {
            this.ordersRepository.save(order);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean update(ProductEntity t) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(ProductEntity product) {
        try 
        {
            this.ordersRepository.deleteById(product.getId());;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
