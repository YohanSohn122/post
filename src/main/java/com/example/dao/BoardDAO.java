package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.bean.BoardVO;
import com.example.common.JDBCUtil;

public class BoardDAO {
	
	Connection conn = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	private final String BOARD_INSERT = "insert into BOARD (firstName, lastName, team, age, aav, teamControl) values (?,?,?,?,?,?)";
	private final String BOARD_UPDATE = "update BOARD set firstName=?, lastName=?, team=? , age=?, aav=?, teamControl=?, where seq=?";
	private final String BOARD_DELETE = "delete from BOARD  where seq=?";
	private final String BOARD_GET = "select * from BOARD  where seq=?";
	private final String BOARD_LIST = "select * from BOARD order by seq desc";

	public int insertBoard(BoardVO vo) {
		System.out.println("===> JDBC로 insertBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_INSERT);
			stmt.setString(1, vo.getFisrtName());
			stmt.setString(2, vo.getLastName());
			stmt.setString(3, vo.getTeam());
			stmt.setInt(4, vo.getAge());
			stmt.setString(5, vo.getAav());
			stmt.setInt(6, vo.getTeamControl());
			stmt.executeUpdate();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	// 글 삭제
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> JDBC로 deleteBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_DELETE);
			stmt.setInt(1, vo.getSeq());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int updateBoard(BoardVO vo) {
		System.out.println("===> JDBC로 updateBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_UPDATE);
			stmt.setString(1, vo.getFisrtName());
			stmt.setString(2, vo.getLastName());
			stmt.setString(3, vo.getTeam());
			stmt.setInt(4, vo.getAge());
			stmt.setString(5, vo.getAav());
			stmt.setInt(6, vo.getTeamControl());
			stmt.setInt(4, vo.getSeq());
			
			
			System.out.println(vo.getFisrtName() + "-" + vo.getLastName() + "-" + vo.getTeam() + "-" + vo.getAge() + "-" + vo.getAav() + "-" + vo.getTeamControl() + "-" + vo.getSeq());
			stmt.executeUpdate();
			return 1;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}	
	
	public BoardVO getBoard(int seq) {
		BoardVO one = new BoardVO();
		System.out.println("===> JDBC로 getBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_GET);
			stmt.setInt(1, seq);
			rs = stmt.executeQuery();
			if(rs.next()) {
				one.setSeq(rs.getInt("seq"));
				one.setFisrtName(rs.getString("firstName"));
				one.setLastName(rs.getString("lastName"));
				one.setTeam(rs.getString("team"));
				one.setAge(rs.getInt("age"));
				one.setAav(rs.getString("aav"));
				one.setTeamControl(rs.getInt("teamControl"));
				one.setCnt(rs.getInt("cnt"));
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return one;
	}
	
	public List<BoardVO> getBoardList(){
		List<BoardVO> list = new ArrayList<BoardVO>();
		System.out.println("===> JDBC로 getBoardList() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_LIST);
			rs = stmt.executeQuery();
			while(rs.next()) {
				BoardVO one = new BoardVO();
				one.setSeq(rs.getInt("seq"));
				one.setFisrtName(rs.getString("firstName"));
				one.setLastName(rs.getString("lastName"));
				one.setTeam(rs.getString("team"));
				one.setAge(rs.getInt("age"));
				one.setAav(rs.getString("aav"));
				one.setTeamControl(rs.getInt("teamControl"));
				one.setRegdate(rs.getDate("regdate"));
				one.setCnt(rs.getInt("cnt"));
				list.add(one);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return list;
	}

	public String getPhotoFileName(int sid) {
		String filename = null;
		try{
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_GET);
			stmt.setInt(1, sid);
			rs = stmt.executeQuery();
			if (rs.next()){
				filename = rs.getString("photo");
			}
			rs.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		System.out.println("===> JDBC로 getPhotoFilename() 기능 처리");
		return filename;
	}
}
