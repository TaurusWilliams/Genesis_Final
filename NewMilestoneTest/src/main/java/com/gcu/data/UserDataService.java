package com.gcu.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.UserEntity;
import com.gcu.data.repository.UsersRepository;

@Service
public class UserDataService implements UserDataAccessInterface<UserEntity>, DataAccessInterface<UserEntity>{

    @Autowired
    UsersRepository usersRepository;
    
    public UserDataService(UsersRepository UsersRepository){
        
    }
    
    @Override
    public List<UserEntity> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public UserEntity findById(String id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean create(UserEntity user) {
        try 
        {
            this.usersRepository.save(user);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean update(UserEntity t) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(UserEntity t) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public UserEntity findByUsername(String username) {
        // TODO Auto-generated method stub
        return usersRepository.findByUsername(username);
    }

    
}
