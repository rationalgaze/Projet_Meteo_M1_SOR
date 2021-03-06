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
 * Servlet implementation class Connexion.
 */
@WebServlet("/Connection")
public class Connection extends HttpServlet {
  private static final long serialVersionUID = 1L;
       
  /**
   * Constructor.
   * @see HttpServlet#HttpServlet()
   */
  public Connection() {
      super();
  }
  
  /**
   * Do Get.
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    request.setAttribute("contenu", "/WEB-INF/auth/LoginForm.jsp");
    request.getServletContext().getRequestDispatcher("/WEB-INF/header/header.jsp")
    .forward(request, response);
  }
  
  /**
   * Do Post.
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    String id = request.getParameter("login");
    String mdp = request.getParameter("mdp");
    
    Manager manager = Manager.creer(request);
    Validation v = new Validation();
    
    if (id != null && mdp != null) {
      // validation des champs du formulaire
      // test des regexp trouvée dans le bean
      v.regexp(bean.Compte.class,"mail", id);
      v.regexp(bean.Compte.class,"password", mdp);
            
      if (v.isValide()) {
        if (manager.auth(id, mdp)) {
          System.out.println("ident OK");
          manager.setIdentifie(true);
          manager.setIdent(id);
          response.sendRedirect("EscpacePersonnel");
          return;
        } else {
          System.out.println("err OK");
          request.setAttribute("msg", 
              "Erreur d'identification : le mot de passe ou login ne sont pas correctes.");
          request.setAttribute("contenu", "/WEB-INF/auth/LoginForm.jsp");
          request.getServletContext().getRequestDispatcher("/WEB-INF/header/header.jsp")
          .forward(request, response);
        }
      } else {
        System.out.println("erreur saisie");
        request.setAttribute("v", v);
        request.setAttribute("contenu", "/WEB-INF/auth/LoginForm.jsp");
        request.getServletContext().getRequestDispatcher("/WEB-INF/header/header.jsp")
        .forward(request, response);
      }
    }
  }

}
