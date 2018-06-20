package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Bean.Class;

public class ClassDao {
	
	//获得表中所有的班级类
	public ArrayList<Class> listAllClasses()
	{
		
		ArrayList<Class> classes=new ArrayList<Class>();
		String sql = "select * from class";
		try {
			DBConnect dbConnect = new DBConnect(sql);
			ResultSet rs =  dbConnect.executeQuery();
			while (rs.next()) {
				Class cla=new Class();
				cla.setClassId(rs.getInt("classId"));
				cla.setClassName(rs.getString("className"));
				classes.add(cla);
			}
			dbConnect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return classes;
		
	}

}
