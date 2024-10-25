package com.example.GiuaKy.services;

import com.example.GiuaKy.models.users;
import com.example.GiuaKy.repository.usersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class usersService {
    @Autowired
    private usersRepository userRepository;


    public List<users> findAll() {
        return userRepository.findAll();
    }


    public users findById(int id) {
        return userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found"));
    }


    public users save(users user) {
        return userRepository.save(user);
    }


    public users update(users user) {
        return userRepository.save(user);
    }

    public void delete(int id) {
        userRepository.deleteById(id);
    }
}
