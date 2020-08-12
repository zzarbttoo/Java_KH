package com.login.dao;

import static com.login.db.JDBCTemplate.close;
import static com.login.db.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.login.dto.MYDto;

public class MYDao {

	// ADMIN

	// 1. 회원 전체 정보(탈퇴한 회원 포함)
	public List<MYDto> selectListAll() {

		Connection con = getConnection();

		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<MYDto> list = new ArrayList<MYDto>();
		String sql = " SELECT MYNO, MYID, MYPW, MYNAME, MYADDR, MYPHONE, MYEMAIL, MYENABLED, MYROLE FROM MYMEMBER ";

		try {
			pstm = con.prepareStatement(sql);

			rs = pstm.executeQuery();

			while (rs.next()) {

				MYDto dto = new MYDto();

				dto.setMyno(rs.getInt(1));
				dto.setMyid(rs.getString(2));
				dto.setMypw(rs.getString(3));
				dto.setMyname(rs.getString(4));
				dto.setMyaddr(rs.getString(5));
				dto.setMyphone(rs.getString(6));
				dto.setMyemail(rs.getString(7));
				dto.setMyenabled(rs.getString(8));
				dto.setMyrole(rs.getString(9));

				list.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			close(rs);
			close(pstm);
			close(con);

		}

		return list;
	}

	// 2. 가입된 회원 전체 정보
	public List<MYDto> selectListEnabled() {

		Connection con = getConnection();

		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<MYDto> list = new ArrayList<MYDto>();
		String sql = " SELECT MYNO, MYID, MYPW, MYNAME, MYADDR, MYPHONE, MYEMAIL, MYENABLED, MYROLE FROM MYMEMBER WHERE MYENABLED = ? ";

		try {
			pstm = con.prepareStatement(sql);

			pstm.setString(1, "Y");
			rs = pstm.executeQuery();

			while (rs.next()) {

				MYDto dto = new MYDto();

				dto.setMyno(rs.getInt(1));
				dto.setMyid(rs.getString(2));
				dto.setMypw(rs.getString(3));
				dto.setMyname(rs.getString(4));
				dto.setMyaddr(rs.getString(5));
				dto.setMyphone(rs.getString(6));
				dto.setMyemail(rs.getString(7));
				dto.setMyenabled(rs.getString(8));
				dto.setMyrole(rs.getString(9));

				list.add(dto);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			close(rs);
			close(pstm);
			close(con);

		}

		return list;
	}

	// 3. 회읜 등급 조정

	// USER
	// 1. 로그인

	public MYDto login(String myid, String mypw) {

		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		MYDto dto = null;

		// 패스워드, 아이디, 그리고 회원 가입 여부를 쓴다
		String sql = " SELECT MYNO, MYID, MYPW, MYNAME, MYADDR, MYPHONE, MYEMAIL, MYENABLED, MYROLE FROM MYMEMBER WHERE MYID = ? AND MYPW = ? AND MYENABLED = ? ";

		try {

			// 쿼리 준비
			pstm = con.prepareStatement(sql);
			pstm.setString(1, myid);
			pstm.setString(2, mypw);
			pstm.setString(3, "Y");

			// 쿼리 실행 및 리턴
			rs = pstm.executeQuery();

			while (rs.next()) {

				dto = new MYDto();
				dto.setMyno(rs.getInt(1));
				dto.setMyid(rs.getString(2));
				dto.setMypw(rs.getString(3));
				dto.setMyname(rs.getString(4));
				dto.setMyaddr(rs.getString(5));
				dto.setMyphone(rs.getString(6));
				dto.setMyemail(rs.getString(7));
				dto.setMyenabled(rs.getString(8));
				dto.setMyrole(rs.getString(9));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			close(rs);
			close(pstm);
			close(con);

		}

		return dto;

	}

	// 2. 회원 가입

	// 3. 내 정보 조회

	// 4. 내 정보 수정

	// 5. 회원 탈퇴

}
