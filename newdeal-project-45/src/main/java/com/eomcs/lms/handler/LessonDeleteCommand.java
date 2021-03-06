package com.eomcs.lms.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import org.mariadb.jdbc.Driver;

public class LessonDeleteCommand implements Command {
  Scanner keyboard;

  public LessonDeleteCommand(Scanner keyboard) {
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

      stmt.executeUpdate("delete from lesson where lno=" + no);

      System.out.println("수업을 삭제했습니다.");

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {stmt.close();} catch (Exception e) {}
      try {con.close();} catch (Exception e) {}
    }
    
  }

}
