package controller.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import database.Connect;
import model.PCBook;

public class PCBookController {
	
	private Connect con = Connect.getConnection();
	
	public ArrayList<PCBook> getAllPCBook() {
		ArrayList<PCBook> bookList = new ArrayList<>();
		
		String q = "SELECT * FROM pc_book";
		
		ResultSet rs = con.executeQuery(q);
		
		try {
			while (rs.next()) {
				int id = rs.getInt("book_id");
				int userId = rs.getInt("user_id");
				int pcId = rs.getInt("pc_id");
				Date bookDate = rs.getDate("book_date");
				
				PCBook book = new PCBook(id, userId, pcId, bookDate);
				bookList.add(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return bookList;
	}
	
	public boolean isBooked(int pcId) {
		String q = "SELECT * FROM pc_book WHERE pc_id = ?";
		
		PreparedStatement ps = con.prepareStatement(q);
		ResultSet rs = null;
		try {
			ps.setInt(1, pcId);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				// PC is Booked
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// PC not Booked
		return false;
	}

	public int getLastId() {
		String q = "SELECT * FROM pc_book ORDER BY user_id DESC LIMIT 1";
		
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
}
