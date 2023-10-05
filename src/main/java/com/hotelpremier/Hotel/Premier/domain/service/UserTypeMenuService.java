package com.hotelpremier.Hotel.Premier.domain.service;

import com.hotelpremier.Hotel.Premier.domain.UserTypeMenu;
import com.hotelpremier.Hotel.Premier.domain.repository.UserTypeMenuRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserTypeMenuService {
    @Autowired
    private UserTypeMenuRepository userTypeMenuRepository;
    public List<UserTypeMenu> getAll(){
        return userTypeMenuRepository.getAll();
    }
    public Optional<UserTypeMenu> getUserTypeMenu(int idMenuTipoUsuario){
        return userTypeMenuRepository.getUserTypeMenu(idMenuTipoUsuario);
    }
    public Optional<List<UserTypeMenu>> getRolesByUserType(int idUserType) {
        return userTypeMenuRepository.getRolesByUserType(idUserType);
    }

    public Optional<List<UserTypeMenu>> getRolesByMenu(int idMenu){
        return userTypeMenuRepository.getRolesByMenu(idMenu);
    }
    public UserTypeMenu save(UserTypeMenu userTypeMenu){
        return userTypeMenuRepository.save(userTypeMenu);
    }
    public UserTypeMenu update(UserTypeMenu userTypeMenu){
        int idUserTypeMenu = userTypeMenu.getIdUserTypeMenu();
        UserTypeMenu utm = getUserTypeMenu(idUserTypeMenu).map(m ->{
            BeanUtils.copyProperties(userTypeMenu, m);
            return m;
        }).orElseThrow(() -> new EntityNotFoundException("UserType not found with ID: " + idUserTypeMenu));
        return userTypeMenuRepository.save(utm);
    }
    public boolean delete(int idMenuTipoUsuario){
        if(getUserTypeMenu(idMenuTipoUsuario).isPresent()){
            userTypeMenuRepository.delete(idMenuTipoUsuario);
            return true;
        }
        else{
            return false;
        }
    }
}
