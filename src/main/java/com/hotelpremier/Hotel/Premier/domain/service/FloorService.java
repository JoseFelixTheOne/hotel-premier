package com.hotelpremier.Hotel.Premier.domain.service;

import com.hotelpremier.Hotel.Premier.domain.Floor;
import com.hotelpremier.Hotel.Premier.domain.repository.FloorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FloorService {
    @Autowired
    private FloorRepository floorRepository;

    public List<Floor> getAll() {
        return floorRepository.getAll();
    }

    public Optional<Floor> getFloor(int idfloor) {
        return  floorRepository.getFloor(idfloor);
    }

    public Floor save(Floor floor) {
        return floorRepository.save(floor);
    }

    public Floor update(Floor floor) {
        int idfloor = floor.getIdfloor();
        Floor piso = getFloor(idfloor).map(f -> {
            BeanUtils.copyProperties(floor, f);
            return f;
        }).orElseThrow(() -> new EntityNotFoundException("Floor not found with ID: " + idfloor));
        return floorRepository.save(piso);
    }

    public boolean delete(int idfloor) {
        if(getFloor(idfloor).isPresent()) {
            floorRepository.delete(idfloor);
            return true;
        }else {
            return false;
        }
    }
}
