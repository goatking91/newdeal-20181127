package com.eomcs.lms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

@Controller
public class MemberDetailContoller {
  MemberDao memberDao;
  
  public MemberDetailContoller(MemberDao memberDao) {
    this.memberDao = memberDao;
  }


  @RequestMapping("/member/detail")
  public String detail(HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    int no = Integer.parseInt(request.getParameter("no"));

    Member member = memberDao.findByNo(no);

    request.setAttribute("member", member);
    response.setContentType("text/html;charset=UTF-8");
    return "/member/detail.jsp";

  }

}