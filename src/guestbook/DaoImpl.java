package guestbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.dbconn.DBConn;

public class DaoImpl implements Dao {
	
	private DBConn db;
	
	public DaoImpl() {
		db = DBConn.getInstance();
	}

	@Override
	public void insert(Article a) {
		Connection conn = db.getConnect(); //db연결
		String sql = "insert into guestbook values(seq_guestbook.nextval,?,?,sysdate,?)";
		try{
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, a.getWriter());
			pstm.setString(2, a.getPwd());
			pstm.setString(3, a.getContent());
			int rows = pstm.executeUpdate(); //insert, update, delete 를 실행하는 메서드, 적용된 줄수 반환
			System.out.println(rows+" 줄이 추가되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try{
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public Article select(int num) { //글 번호로 하나 검색하서 article 객체로 만들어서 반환
		Connection conn = db.getConnect(); //db연결
		String sql = "select * from guestbook where num=?";
		ResultSet rs = null;
		try{
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, num);
			rs = pstm.executeQuery();
			if(rs.next()){
				return new Article(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(5));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try{
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public ArrayList<Article> selectAll() { //글 전체검색해서 article 객체로 만들어서 ArrayList에 담아 반환
		Connection conn = db.getConnect(); //db연결
		String sql = "select * from guestbook order by num desc";
		ResultSet rs = null;
		ArrayList<Article> list = new ArrayList<Article>();
		try{
			PreparedStatement pstm = conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()){
				list.add(new Article(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(5)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try{
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public void update(Article a) { // 글 번호로 찾아서 글 내용 수정
		Connection conn = db.getConnect(); //db연결
		String sql = "update guestbook set content=? where num=?";
		try{
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, a.getContent());
			pstm.setInt(2, a.getNum());
			int rows = pstm.executeUpdate();
			System.out.println(rows+" 줄이 수정 되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try{
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void delete(int num) { // 글 번호로 찾아서 삭제
		Connection conn = db.getConnect(); //db연결
		String sql = "delete guestbook where num=?";
		try{
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1,num);
			pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try{
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
