package com.spring.toleskosecurity.config;

import com.spring.toleskosecurity.UserRepo;
import com.spring.toleskosecurity.model.User;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepo userRepo;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user1 = userRepo.findByUserName(username);
        if(user1==null){
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomUserDetails(user1);
    }
}
