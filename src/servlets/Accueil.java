package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Accueil.
 */
@WebServlet("/Accueil")
public class Accueil extends HttpServlet {
  private static final long serialVersionUID = 1L;
       
  /**
   * Constructor.
   * @see HttpServlet#HttpServlet()
   */
  public Accueil() {
  }

  /**
   * Do get.
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    request.setAttribute("contenu", "/WEB-INF/accueil/accueil.jsp");
    request.getServletContext().getRequestDispatcher("/WEB-INF/header/header.jsp")
    .forward(request, response);
  }

  /**
   * Do post.
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    doGet(request, response);
  }
}
