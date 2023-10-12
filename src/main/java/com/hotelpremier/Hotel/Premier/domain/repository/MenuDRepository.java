package com.hotelpremier.Hotel.Premier.domain.repository;

import com.hotelpremier.Hotel.Premier.domain.MenuD;
import java.util.List;
import java.util.Optional;

public interface MenuDRepository {
    List<MenuD> getAll();
    Optional<MenuD> getMenu(int idMenu);
    MenuD save(MenuD menuD);
    void delete(int idMenu);
}
