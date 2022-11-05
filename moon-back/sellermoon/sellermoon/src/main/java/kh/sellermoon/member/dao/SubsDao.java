package kh.sellermoon.member.dao;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.mybatis.spring.SqlSessionTemplate;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubsDao {
	Logger logger = LogManager.getLogger(SubsDao.class);
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate = null;

	public Map<String, Object> subsList(Map<String, Object> pMap) {
		logger.info(pMap.get("member_no"));
		Map<String, Object> subsList = null;
		subsList = sqlSessionTemplate.selectOne("subsList",pMap);
	      logger.info("pMap : "+pMap);
	      return subsList;
	}

	public Map<String, Object> subsDeliver(Map<String, Object> pMap) {
		logger.info(pMap.get("member_no"));
		Map<String, Object> subsDeliver = null;
		subsDeliver = sqlSessionTemplate.selectOne("subsDeliver",pMap);
	      logger.info("pMap : "+pMap);
	      return subsDeliver;
	}

	public Map<String, Object> subsPurchase(Map<String, Object> pMap) {
		logger.info(pMap.get("member_no"));
		Map<String, Object> subsPurchase = null;
		subsPurchase = sqlSessionTemplate.selectOne("subsPurchase",pMap);
	      logger.info("pMap : "+pMap);
	      return subsPurchase;
	}

	
	
}
