package com.example.phoneVerification2.services;

import com.example.phoneVerification2.models.User;
import com.example.phoneVerification2.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    public User createUser(User user){
        usersRepository.save(user);
        return user;
    }
    public User deleteUser(UUID id){
        User user = usersRepository.findById(id).orElse(null);
        if(user!=null){
            usersRepository.delete(user);
        }
        return user;
    }
    public List<User> findAllUsers(){
        return usersRepository.findAll();
    }

    public User findUserById(UUID id) {
        return usersRepository.findById(id).orElse(null);
    }

    public User updateUser(User user) {
        return usersRepository.save(user);
    }
}
