package kh.sellermoon.member.logic;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.sellermoon.admin.dao.AmdDao;
import kh.sellermoon.admin.logic.AmdLogic;
import kh.sellermoon.member.dao.PaymentDao;

@Service
public class PaymentLogic {
	Logger logger = LogManager.getLogger(AmdLogic.class);
	@Autowired
private PaymentDao paymentDao =null;
	public int paymentInsert(Map<String, Object> pMap) {
		logger.info("paymentInsert Logic 호출 성공");
		int result = 0;
		result = paymentDao.paymentInsert(pMap);
		return result;
	}
}
