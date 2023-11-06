package com.hotelpremier.Hotel.Premier.domain.repository;

import com.hotelpremier.Hotel.Premier.domain.MenuD;
import java.util.List;
import java.util.Optional;

public interface MenuDRepository {
    List<MenuD> getAll();
    List<MenuD> getAllActive();
    List<MenuD> getAllInactive();
    Optional<MenuD> getMenuD(int menuId);
    MenuD save(MenuD menuD);
    void delete(int menuId);
}
