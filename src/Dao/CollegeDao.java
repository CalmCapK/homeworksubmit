package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Bean.College;

public class CollegeDao {
	//获得表中所有的学院类
	public ArrayList<College> listAllColleges()
	{
		
		ArrayList<College> Collegees=new ArrayList<College>();
		String sql = "select * from college";
		try {
			DBConnect dbConnect = new DBConnect(sql);
			ResultSet rs =  dbConnect.executeQuery();
			while (rs.next()) {
				College cla=new College();
				cla.setCollegeId(rs.getInt("collegeId"));
				cla.setCollegeName(rs.getString("collegeName"));
				Collegees.add(cla);
			}
			dbConnect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Collegees;
		
	}

}
