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
import validation.Validation;

/**
 * Servlet implementation class AjoutPhoto.
 */
@WebServlet("/AjoutPhoto")
@MultipartConfig(maxFileSize = 16177215) 
public class AjoutPhoto extends HttpServlet {
  private static final long serialVersionUID = 1L;
       
  /**
   * Constructor.
   * @see HttpServlet#HttpServlet()
   */
  public AjoutPhoto() {
  }
  
  /**
   * Do Get.
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    request.setAttribute("content", "/WEB-INF/ajout/ajout_photo.jsp");
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
    Validation v = new Validation();
    Manager manager = Manager.creer(request);
  
    v.regexp(bean.Meteo.class,"d", request.getParameter("date"));
    System.out.println(request.getParameter("zip"));
    
    if (v.isValide()) {
      Part filePart = request.getPart("zip");
      
      if (filePart != null) {
        request.setAttribute("msg", "L'image a été bien inseré dans la Base De Données");
        InputStream inputStream = null;
        // obtains input stream of the upload file
        inputStream = filePart.getInputStream();
        manager.addPhoto(inputStream, request.getParameter("date"));
      } else {
        request.setAttribute("msg", "L'image n'a pas été inseré dans la Base De Données");
      }
      request.setAttribute("content", "/WEB-INF/ajout/ajout_photo.jsp");
      request.setAttribute("contenu", "/WEB-INF/auth/espaceperso.jsp");
      request.getServletContext().getRequestDispatcher("/WEB-INF/header/header.jsp")
      .forward(request, response);
    } else {
      request.setAttribute("v", v);
      request.setAttribute("content", "/WEB-INF/ajout/ajout_photo.jsp");
      request.setAttribute("contenu", "/WEB-INF/auth/espaceperso.jsp");
      request.getServletContext().getRequestDispatcher("/WEB-INF/header/header.jsp")
      .forward(request, response);
    }
  }

}
