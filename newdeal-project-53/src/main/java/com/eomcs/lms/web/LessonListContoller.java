package com.eomcs.lms.web;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

@Component("/lesson/list")
public class LessonListContoller implements PageController {

  LessonDao lessonDao;

  public LessonListContoller(LessonDao lessonDao) {
    this.lessonDao = lessonDao;
  }
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    List<Lesson> list = lessonDao.findAll();
    request.setAttribute("list", list);

    response.setContentType("text/html;charset=UTF-8");

    return "/lesson/list.jsp";

  }
}

