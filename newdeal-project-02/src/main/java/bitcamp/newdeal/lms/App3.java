package bitcamp.newdeal.lms;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class App3 {

  public static void main(String[] args) {
    Scanner keyIn = new Scanner(System.in);
    

    System.out.print("번호? ");
    int no = Integer.parseInt(keyIn.nextLine());
    
    System.out.print("내용? ");
    String contents = keyIn.nextLine();
    
    Date writeDate = new Date();
    int viewCount = 0;
    
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    keyIn.close();

    System.out.printf("\n번호: %d\n", no);
    System.out.printf("내용: %s\n", contents);
    System.out.printf("작성일: %s\n", simpleDateFormat.format(writeDate));
    System.out.printf("조회수: %d\n", viewCount);
  }

}
