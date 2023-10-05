package com.hotelpremier.Hotel.Premier.domain.repository;

import com.hotelpremier.Hotel.Premier.domain.UserTypeMenu;
import java.util.List;
import java.util.Optional;

public interface UserTypeMenuRepository {
    List<UserTypeMenu> getAll();
    Optional<UserTypeMenu> getUserTypeMenu(int idUserTypeMenu);
    Optional<List<UserTypeMenu>> getRolesByUserType(int idUserType);
    Optional<List<UserTypeMenu>> getRolesByMenu(int idMenu);
    UserTypeMenu save(UserTypeMenu userTypeMenu);
    void delete(int idUserTypeMenu);

}
