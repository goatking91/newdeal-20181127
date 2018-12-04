package com.eomcs.lms.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.mariadb.jdbc.Driver;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

public class MariaDBMemberDao implements MemberDao {

  @Override
  public Member findByEmailPassword(String email, String password) throws Exception {
    DriverManager.registerDriver(new Driver());

    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb", 
        "study", "1111");
        PreparedStatement stmt = con.prepareStatement(
            "select mno, name, email, photo from member" 
                + " where email=? and pwd=?");) {
      stmt.setString(1, email);
      stmt.setString(2, password);

      try (ResultSet rs = stmt.executeQuery()) {
        if (rs.next()) {
          Member member = new Member();
          member.setNo(rs.getInt("mno"));
          member.setName(rs.getString("name"));
          member.setEmail(rs.getString("email"));
          member.setPhoto(rs.getString("photo"));
          return member;
        } else {
          return null;
        }
      }

    }

  }

  public List<Member> findAll() throws Exception {
    DriverManager.registerDriver(new Driver());

    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb", "study", "1111");
        PreparedStatement stmt = con.prepareStatement(
            "select mno, name, email, tel, cdt"
                + " from member");
        ResultSet rs = stmt.executeQuery();) {

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
        PreparedStatement stmt = con.prepareStatement(
            "select name, email, pwd, photo, tel, cdt"
                + " from member"
                + " where mno=?");) {
      stmt.setInt(1, no);

      try (ResultSet rs = stmt.executeQuery()) {
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

  }

  public int insert(Member member) throws Exception {
    DriverManager.registerDriver(new Driver());

    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb", "study", "1111");
        PreparedStatement stmt = con.prepareStatement(
            "insert into member(name, email, pwd, photo, tel)"
                + "values(?, ?, ?, ?, ?)");) {

      stmt.setString(1,member.getName());
      stmt.setString(2,member.getEmail());
      stmt.setString(3,member.getPassword());
      stmt.setString(4,member.getPhoto());
      stmt.setString(5,member.getTel());
      return stmt.executeUpdate();

    } 

  }

  public int update(Member member) throws Exception {
    DriverManager.registerDriver(new Driver());

    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb", "study", "1111");
        PreparedStatement stmt = con.prepareStatement(
            "update member set"
                + " name=?, email=?, pwd=?, photo=?, tel=?"
                + " where mno=?");) {

      stmt.setString(1,member.getName());
      stmt.setString(2,member.getEmail());
      stmt.setString(3,member.getPassword());
      stmt.setString(4,member.getPhoto());
      stmt.setString(5,member.getTel());
      stmt.setInt(6, member.getNo());
      return stmt.executeUpdate();

    }

  }

  public int delete(int no) throws Exception {
    DriverManager.registerDriver(new Driver());

    try (Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost:3306/studydb", "study", "1111");
        PreparedStatement stmt = con.prepareStatement(
            "delete from member"
                + " where mno=?")) {

      stmt.setInt(1, no);
      return stmt.executeUpdate();

    }

  }

}
