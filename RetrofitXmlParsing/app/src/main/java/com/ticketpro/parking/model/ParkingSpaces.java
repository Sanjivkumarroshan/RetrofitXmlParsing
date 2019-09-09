package com.ticketpro.parking.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "ParkingSpaces", strict = false)
public class ParkingSpaces {

    @Element(name = "Id",required = false)
    private String Id;

    public String getId ()
    {
        return Id;
    }

    public void setId (String Id)
    {
        this.Id = Id;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Id = "+Id+"]";
    }
}
