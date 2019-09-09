package com.ticketpro.parking.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "ArrayOfValidParkingData", strict = false)
public class ArrayOfPlaveSearch {

    @Element(name = "ValidParkingData",required = false)
    private ValidParkingData ValidParkingData;

    public ValidParkingData getValidParkingData ()
    {
        return ValidParkingData;
    }

    public void setValidParkingData (ValidParkingData ValidParkingData)
    {
        this.ValidParkingData = ValidParkingData;
    }


}
