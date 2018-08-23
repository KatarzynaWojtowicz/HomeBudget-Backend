package pl.katarzynawojtowicz.BudgetPlanner.profit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProfitDao {
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost/homebudget";
	private static final String USER = "user";
	private static final String PASS = "password";

	public static void addNewProfit(ProfitTo newProfit) {
		String sql = buildInsertSql(newProfit);
		addProfit(sql);
	}

	private static String buildInsertSql(ProfitTo newProfit) {
		String sql = "INSERT INTO profit (nazwa, kwota) VALUES (";

		List<String> insertParts = new ArrayList<>();
		if (newProfit.getNazwa() != null) {
			insertParts.add("'" + newProfit.getNazwa() + "'");
		}

		if (newProfit.getKwota() != null) {
			insertParts.add(newProfit.getKwota().toString());
		}

		if (insertParts.size() > 0) {
			String insertString = String.join(", ", insertParts);
			sql += insertString + ");";
		}
		return sql;
	}

	public static void addProfit(String sql) {
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
