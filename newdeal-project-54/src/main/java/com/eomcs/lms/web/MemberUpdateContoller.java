package com.eomcs.lms.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

@Controller
public class MemberUpdateContoller {
  MemberDao memberDao;

  public MemberUpdateContoller(MemberDao memberDao) {
    this.memberDao = memberDao;
  }
  @RequestMapping("/member/update")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    Member member = new Member();
    member.setNo(Integer.parseInt(request.getParameter("no")));

    member.setName(request.getParameter("name"));

    member.setEmail(request.getParameter("email"));

    member.setPassword(request.getParameter("password"));

    member.setPhoto(request.getParameter("photo"));

    member.setTel(request.getParameter("tel"));

    memberDao.update(member);

    return "redirect:list";


  }

}
