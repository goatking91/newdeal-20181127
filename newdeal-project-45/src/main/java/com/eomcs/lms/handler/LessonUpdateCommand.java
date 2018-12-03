package com.eomcs.lms.handler;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import org.mariadb.jdbc.Driver;

public class LessonUpdateCommand implements Command {
  Scanner keyboard;

  public LessonUpdateCommand(Scanner keyboard) {
    this.keyboard = keyboard;
  }

  @Override
  public void execute() {
    Connection con = null;
    Statement stmt = null;

    try {
      System.out.print("번호? ");
      String no = keyboard.nextLine();


      DriverManager.registerDriver(new Driver());

      con = DriverManager.getConnection(
          "jdbc:mariadb://localhost:3306/studydb", "study", "1111");

      stmt = con.createStatement();

      ResultSet rs = stmt.executeQuery("select title, cont, sdt, edt, tot_hr, day_hr"
          + " from lesson where lno = " + no);

      rs.next();

      String oldTitle = rs.getString("title");
      String oldContent = rs.getString("cont");
      Date oldStartDate = rs.getDate("sdt");
      Date oldEndDate = rs.getDate("edt");
      int oldTotalHours = rs.getInt("tot_hr");
      int oldDayHours = rs.getInt("day_hr");

      System.out.printf("수업명(%s)? ", oldTitle); 
      String title = keyboard.nextLine();
      System.out.printf("설명(%s)? ", oldContent);
      String content = keyboard.nextLine();      
      System.out.printf("시작일(%s)? ", oldStartDate);
      String startDate = keyboard.nextLine();      
      System.out.printf("종료일(%s)? ", oldEndDate);
      String endDate = keyboard.nextLine();      
      System.out.printf("총수업시간(%d)? ", oldTotalHours);
      String totalHours = keyboard.nextLine();      
      System.out.printf("일수업시간(%d)? ", oldDayHours);
      String dayHours = keyboard.nextLine();     

      rs.close();

      stmt.executeUpdate("update lesson set"
          + " title='" + title + "',"
          + " cont='" + content + "',"
          + " sdt='" + startDate +  "',"
          + " edt='" + endDate + "',"
          + " tot_hr=" + totalHours + ","
          + " day_hr=" + dayHours + ""
          + " where lno=" + no);

      System.out.println("수업을 변경했습니다.");

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {stmt.close();} catch (Exception e) {}
      try {con.close();} catch (Exception e) {}
    }

  }

}