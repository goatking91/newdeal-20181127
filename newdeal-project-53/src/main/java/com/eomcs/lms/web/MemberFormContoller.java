package com.eomcs.lms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import com.eomcs.lms.dao.MemberDao;

@Component("/member/form")
public class MemberFormContoller implements PageController {
  MemberDao memberDao;
  
  public MemberFormContoller(MemberDao memberDao) {
    this.memberDao = memberDao;
  }
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    
    response.setContentType("text/html;charset=UTF-8");
    return "/member/form.jsp";
    
  }

}
