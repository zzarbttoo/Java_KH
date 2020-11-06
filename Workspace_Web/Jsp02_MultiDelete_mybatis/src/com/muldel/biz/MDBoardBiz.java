package com.muldel.biz;

import java.util.List;

import com.muldel.dao.MDBoardDao;
import com.muldel.dto.MDBoardDto;

//MDBoardService라고 하기도 한다
public class MDBoardBiz {
	
	private MDBoardDao dao = new MDBoardDao();
	

	public List<MDBoardDto> selectList() {

		return dao.selectList();

	}

	public MDBoardDto selectOne(int seq) {

		return dao.selectOne(seq);
	}

	public int update(MDBoardDto dto) {

		return dao.update(dto);
	}

	public int delete(int seq) {

		return dao.delete(seq);
	}

	public int insert(MDBoardDto dto) {

		
		return dao.insert(dto);

	}

	// delete at Once
	public int multiDelete(String[] seqs) {


		return dao.multiDelete(seqs);
	}
}
