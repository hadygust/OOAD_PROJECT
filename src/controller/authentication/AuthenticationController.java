package controller.authentication;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.Connect;
import javafx.util.Pair;
import main.Main;
import model.User;
import view.scene.authentication.LoginScene;
import view.scene.authentication.RegisterScene;

public class AuthenticationController {
	
	private Connect con = Connect.getConnection();
	
	private static AuthenticationController authController = null;
	
	private AuthenticationController() {}
	
	public static synchronized AuthenticationController getInstance() {
		return authController = (authController == null) ? new AuthenticationController() : authController;
	}
	
	public Pair<User, String> register(String username, String password, String confirm, int age) {
		
		User user = null;
		String message = "";
		
		if(username.isEmpty() || password.isEmpty()) {
			message = "Please fill all the form!";
		} else if (username.length() < 7) {
			message = "Username must contain at least 7 characters!";
		} else if (!checkUniqueUsername(username)) {
			message = "Username taken!";
		} else if (password.length() < 6 || !checkPassword(password)) {
			message = "Password must be alphanumeric and contain at least 6 characters!";
		} else if (!confirm.equals(password)) {
			message = "Password mismatch!";
		} else if (age < 13 || age > 65) {
			message = "Age must be between 13 and 65!";
		}
		
		if(!message.isEmpty()) return new Pair<User, String>(user, message);
		
		String query = "INSERT INTO `user`(`user_name`, `user_password`, `user_age`, `user_role`) VALUES (?,?,?,?)";
		
		PreparedStatement ps = con.prepareStatement(query);
		
		try {
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setInt(3, age);
			ps.setString(4, "Customer");
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		user = login(username, password).getKey();
		
		return new Pair<User, String>(user, message);
	}
	
	public Pair<User, String> login(String username, String password) {
		
		User user = null;
		String message = "";
		
		if(username.isEmpty() || password.isEmpty()) {
			message = "Please fill all the form";
		}
		
		if(!message.isEmpty()) return new Pair<User, String>(user, message);
		
		String query = "SELECT * FROM user WHERE user_name = ?";
		
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs;
		try {
			ps.setString(1, username);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				int fid = rs.getInt(1);
				String fusername = rs.getString("user_name");
				String fpassword = rs.getString("user_password");
				int fage = rs.getInt("user_age");
				String frole = rs.getString("user_role");
				
				if(!fpassword.equals(password)) {
					message = "Wrong password!";
				} else {
					user = new User(fid, fusername, fpassword, fage, frole);
					Main.user = user;
				}
			} else {
				message = "Username not found";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new Pair<User, String>(user, message);
	}
	
	public boolean checkUniqueUsername(String username) {
		
		String q = "SELECT * FROM user";
		
		ResultSet rs = con.executeQuery(q);
		
		try {
			while (rs.next()) {
				System.out.println("check " + rs.getString("user_name") + ' '+ username);
				if(rs.getString("user_name").equals(username)) {
					return false;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
	}
	
	public boolean checkPassword(String password) {
		boolean alpha = false, num = false;
		for(int i = 0; i < password.length(); i++) {
			Character c = password.charAt(i);
			if(Character.isAlphabetic(c)) {
				alpha = true;
			} else if (Character.isDigit(c)) {
				num = true;
			}
		}
		
		return alpha && num;
	}
	
	public void goToRegister() {
		Main.authStage.displayRegister();
	}
	
	public void goToLogin() {
		Main.authStage.displayLogin();
	}
	
	public void goToApp() {
		Main.showApp();
	}
}
