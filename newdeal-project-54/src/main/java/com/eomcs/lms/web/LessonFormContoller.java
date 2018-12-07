package com.eomcs.lms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.eomcs.lms.dao.LessonDao;

@Controller
public class LessonFormContoller {
  
  LessonDao lessonDao;
  
  public LessonFormContoller(LessonDao lessonDao) {
    this.lessonDao = lessonDao;
  }
  
  @RequestMapping("/lesson/form")
  public String form(HttpServletRequest request, 
      HttpServletResponse response) throws Exception {
    
    response.setContentType("text/html;charset=UTF-8");
    return "/lesson/form.jsp";
     
  }
  

}
