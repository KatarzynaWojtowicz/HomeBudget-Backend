package pl.katarzynawojtowicz.BudgetPlanner.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost/homebudget";
	private static final String USER = "user";
	private static final String PASS = "password";

	public static void addNewUser(UserTo newUser) {
		String sql = buildInsertSql(newUser);
		addUser(sql);
	}

	private static String buildInsertSql(UserTo newUser) {
		String sql = "INSERT INTO user (login, password) VALUES (";

		List<String> insertParts = new ArrayList<>();
		if (newUser.getLogin() != null) {
			insertParts.add("'" + newUser.getLogin() + "'");
		}
		if (newUser.getPassword() != null) {
			insertParts.add("'" + newUser.getPassword() + "'");
		}

		if (insertParts.size() > 0) {
			String insertString = String.join(", ", insertParts);
			sql += insertString + ");";
		}
		return sql;
	}

	public static void addUser(String sql) {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			int resultAdded = stmt.executeUpdate(sql);
			System.out.println(resultAdded);
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
