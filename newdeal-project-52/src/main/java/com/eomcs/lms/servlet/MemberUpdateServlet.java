package com.eomcs.lms.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

@WebServlet("/member/update")
public class MemberUpdateServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  
  MemberDao memberDao;

  @Override
  public void init() throws ServletException {
    ApplicationContext iocContainer = 
        (ApplicationContext) this.getServletContext().getAttribute("iocContainer");
    this.memberDao = iocContainer.getBean(MemberDao.class);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      Member member = new Member();
      member.setNo(Integer.parseInt(request.getParameter("no")));
      
      member.setName(request.getParameter("name"));

      member.setEmail(request.getParameter("email"));

      member.setPassword(request.getParameter("password"));

      member.setPhoto(request.getParameter("photo"));

      member.setTel(request.getParameter("tel"));

      memberDao.update(member);
      
      response.sendRedirect("list");
      
    } catch (Exception e) {
      e.printStackTrace();
      throw new ServletException(e);
    }

  }

}
