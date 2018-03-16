package servlets;

import com.qoppa.pdfWriter.PDFDocument;
import com.qoppa.pdfWriter.PDFPage;

import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manager.Manager;

/**
 * Servlet implementation class ExportPdf
 * For exporting Meteo on PDF Format.
 */
@WebServlet("/ExportPdf")
public class ExportPdf extends HttpServlet {
  private static final long serialVersionUID = 1L;
       
  /**
   * Constructor ExportPdf.
   * @see HttpServlet#HttpServlet()
   */
  public ExportPdf() {
  }
  
  /**
   * doGet.
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    generatePdf(request, response);
  }
  
  /**
   * doPost.
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {
    generatePdf(request, response);
  }
  
  private void generatePdf(HttpServletRequest req, HttpServletResponse res) 
      throws IOException, ServletException {

    String draw;
              
    // Create pageformat for the document
    PageFormat pf = new PageFormat();
    Paper paper = new Paper();
    paper.setSize(72 * 8.5, 72 * 11.0);
    pf.setOrientation(PageFormat.LANDSCAPE);
    pf.setPaper(paper);
    
    // Create a document and a page in the document
    PDFDocument pdfDoc = new PDFDocument();
    PDFPage newPage = pdfDoc.createPage(pf);
    
    // Draw to the page
    Graphics2D g2d = newPage.createGraphics();
    
    Manager manager = Manager.creer(req);
    String[][] tab = manager.meteoMensuelle();
    
    for (int i = 0; i < tab.length; i++) {
      draw = "";
      for (int j = 0; j < tab[i].length; j++) {
        draw += tab[i][j] + " ";
      }
      g2d.drawString(draw, 150, (i + 11) * 25);
    }
    
    // Add the page to the document
    pdfDoc.addPage(newPage);

    // Get servlet output stream
    ServletOutputStream sout = res.getOutputStream();
    res.setContentType("application/pdf");  
    res.setHeader("Content-disposition", "attachment; filename=" + "report.pdf");
    
    
    // Save the document to the servlet output stream.  This goes directly to the browser
    pdfDoc.saveDocument(sout);
    
    // Close the server output stream
    sout.close();
  }
}
