package com.bluemaple.reservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.bluemaple.reservation.dao.ReservationDaoInterface;
import com.bluemaple.reservation.model.Admin;
import com.bluemaple.reservation.model.Timings;
import com.bluemaple.reservation.model.User;
@Service
public class ReservationServiceImplementation implements ReservationServiceInterface{
@Autowired
	ReservationDaoInterface database;
	@Override
	public User register(User user) {
		// TODO Auto-generated method stub
		return database.register(user);
	}
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		String name1=user.getUserName();
		String password1=user.getPassword();
	    User newuser = database.login(name1);
	    
	     String name2=newuser.getUserName();
	     String password2=newuser.getPassword();
	     int user_role1=newuser.getUser_role();
	     System.out.println("Service: "+ name2 + ""+password2+user_role1);
	     ModelAndView model=new ModelAndView();
	   
	     if((user_role1==1)&&(name1.equals(name2))&&(password1.equals(password2))){
	    	 newuser.setUser_role(1);
	    	
	    	System.out.println("user");
	     }
	     else 
	    	 if((user_role1==2)&&(name1.equals(name2))&&(password1.equals(password2))){
	    		 newuser.setUser_role(2);
	    		System.out.println("admin");
	    	 }
	    	 else if((name2.equals(null))||(password2.equals(null))) {
	    		
	    		 newuser.setUser_role(3);
	    		System.out.println("null in database");
	    	 }
	    	 else{
	    		 newuser.setUser_role(4);
	    	 }
		return newuser;
	}
	@Override
	public Admin movieregister(Admin admin) {
		// TODO Auto-generated method stub
		System.out.println(admin.getMovie_name());
		System.out.println(2);
		return database.movieregister(admin);
	}
	@Override
	public List<Admin> movielist() {
		// TODO Auto-generated method stub
		return database.movielist();
		
	}
	@Override
	public void movieTiming(Timings time) {
		// TODO Auto-generated method stub
		database.movieTiming(time);
	}
	@Override
	public List<Timings> timelist() {
		// TODO Auto-generated method stub
		return database.timelist();
	}
	

}
