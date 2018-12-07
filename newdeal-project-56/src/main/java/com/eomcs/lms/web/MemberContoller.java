package com.eomcs.lms.web;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
  public String add(Member member) throws Exception {

    memberDao.insert(member);
    return "redirect:list";

  }
  
  @RequestMapping("delete")
  public String delete(int no, Model model)
      throws Exception {
    
      model.addAttribute("count", memberDao.delete(no));
      
      return "member/delete";
      

  }
  
  @RequestMapping("detail")
  public String detail(int no, Model model)
      throws Exception {

    Member member = memberDao.findByNo(no);

    model.addAttribute("member", member);
    return "member/detail";

  }
  
  @RequestMapping("form")
  public String form() throws Exception {
    
    return "member/form";
    
  }
  
  @RequestMapping("list")
  public String list(Model model)
      throws Exception {

    List<Member> list = memberDao.findAll();
    model.addAttribute("list", list);
    
    return "member/list";
    
  }
  
  @RequestMapping("update")
  public String update(Member member)
      throws Exception {

    memberDao.update(member);

    return "redirect:list";

  }


}
