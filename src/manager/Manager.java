package manager;

import javax.servlet.http.HttpServletRequest;

public class Manager {
  boolean identifie = false;
  String ident = null;
  
  public static Manager creer(HttpServletRequest request) {
    Manager m = (Manager) request.getSession().getAttribute("manager");
    
    if (m == null) {
      m = new Manager();
      request.getSession().setAttribute("manager", m);
    }

    return m;
  }
  
  public boolean isIdentifie() {
    return identifie;
  }
  public void setIdentifie(boolean identifie) {
    this.identifie = identifie;
  }
  public String getIdent() {
    return ident;
  }
  public void setIdent(String ident) {
    this.ident = ident;
  }
}
