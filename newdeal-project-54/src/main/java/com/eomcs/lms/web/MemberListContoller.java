package com.eomcs.lms.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

@Controller
public class MemberListContoller {
  MemberDao memberDao;

  public MemberListContoller(MemberDao memberDao) {
    this.memberDao = memberDao;
  }
  @RequestMapping("/member/list")
  public String list(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    List<Member> list = memberDao.findAll();
    request.setAttribute("list", list);
    response.setContentType("text/html;charset=UTF-8");
    
    return "/member/list.jsp";
    
  }

}
