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

@WebServlet("/member/delete")
public class MemberDeleteCommand extends HttpServlet {
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

      RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/member/delete.jsp");
      response.setContentType("text/html;charset=UTF-8");
      request.setAttribute("count", memberDao.delete(no));
      rd.include(request, response);
      
    } catch (Exception e) {
      e.printStackTrace();
      throw new ServletException(e);
    } 

  }

}