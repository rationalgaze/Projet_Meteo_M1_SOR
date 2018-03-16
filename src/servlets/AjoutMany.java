package servlets;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import manager.Manager;

/**
 * Servlet implementation class AjoutMany.
 */
@WebServlet("/AjoutMany")
@MultipartConfig(maxFileSize = 16177215) 
public class AjoutMany extends HttpServlet {
  private static final long serialVersionUID = 1L;
       
  /**
   * Constructor.
   * @see HttpServlet#HttpServlet()
   */
  public AjoutMany() {
  }

  /**
   * Do Get.
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    request.setAttribute("content", "/WEB-INF/ajout/ajout_many.jsp");
    request.setAttribute("contenu", "/WEB-INF/auth/espaceperso.jsp");
    request.getServletContext().getRequestDispatcher("/WEB-INF/header/header.jsp")
    .forward(request, response);
  }
  
  /**
   * Do Post.
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    
    Manager manager = Manager.creer(request);
  
    Part filePart = request.getPart("zip");
  
    if (filePart != null) {
      
      InputStream inputStream = null;
      // obtains input stream of the upload file
      inputStream = filePart.getInputStream();
      System.out.println(inputStream);
      if (manager.addMultipleLines(inputStream)) {
        request.setAttribute("msg", "1");
        request.setAttribute("content", "/WEB-INF/ajout/ajout_many.jsp");
        request.setAttribute("contenu", "/WEB-INF/auth/espaceperso.jsp");
        request.getServletContext().getRequestDispatcher("/WEB-INF/header/header.jsp")
        .forward(request, response);
      } else {
        request.setAttribute("msg", "0");
        request.setAttribute("content", "/WEB-INF/ajout/ajout_many.jsp");
        request.setAttribute("contenu", "/WEB-INF/auth/espaceperso.jsp");
        request.getServletContext().getRequestDispatcher("/WEB-INF/header/header.jsp")
        .forward(request, response);
      }
    } else {
      request.setAttribute("msg", "0");
      request.setAttribute("content", "/WEB-INF/ajout/ajout_many.jsp");
      request.setAttribute("contenu", "/WEB-INF/auth/espaceperso.jsp");
      request.getServletContext().getRequestDispatcher("/WEB-INF/header/header.jsp")
      .forward(request, response);
    }
  }

}
