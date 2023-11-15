package com.hotelpremier.Hotel.Premier.domain.service;

import com.hotelpremier.Hotel.Premier.domain.UserType;
import com.hotelpremier.Hotel.Premier.domain.repository.UserTypeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserTypeService {
    @Autowired
    private UserTypeRepository userTypeRepository;
    public List<UserType> getAll(){
        return userTypeRepository.getAll();
    }
    public Optional<UserType> getUserType(int userTypeId) {
        return userTypeRepository.getUserType(userTypeId);
    }
    public Optional<UserType> getUserTypeByName(String name){
        return userTypeRepository.getUserTypeByName(name);
    }
    public UserType save(UserType userType) {
        return userTypeRepository.save(userType);
    }
    public UserType update(UserType userType){
        int userTypeId = userType.getUserTypeId();
        UserType type = getUserType(userTypeId).map(t ->{
            BeanUtils.copyProperties(userType, t);
            return t;
        }).orElseThrow(() -> new EntityNotFoundException("UserType not found with ID: " + userTypeId));
        return userTypeRepository.save(type);
    }
    public boolean delete(int userTypeId){
        if (getUserType(userTypeId).isPresent()){
            userTypeRepository.delete(userTypeId);
            return true;
        }else {
            return false;
        }
    }
}
