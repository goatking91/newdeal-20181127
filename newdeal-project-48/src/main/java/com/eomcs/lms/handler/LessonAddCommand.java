package com.eomcs.lms.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import org.mariadb.jdbc.Driver;

public class LessonAddCommand implements Command {
  Scanner keyboard;

  public LessonAddCommand(Scanner keyboard) {
    this.keyboard = keyboard;
  }

  @Override
  public void execute() {
    Connection con = null;
    Statement stmt = null;

    try {
      System.out.print("수업명? ");
      String title = keyboard.nextLine();

      System.out.print("설명? ");
      String contents = keyboard.nextLine();

      System.out.print("시작일? ");
      String startDate = keyboard.nextLine();

      System.out.print("종료일? ");
      String endDate = keyboard.nextLine();

      System.out.print("총수업시간? ");
      String totalHours = keyboard.nextLine();

      System.out.print("일수업시간? ");
      String dayHours = keyboard.nextLine();

      System.out.print("회원번호? ");
      String memberNo = keyboard.nextLine();

      DriverManager.registerDriver(new Driver());

      con = DriverManager.getConnection(
          "jdbc:mariadb://localhost:3306/studydb", "study", "1111");

      stmt = con.createStatement();

      stmt.executeQuery("insert into lesson(title, cont, sdt, edt, tot_hr, day_hr, mno)"
          + " values ('" + title + "'"
          + ", '" + contents + "'"
          + ", '" + startDate + "'"
          + ", '" + endDate + "'"
          + ", " + totalHours + ""
          + ", " + dayHours + ""
          + ", " + memberNo + ")");

      System.out.println("저장하였습니다."); 
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {stmt.close();} catch (Exception e) {}
      try {con.close();} catch (Exception e) {}
    }

       
  }

}
