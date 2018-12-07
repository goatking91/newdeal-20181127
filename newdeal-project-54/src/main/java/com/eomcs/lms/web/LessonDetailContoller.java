package com.eomcs.lms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

@Controller
public class LessonDetailContoller {

  LessonDao lessonDao;

  public LessonDetailContoller(LessonDao lessonDao) {
    this.lessonDao = lessonDao;
  }

  @RequestMapping("/lesson/detail")
  public String detail(HttpServletRequest request, HttpServletResponse response) throws Exception {
    // TODO Auto-generated method stub

    int no = Integer.parseInt(request.getParameter("no"));
    Lesson lesson = lessonDao.findByNo(no);

    request.setAttribute("lesson", lesson);
    response.setContentType("text/html;charset=UTF-8");

    return "/lesson/detail.jsp";

  }

}
