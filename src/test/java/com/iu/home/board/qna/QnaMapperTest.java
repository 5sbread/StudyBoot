package com.iu.home.board.qna;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.iu.home.util.Pager;

@SpringBootTest
//@Rollback(true)
@Transactional
class QnaMapperTest {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private QnaMapper qnaMapper;
	
	private QnaVO qnaVO;
	
	@BeforeAll
	static void befoAll() {
		System.out.println("전체 Test 실행전 !!!!");
	}
	
	@AfterAll
	static void afterAll() {
		System.out.println("전체 Test 실행 후 !!!!");
	}
	
	@BeforeEach
	void beforeEach() {
		System.out.println("Test 메서드 실행 전");
		qnaVO = new QnaVO();
		qnaVO.setNum(1L);
		qnaVO.setContents("contents");
	}
	
	@AfterEach
	void afterEach() {
		System.out.println("Test 메서드 실행 후");
	}
	
	//@Test
	@Transactional
	void test2() throws Exception {
		//qnaMapper.setUpdate(qnaVO);
		//qnaMapper.setDelete(qnaVO);
		for(int i=0;i<100;i++) {
			qnaVO = new QnaVO();
			qnaVO.setTitle("Title"+i);
			qnaVO.setWriter("Writer"+i);
			qnaVO.setContents("Contents"+i);
			int result = qnaMapper.setAdd(qnaVO);
		}
		log.info("1000000000000000000");
	}

	//@Test
	void test() throws Exception {
		Pager pager = new Pager();
		pager.makeRow();
		List<QnaVO> ar = qnaMapper.getList(pager);
		log.info("List {} ", ar);
		assertNotEquals(0, ar.size());
	
	}

}
