package bitcamp.newdeal.lms;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class App3 {

  public static void main(String[] args) {
    Scanner keyIn = new Scanner(System.in);
    
    final int DEFAULT_SIZE = 20;
    int[] no = new int[DEFAULT_SIZE];
    String[] contents = new String[DEFAULT_SIZE];    
    Date[] writeDate = new Date[DEFAULT_SIZE];
    int[] viewCount = new int[DEFAULT_SIZE];
    
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    
    int len = 0;
    
    for (int i = 0; i < DEFAULT_SIZE; i++) {
      System.out.print("번호? ");
      no[i] = Integer.parseInt(keyIn.nextLine());

      System.out.print("내용? ");
      contents[i] = keyIn.nextLine();
      
      writeDate[i] = new Date();
      viewCount[i] = 0;

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
      // 목록으로 출력할 항목은 번호,내용,작성일,조회수이다.
      System.out.printf("%d, %s, %s ~ %s, %d\n", 
          no[i], contents[i], writeDate[i], simpleDateFormat.format(viewCount[i]));
    }
    
  }

}
