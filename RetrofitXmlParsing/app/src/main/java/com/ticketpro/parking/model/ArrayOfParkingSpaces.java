package com.ticketpro.parking.model;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@Root(name = "ArrayOfParkingSpaces",strict = false)
public class ArrayOfParkingSpaces {

    @ElementList(entry="ParkingSpaces", inline=true)
    private List<ParkingSpaces> parkingSpaces;

    public ArrayOfParkingSpaces(){}
    public ArrayOfParkingSpaces(List<ParkingSpaces> parkingSpaces) {
        this.parkingSpaces = parkingSpaces;
    }

    public List<ParkingSpaces> getParkingSpaces() {
        return parkingSpaces;
    }

    public void setParkingSpaces(List<ParkingSpaces> parkingSpaces) {
        this.parkingSpaces = parkingSpaces;
    }
}
