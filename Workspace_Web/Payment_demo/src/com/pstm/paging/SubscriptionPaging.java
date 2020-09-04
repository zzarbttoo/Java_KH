package com.pstm.paging;

public class SubscriptionPaging {
	
	//한번에 3개의 페이지만 보이게 할 것이다
	private final static int pageCount = 3;
	private int blockStartNum = 0;
	private int blockLastNum = 0;
	private int lastPageNum = 0;
	
	
	public int getBlockStartNum() {
		return blockStartNum;
	}
	public void setBlockStartNum(int blockStartNum) {
		this.blockStartNum = blockStartNum;
	}
	public int getBlockLastNum() {
		return blockLastNum;
	}
	public void setBlockLastNum(int blockLastNum) {
		this.blockLastNum = blockLastNum;
	}
	public int getLastPageNum() {
		return lastPageNum;
	}
	public void setLastPageNum(int lastPageNum) {
		this.lastPageNum = lastPageNum;
	}
	public static int getPagecount() {
		return pageCount;
	}
	
	//block 생성   
	//현재 페이지가 속한 block 의 시작 번호, 끝 번호를 계산 
	
	public void makeBlock(int curPage) {
		
		
	}
	
	
	
	

}
