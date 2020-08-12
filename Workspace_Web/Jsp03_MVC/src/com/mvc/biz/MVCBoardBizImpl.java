package com.mvc.biz;

import java.util.List;

import com.mvc.dao.MVCBoardDao;
import com.mvc.dao.MVCBoardDaoImpl;
import com.mvc.dto.MVCBoardDto;

public class MVCBoardBizImpl implements MVCBoardBiz {

	//다형성->객체간의 결함도가 낮아진다(이렇게 하면 편하다)
	private MVCBoardDao dao = new MVCBoardDaoImpl();
			
	@Override
	public List<MVCBoardDto> selectList() {
		return dao.selectList();
	}

	@Override
	public MVCBoardDto selectOne(int seq) {
		return dao.selectOne(seq);
	}

	@Override
	public boolean insert(MVCBoardDto dto) {
		return dao.insert(dto);
	}

	@Override
	public boolean update(MVCBoardDto dto) {
		return dao.update(dto);
	}

	@Override
	public boolean delete(int seq) {
		return dao.delete(seq);
	}

}
