package com.iu.home.schedule;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.iu.home.member.MemberMapper;
import com.iu.home.member.MemberVO;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class TestSchedule {
	
	@Autowired
	private MemberMapper memberMapper;
	
	//@Scheduled(fixedRate = 3000, initialDelayString = "1000")
	public void ts1 () {
		log.info("Schedule 실행 =O.O=");
		try {
			Thread.sleep(4000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	//@Scheduled(cron = "30 * * * * *")
	public void cron () throws Exception {
		log.info("Cron 매초 실행 🐱");
		log.info(Calendar.getInstance().getTime().toString());
		
		MemberVO memberVO = new MemberVO();
		memberVO.setId("AutoID"+Calendar.getInstance().getTimeInMillis());
		memberVO.setPw("123");
		memberVO.setName("Name"+Calendar.getInstance().getTimeInMillis());
		memberVO.setEmail("eebb"+Calendar.getInstance().getTimeInMillis()+"@gmail.com");
		log.info("Result {}", memberMapper.setJoin(memberVO));
		
	}

}
