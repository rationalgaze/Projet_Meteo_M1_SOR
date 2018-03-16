package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.Manager;

/**
 * Servlet implementation class Deconnection.
 */
@WebServlet("/Deconnection")
public class Deconnection extends HttpServlet {
  private static final long serialVersionUID = 1L;
       
  /**
   * Constructor.
   * @see HttpServlet#HttpServlet()
   */
  public Deconnection() {
      super();
  }
  
  /**
   * Do Get.
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    Manager manager = Manager.creer(request);
    manager.setIdentifie(false);
    manager.setIdent(null);
    response.sendRedirect("Accueil");
  }
  
  /**
   * Do Post.
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    doGet(request, response);
  }

}
