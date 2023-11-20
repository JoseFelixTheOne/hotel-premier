package com.hotelpremier.Hotel.Premier.domain.repository;

import com.hotelpremier.Hotel.Premier.domain.EstateRoom;
import java.util.List;
import java.util.Optional;

public interface EstateRoomRepository {
    List<EstateRoom> getAll();
    Optional<EstateRoom> getEstateRoom(int idestroom);
    EstateRoom save(EstateRoom estateRoom);
    void delete(int idestroom);
}
