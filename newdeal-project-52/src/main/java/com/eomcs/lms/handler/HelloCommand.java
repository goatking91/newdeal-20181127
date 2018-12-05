package com.eomcs.lms.handler;

import java.util.Scanner;
import org.springframework.stereotype.Component;

//Spring IoC Container가 이 클래스의 인스턴스를 자동 생성하도록
//클래스에 표시해둔다.
@Component("/hello")
public class HelloCommand implements Command{

  Scanner keyboard;

  public HelloCommand(Scanner keyboard) {
    this.keyboard = keyboard;
  }
  
  @Override
  public void execute() {
    System.out.print("이름은? ");
    String name = keyboard.nextLine();
    
    System.out.println(name + "님 반갑습니다!");
  }

}
