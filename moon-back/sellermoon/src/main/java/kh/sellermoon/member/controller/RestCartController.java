package kh.sellermoon.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kh.sellermoon.member.logic.CartLogic;
import kh.sellermoon.member.logic.MemberLogic;
import kh.sellermoon.member.logic.PCartLogic;
import kh.sellermoon.member.vo.CartVO;
import kh.sellermoon.member.vo.MemberVO;

import com.google.gson.Gson;
 
@RestController
@RequestMapping("/cart/*")
public class RestCartController {
	Logger logger = LogManager.getLogger(RestCartController.class);

	@Autowired
	private CartLogic cartLogic;
	
	@Autowired
	private PCartLogic pCartLogic;
	
	
	@GetMapping("jsonList")
	public String getAllCartList(HttpServletRequest req) {
		String result = "";
		try {
			HttpSession session = req.getSession();
			// 리액트 로그인 오류 해결 이후 해당 구문 주석 해제
			//MemberVO member = (MemberVO)session.getAttribute("member");
			//logger.info("member: " + member);
			//int memberNo = member.getMember_no();
			int memberNo = 1;
			List<CartVO> cartList =  pCartLogic.getAllCartList(memberNo);
			logger.info("cartList size: " +cartList.size());
			logger.info("cartList: " +cartList);
			
			Gson g = new Gson();
			result =  g.toJson(cartList);
		
		}catch (Exception e) {
			logger.error("error : " +	e.getStackTrace());
			logger.error("error msg : " +	e.getMessage());
		}
		
		return result;
	}

//	@GetMapping("jsonList")
//	public String CartList(@RequestParam Map<String, Object> pMap) {
//		logger.info("jsonCartList 호출 성공" + pMap);
//		List<Map<String, Object>> cartList = null;
//		cartList = cartLogic.cartList(pMap);
////		logger.info(cartList);
//		Gson g = new Gson();
//		String temp = g.toJson(cartList);
//		return temp;
//	}
	
	/*
	 * @PostMapping("rcartInsert") public String
	 * rcartInsert(MultipartHttpServletRequest mpRequest, @RequestParam(value =
	 * "bs_file", required = false) MultipartFile bs_file) { int result = 0;
	 * Map<String, Object> pMap = new HashMap<>(); HashMapBinder hmb = new
	 * HashMapBinder(mpRequest); hmb.mbind(pMap);
	 * logger.info("cartInsert 호출 성공 ==> "+pMap); if(!bs_file.isEmpty()) { String
	 * filename= bs_file.getOriginalFilename(); String savePath =
	 * "C:\\workspace_spring\\demo0921\\src\\main\\webapp\\pds"; // 파일 풀 네임 담기
	 * String fullPath = savePath+"\\"+filename; try { // File객체는 파일 명을 객체화 해줌 File
	 * file = new File(fullPath); // cart_sub_t에 파일크기를 담기 위해 byte[] bytes =
	 * bs_file.getBytes(); BufferedOutputStream bos = new BufferedOutputStream(new
	 * FileOutputStream(file)); // 실제로 파일 내용이 채워짐 bos.write(bytes); bos.close();
	 * long size = file.length(); double d_size = Math.floor(size/1024.0); //kb
	 * logger.info("size: "+d_size); pMap.put("bs_file", filename);
	 * pMap.put("bs_size", d_size);
	 * logger.info("파일 정보 : "+pMap.get("bs_file")+", "+pMap.get("bs_size")); } catch
	 * (Exception e) { e.printStackTrace(); } } result = cartLogic.cartInsert(pMap);
	 * return String.valueOf(result); }
	 */
}
