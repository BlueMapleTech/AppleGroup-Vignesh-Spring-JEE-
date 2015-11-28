package com.bluemaple.reservation.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bluemaple.reservation.model.Admin;
import com.bluemaple.reservation.model.Timings;
import com.bluemaple.reservation.model.User;

@Repository
public class ReservationDaoImplementation implements ReservationDaoInterface {
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	@Override
	public User register(User user) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO user "
				+ "(username,password,firstname,lastname,email,address,created_date,updated_date,user_role) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?)";

		jdbcTemplate.update(
				sql,
				new Object[] { user.getUserName(), user.getPassword(),
						user.getFirstName(), user.getLastName(),
						user.getEmail(), user.getAddress(), user.getDate(),
						user.getDate(), user.getUser_role() });
		return user;

	}

	@Override
	public User login(String name1) {

		String sql = "SELECT * FROM user WHERE username = ?";

		User user = (User) getJdbcTemplate().queryForObject(sql,
				new Object[] { name1 }, new UserLogin());

		return user;
	}

	private JdbcTemplate getJdbcTemplate() {
		// TODO Auto-generated method stub
		return jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Admin movieregister(Admin admin) {
		// TODO Auto-generated method stub
		System.out.println(admin.getCreated_by());
		System.out.println(admin.getMovie_name());
		System.out.println(admin.getDate());
		/*
		 * String sql = "INSERT INTO movie" +
		 * "(movie_name,release_date,no_of_shows,created_date,updated_date,active,created_by,updated_by) VALUES (?, ?, ?, ?, ?, ?, ?,?)"
		 * ;
		 */
		String sql = "update movie set movie_name=?,release_date=?,no_of_shows=?,updated_date=?,active=?,created_by=?,updated_by=? where movie_id=?";
		System.out.println("dao");
		System.out.println(admin.toString());
		jdbcTemplate = new JdbcTemplate(dataSource);

		System.out.println(admin.getMovie_id());
		jdbcTemplate.update(
				sql,
				new Object[] { admin.getMovie_name(), admin.getRelease_date(),
						admin.getNo_of_shows(), admin.getDate(),
						admin.getActive(), admin.getCreated_by(),
						admin.getUpdated_by(), admin.getMovie_id() });
		System.out.println("4");
		return admin;

	}

	@Override
	public List<Admin> movielist() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM movie";
		
		
		List<Admin> admin = getJdbcTemplate().query(sql,
				new BeanPropertyRowMapper(Admin.class));
		
		return admin;

	}

	@Override
	public void movieTiming(Timings time) {
		// TODO Auto-generated method stub
		/*String sql = "INSERT INTO timings "
				+ "(timings,created_date,updated_date,created_by,updated_by) VALUES (?, ?, ?, ?, ?)";
*/
		String sql = "update timings set timings=?,updated_date=?,created_by=?,updated_by=? where timings_id=?";
		
		jdbcTemplate.update(
				sql,
				new Object[] { time.getTimings(),
						time.getDate(), time.getCreated_by(),
						time.getUpdated_by(),time.getTimings_id() });

	}

	@Override
	public List<Timings> timelist() {
		// TODO Auto-generated method stub
String sql = "SELECT * FROM timings";
		
		
		List<Timings> time = getJdbcTemplate().query(sql,
				new BeanPropertyRowMapper(Timings.class));
		
		return time;

		
	}

}
