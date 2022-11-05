package kh.sellermoon.member.logic;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.sellermoon.member.dao.CartDao;
import kh.sellermoon.member.vo.CartVO;

@Service
public class CartLogic {
	Logger logger = LoggerFactory.getLogger(CartLogic.class);

	@Autowired
	private CartDao cartDao;
//	로직에서는 그대로 모두 사용함 - RequestParam이나 RequestMapping, Model 모두 필요 없음
//	공통된 관심사는 트랜잭션 처리 - 하나의 메소드에서 Dao에 두 개 메소드 호출
//	cart_master_t, cart_sub_t
	/*
	 * public List<Map<String,Object>> cartDetail(Map<String, Object> pMap){
	 * logger.info("cartDetail 호출 성공"); List<Map<String,Object>> cartList = null;
	 * cartList = cartDao.cartList(pMap); if(cartList!=null && cartList.size()==1) {
	 * cartDao.hitCount(pMap); } return cartList; }
	 */

	public List<CartVO> getAllCartList(int no) throws Exception {
		return cartDao.getAllCartList(no);
	}

	public String getCart() throws Exception {
		return cartDao.getCart();
	}

//	하나의 메소드 안에서 Dao의 여러 메소드를 호출할 수 있음 - 트랜잭션 처리 공통된 관심사를 갖는 부분
//	로직은 여러가지의 처리를 할 수 있고 이에 따른 선택기준이 필요한 부분
//	public int cartInsert(Map<String, Object> pMap) {
//		logger.info("cartInsert 호출 성공");
//		int result = 0;
//		int b_no = 0;
//		int b_group = 0;
//		// 글번호 채번할 때 한 번--------------------------------------------------
//		b_no = cartDao.getBNo();
//		pMap.put("b_no", b_no);
//		if(pMap.get("b_group")!=null) {
//			b_group = Integer.parseInt(pMap.get("b_group").toString());
//		}
//		// 댓글 쓰기
//		if(b_group > 0) {
////			아래 코드는 내 뒤에 댓글이 있을 때에만 처리가 됨
//			// 내 뒤에 댓글있으면 두 번---------------------------------------------
//			cartDao.bStepUpdate(pMap);
//			pMap.put("b_pos",  Integer.parseInt(pMap.get("b_pos").toString())+1);
//			pMap.put("b_step", Integer.parseInt(pMap.get("b_step").toString())+1);
//		}
//		// 새글 쓰기
//		else {
//			// 새글 쓰기에서는 댓글 쓰기와는 다르게 그룹번호를 새로 채번해야 함
//			// 새 글일 때, 그룹번호 채번할 떄 세 번 -----------------------------------
//			b_group = cartDao.getBGroup();
//			pMap.put("b_group", b_group);
//			pMap.put("b_pos", 0);
//			pMap.put("b_step", 0);
//		}
//		result = cartDao.cartInsert(pMap); // 새 글 쓰기, 댓글 쓰기 
////		result = cartDao.pro_cartinsert(pMap);
//		// 첨부파일이 있는 경우에만 cart_sub_t 추가함
//		// 첨부 파일이 있니?
//		if(pMap.get("bs_file")!=null && pMap.get("bs_file").toString().length()>1) {
//			pMap.put("b_no", b_no);
//			pMap.put("bs_seq", 1);
//			int result2 = cartDao.cartSInsert(pMap);
//			logger.info("result2가 1이면 등록 성공===> "+result2);
//		}
//		return result;
//	}

	public int cartDelete(Map<String, Object> pMap) {
		int result = 0;
		result = cartDao.cartDelete(pMap);
		return result;
	}
	
	
}
