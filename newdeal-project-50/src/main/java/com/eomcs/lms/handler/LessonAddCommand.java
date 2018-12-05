package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import org.springframework.stereotype.Component;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

//Spring IoC Container가 이 클래스의 인스턴스를 자동 생성하도록
//클래스에 표시해둔다.
@Component("/lesson/add")
public class LessonAddCommand implements Command {
  Scanner keyboard;
  LessonDao lessonDao;

  public LessonAddCommand(Scanner keyboard, LessonDao lessonDao) {
    this.keyboard = keyboard;
    this.lessonDao = lessonDao;
  }

  @Override
  public void execute() {
    try {
      Lesson lesson = new Lesson();

      System.out.print("수업명? ");
      lesson.setTitle(keyboard.nextLine());

      System.out.print("설명? ");
      lesson.setContents(keyboard.nextLine());

      System.out.print("시작일? ");
      lesson.setStartDate(Date.valueOf(keyboard.nextLine()));

      System.out.print("종료일? ");
      lesson.setEndDate(Date.valueOf(keyboard.nextLine()));

      System.out.print("총수업시간? ");
      lesson.setTotalHours(Integer.parseInt(keyboard.nextLine()));

      System.out.print("일수업시간? ");
      lesson.setDayHours(Integer.parseInt(keyboard.nextLine()));

      System.out.print("회원번호? ");
      lesson.setMemberNo(Integer.parseInt(keyboard.nextLine()));

      lessonDao.insert(lesson);

      System.out.println("입력했습니다!");


    } catch (Exception e) {
      e.printStackTrace();
    } 

  }

}
