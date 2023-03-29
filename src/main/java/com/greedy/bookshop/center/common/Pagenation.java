package com.greedy.bookshop.center.common;

import java.util.Map;

public class Pagenation {
	
	public static SelectCriteria getSelectCriteria(int page, int totalCount, int limit, int buttonAmount, Map<String, String> searchMap) {
		
		int maxPage;
		int startPage;
		int endPage;
		int startRow;
		int endRow;
		
		maxPage = (int) Math.ceil((double) totalCount / limit);
		
		startPage = (int) (Math.ceil((double) page / buttonAmount) - 1) * buttonAmount +1;
		
		endPage = startPage + buttonAmount -1;
		
		if(maxPage < endPage) {
			endPage = maxPage;
		}
		
		if(maxPage == 0 && endPage == 0) {
			maxPage = startPage;
			endPage = startPage;
		}
		
		startRow = (page - 1) * limit + 1;
		endRow = startRow + limit - 1;
		
		SelectCriteria selectCriteria = new SelectCriteria(page, totalCount, limit, buttonAmount, maxPage, startPage, endPage, startRow, endRow);
		
		return selectCriteria;
		
	}


}
