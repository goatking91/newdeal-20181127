package com.eomcs.lms.handler;

import java.util.Scanner;
import org.springframework.stereotype.Component;
import com.eomcs.lms.dao.MemberDao;

//Spring IoC Container가 이 클래스의 인스턴스를 자동 생성하도록
//클래스에 표시해둔다.
@Component("/member/delete")
public class MemberDeleteCommand implements Command {
  Scanner keyboard;
  MemberDao memberDao;

  public MemberDeleteCommand(Scanner keyboard, MemberDao memberDao) {
    this.keyboard = keyboard;
    this.memberDao = memberDao;
  }

  @Override
  public void execute() {
    try {
      System.out.print("번호? ");
      int no = Integer.parseInt(keyboard.nextLine());

      if(memberDao.delete(no) > 0)
        System.out.println("회원을 삭제했습니다.");
      else
        System.out.println("회원을 찾을 수 없습니다.");
      
    } catch (Exception e) {
      e.printStackTrace();
    } 

  }

}