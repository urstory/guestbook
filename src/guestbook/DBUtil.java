package guestbook;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	public static Connection getConnection() throws Exception{
		String url = "jdbc:mysql://127.0.0.1:3306/guestbook";        // 사용하려는 데이터베이스명을 포함한 URL 기술
		String id = "guestbook";                                                    // 사용자 계정
		String pw = "guestbook";                                                // 사용자 계정의 패스워드

		Class.forName("com.mysql.jdbc.Driver");                       // 데이터베이스와 연동하기 위해 DriverManager에 등록한다.
		Connection conn=DriverManager.getConnection(url,id,pw);  		
		return conn;
	}
	
	public static void main(String[] args) throws Exception{
		Connection conn = DBUtil.getConnection();
		if(conn != null){
			System.out.println("conn is ok");
		}
	}
}
