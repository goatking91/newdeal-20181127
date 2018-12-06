package com.eomcs.lms.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.context.ApplicationContext;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

//Spring IoC Container가 이 클래스의 인스턴스를 자동 생성하도록
//클래스에 표시해둔다.
@WebServlet("/auth/login")
public class LoginServlet extends HttpServlet {
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
    RequestDispatcher rd =  request.getRequestDispatcher(
        "/auth/form.jsp");

    rd.forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
      String email = request.getParameter("email");

      String password = request.getParameter("password");

      Member member = memberDao.findByEmailPassword(email, password);
      
      // 해당 클라이언트를 위한 HttpSession 객체가 있다면,
      // 그 객체를 리턴한다.
      // 없다면, 새로 만들어 리턴한다.
      HttpSession session = request.getSession();
      
      if(member != null) {
        session.setAttribute("loginUser", member);
        response.sendRedirect("../board/list");
      }
        
      else {
        session.invalidate();
        response.sendRedirect("login");
      }

    } catch (Exception e) {
      e.printStackTrace();
      throw new ServletException(e);
    } 

  }

}
