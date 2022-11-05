package kh.sellermoon.member.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kh.sellermoon.admin.controller.RestAdminController;
import kh.sellermoon.member.logic.MemberLogic;
import kh.sellermoon.member.logic.PaymentLogic;
import kh.sellermoon.member.vo.MemberVO;
import kh.sellermoon.member.vo.PointVO;

@RestController
@RequestMapping("/*")
public class RestPaymentController {
	Logger logger = LoggerFactory.getLogger(RestPaymentController.class);
	
	@Autowired
	private PaymentLogic paymentLogic = null;
	
	@ResponseBody
	@PostMapping("paymentInsert")
	public String RestpaymentInsert(@RequestBody Map<String, Object> pMap) {
		logger.info("RestpaymentInsert 호출 성공");
		logger.info("pMap");
		int result = 0;
		result = paymentLogic.paymentInsert(pMap);
		logger.info(result+"");
	   return ""+result; // 문자열 붙이면 String 타입으로 형전환
	}   
	
	
}
