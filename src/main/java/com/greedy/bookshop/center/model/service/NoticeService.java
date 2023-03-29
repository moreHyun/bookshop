package com.greedy.bookshop.center.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.greedy.bookshop.center.common.Pagenation;
import com.greedy.bookshop.center.common.SelectCriteria;
import com.greedy.bookshop.center.model.dao.NoticeMapper;
import com.greedy.bookshop.center.model.dto.NoticeDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class NoticeService {

	private static NoticeMapper noticeMapper; 
	
	public NoticeService(NoticeMapper noticeMapper) {
		this.noticeMapper = noticeMapper;
	}
	
	public Map<String, Object> selectNoticeList(Map<String, String> searchMap, int page) {
		
		
		/* 1. 전체 게시글 수 확인 (검색어가 있는 경우 포함) => 페이징 처리 계산을 위해서 */
		int totalCount = noticeMapper.selectNoticeCount(searchMap); 
		log.info("[BoardService] totalCount : {}", totalCount);
		
		/* 한 페이지에 보여줄 게시물의 수 */
		int limit = 5;
		/* 한 번에 보여질 페이징 버튼의 수 */
		int buttonAmount = 5;
		
		SelectCriteria selectCriteria = Pagenation.getSelectCriteria(page, totalCount, limit, buttonAmount, searchMap);
		log.info("[NoticeService] selectCriteria : {}", selectCriteria);
		
		/* 요청 페이지와 검색 기준에 맞는 게시글을 조회해온다.*/
		List<NoticeDTO> noticeList = noticeMapper.selectNoticeList(selectCriteria); 
		log.info("[NoticeService] noticeList : {}", noticeList);
		
		Map<String, Object> noticeListAndPaging = new HashMap<>();
		noticeListAndPaging.put("paging", selectCriteria);
		noticeListAndPaging.put("notice", noticeList);
		
		return noticeListAndPaging;
	}

	public static NoticeDTO selectNoticeDetail(int no) {
		
		/* 1. 조회수 로직 */
		int result = noticeMapper.incrementNoticeCount(no);
		
		/* 게시글 내용 조회 */
		return noticeMapper.selectNoticeDetail(no);
	}
	
	

}
