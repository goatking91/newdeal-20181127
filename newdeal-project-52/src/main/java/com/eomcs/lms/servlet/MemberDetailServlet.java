package com.eomcs.lms.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

@WebServlet("/member/detail")
public class MemberDetailServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
  
  MemberDao memberDao;

  @Override
  public void init() throws ServletException {
    ApplicationContext iocContainer = 
        (ApplicationContext) this.getServletContext().getAttribute("iocContainer");
    this.memberDao = iocContainer.getBean(MemberDao.class);
  }
  
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      int no = Integer.parseInt(request.getParameter("no"));
      
      Member member = memberDao.findByNo(no);
      
      RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/member/detail.jsp");
      response.setContentType("text/html;charset=UTF-8");
      request.setAttribute("member", member);
      rd.include(request, response);
      
    } catch (Exception e) {
      e.printStackTrace();
    } 
   
  }
  
}