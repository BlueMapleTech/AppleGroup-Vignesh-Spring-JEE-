package com.bluemaple.ticketreservation.model;

public class MovieHasTiming {
	private int timings_id;
	private int movie_id;

	public int getTimings_id() {
		return timings_id;
	}

	public void setTimings_id(int timings_id) {
		this.timings_id = timings_id;
	}

	public int getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}

	@Override
	public String toString() {
		return "MovieHashTiming [timings_id=" + timings_id + "]";
	}

}
