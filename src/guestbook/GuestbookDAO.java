package guestbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


// DataAccessObject
public class GuestbookDAO {
	public int addGuestbook(Guestbook guestbook){
		int addCount = 0;
		// db 연결
		// sql 문자열을 db에 준비
		// 바인딩(?를 설정)
		// sql을 실행
		// db 연결 close
		
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn = DBUtil.getConnection();
			String sql = "insert into guestbook (name, content, create_date, ip) values (?, ?, now(), ?)";
			//sql을 dbms에 준비.
			ps = conn.prepareStatement(sql);
			// 바인딩 (?에 값을 설정)
			ps.setString(1, guestbook.getName());
			ps.setString(2, guestbook.getContent());
			ps.setString(3, guestbook.getIp());
			//실행
			addCount = ps.executeUpdate();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			if(ps != null){
				try{ ps.close(); }catch(Exception e){}
			}
			if(conn != null){
				try{ conn.close(); }catch(Exception e){}
			}			
		}// finally
		
		
		return addCount;
	}
	
	public List<Guestbook> getGuestbook(int pg){
		List<Guestbook> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = DBUtil.getConnection();
			String sql = "select id, name, content, create_date, ip from guestbook order by id desc limit ?,?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, pg * 5 - 5);
			ps.setInt(2, 5);
			rs = ps.executeQuery();
			while(rs.next()){
				Guestbook guest = new Guestbook();
				guest.setId(rs.getLong(1));
				guest.setName(rs.getString(2));
				guest.setContent(rs.getString(3));
				guest.setCreateDate(rs.getDate(4));
				guest.setIp(rs.getString(5));
				list.add(guest);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			if(rs != null){
				try{rs.close();}catch(Exception e){}
			}
			if(ps != null){
				try{ps.close();}catch(Exception e){}
			}	
			if(conn != null){
				try{ps.close();}catch(Exception e){}
			}			
		}		
		return list;
	}
	
	public int getGuestbookCount(){
		int count = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = DBUtil.getConnection();
			String sql = "select count(*) from guestbook";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			rs.next(); // 한건의 row를 가져온다.
			count = rs.getInt(1); // 첫번째 칼럼의 값을 리터
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			if(rs != null){
				try{rs.close();}catch(Exception e){}
			}
			if(ps != null){
				try{ps.close();}catch(Exception e){}
			}	
			if(conn != null){
				try{ps.close();}catch(Exception e){}
			}			
		}
		return count;
	}
	
	public int deleteGuestbook(long id){
		int deleteCount = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn = DBUtil.getConnection();
			String sql = "delete from guestbook where id = ?";
			//sql을 dbms에 준비.
			ps = conn.prepareStatement(sql);
			// 바인딩 (?에 값을 설정)
			ps.setLong(1, id);
			//실행
			deleteCount = ps.executeUpdate();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			if(ps != null){
				try{ ps.close(); }catch(Exception e){}
			}
			if(conn != null){
				try{ conn.close(); }catch(Exception e){}
			}			
		}// finally
				
		return deleteCount;
	}
}

/*
CREATE TABLE guestbook( 
id int(11) unsigned NOT NULL auto_increment, 
name varchar(20) NULL, 
content text, 
create_date datetime NULL, 
ip varchar(16) NULL, 
PRIMARY KEY (id) 
); 


insert into guestbook (name, content, create_date, ip) 
values ('kim', 'hello', now(), '127.0.0.1'); 

select id, name, content, create_date, ip from guestbook 
order by id desc; 

delete from guestbook where id = 1; 
*/