package com.hotelpremier.Hotel.Premier.domain.service;

import com.hotelpremier.Hotel.Premier.domain.RoomType;
import com.hotelpremier.Hotel.Premier.domain.repository.RoomTypeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RoomTypeService {
    @Autowired
    private RoomTypeRepository roomTypeRepository;
    public List<RoomType> getAll() {
        return roomTypeRepository.getAll();
    }
    public List<RoomType> getAllActive() {
        return roomTypeRepository.getAllActive();
    }
    public List<RoomType> getAllInactive() {
        return roomTypeRepository.getAllInactive();
    }
    public Optional<RoomType> getRoomType(int idroomtype) {
        return roomTypeRepository.getRoomType(idroomtype);
    }
    public RoomType save(RoomType roomType) {
        roomType.setActive("A");
        return roomTypeRepository.save(roomType);
    }
    public RoomType update(RoomType roomType) {
        int idroomtype = roomType.getIdroomtype();
        RoomType type = getRoomType(idroomtype).map(t ->{
                BeanUtils.copyProperties(roomType, t);
                return t;
        }).orElseThrow(() -> new EntityNotFoundException("RoomType not found with ID: " + idroomtype));
        return roomTypeRepository.save(type);
    }
    public void delete(int idroomtype) {
        if (getRoomType(idroomtype).isPresent()) {
            RoomType roomType = roomTypeRepository.getRoomType(idroomtype).get();
            roomType.setActive("I");
            roomTypeRepository.save(roomType);
        }else {
            System.out.println("ERROR 404 : ROOMTYPE "+ idroomtype +" NOT FOUND");
        }
    }
}
