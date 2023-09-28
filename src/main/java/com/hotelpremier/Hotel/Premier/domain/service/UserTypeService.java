package com.hotelpremier.Hotel.Premier.domain.service;

import com.hotelpremier.Hotel.Premier.domain.UserType;
import com.hotelpremier.Hotel.Premier.domain.repository.UserTypeRepository;
import com.hotelpremier.Hotel.Premier.persistence.entity.TipoUsuario;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserTypeService {
    @Autowired
    private UserTypeRepository userTypeRepository;

    public List<UserType> getAll(){
        return userTypeRepository.getAll();
    }

    public Optional<UserType> getUserType(int userTypeId) {
        return userTypeRepository.getUserType(userTypeId);
    }

    public UserType save(UserType userType) {
        return userTypeRepository.save(userType);
    }

    public void delete(int userTypeId){
        userTypeRepository.delete(userTypeId);
    }
}
