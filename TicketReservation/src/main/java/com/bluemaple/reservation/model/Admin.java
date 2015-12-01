package com.bluemaple.reservation.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Admin {
	private int movie_id;

	public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}

	private String movie_name;
	private String release_date;
	private int no_of_shows;
	private String created_by = "admin";
	private String updated_by = "admin";
	private String active = "yes";
	

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public String getUpdated_by() {
		return updated_by;
	}

	public void setUpdated_by(String updated_by) {
		this.updated_by = updated_by;
	}

	Date today = Calendar.getInstance().getTime();
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-hh.mm.ss");
	private String date = formatter.format(today);

	public String getMovie_name() {
		return movie_name;
	}

	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}

	public String getRelease_date() {
		return release_date;
	}

	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}

	public int getNo_of_shows() {
		return no_of_shows;
	}

	public void setNo_of_shows(int no_of_shows) {
		this.no_of_shows = no_of_shows;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Admin [movie_id=" + movie_id + ", movie_name=" + movie_name
				+ ", release_date=" + release_date + ", no_of_shows="
				+ no_of_shows + ", created_by=" + created_by + ", updated_by="
				+ updated_by + ", active=" + active + ", date=" + date + "]";
	}

	
}
