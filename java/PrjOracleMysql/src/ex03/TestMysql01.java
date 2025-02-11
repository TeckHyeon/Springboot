package ex03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestMysql01 {
	
	//연결 문자열 Connection String
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3306/testdb?serverTimezone=UTC";
	private static String id = "test"; //계정이름
	private static String pw = "1234"; //비밀번호

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url,id,pw);
		String sql = "";
		sql += "SELECT ID, USERID, USERNAME, USERPASS, EMAIL";
		sql += " FROM MEMBER";
		// sql += " WHERE ID = ?"; // ? : 입력 파라미터
		PreparedStatement pstmt = conn.prepareStatement(sql);
		//파라미터 설정 ?에 값 넣기
		//pstmt.setInt(1, 1);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			int id = rs.getInt("id");
			String userid = rs.getString("userid");
			String username = rs.getString("username");
			String userpass = rs.getString("userpass");
			String email = rs.getString("email");
			String fmt = "%d %s %s %s %s";
			String msg = String.format(fmt, id, userid, username, userpass, email);
			System.out.println(msg);
		}
		pstmt.close();
		conn.close();
	}

}
