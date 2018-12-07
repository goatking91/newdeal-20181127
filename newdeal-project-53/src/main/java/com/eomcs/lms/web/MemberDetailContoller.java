package com.eomcs.lms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

@Component("/member/detail")
public class MemberDetailContoller implements PageController {
  MemberDao memberDao;

  public MemberDetailContoller(MemberDao memberDao) {
    this.memberDao = memberDao;
  }


  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    int no = Integer.parseInt(request.getParameter("no"));

    Member member = memberDao.findByNo(no);

    request.setAttribute("member", member);
    response.setContentType("text/html;charset=UTF-8");
    return "/member/detail.jsp";

  }

}