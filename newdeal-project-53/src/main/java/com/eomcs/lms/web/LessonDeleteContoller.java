package com.eomcs.lms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import com.eomcs.lms.dao.LessonDao;

@Component("/lesson/delete")
public class LessonDeleteContoller implements PageController {
  LessonDao lessonDao;

  public LessonDeleteContoller(LessonDao lessonDao) {
    this.lessonDao = lessonDao;
  }

  @Override
  public String execute(HttpServletRequest request,
      HttpServletResponse response) throws Exception {
      int no = Integer.parseInt(request.getParameter("no"));

      request.setAttribute("count", lessonDao.delete(no));
      response.setContentType("text/html;charset=UTF-8");
      return "/lesson/delete.jsp";

  }

}
