package kh.sellermoon.member.dao;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailDao {
	Logger logger = LogManager.getLogger(OrderDetailDao.class);
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate = null;
	
	public List<Map<String, Object>> orderDetailList(Map<String, Object> pMap) {
		logger.info("orderDetailList DAO 호출 성공");
		logger.info(pMap.get("ORDER_NO"));
		List<Map<String, Object>> orderDetailList = null;
		orderDetailList = sqlSessionTemplate.selectList("orderdetail", pMap);
		logger.info("pMap : " + pMap);
		return orderDetailList;
	}

	public List<Map<String, Object>> orderDetailList2(Map<String, Object> pMap) {
		logger.info("orderDetailList2 DAO 호출 성공");
		logger.info(pMap.get("ORDER_NO"));
		List<Map<String, Object>> orderDetailList2 = null;
		orderDetailList2 = sqlSessionTemplate.selectList("orderdetail2", pMap);
		logger.info("pMap : " + pMap);
		return orderDetailList2;
	}
}
