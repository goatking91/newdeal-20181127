package com.eomcs.lms.servlet;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

//Spring IoC Container가 이 클래스의 인스턴스를 자동 생성하도록
//클래스에 표시해둔다.
@WebServlet("/lesson/update")
public class LessonUpdateServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  LessonDao lessonDao;

  @Override
  public void init() throws ServletException {
    ApplicationContext iocContainer = 
        (ApplicationContext) this.getServletContext().getAttribute("iocContainer");
    this.lessonDao = iocContainer.getBean(LessonDao.class);
  }
  
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
      Lesson lesson = new Lesson();

      lesson.setTitle(request.getParameter("title"));
      lesson.setContents(request.getParameter("contents"));      
      lesson.setStartDate(Date.valueOf(request.getParameter("startDate")));      
      lesson.setEndDate(Date.valueOf(request.getParameter("endDate")));      
      lesson.setTotalHours(Integer.parseInt(request.getParameter("totalHours")));      
      lesson.setDayHours(Integer.parseInt(request.getParameter("dayHours")));  
      lesson.setNo(Integer.parseInt(request.getParameter("no")));

      lessonDao.update(lesson);
      response.sendRedirect("list");

    } catch (Exception e) {
      e.printStackTrace();
      throw new ServletException(e);
    }

  }

}