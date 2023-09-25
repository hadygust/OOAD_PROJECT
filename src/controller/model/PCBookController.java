package controller.model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import controller.service.DateService;
import database.Connect;
import javafx.util.Pair;
import main.Main;
import model.PC;
import model.PCBook;

public class PCBookController {
	
	private Connect con = Connect.getConnection();
	
	private static PCBookController instance = null;
	
	private PCBookController() {}
	
	public static PCBookController getInstance() {
		return instance = (instance == null) ? new PCBookController() : instance;
	}

	public int getLastId() {
		String q = "SELECT * FROM pc_book ORDER BY book_id DESC LIMIT 1";
		
		ResultSet rs = con.executeQuery(q);
		
		int id = 0;
		
		try {
			if(rs.next()) {
				id = rs.getInt("book_id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return id;
	}
	
	public Pair<Boolean, String> bookPC(PC pc, LocalDate date){
		
		String message = "";
		
		if(!pc.getCondition().equalsIgnoreCase("Usable")) {
			message = "PC is currently not available! Please select another PC!";
		} else if (pcIsBooked(pc)) { 
			message = "PC is booked! Please select another PC!";
		} else if (date == null) {
			message = "Please select your book date!";
		} else if(DateService.dateIsPassed(date)) {
			message = "Date must be later than now!";
		} 
		
		if(!message.isEmpty()) {
			return new Pair<Boolean, String>(false, message);
		}
		
		String q = "INSERT INTO `pc_book`(`pc_id`, `user_id`, `book_date`) "
				+ "VALUES (?,?,?)";
		
		PreparedStatement ps = con.prepareStatement(q);
		
		try {
			ps.setInt(1, pc.getId());
			ps.setInt(2, Main.user.getId());
			ps.setDate(3, Date.valueOf(date));
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			message = e.getMessage();
			return new Pair<Boolean, String>(false, message);
		}
		
		return new Pair<Boolean, String>(true, message);
	}
	
	public Boolean pcIsBooked(PC pc) {
		
		if(pc == null) return false;
		
		String q = "SELECT * FROM pc_book WHERE pc_id = ?";
		
		PreparedStatement ps = con.prepareStatement(q);
		
		try {
			ps.setInt(1, pc.getId());
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
		return false;
	}
}
