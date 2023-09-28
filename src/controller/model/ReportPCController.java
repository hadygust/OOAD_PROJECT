  package controller.model;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import controller.service.DateService;
import database.Connect;
import javafx.util.Pair;
import main.Main;
import model.PC;
import model.Report;

public class ReportPCController {
	
	public static ReportPCController instance = null;
	
	private ReportPCController() {}
	
	public static ReportPCController getInstance() {
		return instance = (instance == null) ? new ReportPCController() : instance;
	}
	
	private Connect con = Connect.getConnection();
	private PCController pcCon = PCController.getInstance();

	public int getLastId() {
		String q = "SELECT * FROM report ORDER BY report_id DESC LIMIT 1";
		
		ResultSet rs = con.executeQuery(q);
		
		int id = 0;
		
		try {
			if(rs.next()) {
				id = rs.getInt("report_id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return id;
	}
	
	public Pair<Boolean, String> addReport(PC pc, String note){
		
		String message = "";
		
		if(pc == null) {
			message = "Please select a PC first!";
		} else if (note.isEmpty()){
			message = "Please fill write your report note!";
		} else if (!pcCon.isExist(pc.getId())) {
			message = "PC did not exists, please select another PC!";
		} 
		
		if(!message.isEmpty()) {
			return new Pair<Boolean, String>(false, message);
		}
		
		String q = "INSERT INTO `report`(`user_id`, `pc_id`, `report_note`, `report_date`) VALUES (?,?,?,?)";
		
		PreparedStatement ps = con.prepareStatement(q);
		
		try {
			ps.setInt(1, Main.user.getId());
			ps.setInt(2, pc.getId());
			ps.setString(3, note);
			ps.setDate(4, Date.valueOf(LocalDate.now()));
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return new Pair<Boolean, String>(false, e.getMessage());
		}
		
		
		return new Pair<Boolean, String>(true, message);
		
	}
	
	public ArrayList<Report> getAllReport() {
		ArrayList<Report> pcList = new ArrayList<>();
		
		String q = "SELECT * FROM report";
		
		ResultSet rs = con.executeQuery(q);
		
		try {
			while(rs.next()) {
				int id = rs.getInt("report_id");
				int userId = rs.getInt("user_id");
				int pcId = rs.getInt("pc_id");
				String note = rs.getString("report_note");
				LocalDate date = DateService.toLocalDate(rs.getDate("report_date")) ;
				
				pcList.add(new Report(id, userId, pcId, note, date));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pcList;
	}
}
