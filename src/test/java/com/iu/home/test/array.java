package com.iu.home.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class array {

	// 1. 배열 이용해 총합과 평균 구하기
	@Test
	void arryTest1() throws Exception {
		int sum = 0;
		float avg = 0f;
		
		int[] score = {100, 88, 100, 100, 90};
		
		for(int i=0; i < score.length; i++) {
			//참이면 배열에 더해짐
			sum += score[i];
		}
		
		avg = sum/(float)score.length;
		System.out.println("총합 : "+sum);
		System.out.println("평균 : "+avg);		
	}
	
	//최댓값, 최솟값 출력
	@Test
	void arryTest2 () throws Exception {
		int[] list = {79, 4, 75, 30, 56};
		
		int max = list[0];
		int min = list[0];
		
		for (int i=1; i < list.length; i++) {
			if(list[i] > max) {
				max = list[i];
			} else if(list[i] < max) {
				min = list[i];
			}
		}
	}
	
	//중복값 제거 후 출력
	@Test
	void 
	
}
