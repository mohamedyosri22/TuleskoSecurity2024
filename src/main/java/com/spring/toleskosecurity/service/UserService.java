package com.spring.toleskosecurity.service;

import com.spring.toleskosecurity.UserRepo;
import com.spring.toleskosecurity.model.User;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepo userRepo;
    private final BCryptPasswordEncoder encoder;

    private final AuthenticationManager authManager;
    private final JwtService jwtService;


    public User register(User user){
        User userDb = new User();

        userDb.setPassword(encoder.encode(user.getPassword()));
        userDb.setUserName(user.getUserName());
        userDb.setId(user.getId());

        return userRepo.save(userDb);
    }

    public String verify(User user){
        Authentication auth =
                authManager
                        .authenticate(
                                new UsernamePasswordAuthenticationToken(user.getUserName(),
                                        user.getPassword()));
        if (auth.isAuthenticated()){
            return jwtService.GenerateToken(user);
        }
        else
            return "failed";
    }
}
