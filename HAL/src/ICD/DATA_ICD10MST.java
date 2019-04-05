package ICD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DATA_ICD10MST {
	static final String DRIVER_EXCEL = "sun.jdbc.odbc.JdbcOdbcDriver";
	static final String DATABASE_EXCEL = "jdbc:odbc:ICDExcel";
	static final String DRIVER_SQL = "com.mysql.jdbc.Driver";
	static final String DATABASE_SQL = "jdbc:mysql://158.94.0.201:8081/hms_new";
	static int x = 0;
	static int x1 = 0;

	public static void main(String[] args) {
		try {
			java.sql.PreparedStatement preparedStatement = getPreparedStatement();
			Class.forName(DRIVER_EXCEL);
			Connection conn = null;
			conn = DriverManager.getConnection(DATABASE_EXCEL);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from [ICD10MST$]");
			////System.out.println("DATABASE_EXCEL>>: " + DATABASE_EXCEL);
			////System.out.println("Connection excel >>: " + conn);

			while (rs.next()) {

				String icode = rs.getString(2);
				String iname = rs.getString(3);
				String ssubgrpcd = rs.getString(4);

				Class.forName(DRIVER_SQL);
				Connection conndb = DriverManager.getConnection(DATABASE_SQL,
						"hms", "hms");

				////System.out.println("DATABASE_SQL >>: " + DATABASE_SQL);
				////System.out.println("Connection Sql>>: " + conndb);

				Statement stmtdb = conndb.createStatement();
				ResultSet rsdb = stmtdb
						.executeQuery("SELECT icd_sub_category_id FROM mas_icd_sub_category where icd_sub_category_code='"
								+ ssubgrpcd + "'");

				while (rsdb.next()) {

					int id = rsdb.getInt(1);

					////System.out.println("id>>>>" + id);
					////System.out.println(icode);

					if (icode != null) {
						preparedStatement.setString(1, icode);
						preparedStatement.setString(2, iname);
						preparedStatement.setInt(3, id);

						int y = preparedStatement.executeUpdate();
						////System.out.println("y in 0000---------" + y);
					}
				}
				x1++;
				rsdb.close();
				stmtdb.close();
			}

			x++;
			rs.close();
			stmt.close();
		} catch (ClassNotFoundException cnfe) {
			System.err.println("ClassNotFoundException Was Thrown");
			cnfe.printStackTrace();
		} catch (SQLException sqle) {
			System.err.println("SQLException Was Thrown");
			String cause = sqle.getLocalizedMessage();
			////System.out.println("message===" + cause);
			sqle.printStackTrace();
		}
	}

	private static java.sql.PreparedStatement getPreparedStatement()
			throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		java.sql.Connection connection = DriverManager.getConnection(
				"jdbc:mysql://192.168.202.161:3306/hms", "hms", "hms");

		java.sql.PreparedStatement preparedStatement = connection
				.prepareStatement("insert into mas_icd values(icd_id,?,?,?,'y','admin','2008-03-19','00:00:00',1)");
		return preparedStatement;
	}

}
