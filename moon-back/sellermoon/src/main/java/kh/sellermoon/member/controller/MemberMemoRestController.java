package kh.sellermoon.member.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

/*
	<<<회원>>> MemoRestController (받은 쪽지, 보낸 쪽지 조회 select)
*/
@RestController
@RequestMapping("/member/memo/*")
public class MemberMemoRestController {
	Logger logger = LoggerFactory.getLogger(MemberMemoRestController.class);
	
	// [[[[[[[[[[ 회원 보낸 쪽지 전체조회, 상세조회, 조건검색 ]]]]]]]]]]
	@GetMapping("jsonSendMemoList")
	public String jsonSendMemoList(@RequestParam Map<String, Object> pMap) {
		logger.info("member : jsonSendMemoList 호출 성공");
		List<Map<String, Object>> sendMemoList = null;
		String gSendMemoList = null;
		Gson g = new Gson();
		gSendMemoList = g.toJson(sendMemoList);
		return gSendMemoList;
	}
	
	// [[[[[[[[[[ 회원 받은 쪽지 전체조회, 상세조회, 조건검색 ]]]]]]]]]]
	@GetMapping("jsonReceiveMemoList")
	public String jsonReceiveMemoList(@RequestParam Map<String, Object> pMap) {
		logger.info("member : jsonReceiveMemoList 호출 성공");
		List<Map<String, Object>> receiveMemoList = null;
		String gReceiveMemoList = null;
		Gson g = new Gson();
		gReceiveMemoList = g.toJson(receiveMemoList);
		return gReceiveMemoList;
	}
}
