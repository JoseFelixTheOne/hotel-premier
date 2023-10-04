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
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public UserTypeMenuService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<UserTypeMenu> getAll(){
        return userTypeMenuRepository.getAll();
    }

    public Optional<UserTypeMenu> getUserTypeMenu(int idMenuTipoUsuario){
        return userTypeMenuRepository.getUserTypeMenu(idMenuTipoUsuario);
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

    public List<Map<String, Object>> getMenus(int idMenuTipoUsuario) {
        String sql = "SELECT * FROM tb_tipousuariomenu as tum " +
                "JOIN tb_menu as m ON tum.id_menu = m.id_menu " +
                "WHERE tum.id_tipouser = " + idMenuTipoUsuario;
        return jdbcTemplate.queryForList(sql, idMenuTipoUsuario);
    }
}
