package com.eomcs.lms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import com.eomcs.lms.dao.LessonDao;

@Component("/lesson/form")
public class LessonFormContoller implements PageController {
  
  LessonDao lessonDao;
  
  public LessonFormContoller(LessonDao lessonDao) {
    this.lessonDao = lessonDao;
  }
  
  @Override
  public String execute(HttpServletRequest request, 
      HttpServletResponse response) throws Exception {
    
    response.setContentType("text/html;charset=UTF-8");
    return "/lesson/form.jsp";
     
  }
  

}
