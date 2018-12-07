package com.eomcs.lms.web;

import java.sql.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

@Controller
public class LessonAddContoller {

  LessonDao lessonDao;

  public LessonAddContoller(LessonDao lessonDao) {
    this.lessonDao = lessonDao;
  }

  @RequestMapping("/lesson/add")
  public String add(HttpServletRequest request, HttpServletResponse response) 
      throws Exception {

      Lesson lesson = new Lesson();

      lesson.setTitle(request.getParameter("title"));
      lesson.setContents(request.getParameter("contents"));
      lesson.setStartDate(Date.valueOf(request.getParameter("startDate")));
      lesson.setEndDate(Date.valueOf(request.getParameter("endDate")));
      lesson.setTotalHours(Integer.parseInt(request.getParameter("totalHours")));
      lesson.setDayHours(Integer.parseInt(request.getParameter("dayHours")));
      lesson.setMemberNo(Integer.parseInt(request.getParameter("memberNo")));

      lessonDao.insert(lesson);
      return "redirect:list";

  }

}
