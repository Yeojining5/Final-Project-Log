package kh.sellermoon.member.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import kh.sellermoon.member.vo.CartVO;
import kh.sellermoon.member.vo.MdVO;

@Service
public class PCartDao {
	Logger logger = LoggerFactory.getLogger(PCartDao.class);

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public List<CartVO> getAllCarts(int no) {
		List<CartVO> list = sqlSessionTemplate.selectList("getAllPCartList", no);
		logger.info("P-CART "+  list);
		return list;
	}

	
}