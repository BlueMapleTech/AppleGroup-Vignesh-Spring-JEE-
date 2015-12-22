package com.bluemaple.ticketreservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluemaple.ticketreservation.dao.TicketTypeDaoInterface;
import com.bluemaple.ticketreservation.model.TicketType;

@Service
public class TicketTypeServiceImplementation implements
		TicketTypeServiceInterface {
	@Autowired
	TicketTypeDaoInterface ticketTypeDao;

	@Override
	public void ticketType(TicketType ticket) {
		// TODO Auto-generated method stub
		ticketTypeDao.ticketCount(ticket);

	}

	/*
	 * @Override public List<TicketType> ticketCountlist() { // TODO
	 * Auto-generated method stub return ticketTypeDao.ticketCount(); }
	 */

}
