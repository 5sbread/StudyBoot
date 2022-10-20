package com.iu.home.file;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.iu.home.board.qna.QnaFileVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class FileManageController {
	
						//URL의 주소를 변수(DATA)로 활용
						//RestFul, RestAPI
	@GetMapping("/fileDown/{p}")
	public ModelAndView fileDownQna(@PathVariable(name="p") String path, QnaFileVO qnaFileVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		//DB에서 정보 조회
		if(path.equals("qna")) {
		
		}else if(path.equals("notice"))
			
		qnaFileVO.setFileName("75aaf265-c34f-4ed6-a881-1d152e806b18_아이유.jpg");
		qnaFileVO.setOriName("아이유.jpg");
		
		mv.addObject("fileVO", qnaFileVO);
		mv.addObject("path", path);		
		mv.setViewName("fileManager");
		
		return mv;
	}
	
	


}
