package bitcamp.newdeal.lms;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class App2 {

  public static void main(String[] args) {
    Scanner keyIn = new Scanner(System.in);

    final int DEFAULT_SIZE = 20;
    int[] no = new int[DEFAULT_SIZE];
    String[] name = new String[DEFAULT_SIZE];
    String[] email = new String[DEFAULT_SIZE];
    String[] password = new String[DEFAULT_SIZE];
    String[] photo = new String[DEFAULT_SIZE];
    String[] phone = new String[DEFAULT_SIZE];
    Date[] joinDate = new Date[DEFAULT_SIZE];
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    int len = 0;

    for (int i = 0; i < DEFAULT_SIZE; i++) {
      System.out.print("번호? ");
      no[i] = Integer.parseInt(keyIn.nextLine());

      System.out.print("이름? ");
      name[i] = keyIn.nextLine();

      System.out.print("이메일? ");
      email[i] = keyIn.nextLine();

      System.out.print("암호? ");
      password[i] = keyIn.nextLine();

      System.out.print("사진? ");
      photo[i] = keyIn.nextLine();

      System.out.print("전화? ");
      phone[i] = keyIn.nextLine();

      joinDate[i] = new Date();

      len++;

      System.out.print("계속하시겠습니까?(Y/n) ");
      String input = keyIn.nextLine();
      if (input.equals("") || input.equalsIgnoreCase("y")) {
        continue;
      }
      break;
    }
    keyIn.close();

    for (int i = 0; i < len; i++) {
      // 목록으로 출력할 항목은 번호,이름,이메일,전화,가입일이다.
      System.out.printf("%d, %s, %s ~ %s, %d\n", 
          no[i], name[i], email[i], phone[i], simpleDateFormat.format(joinDate[i]));
    }

  }

}
