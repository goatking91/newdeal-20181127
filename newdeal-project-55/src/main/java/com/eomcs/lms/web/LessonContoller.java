package com.eomcs.lms.web;

import java.sql.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

@Controller
@RequestMapping("/lesson")
public class LessonContoller {

  LessonDao lessonDao;

  public LessonContoller(LessonDao lessonDao) {
    this.lessonDao = lessonDao;
  }

  @RequestMapping("add")
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
  
  @RequestMapping("delete")
  public String delete(HttpServletRequest request,
      HttpServletResponse response) throws Exception {
      int no = Integer.parseInt(request.getParameter("no"));

      request.setAttribute("count", lessonDao.delete(no));
      response.setContentType("text/html;charset=UTF-8");
      return "/lesson/delete.jsp";

  }
  
  @RequestMapping("detail")
  public String detail(HttpServletRequest request, HttpServletResponse response) throws Exception {
    // TODO Auto-generated method stub

    int no = Integer.parseInt(request.getParameter("no"));
    Lesson lesson = lessonDao.findByNo(no);

    request.setAttribute("lesson", lesson);
    response.setContentType("text/html;charset=UTF-8");

    return "/lesson/detail.jsp";

  }
  
  @RequestMapping("form")
  public String form(HttpServletRequest request, 
      HttpServletResponse response) throws Exception {
    
    response.setContentType("text/html;charset=UTF-8");
    return "/lesson/form.jsp";
     
  }
  
  @RequestMapping("list")
  public String list(HttpServletRequest request, HttpServletResponse response) throws Exception {

    List<Lesson> list = lessonDao.findAll();
    request.setAttribute("list", list);

    response.setContentType("text/html;charset=UTF-8");

    return "/lesson/list.jsp";

  }
  
  @RequestMapping("update")
  public String update(HttpServletRequest request,
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
