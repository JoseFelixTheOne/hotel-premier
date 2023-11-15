package com.hotelpremier.Hotel.Premier.persistence;

import com.hotelpremier.Hotel.Premier.domain.UserType;
import com.hotelpremier.Hotel.Premier.domain.repository.UserTypeRepository;
import com.hotelpremier.Hotel.Premier.persistence.crud.TipoUsuarioCrudRepository;
import com.hotelpremier.Hotel.Premier.persistence.entity.TipoUsuario;
import com.hotelpremier.Hotel.Premier.persistence.entity.Usuario;
import com.hotelpremier.Hotel.Premier.persistence.mapper.UserTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TipoUsuarioRepository implements UserTypeRepository {
    @Autowired
    private TipoUsuarioCrudRepository tipoUsuarioCrudRepository;

    @Autowired
    private UserTypeMapper mapper;

    @Override
    public List<UserType> getAll(){
        List<TipoUsuario> tipos = tipoUsuarioCrudRepository.findAll();
        return mapper.toUserTypes(tipos);
    }

    @Override
    public Optional<UserType> getUserType(int userTypeId) {
        return tipoUsuarioCrudRepository.findById(userTypeId).map(tipo -> mapper.toUserType(tipo));
    }

    @Override
    public Optional<UserType> getUserTypeByName(String name) {
        return tipoUsuarioCrudRepository.getUserTypeByName(name).map(usuario -> mapper.toUserType(usuario));
    }

    @Override
    public UserType save(UserType userType) {
        TipoUsuario tipo = mapper.toTipoUsuario(userType);
        return mapper.toUserType(tipoUsuarioCrudRepository.save(tipo));
    }

    @Override
    public void delete(int userTypeId){
        tipoUsuarioCrudRepository.deleteById(userTypeId);
    }
}
