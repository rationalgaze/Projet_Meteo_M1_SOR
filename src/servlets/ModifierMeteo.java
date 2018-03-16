package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.Manager;
import validation.Validation;

/**
 * Servlet implementation class ModifierMeteo.
 */
@WebServlet("/ModifierMeteo")
public class ModifierMeteo extends HttpServlet {
  private static final long serialVersionUID = 1L;
       
  /**
   * ModifierMeteo.
   * @see HttpServlet#HttpServlet()
   */
  public ModifierMeteo() {
  }
  
  /**
   * doGet.
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    request.setAttribute("content", "/WEB-INF/meteo/modify.jsp");
    request.setAttribute("contenu", "/WEB-INF/auth/espaceperso.jsp");
    request.getServletContext().getRequestDispatcher("/WEB-INF/header/header.jsp")
    .forward(request, response);
  }
  
  /**
   * doPost.
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    Validation v = new Validation();
    Manager manager = Manager.creer(request);
    
    v.regexp(bean.Meteo.class,"d", request.getParameter("date"));
    v.regexp(bean.Meteo.class,"location", request.getParameter("location"));
    v.regexp(bean.Meteo.class,"temp_min", request.getParameter("min"));
    v.regexp(bean.Meteo.class,"temp_max", request.getParameter("max"));
    v.regexp(bean.Meteo.class,"temp_moy", request.getParameter("moy"));
    v.regexp(bean.Meteo.class,"sun", request.getParameter("sun"));
    v.regexp(bean.Meteo.class,"wind", request.getParameter("wind"));
    v.regexp(bean.Meteo.class,"rain", request.getParameter("rain"));
    v.regexp(bean.Meteo.class,"rafale", request.getParameter("raf"));
    v.regexp(bean.Meteo.class,"direction", request.getParameter("dir"));
    
    
    if (v.isValide()) {
      boolean insertion = manager.updateMeteo(request.getParameter("date"), 
          request.getParameter("location"), Double.parseDouble(request.getParameter("min")), 
          Double.parseDouble(request.getParameter("max")), 
          Double.parseDouble(request.getParameter("moy")), 
          Double.parseDouble(request.getParameter("rain")), 
          Double.parseDouble(request.getParameter("sun")), 
          Double.parseDouble(request.getParameter("wind")), 
          Double.parseDouble(request.getParameter("raf")), 
          request.getParameter("dir"));
      System.out.println("Valid : " + insertion);
      
      if (insertion) {
        request.setAttribute("msg", "0");
        request.setAttribute("content", "/WEB-INF/meteo/modify.jsp");
        request.setAttribute("contenu", "/WEB-INF/auth/espaceperso.jsp");
        request.getServletContext().getRequestDispatcher("/WEB-INF/header/header.jsp")
        .forward(request, response);
      } else {
        request.setAttribute("msg", "1");
        request.setAttribute("content", "/WEB-INF/meteo/modify.jsp");
        request.setAttribute("contenu", "/WEB-INF/auth/espaceperso.jsp");
        request.getServletContext().getRequestDispatcher("/WEB-INF/header/header.jsp")
        .forward(request, response);
      }
    } else {
      request.setAttribute("v", v);
      request.setAttribute("msg", "0");
      request.setAttribute("content", "/WEB-INF/meteo/modify.jsp");
      request.setAttribute("contenu", "/WEB-INF/auth/espaceperso.jsp");
      request.getServletContext().getRequestDispatcher("/WEB-INF/header/header.jsp")
      .forward(request, response);
    }
  }

}
