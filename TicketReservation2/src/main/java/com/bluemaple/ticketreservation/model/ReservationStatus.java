package com.bluemaple.ticketreservation.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ReservationStatus {
private int reservation_status_id;
private String reservation_status;
Date today = Calendar.getInstance().getTime();
SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-hh.mm.ss");
private String date = formatter.format(today);
public int getReservation_status_id() {
	return reservation_status_id;
}
public void setReservation_status_id(int reservation_status_id) {
	this.reservation_status_id = reservation_status_id;
}
public String getReservation_status() {
	return reservation_status;
}
public void setReservation_status(String reservation_status) {
	this.reservation_status = reservation_status;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
@Override
public String toString() {
	return "ReservationStatus [reservation_status_id=" + reservation_status_id
			+ ", reservation_status=" + reservation_status + ", date=" + date
			+ "]";
}

}
