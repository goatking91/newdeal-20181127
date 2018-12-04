package com.eomcs.lms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.mariadb.jdbc.Driver;
import com.eomcs.lms.domain.Lesson;

public class LessonDao {
  public List<Lesson> findAll() throws Exception{
    DriverManager.registerDriver(new Driver());

    try(Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb", "study", "1111");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select lno, title, sdt, edt, tot_hr"
            + " from lesson");) {

      List<Lesson> list = new ArrayList<>();

      while (rs.next()) {
        Lesson lesson = new Lesson();
        lesson.setNo(rs.getInt("lno"));
        lesson.setTitle(rs.getString("title"));
        lesson.setStartDate(rs.getDate("sdt"));
        lesson.setEndDate(rs.getDate("edt"));
        lesson.setTotalHours(rs.getInt("tot_hr"));

        list.add(lesson);
      }
      return list;
    } 
  }

  public Lesson findByNo(int no) throws Exception{
    DriverManager.registerDriver(new Driver());

    try(Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb", "study", "1111");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(
            "select title, cont, sdt, edt, tot_hr, day_hr"
                + " from lesson"
                + " where lno = " + no);) {

      rs.next();

      Lesson lesson = new Lesson();
      lesson.setTitle(rs.getString("title"));
      lesson.setContents(rs.getString("cont"));
      lesson.setStartDate(rs.getDate("sdt"));
      lesson.setEndDate(rs.getDate("edt"));
      lesson.setTotalHours(rs.getInt("tot_hr"));
      lesson.setDayHours(rs.getInt("day_hr"));

      return lesson;
    }
  }

  public int insert(Lesson lesson) throws Exception {
    DriverManager.registerDriver(new Driver());

    try(Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb", "study", "1111");
        Statement stmt = con.createStatement();) {

      return stmt.executeUpdate("insert into lesson(title, cont, sdt, edt, tot_hr, day_hr, mno)"
          + " values ('" + lesson.getTitle() + "'"
          + ", '" + lesson.getContents() + "'"
          + ", '" + lesson.getStartDate() + "'"
          + ", '" + lesson.getEndDate() + "'"
          + ", " + lesson.getTotalHours() + ""
          + ", " + lesson.getDayHours() + ""
          + ", " + lesson.getMemberNo() + ")");

    }

  }

  public int update(Lesson lesson) throws Exception {
    DriverManager.registerDriver(new Driver());

    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb", "study", "1111");
        Statement stmt = con.createStatement();) {

      return stmt.executeUpdate("update lesson set"
          + " title='" + lesson.getTitle() + "',"
          + " cont='" + lesson.getContents() + "',"
          + " sdt='" + lesson.getStartDate() +  "',"
          + " edt='" + lesson.getEndDate() + "',"
          + " tot_hr=" + lesson.getTotalHours() + ","
          + " day_hr=" + lesson.getDayHours() + ""
          + " where lno=" + lesson.getNo());

    }

  }

  public int delete(int no) throws Exception {
    DriverManager.registerDriver(new Driver());

    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb", "study", "1111");
        Statement stmt = con.createStatement();) {

      return stmt.executeUpdate("delete from lesson where lno=" + no);
      
    }
  }
}
