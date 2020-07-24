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
		Connection conn = db.getConnect(); //db����
		String sql = "insert into guestbook values(seq_guestbook.nextval,?,?,sysdate,?)";
		try{
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, a.getWriter());
			pstm.setString(2, a.getPwd());
			pstm.setString(3, a.getContent());
			int rows = pstm.executeUpdate(); //insert, update, delete �� �����ϴ� �޼���, ����� �ټ� ��ȯ
			System.out.println(rows+" ���� �߰��Ǿ����ϴ�.");
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
	public Article select(int num) { //�� ��ȣ�� �ϳ� �˻��ϼ� article ��ü�� ���� ��ȯ
		Connection conn = db.getConnect(); //db����
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
	public ArrayList<Article> selectAll() { //�� ��ü�˻��ؼ� article ��ü�� ���� ArrayList�� ��� ��ȯ
		Connection conn = db.getConnect(); //db����
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
	public void update(Article a) { // �� ��ȣ�� ã�Ƽ� �� ���� ����
		Connection conn = db.getConnect(); //db����
		String sql = "update guestbook set content=? where num=?";
		try{
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, a.getContent());
			pstm.setInt(2, a.getNum());
			int rows = pstm.executeUpdate();
			System.out.println(rows+" ���� ���� �Ǿ����ϴ�.");
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
	public void delete(int num) { // �� ��ȣ�� ã�Ƽ� ����
		Connection conn = db.getConnect(); //db����
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
