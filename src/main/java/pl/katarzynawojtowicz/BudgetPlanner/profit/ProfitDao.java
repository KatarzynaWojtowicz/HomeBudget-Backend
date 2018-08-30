package pl.katarzynawojtowicz.BudgetPlanner.profit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
		String sql = "INSERT INTO profit (nazwa) VALUES (";

		List<String> insertParts = new ArrayList<>();
		if (newProfit.getNazwa() != null) {
			insertParts.add("'" + newProfit.getNazwa() + "'");
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

	public static List<ProfitTo> findByParameters(String searchNazwa) {
		String sql = buildSelectSql(searchNazwa);
		return performSelect(sql);
	}

	private static String buildSelectSql(String searchNazwa) {
		String sql = "SELECT idprofit, nazwa, kwota FROM profit";

		String whereString = " WHERE ";

		if (searchNazwa != null) {
			sql += whereString + "nazwa = '" + searchNazwa + "'";
		}
		System.out.println(sql);
		return sql;
	}

	private static List<ProfitTo> performSelect(String sql) {
		Connection conn = null;
		Statement stmt = null;
		List<ProfitTo> result = new ArrayList<>();
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				long idprofit = rs.getLong("idprofit");
				String nazwa = rs.getString("nazwa");
				Float kwota = rs.getFloat("kwota");

				ProfitTo newProfit = new ProfitTo(idprofit, nazwa, kwota);
				result.add(newProfit);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
