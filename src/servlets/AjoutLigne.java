package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import validation.Validation;

/**
 * Servlet implementation class AjoutZip
 */
@WebServlet("/AjoutLigne")
public class AjoutLigne extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjoutLigne() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  request.setAttribute("content", "/WEB-INF/ajout/ajout_ligne.jsp");
	  request.setAttribute("contenu", "/WEB-INF/auth/espaceperso.jsp");
    request.getServletContext().getRequestDispatcher("/WEB-INF/header/header.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    Validation v = new Validation();
    
      System.out.println(request.getParameter("dir"));
      v.regexp(bean.Meteo.class,"temp_min", request.getParameter("min"));
      v.regexp(bean.Meteo.class,"temp_max", request.getParameter("max"));
      v.regexp(bean.Meteo.class,"temp_moy", request.getParameter("moy"));
      v.regexp(bean.Meteo.class,"sun", request.getParameter("sun"));
      v.regexp(bean.Meteo.class,"wind", request.getParameter("wind"));
      v.regexp(bean.Meteo.class,"rain", request.getParameter("rain"));
      v.regexp(bean.Meteo.class,"rafale", request.getParameter("raf"));
      v.regexp(bean.Meteo.class,"dir", request.getParameter("dir"));
      v.regexp(bean.Meteo.class,"date", request.getParameter("date"));      
      
      if (v.isValide()) {
        // TODO
        System.out.println("Valid");
      } else {
        request.setAttribute("v", v);
        request.setAttribute("content", "/WEB-INF/ajout/ajout_ligne.jsp");
        request.setAttribute("contenu", "/WEB-INF/auth/espaceperso.jsp");
        request.getServletContext().getRequestDispatcher("/WEB-INF/header/header.jsp").forward(request, response);
      }

	}

}
