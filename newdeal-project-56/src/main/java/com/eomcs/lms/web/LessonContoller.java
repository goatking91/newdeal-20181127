package com.eomcs.lms.web;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
  public String add(Lesson lesson) 
      throws Exception {

      lessonDao.insert(lesson);
      return "redirect:list";

  }
  
  @RequestMapping("delete")
  public String delete(int no) throws Exception {

      return "lesson/delete";

  }
  
  @RequestMapping("detail")
  public String detail(int no, Model model) throws Exception {
    Lesson lesson = lessonDao.findByNo(no);

    model.addAttribute("lesson", lesson);

    return "lesson/detail";

  }
  
  @RequestMapping("form")
  public String form() throws Exception {
    return "lesson/form";
     
  }
  
  @RequestMapping("list")
  public String list(Model model) throws Exception {

    List<Lesson> list = lessonDao.findAll();
    model.addAttribute("list", list);

    return "lesson/list";

  }
  
  @RequestMapping("update")
  public String update(Lesson lesson) throws Exception {
    
    lessonDao.update(lesson);
    return "redirect:list";

  }

}
