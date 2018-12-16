package pl.katarzynawojtowicz.BudgetPlanner.expense;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExpenseDao {
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost/homebudget";
	private static final String USER = "user";
	private static final String PASS = "password";

	private static SimpleDateFormat databaseDateFormatter = new SimpleDateFormat("yyyy-MM-dd");

	public static List<ExpenseTo> findByParameters(Status searchStatus, String searchKategoria, String searchNazwa,
			Date dataWydatku,
			int userId) {
		String sql = buildSelectSql(searchStatus, searchKategoria, searchNazwa, dataWydatku, userId);
		return performSelect(sql);
	}

	public static void addNewExpense(ExpenseTo newExpense, int userId) {
		String sql = buildInsertSql(newExpense, userId);
		addExpense(sql);
	}

	public static void removeExpense(Long id, int userId) {
		String sql = "DELETE FROM expense WHERE id = " + id + " AND id_user = " + userId + ";";
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

	public static void editExpense(ExpenseTo newExpense, int userId) {
		String sql = "UPDATE expense SET ";

		List<String> insertParts = new ArrayList<>();
		if (newExpense.getNazwa() != null) {
			insertParts.add("wydatek = '" + newExpense.getNazwa() + "'");
		}
		if (newExpense.getKategoria() != null) {
			insertParts.add("kategoria = '" + newExpense.getKategoria() + "'");
		}
		if (newExpense.getCena() != null) {
			insertParts.add("cena = " + newExpense.getCena().toString());
		}
		if (newExpense.getStatus() != null) {
			insertParts.add("status = '" + newExpense.getStatus().toString() + "'");
		}
		if (newExpense.getDataWydatku() != null) {
			insertParts.add("data_wydatku = '" + databaseDateFormatter.format(newExpense.getDataWydatku()) + "'");
		}

		if (insertParts.size() > 0) {
			String insertString = String.join(", ", insertParts);
			sql += insertString + " WHERE (id = '" + newExpense.getId() + "' AND id_user = " + userId + ");";
		}
		System.out.println(sql);

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

	public static ExpenseTo findById(Long id, int userId) {
		String sql = "SELECT * FROM expense WHERE id = " + id + " AND id_user = " + userId + ";";
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				String wydatek = rs.getString("wydatek");
				String kategoria = rs.getString("kategoria");
				Float cena = rs.getFloat("cena");
				String status = rs.getString("status");
				Status s = Status.valueOf(status);
				Date dataWydatku = rs.getDate("data_wydatku");

				ExpenseTo newExpense = new ExpenseTo(id, wydatek, kategoria, cena, s, dataWydatku);
				return newExpense;
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	private static String buildSelectSql(Status searchStatus, String searchKategoria, String searchNazwa,
			Date dataWydatku, int userId) {
		String sql = "SELECT id, wydatek, kategoria, cena, status, data_wydatku FROM expense";

		List<String> whereParts = new ArrayList<>();

		if (searchStatus != null) {
			whereParts.add("status = '" + searchStatus.toString() + "'");
		}
		if (searchKategoria != null) {
			whereParts.add("kategoria = '" + searchKategoria + "'");
		}
		if (searchNazwa != null) {
			whereParts.add("wydatek LIKE '%" + searchNazwa + "%'");
		}
		if (dataWydatku != null) {
			whereParts.add("data_wydatku = '" + databaseDateFormatter.format(dataWydatku) + "'");
		}
		whereParts.add("id_user = " + userId);

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
				Status status = Status.valueOf(rs.getString("status"));
				Date dataWydatku = rs.getDate("data_wydatku");

				ExpenseTo newExpense = new ExpenseTo(id, wydatek, kategoria, cena, status, dataWydatku);
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

	private static String buildInsertSql(ExpenseTo newExpense, int userId) {
		String sql = "INSERT INTO expense (wydatek, kategoria, cena, status, data_wydatku, id_user) VALUES (";

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

		if (newExpense.getDataWydatku() != null) {
			insertParts.add("'" + databaseDateFormatter.format(newExpense.getDataWydatku()) + "'");
		}

		insertParts.add(String.valueOf(userId));
		if (insertParts.size() > 0) {
			String insertString = String.join(", ", insertParts);
			sql += insertString + ");";
		}
		return sql;
	}

	private static void addExpense(String sql) {
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