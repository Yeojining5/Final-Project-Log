package kh.sellermoon.member.controller;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import kh.sellermoon.member.logic.SubsLogic;

@RestController
@RequestMapping("/subs/*")
public class RestSubsController {
	Logger logger = LogManager.getLogger(RestSubsController.class);
	
	@Autowired
	private SubsLogic subsLogic = null;
	
	@GetMapping("subslist")
	public String SubsList(Model model, @RequestParam Map<String, Object> pMap) {
      logger.info("SubsList 호출 성공");
      
      Map<String, Object> subsList = null;
      subsList = subsLogic.subsList(pMap);
      logger.info(subsList);
      String temp = null;
      Gson g = new Gson();
      temp = g.toJson(subsList);
      return temp;
   }
	
	@GetMapping("subsdeliver")
	public String SubsDeliver(Model model, @RequestParam Map<String, Object> pMap) {
		logger.info("SubsDeliver 호출 성공");
		
		Map<String, Object> subsDeliver = null;
		subsDeliver = subsLogic.subsDeliver(pMap);
		logger.info(subsDeliver);
		String temp = null;
		Gson g = new Gson();
		temp = g.toJson(subsDeliver);
		return temp;
	}
	
	@GetMapping("subspurchase")
	public String SubsPurchase(Model model, @RequestParam Map<String, Object> pMap) {
		logger.info("SubsPurchase 호출 성공");
		
		Map<String, Object> subsPurchase = null;
		subsPurchase = subsLogic.subsPurchase(pMap);
		logger.info(subsPurchase);
		String temp = null;
		Gson g = new Gson();
		temp = g.toJson(subsPurchase);
		return temp;
	}
	
	
}
