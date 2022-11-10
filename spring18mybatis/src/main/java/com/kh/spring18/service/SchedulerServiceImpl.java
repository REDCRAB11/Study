package com.kh.spring18.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.kh.spring18.repository.CertDao;

@Service
public class SchedulerServiceImpl implements SchedulerService{
	
	@Autowired
	private CertDao certDao;
	
	//Scheduler(스케쥴러)
	// - 특정 작업을 정기적으로 반복하여 실행하는 도구 
	// - @EnableScheduling 필요 
	// - 서비스에 @Shceduled 추가 
	// - 실행 주기나 패턴을 옵션으로 저장 
	
//	@Scheduled(fixedRate = 1000) // 1000ms마다 실행
//	@Scheduled(cron = "* * * * * *")// 매초 매분 매시 매일 매월 매요일 (매 1초마다)
//	@Scheduled(cron = "0 * * * * *")// 0초 매분 매시 매일 매월 매요일(매 1분마다)
//	@Scheduled(cron = "0, 30 * * * *")//0, 30초 매분 매시 매일 매월 매요일 
//	@Scheduled(cron = "0-10 * * * *")//0~10초 매분 매시 매일 매월 매요일 
//	@Scheduled(cron = "*/5 * * * *")//5초마다  매분 매시 매일 매월 매요일
	@Scheduled(cron = "0 0 * * * *")// 매시 정각 실행
//	@Scheduled(cron = "0 0 9,18 * * *")// 출근(9) 퇴근(6)시에만 
//	@Scheduled(cron = "0 0 9-18 * * 1-5")// 매 업무시각 정각마다(9 to 6)
//	@Scheduled(cron = "0 0 9-18 * * mon-fir")// 월~금 업무시각  정각마다(9 to 6)
//	@Scheduled(cron = "0 0 15 25 * ?")//매월 25일 오후 3시마다(ex:급여)
//	@Scheduled(cron = "* * * ? * 4#2")// 매월  둘째주 목요일
//	@Scheduled(cron = "* * * ? * thu#2")// 매월  둘째주 목요일
//	@Scheduled(cron = "* * * ? * 4L")// 매월 마지막 목요일
//	@Scheduled(cron = "* * * ? * thuL")// 매월 마지막 목요일
	@Override
	public void clearCert() {
//		System.out.println(LocalDateTime.now());
		certDao.clear();
	}
	
}
