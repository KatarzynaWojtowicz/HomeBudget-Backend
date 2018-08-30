package pl.katarzynawojtowicz.BudgetPlanner.expense;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ExpenseDao {
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost/homebudget";
	private static final String USER = "user";
	private static final String PASS = "password";

	public static List<ExpenseTo> findByParameters(Status searchStatus, String searchKategoria, String searchNazwa) {
		String sql = buildSelectSql(searchStatus, searchKategoria, searchNazwa);
		return performSelect(sql);
	}

	public static void addNewExpense(ExpenseTo newExpense) {
		String sql = buildInsertSql(newExpense);
		addExpense(sql);
	}

	private static String buildSelectSql(Status searchStatus, String searchKategoria, String searchNazwa) {
		String sql = "SELECT id, wydatek, kategoria, cena, status FROM expense";

		List<String> whereParts = new ArrayList<>();
		if (searchStatus != null) {
			whereParts.add("status = '" + searchStatus.toString() + "'");
		}
		if (searchKategoria != null) {
			whereParts.add("kategoria = '" + searchKategoria + "'");
		}
		if (searchNazwa != null) {
			whereParts.add("wydatek = '" + searchNazwa + "'");
		}

		if (whereParts.size() > 0) {
			String whereString = String.join(" AND ", whereParts);
			sql += " WHERE " + whereString;
		}
		return sql;
	}

	private static List<ExpenseTo> performSelect(String sql) {
		Connection conn = null;
		Statement stmt = null;
		List<ExpenseTo> result = new ArrayList<>();
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				long id = rs.getLong("id");
				String wydatek = rs.getString("wydatek");
				String kategoria = rs.getString("kategoria");
				Float cena = rs.getFloat("cena");
				String status = rs.getString("status");
				Status s = Status.valueOf(status);

				ExpenseTo newExpense = new ExpenseTo(id, wydatek, kategoria, cena, s);
				result.add(newExpense);
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	private static String buildInsertSql(ExpenseTo newExpense) {
		String sql = "INSERT INTO expense (wydatek, kategoria, cena, status) VALUES (";

		List<String> insertParts = new ArrayList<>();
		if (newExpense.getNazwa() != null) {
			insertParts.add("'" + newExpense.getNazwa() + "'");
		}
		if (newExpense.getKategoria() != null) {
			insertParts.add("'" + newExpense.getKategoria() + "'");
		}
		if (newExpense.getCena() != null) {
			insertParts.add(newExpense.getCena().toString());
		}
		if (newExpense.getStatus() != null) {
			insertParts.add("'" + newExpense.getStatus().toString() + "'");
		}

		if (insertParts.size() > 0) {
			String insertString = String.join(", ", insertParts);
			sql += insertString + ");";
		}
		return sql;
	}

	public static void addExpense(String sql) {
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
