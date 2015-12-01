package com.bluemaple.ticketreservation.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bluemaple.ticketreservation.model.Timings;


@Repository
public class TimingsDaoImplements implements TimingsDaoInterface{
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	@Override
	public void movieTiming(Timings time) {
		// TODO Auto-generated method stub
		
		int id=time.getTimings_id();
		if(id == 0){
			
			String sql = "INSERT INTO timings " +
					  "(timings,created_date,updated_date,created_by,updated_by) VALUES (?, ?, ?, ?, ?)";
			jdbcTemplate = new JdbcTemplate(dataSource);
			jdbcTemplate.update(
					sql,
					new Object[] { time.getTimings(), time.getDate(),time.getDate(),
							time.getCreated_by(), time.getUpdated_by(),
							 });
			
		}else{
		String sql = "update timings set timings=?,updated_date=?,created_by=?,updated_by=? where timings_id=?";
System.out.println("DAOTime"+time.toString());
jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(
				sql,
				new Object[] { time.getTimings(), time.getDate(),
						time.getCreated_by(), time.getUpdated_by(),
						time.getTimings_id() });
		}
		
	}

	/*@Override
	public List<Timings> timelist() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM timings";

		List<Timings> time = getJdbcTemplate().query(sql,
				new BeanPropertyRowMapper(Timings.class));

		return time;
	}*/
	private JdbcTemplate getJdbcTemplate() {
		// TODO Auto-generated method stub
		return jdbcTemplate = new JdbcTemplate(dataSource);
	}
}
