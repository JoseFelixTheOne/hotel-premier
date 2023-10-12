package com.hotelpremier.Hotel.Premier.domain;

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

    private EstateRoom objRoomStatus;
    private Floor objFloor;
    private RoomType objRoomType;
}
