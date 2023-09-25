package controller.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.Connect;
import javafx.util.Pair;
import model.PC;

public class PCController {
	
	private Connect con = Connect.getConnection();
	
	private static PCController instance = null;
	
	public static PCController getInstance() {
		return instance = (instance == null) ? new PCController() : instance;
	}
	
	private PCController() {}
	
	public ArrayList<PC> getAllPC() {
		ArrayList<PC> pcList = new ArrayList<>();
		
		String q = "SELECT * FROM pc";
		
		ResultSet rs = con.executeQuery(q);
		
		try {
			while(rs.next()) {
				int id = rs.getInt("pc_id");
				String condition = rs.getString("pc_condition");
				
				pcList.add(new PC(id, condition));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pcList;
	}
	
	public ArrayList<PC> getAllPCWithStatus() {
		ArrayList<PC> pcList = new ArrayList<>();
		
		String q = "SELECT pc.pc_id, pc_condition, :D FROM pc JOIN ";//TODO !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		
		ResultSet rs = con.executeQuery(q);
		
		try {
			while(rs.next()) {
				int id = rs.getInt("pc_id");
				String condition = rs.getString("pc_condition");
				
				pcList.add(new PC(id, condition));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pcList;
	}

	public Pair<Boolean, String> deletePC(PC pc) {
		//TODO VAILDATE IF PC IS BOOKED
		String message = "";
		
		
		// DELETE THE PC FROM DB
		String q = "DELETE FROM `pc` WHERE pc_id = ?";
		
		PreparedStatement ps = con.prepareStatement(q);
		
		try {
			ps.setInt(1, pc.getId());
			
			ps.execute();
			return new Pair<Boolean, String>(true, message);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			message = e.getMessage();
		}
		
		return new Pair<Boolean, String>(false, message);
	}
	
	public Pair<Boolean, String> updatePCCondition(PC pc, String condition) {
		
		String message = "";
		
		if(pc == null) {
			message = "Please select a pc first!";
			return new Pair<Boolean, String>(false, message);
		}
		
		if(condition.isBlank()) {
			message = "Please fill all the form!";
			return new Pair<Boolean, String>(false, message);
		} else if (!(condition.equals("Maintenance") || condition.equals("Usable") || condition.equals("Broken"))){
			message = "Please input a right condition status! (Broken, Usable, Maintenance)";
		}
		
		String q = "UPDATE `pc` SET `pc_condition`= ? WHERE pc_id = ?";
		
		PreparedStatement ps = con.prepareStatement(q);
		
		try {
			ps.setString(1, condition);
			ps.setInt(2, pc.getId());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			message = e.getMessage();
			return new Pair<Boolean, String>(false, message);
		}
		
		return new Pair<Boolean, String>(true, message);
	}
	
	public Pair<Boolean, String> addNewPC(String sid){
		String message = "";
		
		int id = -1;
		
		try {
			id = Integer.parseInt(sid);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			message = "Please input a right id!";
			return new Pair<Boolean, String>(false, message);
		}

		if (!validateDuplicate(id)) {
			message = "PC Already Exist!";
			return new Pair<Boolean, String>(false, message);
		}
		
		String q = "INSERT INTO `pc`(`pc_id`, `pc_condition`) VALUES (?,'Usable')";
		
		PreparedStatement ps = con.prepareStatement(q);
		
		try {
			ps.setInt(1, id);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return new Pair<Boolean, String>(true, message);
	}
	
	public boolean validateDuplicate(int id) {
		String q = "SELECT * FROM pc WHERE pc_id = ?";
		
		PreparedStatement ps = con.prepareStatement(q);
		
		try {
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return false;
			} else {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
}
