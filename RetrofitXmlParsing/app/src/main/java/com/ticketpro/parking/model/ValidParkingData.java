package com.ticketpro.parking.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "ValidParkingData", strict = false)
public class ValidParkingData {
    @Element(name = "IsExpired", required = false)
    private String IsExpired;

    @Element(name = "EndDateUtc", required = false)
    private String EndDateUtc;

    @Element(name = "Zone", required = false)
    private String Zone;

    @Element(name = "StartDateUtc", required = false)
    private String StartDateUtc;

    @Element(name = "Code", required = false)
    private String Code;

    public String getIsExpired() {
        return IsExpired;
    }

    public void setIsExpired(String IsExpired) {
        this.IsExpired = IsExpired;
    }

    public String getEndDateUtc() {
        return EndDateUtc;
    }

    public void setEndDateUtc(String EndDateUtc) {
        this.EndDateUtc = EndDateUtc;
    }


    public String getZone() {
        return Zone;
    }

    public void setZone(String Zone) {
        this.Zone = Zone;
    }


    public String getStartDateUtc() {
        return StartDateUtc;
    }

    public void setStartDateUtc(String StartDateUtc) {
        this.StartDateUtc = StartDateUtc;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

}