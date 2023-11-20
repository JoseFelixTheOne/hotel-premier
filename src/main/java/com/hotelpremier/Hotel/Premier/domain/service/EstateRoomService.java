package com.hotelpremier.Hotel.Premier.domain.service;

import com.hotelpremier.Hotel.Premier.domain.EstateRoom;
import com.hotelpremier.Hotel.Premier.domain.repository.EstateRoomRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EstateRoomService {
    @Autowired
    private EstateRoomRepository estateRoomRepository;
    public List<EstateRoom> getAll() {
        return estateRoomRepository.getAll();
    }
    public Optional<EstateRoom> getEstateRoom(int idestroom) {
        return estateRoomRepository.getEstateRoom(idestroom);
    }
    public EstateRoom save(EstateRoom estateRoom) {
        return estateRoomRepository.save(estateRoom);
    }
    public EstateRoom update(EstateRoom estateRoom) {
        int idestroom = estateRoom.getIdestroom();
        EstateRoom estado = getEstateRoom(idestroom).map(e ->{
            BeanUtils.copyProperties(estateRoom, e);
            return e;
        }).orElseThrow(() -> new EntityNotFoundException("EstateRoom not found with ID: " + idestroom));
        return estateRoomRepository.save(estado);
    }
    public void delete(int idestroom) {
        if (getEstateRoom(idestroom).isPresent()){
            EstateRoom estateRoom = estateRoomRepository.getEstateRoom(idestroom).get();
            estateRoom.setActive("I");
            estateRoomRepository.save(estateRoom);
        }else {
            System.out.println("ERROR 404 : ROOM STATUS NOT FOUND");
        }
    }
}
