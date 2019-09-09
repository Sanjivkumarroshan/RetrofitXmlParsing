package com.ticketpro.parking.model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "ValidParkingData", strict = false)
public class ValidParkingData1 {

    @Element(name = "IsExpired", required = false)
    private String IsExpired;
    @Element(name = "ParkingSpace", required = false)
    private String ParkingSpace;
    @Element(name = "Zone", required = false)
    private String Zone;
    @Element(name = "Amount", required = false)
    private String Amount;
    @Element(name = "Code", required = false)
    private String Code;
    @Element(name = "DateChangedUtc", required = false)
    private String DateChangedUtc;
    @Element(name = "EndDateUtc", required = false)
    private String EndDateUtc;
    @Element(name = "TicketNumber", required = false)
    private String TicketNumber;
    @Element(name = "DateCreatedUtc", required = false)
    private String DateCreatedUtc;
    @Element(name = "ParkingZone", required = false)
    private String ParkingZone;
    @Element(name = "StartDateUtc", required = false)
    private String StartDateUtc;
    @Element(name = "ContainsTerminalOutOfCommunication", required = false)
    private String ContainsTerminalOutOfCommunication;
    @Element(name = "PurchaseDateUtc", required = false)
    private String PurchaseDateUtc;

    public String getIsExpired() {
        return IsExpired;
    }

    public void setIsExpired(String IsExpired) {
        this.IsExpired = IsExpired;
    }

    public String getParkingSpace() {
        return ParkingSpace;
    }

    public void setParkingSpace(String ParkingSpace) {
        this.ParkingSpace = ParkingSpace;
    }

    public String getZone() {
        return Zone;
    }

    public void setZone(String Zone) {
        this.Zone = Zone;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String Amount) {
        this.Amount = Amount;
    }


    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }


    public String getDateChangedUtc() {
        return DateChangedUtc;
    }

    public void setDateChangedUtc(String DateChangedUtc) {
        this.DateChangedUtc = DateChangedUtc;
    }

    public String getEndDateUtc() {
        return EndDateUtc;
    }

    public void setEndDateUtc(String EndDateUtc) {
        this.EndDateUtc = EndDateUtc;
    }

    public String getTicketNumber() {
        return TicketNumber;
    }

    public void setTicketNumber(String TicketNumber) {
        this.TicketNumber = TicketNumber;
    }

    public String getDateCreatedUtc() {
        return DateCreatedUtc;
    }

    public void setDateCreatedUtc(String DateCreatedUtc) {
        this.DateCreatedUtc = DateCreatedUtc;
    }

    public String getParkingZone() {
        return ParkingZone;
    }

    public void setParkingZone(String ParkingZone) {
        this.ParkingZone = ParkingZone;
    }

    public String getStartDateUtc() {
        return StartDateUtc;
    }

    public void setStartDateUtc(String StartDateUtc) {
        this.StartDateUtc = StartDateUtc;
    }

    public String getContainsTerminalOutOfCommunication() {
        return ContainsTerminalOutOfCommunication;
    }

    public void setContainsTerminalOutOfCommunication(String ContainsTerminalOutOfCommunication) {
        this.ContainsTerminalOutOfCommunication = ContainsTerminalOutOfCommunication;
    }

    public String getPurchaseDateUtc() {
        return PurchaseDateUtc;
    }

    public void setPurchaseDateUtc(String PurchaseDateUtc) {
        this.PurchaseDateUtc = PurchaseDateUtc;
    }
}
