package com.jacob.reservationapp;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class ReservationViewModel extends AndroidViewModel {
    private ReservationRepository repository;

    private LiveData<List<Reservation>> allReservations;

    private static final String TAG = "MainActivityViewModel";
    private MutableLiveData<Boolean> isLoading = new MutableLiveData<>();
    private LiveData<List<Reservation>> reservationLiveData;

    public ReservationViewModel(@NonNull Application application) {
        super(application);
        isLoading.setValue(true);
        ReservationRepository repo = ReservationRepository.getInstance();
        reservationLiveData = repo.getReservations();
    }


    @Override
    protected void onCleared() {
        super.onCleared();
    }

    public MutableLiveData<Boolean> getIsLoading() {
        return isLoading;
    }

    public LiveData<List<Reservation>> getReservationLiveData() {
        return reservationLiveData;
    }
    public void insert(Reservation reservation){
        repository.createReservation(reservation);
    }

//    public void insert(Reservation reservation) {
//        repository.insert(reservation);
//    }
//    public void update(Reservation reservation){
//        repository.update(reservation);
//    }
//    public void delete(Reservation reservation){
//        repository.delete(reservation);
//    }
//    public void deleteAllReservations(){
//        repository.deleteAllReservation();
//    }
//    public LiveData<List<Reservation>> getAllReservations(){
//        return allReservations;
//    }
}
