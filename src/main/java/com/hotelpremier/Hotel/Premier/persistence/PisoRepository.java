package com.hotelpremier.Hotel.Premier.persistence;

import com.hotelpremier.Hotel.Premier.domain.Floor;
import com.hotelpremier.Hotel.Premier.domain.repository.FloorRepository;
import com.hotelpremier.Hotel.Premier.persistence.crud.PisoCrudRepository;
import com.hotelpremier.Hotel.Premier.persistence.entity.Piso;
import com.hotelpremier.Hotel.Premier.persistence.mapper.FloorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PisoRepository implements FloorRepository {

    @Autowired
    private PisoCrudRepository pisoCrudRepository;

    @Autowired
    private FloorMapper mapper;
    @Override
    public List<Floor> getAll() {
        List<Piso> lista = new ArrayList<Piso>();
        try {
            var pisos = pisoCrudRepository.findAll();
            for(Piso piso : pisos){
                if(piso.getActivo().equals("a")){
                    lista.add(piso);
                }
            }
        }catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return mapper.toFloors(lista);
    }

    @Override
    public Optional<Floor> getFloor(int idfloor) {
        return pisoCrudRepository.findById(idfloor).map(piso -> mapper.toFloor(piso));
    }

    @Override
    public Floor save(Floor floor) {
        Piso piso = mapper.toPiso(floor);
        return mapper.toFloor(pisoCrudRepository.save(piso));
    }

    @Override
    public void delete(int idfloor) {
        Piso piso = pisoCrudRepository.findById(idfloor).orElse(new Piso());
        piso.setActivo("d");
        pisoCrudRepository.save(piso);
    }
}
