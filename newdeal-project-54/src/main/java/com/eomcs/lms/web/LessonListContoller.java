package com.eomcs.lms.web;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

@Controller
public class LessonListContoller {

  LessonDao lessonDao;

  public LessonListContoller(LessonDao lessonDao) {
    this.lessonDao = lessonDao;
  }
  @RequestMapping("/lesson/list")
  public String list(HttpServletRequest request, HttpServletResponse response) throws Exception {

    List<Lesson> list = lessonDao.findAll();
    request.setAttribute("list", list);

    response.setContentType("text/html;charset=UTF-8");

    return "/lesson/list.jsp";

  }
}

