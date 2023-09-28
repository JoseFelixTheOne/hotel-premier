package com.hotelpremier.Hotel.Premier.persistence;

import com.hotelpremier.Hotel.Premier.persistence.crud.TipoUsuarioCrudRepository;
import com.hotelpremier.Hotel.Premier.persistence.entity.TipoUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TipoUsuarioRepository {
    @Autowired
    private TipoUsuarioCrudRepository tipoUsuarioCrudRepository;

    public List<TipoUsuario> getAll(){
        return tipoUsuarioCrudRepository.findAll();
    }
    public Optional<TipoUsuario> getTipoUsuario(int idTipouser){
        return tipoUsuarioCrudRepository.findById(idTipouser);
    }
    public TipoUsuario save(TipoUsuario tipoUsuario){
        return tipoUsuarioCrudRepository.save(tipoUsuario);
    }
    public void delete(int idTipouser){
        tipoUsuarioCrudRepository.deleteById(idTipouser);
    }
}
