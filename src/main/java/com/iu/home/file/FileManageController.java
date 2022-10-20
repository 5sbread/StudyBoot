package com.iu.home.file;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iu.home.board.qna.QnaFileVO;

@Controller
public class FileManageController {
	
	@GetMapping("/fileDown/qna")
	public ModelAndView fileDown(QnaFileVO qnaFileVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		//DB에서 정보 조회
		qnaFileVO.setFileName("75aaf265-c34f-4ed6-a881-1d152e806b18_아이유.jpg");
		qnaFileVO.setOriName("아이유.jpg");
		
		mv.addObject("fileVO", qnaFileVO);
		
		mv.setViewName("fileManager");
		
		return mv;
	}

}
