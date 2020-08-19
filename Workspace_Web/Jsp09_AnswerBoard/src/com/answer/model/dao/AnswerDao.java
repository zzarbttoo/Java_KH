package com.answer.model.dao;

import java.util.List;

import com.answer.model.dto.AnswerDto;

public interface AnswerDao {
	
	String SELECT_LIST_SQL = " SELECT BOARDNO, GROUPNO, GROUPSEQ, TITLETAB, TITLE, CONTENT, WRITER, REGDATE FROM ANSWERBOARD ORDER BY GROUPNO DESC, GROUPSEQ ";
	String SELECT_ONE_SQL = " SELECT BOARDNO, GROUPNO, TITLETAB, TITLE, CONTENT, WRITER, REGDATE FROM ANSWERBOARD WHERE BOARDNO = ? ";
	
	//그냥 딜리터 해도 되는 것일까
	String DELETE_BOARD_SQL = " DELETE FROM ANSWERBOARD WHERE BOARDNO = ? ";
	String UPDATE_BOARD_SQL = " UPDATE ANSWERBOARD SET TITLE = ?, CONTENT = ?, WRITER = ? WHERE BOARDNO = ? ";
	String INSERT_BOARD_SQL = " INSERT INTO ANSWERBOARD VALUES (?, ?, ?, ?, ?, ?, ?, ?) ";
	
	String UPDATE_ANSWER_SQL = " UPDATE ANSWERBOARD SET GROUPSEQ = ? + 1 WHERE GROUPNO = (SELECT GROUPNO FROM ANSWERBOARD WHERE BOARDNO = ? AND (GROUPSEQ > (SELECT GROUPSEQ FROM ANSWERBOARD WHERE BOARDNO = ?) ";
	String INSERT_ANSWER_SQL = " INSERT INTO ANSWERBOARD VALUES(BOARDNOSEQ.NEXTVAL, (SELECT GROUPNO FROM ANSWERBOARD WHERE BOARDNO = ?), (SELECT GROUPSEQ FROM ANSWERBOARD WHERE BOARDNO = ?) + 1, (SELECT TITLETAB + 1 FROM ANSWERBOARD WHERE BOARDNO = ?) , ?, ?, ?, SYSDATE) ";
	
	public List<AnswerDto> selectList();
	public AnswerDto selectOne(int boardno);
	public int update(AnswerDto dto);
	public int insert(AnswerDto dto);
	public int delete(int boardno);
	
	public int updateAnswer(int boardno);
	public int insertAnswer(AnswerDto dto);
	
}
