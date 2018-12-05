package com.eomcs.lms.handler;

import java.util.Scanner;
import org.springframework.stereotype.Component;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

//Spring IoC Container가 이 클래스의 인스턴스를 자동 생성하도록
//클래스에 표시해둔다.
@Component("/member/add")
public class MemberAddCommand implements Command {
  Scanner keyboard;
  MemberDao memberDao;

  public MemberAddCommand(Scanner keyboard, MemberDao memberDao) {
    this.keyboard = keyboard;
    this.memberDao = memberDao;
  }

  @Override
  public void execute() {
    try {
      Member member = new Member();
      
      System.out.print("이름? ");
      member.setName(keyboard.nextLine());

      System.out.print("이메일? ");
      member.setEmail(keyboard.nextLine());

      System.out.print("암호? ");
      member.setPassword(keyboard.nextLine());

      System.out.print("사진? ");
      member.setPhoto(keyboard.nextLine());

      System.out.print("전화? ");
      member.setTel(keyboard.nextLine());
      
      if(memberDao.insert(member)>0)
        System.out.println("저장하였습니다.");
      
    } catch (Exception e) {
      e.printStackTrace();
    } 

  }

}
