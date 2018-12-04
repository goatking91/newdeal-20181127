package com.eomcs.lms.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.mariadb.jdbc.Driver;
import com.eomcs.lms.domain.Member;

public class MemberDao {
  public List<Member> findAll() throws Exception {
    DriverManager.registerDriver(new Driver());

    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb", "study", "1111");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select mno, name, email, tel, cdt"
            + " from member");) {

      List<Member> list = new ArrayList<>();

      while (rs.next()) {

        Member member = new Member();
        member.setNo(rs.getInt("mno"));
        member.setName(rs.getString("name"));
        member.setEmail(rs.getString("email"));
        member.setTel(rs.getString("tel"));
        member.setRegisteredDate(Date.valueOf(rs.getString("cdt")));
        list.add(member);
      }
      return list;
    } 

  }

  public Member findByNo(int no) throws Exception {
    DriverManager.registerDriver(new Driver());

    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb", "study", "1111");
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(
            "select name, email, pwd, photo, tel, cdt"
                + " from member"
                + " where mno=" + no);) {

      rs.next();
      Member member = new Member();
      member.setName(rs.getString("name"));
      member.setEmail(rs.getString("email"));
      member.setPassword(rs.getString("pwd"));
      member.setPhoto(rs.getString("photo"));
      member.setTel(rs.getString("tel"));
      member.setRegisteredDate(Date.valueOf(rs.getString("cdt")));

      return member;

    }

  }

  public int insert(Member member) throws Exception {
    DriverManager.registerDriver(new Driver());

    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb", "study", "1111");
        Statement stmt = con.createStatement();) {

      return stmt.executeUpdate("insert into member(name, email, pwd, photo, tel)"
          + "values('" + member.getName() + "', "
          + "'" + member.getEmail() + "', "
          + "'" + member.getPassword() + "', "
          + "'" + member.getPhoto() + "', "
          + "'" + member.getTel() +"')");


    } 

  }

  public int update(Member member) throws Exception {
    DriverManager.registerDriver(new Driver());

    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb", "study", "1111");
        Statement stmt = con.createStatement();) {

      return stmt.executeUpdate("update member set"
          + " name='" + member.getName() + "', email='" + member.getEmail() + "',"
          + " pwd='" + member.getPassword() + "', photo='" + member.getPhoto() + "',"
          + " tel='" + member.getTel() + "'"
          + " where mno=" + member.getNo());

    }

  }

  public int delete(int no) throws Exception {
    DriverManager.registerDriver(new Driver());

    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb", "study", "1111");
        Statement stmt = con.createStatement()) {

      return stmt.executeUpdate("delete from member where mno=" + no);

    }

  }
  
}