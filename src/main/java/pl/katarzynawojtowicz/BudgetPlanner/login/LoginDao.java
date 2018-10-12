package pl.katarzynawojtowicz.BudgetPlanner.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDao {
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost/homebudget";
	private static final String USER = "user";
	private static final String PASS = "password";

	public static void login(LoginTo newLogin) {
		String sql = buildSelectSql(newLogin);
		checkPassword(sql, newLogin);
	}

	private static String buildSelectSql(LoginTo newLogin) {
		String sql = "SELECT password FROM user WHERE login = '" + newLogin.getUserPassword() + "';";
		return sql;
	}

	public static void checkPassword(String sql, LoginTo newLogin) {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(sql);
			if (result.getString("password") == newLogin.getUserPassword()) {
				System.out.println("ZALOGOWANY!");
			}
			System.out.println(result);
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
