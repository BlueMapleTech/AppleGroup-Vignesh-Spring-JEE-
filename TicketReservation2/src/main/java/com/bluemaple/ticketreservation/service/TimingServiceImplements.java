package com.bluemaple.ticketreservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluemaple.ticketreservation.dao.TimingsDaoInterface;
import com.bluemaple.ticketreservation.model.Timings;


@Service
public class TimingServiceImplements implements TimingsServiceInterface {
@Autowired
TimingsDaoInterface timingDao;
	@Override
	public void movieTiming(Timings time) {
		// TODO Auto-generated method stub
		timingDao.movieTiming(time);
		
	}
/*
	@Override
	public List<Timings> timelist() {
		// TODO Auto-generated method stub
		return timingDao.timelist();
	}
*/
}
