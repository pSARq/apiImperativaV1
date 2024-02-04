package com.api.imperativa.imperativa.services;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.imperativa.imperativa.models.UserModel;
import com.api.imperativa.imperativa.repositories.UserRepository;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ArrayList<UserModel> findAll() {
        return (ArrayList<UserModel>) userRepository.findAll();
    }

    public UserModel save(UserModel userModel) {
        Objects.requireNonNull(userModel);
        return userRepository.save(userModel);
    }

    public Optional<UserModel> findById(Long id) {
        Objects.requireNonNull(id);
        return userRepository.findById(id);
    }

    public ArrayList<UserModel> findByPriority(Integer priority) {
        return userRepository.findByPriority(priority);
    }

    public boolean deleteById(Long id) {
        try {
            Objects.requireNonNull(id);
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
