package com.api.imperativa.imperativa.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.api.imperativa.imperativa.models.UserModel;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Long> {
    
    public ArrayList<UserModel> findByPriority(Integer priority);

}
