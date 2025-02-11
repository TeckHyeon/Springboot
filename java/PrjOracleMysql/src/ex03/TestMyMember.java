package ex03;

import java.sql.*;

public class TestMyMember {
	private static String driver = "oracle.jdbc.OracleDriver";
	private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String dbuid = "hr";
	private static String dbpwd = "1234";

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, dbuid, dbpwd);
		String sql = "{ CALL GET_DNAME_ENAME(?, ?, ?) }";
		CallableStatement cstmt = conn.prepareCall(sql);
		cstmt.setInt(1, 100);
		cstmt.registerOutParameter(2, Types.VARCHAR);
		cstmt.registerOutParameter(3, Types.VARCHAR);
		cstmt.execute();
		System.out.println(cstmt.getString(2));
		System.out.println(cstmt.getString(3));
		cstmt.close();
		conn.close();
	}

}
