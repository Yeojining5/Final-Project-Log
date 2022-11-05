package kh.sellermoon.member.dao;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.sellermoon.admin.dao.AmdDao;

@Service
public class PaymentDao {
	Logger logger = LogManager.getLogger(AmdDao.class);
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate = null;
	public int paymentInsert(Map<String, Object> pMap) {
		logger.info("paymentInsert DAO 호출 성공");
		int result = 0;
		result = sqlSessionTemplate.update("paymentInsert", pMap);
		logger.info("pMap : " + pMap);
		return result;
	}
}
