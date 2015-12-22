package com.bluemaple.ticketreservation.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TicketType {
	private int ticket_type_id;
	private String ticket_type;
	private int ticket_type_count;
	Date today = Calendar.getInstance().getTime();
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-hh.mm.ss");
	private String date = formatter.format(today);

	public int getTicket_type_id() {
		return ticket_type_id;
	}

	public void setTicket_type_id(int ticket_type_id) {
		this.ticket_type_id = ticket_type_id;
	}

	public String getTicket_type() {
		return ticket_type;
	}

	public void setTicket_type(String ticket_type) {
		this.ticket_type = ticket_type;
	}

	public int getTicket_type_count() {
		return ticket_type_count;
	}

	public void setTicket_type_count(int ticket_type_count) {
		this.ticket_type_count = ticket_type_count;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "TicketType [ticket_type_id=" + ticket_type_id
				+ ", ticket_type=" + ticket_type + ", ticket_type_count="
				+ ticket_type_count + ", date=" + date + "]";
	}

}
