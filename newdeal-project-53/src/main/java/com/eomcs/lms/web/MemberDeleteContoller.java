package com.eomcs.lms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import com.eomcs.lms.dao.MemberDao;

@Component("/member/delete")
public class MemberDeleteContoller implements PageController {
  MemberDao memberDao;

  public MemberDeleteContoller(MemberDao memberDao) {
    this.memberDao = memberDao;
  }


  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    
      int no = Integer.parseInt(request.getParameter("no"));
      response.setContentType("text/html;charset=UTF-8");
      request.setAttribute("count", memberDao.delete(no));
      
      return "/member/delete.jsp";
      

  }

}