package com.eomcs.lms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.eomcs.lms.dao.LessonDao;

@Controller
public class LessonDeleteContoller {
  LessonDao lessonDao;

  public LessonDeleteContoller(LessonDao lessonDao) {
    this.lessonDao = lessonDao;
  }

  @RequestMapping("/lesson/delete")
  public String delete(HttpServletRequest request,
      HttpServletResponse response) throws Exception {
      int no = Integer.parseInt(request.getParameter("no"));

      request.setAttribute("count", lessonDao.delete(no));
      response.setContentType("text/html;charset=UTF-8");
      return "/lesson/delete.jsp";

  }

}
