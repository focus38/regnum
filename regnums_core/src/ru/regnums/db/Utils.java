package ru.regnums.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Utils {

	public static int lastInsertId(PreparedStatement ps) throws SQLException
	{
		int id = -1;
		ResultSet rs = ps.getGeneratedKeys();
		if (rs.last()) id = rs.getInt(1);
		return id;
	}	
}
