package pl.katarzynawojtowicz.BudgetPlanner.profit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProfitDao {
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost/homebudget";
	private static final String USER = "user";
	private static final String PASS = "password";

	private static SimpleDateFormat databaseDateFormatter = new SimpleDateFormat("yyyy-MM-dd");

	public static void addNewProfit(ProfitTo newProfit, int userId) {
		String sql = buildInsertSql(newProfit, userId);
		addProfit(sql);
	}

	private static String buildInsertSql(ProfitTo newProfit, int userId) {
		String sql = "INSERT INTO profit (nazwa, kwota, data_przychodu, id_user) VALUES (";

		List<String> insertParts = new ArrayList<>();
		insertParts.add("'" + newProfit.getNazwa() + "'");
		insertParts.add(newProfit.getKwota().toString());
		String dateString = newProfit.getDataPrzychodu() != null
				? databaseDateFormatter.format(newProfit.getDataPrzychodu())
				: "null";
		insertParts.add(dateString);
		insertParts.add(String.valueOf(userId));

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

	public static List<ProfitTo> findByParameters(String searchNazwa, Date dataPrzychodu, int userId) {
		String sql = buildSelectSql(searchNazwa, dataPrzychodu, userId);
		return performSelect(sql);
	}

	private static String buildSelectSql(String searchNazwa, Date dataPrzychodu, int userId) {
		String sql = "SELECT id, nazwa, kwota, data_przychodu FROM profit";

		sql += " WHERE id_user = " + userId;

		if (searchNazwa != null) {
			sql += " AND nazwa LIKE '%" + searchNazwa + "%'";
		}
		if (dataPrzychodu != null) {
			sql += " AND data_przychodu = '" + databaseDateFormatter.format(dataPrzychodu) + "'";
		}

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
				long idprofit = rs.getLong("id");
				String nazwa = rs.getString("nazwa");
				Float kwota = rs.getFloat("kwota");
				Date dataPrzychodu = rs.getDate("data_przychodu");

				ProfitTo newProfit = new ProfitTo(idprofit, nazwa, kwota, dataPrzychodu);
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

	public static void removeProfit(long id, int userId) {
		String sql = "DELETE FROM profit WHERE id = " + id + " AND id_user = " + userId;
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

	public static void editProfit(ProfitTo newProfit, int userId) {
		String sql = "UPDATE profit SET ";

		List<String> insertParts = new ArrayList<>();
		if (newProfit.getNazwa() != null) {
			insertParts.add("nazwa = '" + newProfit.getNazwa() + "'");
		}

		if (newProfit.getKwota() != null) {
			insertParts.add("kwota = " + newProfit.getKwota().toString());
		}

		if (newProfit.getDataPrzychodu() != null) {
			insertParts.add("data_przychodu = '" + databaseDateFormatter.format(newProfit.getDataPrzychodu()) + "'");
		}

		if (insertParts.size() > 0) {
			String insertString = String.join(", ", insertParts);
			sql += insertString + " WHERE (id = '" + newProfit.getIdprofit() + "' AND id_user = " + userId + ");";
		}

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

	public static ProfitTo findById(long id, int userId) {
		String sql = "SELECT * FROM profit WHERE id = " + id + " AND id_user = " + userId + ";";
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				String nazwa = rs.getString("nazwa");
				Float kwota = rs.getFloat("kwota");
				Date dataPrzychodu = rs.getDate("data_przychodu");
				ProfitTo newProfit = new ProfitTo(id, nazwa, kwota, dataPrzychodu);
				return newProfit;
			}
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
