package com.subbu.springsecurity.service;

import com.subbu.springsecurity.model.User;
import com.subbu.springsecurity.model.UserPrinciPal;
import com.subbu.springsecurity.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class MyUserDetailsService implements UserDetailsService {


    private final UserRepo userRepo;

    public MyUserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("Received username: " + username);
        User user = userRepo.findByUsername(username);
//        System.out.println("Received username: " + username);
        System.out.println(user);
        if (user == null) {
            throw new UsernameNotFoundException("User Not Found!");
        }
        return new UserPrinciPal(user);
    }
}
