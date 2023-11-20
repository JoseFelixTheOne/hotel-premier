package com.hotelpremier.Hotel.Premier.domain.repository;

import com.hotelpremier.Hotel.Premier.domain.RoomType;
import java.util.List;
import java.util.Optional;

public interface RoomTypeRepository {
    List<RoomType> getAll();
    List<RoomType> getAllActive();
    List<RoomType> getAllInactive();
    Optional<RoomType> getRoomType(int idroomtype);
    RoomType save(RoomType roomType);
    void delete(int idroomtype);
}
