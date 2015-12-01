package com.bluemaple.ticketreservation.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bluemaple.ticketreservation.model.TicketType;
@Repository
public class TicketTypeDaoImplements implements TicketTypeDaoInterface{
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;


	@Override
	public void ticketCount(TicketType ticket) {
		// TODO Auto-generated method stub
int id = ticket.getTicket_type_id();
		
		if (id == 0) {
			
			String sql = "INSERT INTO ticket_type"
					+ "(ticket_type,ticket_type_count,created_date,updated_date) VALUES (?, ?, ?, ?)";
			jdbcTemplate = new JdbcTemplate(dataSource);
			jdbcTemplate.update(
					sql,
					new Object[] { ticket.getTicket_type(),
							ticket.getTicket_type_count(), ticket.getDate(),ticket.getDate()
							});
		} else {
			String sql = "update ticket_type set ticket_type=?,ticket_type_count=?,updated_date=? where ticket_type_id=?";
			
			
			jdbcTemplate = new JdbcTemplate(dataSource);

			
			jdbcTemplate.update(
					sql,
					new Object[] { ticket.getTicket_type(),
							ticket.getTicket_type_count(), ticket.getDate(),
							ticket.getTicket_type_id() });
			
		}
	
		
		
	}

	/*@Override
	public List<TicketType> ticketCount() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM ticket_type";

		List<TicketType> ticket = getJdbcTemplate().query(sql,
				new BeanPropertyRowMapper(TicketType.class));
		
		return ticket;
	}*/
	private JdbcTemplate getJdbcTemplate() {
		// TODO Auto-generated method stub
		return jdbcTemplate = new JdbcTemplate(dataSource);
	}
}
