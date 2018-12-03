package com.eomcs.lms.handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import org.mariadb.jdbc.Driver;

public class MemberUpdateCommand implements Command {
  Scanner keyboard;

  public MemberUpdateCommand(Scanner keyboard) {
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
      ResultSet rs = stmt.executeQuery("select name, email, photo, tel"
          + " from member"
          + " where mno = " + no);
      
      rs.next();
      
      System.out.printf("이름(%s)? ", rs.getString("name"));
      String name = keyboard.nextLine();

      System.out.printf("이메일(%s)? ", rs.getString("email"));
      String email = keyboard.nextLine();

      System.out.printf("암호(********)? ");
      String password = keyboard.nextLine();

      System.out.printf("사진(%s)? ", rs.getString("photo"));
      String photo = keyboard.nextLine();

      System.out.printf("전화(%s)? ", rs.getString("tel"));
      String tel = keyboard.nextLine();

      rs.close();
      stmt.executeUpdate("update member set"
          + " name='" + name + "', email='" + email + "',"
          + " pwd='" + password + "', photo='" + photo + "', tel='" + tel + "'"
          + " where mno=" + no);

      System.out.println("회원을 변경했습니다.");


      System.out.println("저장하였습니다.");

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {stmt.close();} catch (Exception e) {}
      try {con.close();} catch (Exception e) {}
    }

  }

}
