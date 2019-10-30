package com.jacob.reservationapp;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ReservationRepository {

//    private ReservationDao reservationDao;
//    private LiveData<List<Reservation>> allReservations;
//    private JsonReservationApi jsonReservationApi;

    private static final String TAG = "ReservationRepository";
    private static final ReservationRepository ourInstance = new ReservationRepository();
    private JsonReservationApi api;

    private MutableLiveData<List<Reservation>> reservationListLiveData = new MutableLiveData<>();
    private MutableLiveData<Reservation> reservationLiveData = new MutableLiveData<>();
    private MutableLiveData<Reservation> insertReservationLiveData = new MutableLiveData<>();

    public static ReservationRepository getInstance() {

        return ourInstance;

//        JsonReservationApi database = Retrofit.
//        reservationDao = database.reservationDao();
//        allReservations = reservationDao.getAllReservations();
    }

    private ReservationRepository(){
        api = ReservationApi.create(JsonReservationApi.class);
    }
//    public void insert(Reservation reservation){
//        new InsertReservationAsyncTask(reservationDao).execute(reservation);
//    }
//    public void update(Reservation reservation){
//        new UpdateReservationAsyncTask(reservationDao).execute(reservation);
//    }
//    public void delete(Reservation reservation){
//        new DeleteReservationAsyncTask(reservationDao).execute(reservation);
//    }
//    public void deleteAllReservation(){
//        new DeleteAlleservationsAsyncTask(reservationDao).execute();
//    }
    public LiveData<List<Reservation>> getReservations(){
        api.getReservations().enqueue(new Callback<List<Reservation>>(){
            @Override
            public void onResponse(@NonNull Call<List<Reservation>> call, @NonNull Response<List<Reservation>> response){
                reservationListLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Reservation>> call, Throwable t) {
                Log.d(TAG, "onFailure: failed to fetch Reservationlist from server");
            }
        });
        return reservationListLiveData;
    }

    public LiveData<Reservation> getReservation(int roomId){
        api.getReservation(roomId).enqueue(new Callback<Reservation>() {
            @Override
            public void onResponse(Call<Reservation> call, Response<Reservation> response) {
                reservationLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<Reservation> call, Throwable t) {
                Log.d(TAG, "onFailure: failed to get reservation");
            }
        });
        return reservationLiveData;
    }

    public void createReservation(Reservation reservation){
        api.createReservation(reservation).enqueue(new Callback<Reservation>() {
            @Override
            public void onResponse(Call<Reservation> call, Response<Reservation> response) {
                Log.d(TAG, "onFailure: failed to get reservation1");
            }

            @Override
            public void onFailure(Call<Reservation> call, Throwable t) {
                Log.d(TAG, "onFailure: failed to get reservation2");
            }
        });
    }


//    private static class InsertReservationAsyncTask extends AsyncTask<Reservation, Void, Void>{
//        private ReservationDao reservationDao;
//        private InsertReservationAsyncTask(ReservationDao reservationDao){
//            this.reservationDao = reservationDao;
//        }
//        @Override
//        protected Void doInBackground(Reservation... reservations) {
//            reservationDao.insert(reservations[0]);
//            return null;
//        }
//    }
//    private static class UpdateReservationAsyncTask extends AsyncTask<Reservation, Void, Void>{
//        private ReservationDao reservationDao;
//        private UpdateReservationAsyncTask(ReservationDao reservationDao){
//            this.reservationDao = reservationDao;
//        }
//        @Override
//        protected Void doInBackground(Reservation... reservations) {
//            reservationDao.update(reservations[0]);
//            return null;
//        }
//    }
//    private static class DeleteReservationAsyncTask extends AsyncTask<Reservation, Void, Void>{
//        private ReservationDao reservationDao;
//        private DeleteReservationAsyncTask(ReservationDao reservationDao){
//            this.reservationDao = reservationDao;
//        }
//        @Override
//        protected Void doInBackground(Reservation... reservations) {
//            reservationDao.delete(reservations[0]);
//            return null;
//        }
//    }
//    private static class DeleteAlleservationsAsyncTask extends AsyncTask<Void, Void, Void>{
//        private ReservationDao reservationDao;
//        private DeleteAlleservationsAsyncTask(ReservationDao reservationDao){
//            this.reservationDao = reservationDao;
//        }
//        @Override
//        protected Void doInBackground(Void... voids) {
//            reservationDao.deleteAllReservation();
//            return null;
//        }
//    }
}
