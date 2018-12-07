package com.eomcs.lms.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

@Controller
@RequestMapping("/member")
public class MemberContoller {
  MemberDao memberDao;

  public MemberContoller(MemberDao memberDao) {
    this.memberDao = memberDao;
  }
  @RequestMapping("add")
  public String add(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    Member member = new Member();

    member.setName(request.getParameter("name"));
    member.setEmail(request.getParameter("email"));
    member.setPassword(request.getParameter("password"));
    member.setPhoto(request.getParameter("photo"));
    member.setTel(request.getParameter("tel"));
    memberDao.insert(member);
    return "redirect:list";

  }
  
  @RequestMapping("delete")
  public String delete(HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    
      int no = Integer.parseInt(request.getParameter("no"));
      response.setContentType("text/html;charset=UTF-8");
      request.setAttribute("count", memberDao.delete(no));
      
      return "/member/delete.jsp";
      

  }
  
  @RequestMapping("detail")
  public String detail(HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    int no = Integer.parseInt(request.getParameter("no"));

    Member member = memberDao.findByNo(no);

    request.setAttribute("member", member);
    response.setContentType("text/html;charset=UTF-8");
    return "/member/detail.jsp";

  }
  
  @RequestMapping("form")
  public String form(HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    
    response.setContentType("text/html;charset=UTF-8");
    return "/member/form.jsp";
    
  }
  
  @RequestMapping("list")
  public String list(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    List<Member> list = memberDao.findAll();
    request.setAttribute("list", list);
    response.setContentType("text/html;charset=UTF-8");
    
    return "/member/list.jsp";
    
  }
  
  @RequestMapping("update")
  public String update(HttpServletRequest request, HttpServletResponse response)
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
