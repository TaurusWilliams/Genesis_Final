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
    
    /**
     * This method isnt called in our code but its used by the
     * spring boot framework. it finds a user and asign it the rol user
     * if the user is null it throws a UsernameNotFoundException
     */
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

    /**
     * This method requests a user model then takes the password or the user model then incripts it.
     * after thats done it takes all the info from the user model exept the normal password 
     * and pastes it into a user entity. then it puts the encrypted password into the password variable
     * and sends it to the data access layer.
     * @param userModel
     */
    public void addUser(UserModel userModel) {
        String password = new BCryptPasswordEncoder().encode(userModel.getPassword());
        UserEntity userEntity = new UserEntity(null,userModel.getUsername(),password,userModel.getFirstName(),userModel.getLastName(),userModel.getEmail(),userModel.getPhoneNumber());
        service.create(userEntity);
    }
}
