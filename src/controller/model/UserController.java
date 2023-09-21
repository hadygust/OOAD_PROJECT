package controller.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.Connect;
import model.User;

public class UserController {
	
	private static UserController instance = null;
	
	public static synchronized UserController getInstance() {
		return instance = (instance == null) ? new UserController() : instance;
	}
	
	private UserController() {}
	
	private Connect con = Connect.getConnection();
	
	public ArrayList<User> getAllUser() {
		return new ArrayList<>();
	}
	
	public int getLastId() {
		String q = "SELECT * FROM user ORDER BY user_id DESC LIMIT 1";
		
		ResultSet rs = con.executeQuery(q);
		
		int id = 0;
		
		try {
			if(rs.next()) {
				id = rs.getInt("user_id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return id;
	}

}
