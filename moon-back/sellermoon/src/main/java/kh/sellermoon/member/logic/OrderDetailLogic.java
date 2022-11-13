package kh.sellermoon.member.logic;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.sellermoon.member.dao.OrderDetailDao;

@Service
public class OrderDetailLogic {
	Logger logger = LogManager.getLogger(OrderDetailLogic.class);
	@Autowired
private OrderDetailDao orderdetailDao =null;
	
	public List<Map<String, Object>> orderDetailList(Map<String, Object> pMap) {
		logger.info("storeList Logic 호출 성공");
		List<Map<String, Object>> orderDetailList = null;
		orderDetailList = orderdetailDao.orderDetailList(pMap);
	      return orderDetailList;
	}

	public List<Map<String, Object>> orderDetailList2(Map<String, Object> pMap) {
		logger.info("orderDetailList2 Logic 호출 성공");
		List<Map<String, Object>> orderDetailList2 = null;
		orderDetailList2 = orderdetailDao.orderDetailList2(pMap);
	      return orderDetailList2;
	}
	}

