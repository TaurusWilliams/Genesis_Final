package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gcu.data.UserDataService;
import com.gcu.data.entity.UserEntity;
import com.gcu.model.UserModel;

@Service
public class UserBusinessService implements UserDetailsService {

    @Autowired
    private UserDataService service;
    
    public UserBusinessService(UserDataService service) {
        this.service = service;
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = service.findByUsername(username);
        if(user != null) {
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority("USER"));
            return new User(user.getUsername(), user.getPassword(), authorities);
        }
        else
        {
            throw new UsernameNotFoundException("username not found");
        }
    }

    
    public void addUser(UserModel userModel) {
        String password = new BCryptPasswordEncoder().encode(userModel.getPassword());
        UserEntity userEntity = new UserEntity(null,userModel.getUsername(),password,userModel.getFirstName(),userModel.getLastName(),userModel.getEmail(),userModel.getPhoneNumber());
        service.create(userEntity);
    }
}
