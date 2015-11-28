package com.bluemaple.reservation.service;

import java.util.List;

import com.bluemaple.reservation.model.Admin;
import com.bluemaple.reservation.model.Timings;
import com.bluemaple.reservation.model.User;

public interface ReservationServiceInterface {

 public	User register(User user);

public User login(User user);

public Admin movieregister(Admin admin);

public List<Admin> movielist();

public void movieTiming(Timings time);

public List<Timings> timelist();

}
