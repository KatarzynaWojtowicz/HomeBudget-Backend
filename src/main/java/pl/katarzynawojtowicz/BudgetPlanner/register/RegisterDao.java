package pl.katarzynawojtowicz.BudgetPlanner.register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RegisterDao {
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost/homebudget";
	private static final String USER = "user";
	private static final String PASS = "password";

	public static void addNewUser(RegisterTo newRegister) {
		String sql = buildInsertSql(newRegister);
		addUser(sql);
	}

	private static String buildInsertSql(RegisterTo newRegister) {
		String sql = "INSERT INTO user (active, name, last_name, login, password, email) VALUES (true, ";

		List<String> insertParts = new ArrayList<>();
		if (newRegister.getName() != null) {
			insertParts.add("'" + newRegister.getName() + "'");
		}
		if (newRegister.getLastName() != null) {
			insertParts.add("'" + newRegister.getLastName() + "'");
		}
		if (newRegister.getLogin() != null) {
			insertParts.add("'" + newRegister.getLogin() + "'");
		}
		if (newRegister.getPassword() != null) {
			insertParts.add("'" + newRegister.getPassword() + "'");
		}
		if (newRegister.getEmail() != null) {
			insertParts.add("'" + newRegister.getEmail() + "'");
		}

		if (insertParts.size() > 0) {
			String insertString = String.join(", ", insertParts);
			sql += insertString + ");";
		}
		return sql;
	}

	private static void addUser(String sql) {
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
