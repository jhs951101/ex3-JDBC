package pkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestDatabase {
	
	public static void main(String args[])
	{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://localhost/mysql", "root", "leon9025");
			// MariaDB에 연결 시도 (에러 발생 시 '?useSSL=false'을 링크에 추가)
			
			String query = "SELECT USER FROM USER";
				
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();

			System.out.println("<테이블 출력 결과>");
			
			while(rs.next()) {
				System.out.println(rs.getString(1));  // 쿼리문 실행 후 결과값 출력
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				conn.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}