package com.hotelpremier.Hotel.Premier.domain.repository;

import com.hotelpremier.Hotel.Premier.domain.UserType;

import java.util.List;
import java.util.Optional;

public interface UserTypeRepository {
    List<UserType> getAll();
    Optional<UserType> getUserType(int userTypeId);
    UserType save(UserType userType);
    void delete(int userTypeId);
}
