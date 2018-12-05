package com.eomcs.lms.handler;

import java.util.Scanner;
import org.springframework.stereotype.Component;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

//Spring IoC Container가 이 클래스의 인스턴스를 자동 생성하도록
//클래스에 표시해둔다.
@Component("/member/update")
public class MemberUpdateCommand implements Command {
  Scanner keyboard;
  MemberDao memberDao;

  public MemberUpdateCommand(Scanner keyboard, MemberDao memberDao) {
    this.keyboard = keyboard;
    this.memberDao = memberDao;
  }

  @Override
  public void execute() {
    try {
      System.out.print("번호? ");
      int no = Integer.parseInt(keyboard.nextLine());
      Member member = memberDao.findByNo(no);
      member.setNo(no);
      
      System.out.printf("이름(%s)? ", member.getName());
      member.setName(keyboard.nextLine());

      System.out.printf("이메일(%s)? ",member.getEmail());
      member.setEmail(keyboard.nextLine());

      System.out.printf("암호(********)? ");
      member.setPassword(keyboard.nextLine());

      System.out.printf("사진(%s)? ", member.getPhoto());
      member.setPhoto(keyboard.nextLine());

      System.out.printf("전화(%s)? ", member.getTel());
      member.setTel(keyboard.nextLine());

      if(memberDao.update(member)>0)
      System.out.println("회원을 변경했습니다.");

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}
