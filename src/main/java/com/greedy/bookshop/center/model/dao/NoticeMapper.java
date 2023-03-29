package com.greedy.bookshop.center.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.greedy.bookshop.center.common.SelectCriteria;
import com.greedy.bookshop.center.model.dto.NoticeDTO;

@Mapper
public interface NoticeMapper {
	
	int selectNoticeCount(Map<String, String> searchMap);
	
	List<NoticeDTO> selectNoticeList(SelectCriteria selectCriteria);

	int incrementNoticeCount(int no);

	NoticeDTO selectNoticeDetail(int no);

	

    


}
