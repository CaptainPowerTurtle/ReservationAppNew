package com.jacob.reservationapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JsonReservationApi {
    @GET("reservations")
    Call<List<Reservation>> getReservations();

    @GET("reservations/room/{roomId}")
    Call<Reservation> getReservation(@Path("roomId") int roomId);

    @POST("reservations")
    Call<Reservation>createReservation(@Body Reservation reservation);
}
