package com.bluemaple.ticketreservation.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Timings {
	private int timings_id;
	private String timings;
	private String created_by = "admin";
	private String updated_by = "admin";
	Date today = Calendar.getInstance().getTime();
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-hh.mm.ss");
	private String date = formatter.format(today);
	
	public int getTimings_id() {
		return timings_id;
	}
	public void setTimings_id(int timings_id) {
		this.timings_id = timings_id;
	}
	public String getTimings() {
		return timings;
	}
	public void setTimings(String timings) {
		this.timings = timings;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Timings [timings_id=" + timings_id + ", timings=" + timings
				+ ", created_by=" + created_by + ", updated_by=" + updated_by
				+ ", date=" + date + "]";
	}
	
}
