package com.eomcs.lms.handler;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import org.mariadb.jdbc.Driver;
import com.eomcs.lms.dao.LessonDao;

public class LessonListCommand implements Command {
  Scanner keyboard;
  LessonDao lessonDao;
  
  public LessonListCommand(Scanner keyboard, LessonDao lessonDao) {
    this.keyboard = keyboard;
    this.lessonDao = lessonDao;
  }
  
  @Override
  public void execute() {
    Connection con = null;
    Statement stmt = null;
    ResultSet rs = null;
    
    try {
      DriverManager.registerDriver(new Driver());
      
      con = DriverManager.getConnection(
          "jdbc:mariadb://localhost:3306/studydb", "study", "1111");
      
      stmt = con.createStatement();
      
      rs = stmt.executeQuery("select lno, title, sdt, edt, tot_hr"
          + " from lesson");
      
      while (rs.next()) {
        System.out.printf("%3d, %-15s, %10s ~ %10s, %4d\n", 
            rs.getInt("lno"), rs.getString("title"), 
            rs.getDate("sdt"), rs.getDate("edt"), rs.getInt("tot_hr"));
      }
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {rs.close();} catch (Exception e) {}
      try {stmt.close();} catch (Exception e) {}
      try {con.close();} catch (Exception e) {}
    }
  }

}
