package com.hotelpremier.Hotel.Premier.domain.service;

import com.hotelpremier.Hotel.Premier.domain.MenuD;
import com.hotelpremier.Hotel.Premier.domain.repository.MenuDRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MenuDService {
    @Autowired
    private MenuDRepository menuDRepository;

    public List<MenuD> getAll() {
        return menuDRepository.getAll();
    }
    public List<MenuD> getAllActive() {
        return menuDRepository.getAllActive();
    }
    public List<MenuD> getAllInactive() {
        return menuDRepository.getAllInactive();
    }
    public Optional<MenuD> getMenuD(int menuId){
        MenuD menu = menuDRepository.getMenuD(menuId).get();
        if(menu.getMenuActive().equals("A")){
            return menuDRepository.getMenuD(menuId);
        }
        else{
            return menuDRepository.getMenuD(0);
        }
    }
    public MenuD save(MenuD menuD){
        menuD.setMenuActive("A");
        return menuDRepository.save(menuD);
    }
    public MenuD update(MenuD menuD){
        int idMenu = menuD.getMenuId();
        MenuD menu = getMenuD(idMenu).map(m ->{
            BeanUtils.copyProperties(menuD, m);
            return m;
        }).orElseThrow(() -> new EntityNotFoundException("Menu not found using ID: " + idMenu));
        return menuDRepository.save(menu);
    }
    public void delete(int menuId){
        if(getMenuD(menuId).isPresent()) {
            MenuD menu = menuDRepository.getMenuD(menuId).get();
            menu.setMenuActive("I");
            menuDRepository.save(menu);
        }
        else{
            System.out.println("ERROR 404 : MENU NOT FOUND");
        }
    }
}
