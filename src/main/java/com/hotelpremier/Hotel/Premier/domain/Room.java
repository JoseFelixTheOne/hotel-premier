package com.hotelpremier.Hotel.Premier.domain;

import com.hotelpremier.Hotel.Premier.persistence.entity.EstadoHabitacion;
import com.hotelpremier.Hotel.Premier.persistence.entity.Piso;
import com.hotelpremier.Hotel.Premier.persistence.entity.TipoHabitacion;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Room {

    private int roomId;
    private String roomNumber;
    private double roomPrice;
    private int roomStatusId;
    private int floorId;
    private int roomTypeId;
    private String roomActive;

    private EstadoHabitacion objRoomStatus;
    private Piso objFloor;
    private TipoHabitacion objRoomType;
}
