package kh.sellermoon.member.logic;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kh.sellermoon.member.dao.MemberMemoDao;

@Service
public class MemberMemoLogic {
	Logger logger = LoggerFactory.getLogger(MemberMemoLogic.class);
	
	@Autowired(required = false)
	private MemberMemoDao memoDao = null;
	
	// [[[[[[[[[[ 회원 보낸 쪽지함 ]]]]]]]]]]
	public List<Map<String, Object>> sendMemoList(Map<String, Object> pMap) {
		logger.info("member : sendMemoList 호출 성공");
		List<Map<String, Object>> sendMemoList = null;
		sendMemoList = memoDao.sendMemoList(pMap);
		return sendMemoList;
	}
	
	// [[[[[[[[[[ 회원 받은 쪽지함 ]]]]]]]]]]
	public List<Map<String, Object>> receiveMemoList(Map<String, Object> pMap, HttpSession session) {
		logger.info("member : receiveMemoList 호출 성공");
		List<Map<String, Object>> receiveMemoList = null;
		receiveMemoList = memoDao.receiveMemoList(pMap);
		int cnt = memoDao.noReadMemo(pMap);
		session.setAttribute("s_cnt", cnt);
		return receiveMemoList;
	}
	
	// [[[[[[[[[[ 회원 보낸 쪽지 상세 (제목 클릭 시 모달) ]]]]]]]]]]
	public Map<String, Object> sendMemoDetail(Map<String, Object> pMap) {
		logger.info("member : sendMemoDetail 호출 성공");
		Map<String, Object> sendMemoDetail = null;
		sendMemoDetail = memoDao.sendMemoDetail(pMap);
		return sendMemoDetail;
	}
	
	// [[[[[[[[[[ 회원 받은 쪽지 상세 (제목 클릭 시 모달 - 클릭 시 읽음 여부 갱신) ]]]]]]]]]]
	public Map<String, Object> receiveMemoDetail(Map<String, Object> pMap) {
		logger.info("member : receiveMemoDetail 호출 성공");
		Map<String, Object> rmap = null;
		rmap = memoDao.receiveMemoDetail(pMap); // select 
		if(rmap != null) {
			memoDao.readYnUpdate(pMap); // update
		}
		return rmap;
	}
	
	// [[[[[[[[[[ 회원 쪽지 작성 ]]]]]]]]]]
	public int memoInsert(Map<String, Object> pMap) {
		logger.info("member : memoInsert 호출 성공");
		int result = 0;
		result = memoDao.memoInsert(pMap);
		return result;
	}

	// [[[[[[[[[[ 회원 보낸 쪽지 삭제 ]]]]]]]]]]
	public int sendMemoDelete(Map<String, Object> pMap) {
		logger.info("member : sendMemoDelete 호출 성공");
		int result = 0;
		result = memoDao.sendMemoDelete(pMap);
		return result;
	}
	
	// [[[[[[[[[[ 회원 받은 쪽지 삭제 ]]]]]]]]]]
	public int receiveMemoDelete(Map<String, Object> pMap) {
		logger.info("member : receiveMemoDelete 호출 성공");
		int result = 0;
		result = memoDao.receiveMemoDelete(pMap);
		return result;
	}
}
