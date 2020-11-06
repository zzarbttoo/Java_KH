package com.answer.model.dao;

import java.util.List;

import com.answer.model.dto.AnswerDto;

public interface AnswerDao {
	
	String SELECT_LIST_SQL=" SELECT BOARDNO, GROUPNO, GROUPSEQ, TITLETAB, DELFLAG, TITLE, CONTENT, WRITER, REGDATE FROM ANSWERBOARD ORDER BY GROUPNO DESC, GROUPSEQ ";
	String SELECT_ONE_SQL =" SELECT BOARDNO, GROUPNO, GROUPSEQ, TITLETAB, DELFLAG, TITLE, CONTENT, WRITER, REGDATE FROM ANSWERBOARD WHERE BOARDNO = ? ";
	String INSERT_BOARD_SQL = " INSERT INTO ANSWERBOARD VALUES(BOARDNOSEQ.NEXTVAL, GROUPNOSEQ.NEXTVAL, 1, 0, 'N', ?, ?, ?, SYSDATE ) ";
	String UPDATE_BOARD_SQL =" UPDATE ANSWERBOARD SET TITLE = ?, CONTENT = ? WHERE BOARDNO = ? ";
	String DELETE_BOARD_SQL = " UPDATE ANSWERBOARD SET DELFALG = 'Y' WHERE BOARDNO = ? ";
	String UPDATE_ANSWER_SQL = "";
	String INSERT_ANSWER_SQL = "";
	
	public List<AnswerDto> selectList();
	public AnswerDto selectOne(int boardno);
	public int insertBoard(AnswerDto dto);
	public int updateBoard(AnswerDto dto);
	public int deleteBoard(int boardno);
	public int updateAnswer(int parentboardno);
	public int insertAnswer(AnswerDto dto);

}
