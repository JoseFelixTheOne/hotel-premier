package com.hotelpremier.Hotel.Premier.domain.repository;

import com.hotelpremier.Hotel.Premier.domain.UserType;
import com.hotelpremier.Hotel.Premier.persistence.entity.Usuario;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserTypeRepository {
    List<UserType> getAll();
    Optional<UserType> getUserType(int userTypeId);
    Optional<UserType> getUserTypeByName(String name);
    UserType save(UserType userType);
    void delete(int userTypeId);
}
