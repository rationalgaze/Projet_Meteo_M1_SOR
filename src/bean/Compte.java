package bean;

import annotation.Regexp;

public class Compte {
  // ^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$
  @Regexp(expr="^([A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+)$" , value="Le champ doit contenir un email valide")
  private String mail;
  
  @Regexp(expr="^[A-Za-z0-9._%+-+@]{3,128}$" , value="Le champ doit contenir au minimum 3 symboles")
  private String password;
  
  public Compte () {
    this.mail = null;
    this.password = null;
  }
  
  public Compte (String m, String pwd) {
    this.mail = m;
    this.password = pwd;
  }

  public String getMail() {
    return mail;
  }

  public String getPassword() {
    return password;
  }
  
}
