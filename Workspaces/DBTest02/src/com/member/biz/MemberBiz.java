package com.member.biz;

import java.util.List;

import com.member.dao.MemberDao;
import com.member.dto.MemberDto;

//Biz : Business Logic
//연산하거나 처리
//성별에 대문자가 들어가야하는데 소문자로 들어왔다면, 그것을 대문자로 바꿔주는 로직을 써서 처리할 것이다
public class MemberBiz {
	
	private MemberDao dao = new MemberDao();
	//전체 출력
	
	public List<MemberDto> selectList(){
		
		//Select에서는 연산할 것이 없기 때문에 그냥 다오를 리턴하도록 했다
		return dao.selectList();
	}
	
	//선택 출력
	public MemberDto selectOne(int mno) {
		
		//다오한테 보내줘야한다!
		return dao.selectOne(mno);
	}
	
	//추가
	public int insert(MemberDto dto) {
		
		dto.setMgender(dto.getMgender().toUpperCase());
		
		return dao.insert(dto);
	}
	
	//수정
	
	public int update(MemberDto dto) {
		
		return dao.update(dto);
	}
	
	//삭제
	public int delete(int mno) {
		
		return dao.delete(mno);
		
	}
	
	
	
	
	
	
	
}
