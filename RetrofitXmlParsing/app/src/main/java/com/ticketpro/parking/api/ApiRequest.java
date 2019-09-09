package com.ticketpro.parking.api;

import com.ticketpro.parking.model.ArrayOfEnforcementZone;
import com.ticketpro.parking.model.ArrayOfParkingSpaces;
import com.ticketpro.parking.model.ArrayOfPlaveSearch;
import com.ticketpro.parking.model.ArrayOfValidParkingData;
import com.ticketpro.parking.model.ValidParkingData;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ApiRequest {

    @GET("getspaceenforcementzones")
    Call<ArrayOfEnforcementZone> getZone();

    @GET
    Call<ArrayOfPlaveSearch> _serchPlate(@Url String url);

    @GET
    Call<ArrayOfParkingSpaces> _getZoneSpace(@Url String url);

    @GET
    Call<ArrayOfValidParkingData> _validateParking(@Url String url);
}
