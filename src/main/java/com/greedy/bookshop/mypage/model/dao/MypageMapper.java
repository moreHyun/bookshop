package com.greedy.bookshop.mypage.model.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.greedy.bookshop.center.common.SelectCriteria;
import com.greedy.bookshop.mypage.model.dto.OrderDTO;

@Mapper
public interface MypageMapper {
	
	int selectPayCount();
	
	int selectReadyCount();
	
	int selectCompleteCount();

	int selectOrderCount(Map<String, String> searchMap);

	List<OrderDTO> selectOrderList(SelectCriteria selectCriteria);

	int selectRefundCount(Map<String, String> searchMap);

	List<OrderDTO> selectRefundList(SelectCriteria selectCriteria);

	int selectYesCount();

	int selectNoCount();
	


}
