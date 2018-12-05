package com.eomcs.lms.handler;

import java.util.Scanner;
import org.springframework.stereotype.Component;
import com.eomcs.lms.dao.LessonDao;

//Spring IoC Container가 이 클래스의 인스턴스를 자동 생성하도록
//클래스에 표시해둔다.
@Component("/lesson/delete")
public class LessonDeleteCommand implements Command {
  Scanner keyboard;
  LessonDao lessonDao;

  public LessonDeleteCommand(Scanner keyboard, LessonDao lessonDao) {
    this.keyboard = keyboard;
    this.lessonDao = lessonDao;
  }

  @Override
  public void execute() {
    try {
      System.out.print("번호? ");
      int no = Integer.parseInt(keyboard.nextLine());

      if (lessonDao.delete(no) > 0) {
        System.out.println("삭제했습니다!");
      } else {
        System.out.println("해당 수업이 없습니다.");
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
    
  }

}
