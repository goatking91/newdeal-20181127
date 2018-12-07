package com.eomcs.lms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

@Component("/lesson/detail")
public class LessonDetailContoller implements PageController {

  LessonDao lessonDao;

  public LessonDetailContoller(LessonDao lessonDao) {
    this.lessonDao = lessonDao;
  }

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    // TODO Auto-generated method stub

    int no = Integer.parseInt(request.getParameter("no"));
    Lesson lesson = lessonDao.findByNo(no);

    request.setAttribute("lesson", lesson);
    response.setContentType("text/html;charset=UTF-8");

    return "/lesson/detail.jsp";

  }

}
