package controller.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import database.Connect;
import model.TransactionDetail;
import model.TransactionHeader;

public class TransactionController {

	private static TransactionController instance = null;
	
	private TransactionController() {}
	
	public static TransactionController getInstace() {
		return instance = (instance == null) ? new TransactionController() : instance;
	}
	
	private Connect con = Connect.getConnection();
	
	public ArrayList<TransactionHeader> getAllTransactionHeaders(){
		ArrayList<TransactionHeader> thList = new ArrayList<>();
		
		String q = "SELECT * FROM transaction_header";
		
		ResultSet rs = con.executeQuery(q);
		
		try {
			while(rs.next()) {
				int fid = rs.getInt("transaction_id");
				int fuserId = rs.getInt("user_id");
				LocalDate ftransactionDate = rs.getDate("transaction_date").toLocalDate();
				
				thList.add(new TransactionHeader(fid, fuserId, ftransactionDate));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return thList;
	}
	
	public ArrayList<TransactionDetail> getTransactionDetails(int userId){
		ArrayList<TransactionDetail> tdList = new ArrayList<>();
		
		String q = "SELECT * FROM transaction_detail WHERE user_id = ?";
		
		PreparedStatement ps = con.prepareStatement(q);
		
		
		try {
			ps.setInt(1, userId);

			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int fid = rs.getInt("transaction_id");
				int fuserId = rs.getInt("user_id");
				int fpcId = rs.getInt("pc_id");
				LocalDate fbookTime = rs.getDate("book_time").toLocalDate();
				
				tdList.add(new TransactionDetail(fid, fuserId, fpcId, fbookTime));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tdList;
	}
	
	public ArrayList<TransactionDetail> getAllTransactionDetails(){
		ArrayList<TransactionDetail> tdList = new ArrayList<>();
		
		String q = "SELECT * FROM transaction_detail";
		
		ResultSet rs = con.executeQuery(q);
		
		try {
			while(rs.next()) {
				int fid = rs.getInt("transaction_id");
				int fuserId = rs.getInt("user_id");
				int fpcId = rs.getInt("pc_id");
				LocalDate fbookTime = rs.getDate("book_time").toLocalDate();
				
				tdList.add(new TransactionDetail(fid, fuserId, fpcId, fbookTime));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tdList;
	}
	
	public ArrayList<TransactionDetail> getUserTransactionDetails(int userId){
		ArrayList<TransactionDetail> tdList = new ArrayList<>();
		
		String q = "SELECT * FROM transaction_detail WHERE user_id = ?";
		
		PreparedStatement ps = con.prepareStatement(q);
		
		
		try {
			ps.setInt(1, userId);

			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int fid = rs.getInt("transaction_id");
				int fuserId = rs.getInt("user_id");
				int fpcId = rs.getInt("pc_id");
				LocalDate fbookTime = rs.getDate("book_time").toLocalDate();
				
				tdList.add(new TransactionDetail(fid, fuserId, fpcId, fbookTime));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tdList;
	}
	
	public ArrayList<TransactionDetail> getTransactionDetailsByID(int id){
		ArrayList<TransactionDetail> tdList = new ArrayList<>();
		
		String q = "SELECT * FROM transaction_detail WHERE transaction_id = ?";
		
		PreparedStatement ps = con.prepareStatement(q);
		
		
		try {
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int fid = rs.getInt("transaction_id");
				int fuserId = rs.getInt("user_id");
				int fpcId = rs.getInt("pc_id");
				LocalDate fbookTime = rs.getDate("book_time").toLocalDate();
				
				tdList.add(new TransactionDetail(fid, fuserId, fpcId, fbookTime));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tdList;
	}
}
