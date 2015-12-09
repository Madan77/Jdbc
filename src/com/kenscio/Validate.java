package com.kenscio;

import java.sql.*;

public class Validate {
	public static boolean checkUser(String email, String pass) {
		Connection con = null;
		boolean st = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Login", "root", "madan007");
			PreparedStatement ps = con.prepareStatement("select password from customer where emailid=?;");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String dbpass = rs.getString(1);
				if (pass.equalsIgnoreCase(dbpass)) {
					st = true;
					return st;
				}
			}
		} catch (Exception e) {
			System.out.println("excep occ" + e);
		}

		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return st;

	}

}
