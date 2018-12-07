package com.eomcs.lms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.eomcs.lms.dao.MemberDao;

@Controller
public class MemberDeleteContoller {
  MemberDao memberDao;

  public MemberDeleteContoller(MemberDao memberDao) {
    this.memberDao = memberDao;
  }


  @RequestMapping("/member/delete")
  public String delete(HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    
      int no = Integer.parseInt(request.getParameter("no"));
      response.setContentType("text/html;charset=UTF-8");
      request.setAttribute("count", memberDao.delete(no));
      
      return "/member/delete.jsp";
      

  }

}