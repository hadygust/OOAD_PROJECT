package controller.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.Connect;
import model.Job;

public class JobController {

	private static JobController instance = null;
	
	private JobController() {}
	
	public static JobController getInstance() {
		return instance = (instance == null) ? new JobController() : instance;
	}
	
	private Connect con = Connect.getConnection();
	
	public ArrayList<Job> getTechnicianJobs(int id){
		
		ArrayList<Job> res = new ArrayList<>();
		
		String q = "SELECT * FROM job WHERE user_id = ?";
		
		PreparedStatement ps = con.prepareStatement(q);
		
		
		
		try {

			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int fjobId = rs.getInt("job_id");
				int fuserId = rs.getInt("user_id");
				int fpcId = rs.getInt("pc_id");
				String status = rs.getString("job_status");
				
				res.add(new Job(fjobId, fuserId, fpcId, status));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
	
	public void UpdateJobStatus(int jobId, String jobStatus) {
		String q = "UPDATE `job` SET `job_status`= ? WHERE job_id = ?";
		
		PreparedStatement ps = con.prepareStatement(q);
		
		try {
			ps.setInt(2, jobId);
			ps.setString(1, jobStatus);
			
			ps.executeUpdate();
			System.out.println("jobupdated");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
