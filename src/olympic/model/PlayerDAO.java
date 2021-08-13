package olympic.model;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.log4j.Logger;

import olympic.exception.NotExistException;
import olympic.model.dto.PlayerDTO;
import olympic.model.util.DBUtil;

public class PlayerDAO {
	
	static Logger logger = Logger.getLogger("olympic.view.PlayerDAO");
	private static Properties sql = DBUtil.getSql();
	
	//���� ���� �߰�
	public static boolean addPlayer(PlayerDTO player) throws SQLException {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("addPlayer"));
						
			pstmt.setInt(1, player.getPlayerNum());
			pstmt.setString(2, player.getName());
			pstmt.setInt(3, player.getAge());
			pstmt.setString(4, player.getCountry());
			pstmt.setString(5, player.getSportName());
						
			int result = pstmt.executeUpdate();
					
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}
			
	//������ȣ�� �����̸� ����
	public static boolean updatePlayer(String name, int playerNum) throws SQLException {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try{
			con = DBUtil.getConnection();
			
			//player table ����
			pstmt = con.prepareStatement(sql.getProperty("updatePlayer"));
			pstmt.setString(1, name);
			pstmt.setInt(2, playerNum);
						
			int result = pstmt.executeUpdate();
			
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	//�����̸����� Ư�� ���� ���� ����
	public static boolean deletePlayer(String sportName, String name) throws SQLException {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("deletePlayer"));
			pstmt.setString(1, sportName);
			pstmt.setString(1, name);
			
			int result = pstmt.executeUpdate();
			
			if(result == 1){
				return true;
			}
		}finally{
			DBUtil.close(con, pstmt);
		}
		return false;
	}
	
	//Ư�� ���� ���� ��ȯ
	public static PlayerDTO getPlayer(String country, String name) throws SQLException, NotExistException {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		PlayerDTO player = null;
		
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("getPlayer"));
			pstmt.setString(1, country);
			pstmt.setString(2, name);
			rset = pstmt.executeQuery();
			
			if(rset.next()){
				logger.info(rset.getString(2));
				player = new PlayerDTO(rset.getInt(1), rset.getString(2), rset.getInt(3), rset.getString(4), rset.getString(5));
			}else {
				throw new NotExistException("���� ������ �����ϴ�");
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return player;
	}
			
	//��� ���� ���� ��ȯ
	public static ArrayList<PlayerDTO> getAllPlayer() throws SQLException {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<PlayerDTO> list = null;
	
		try{
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql.getProperty("getAllPlayer"));
			rset = pstmt.executeQuery();
			list = new ArrayList<PlayerDTO>();
			
			while(rset.next()){
				list.add(new PlayerDTO(rset.getInt(1), rset.getString(2), rset.getInt(3), rset.getString(4), rset.getString(5)));
			}
		}finally{
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
}