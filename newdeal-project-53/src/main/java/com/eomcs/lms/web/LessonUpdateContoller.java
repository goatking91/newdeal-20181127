package com.eomcs.lms.web;

import java.sql.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

@Component("/lesson/update")
public class LessonUpdateContoller implements PageController {

  LessonDao lessonDao;

  public LessonUpdateContoller(LessonDao lessonDao) {
    this.lessonDao = lessonDao;
  }

  @Override
  public String execute(HttpServletRequest request,
      HttpServletResponse response) throws Exception {

    Lesson lesson = new Lesson();

    lesson.setTitle(request.getParameter("title"));
    lesson.setContents(request.getParameter("contents"));      
    lesson.setStartDate(Date.valueOf(request.getParameter("startDate")));      
    lesson.setEndDate(Date.valueOf(request.getParameter("endDate")));      
    lesson.setTotalHours(Integer.parseInt(request.getParameter("totalHours")));      
    lesson.setDayHours(Integer.parseInt(request.getParameter("dayHours")));  
    lesson.setNo(Integer.parseInt(request.getParameter("no")));

    lessonDao.update(lesson);
    return "redirect:list";


  }

}