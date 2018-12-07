package com.eomcs.lms.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

@Component("/member/list")
public class MemberListContoller implements PageController {
  MemberDao memberDao;

  public MemberListContoller(MemberDao memberDao) {
    this.memberDao = memberDao;
  }
  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    List<Member> list = memberDao.findAll();
    request.setAttribute("list", list);
    response.setContentType("text/html;charset=UTF-8");
    
    return "/member/list.jsp";
    
  }

}
