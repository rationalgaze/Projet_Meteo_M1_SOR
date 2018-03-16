package manager;

import bean.Meteo;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import rmi.ServeurRMI;


public class Manager {
  boolean identifie = false;
  String ident = null;
  ServeurRMI serveur;
  int port;
  Registry registry;
  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
  
  /**
   * Manager constructor.
   */
  public Manager() {
    port = 2000;
    try {
      registry = LocateRegistry.getRegistry(port);
      serveur = (ServeurRMI) registry.lookup("serveurRMI");
      serveur.connect();
      String res = serveur.meth("test");
      System.out.println("res ICI = " + res);   
    } catch (Exception e) {
      System.out.println("Erreur client RMI " + e.getMessage());
      e.printStackTrace();
    }
  }
  
  /**
   * creation of Manager and works like client RMI.
   * @param request HttpServletRequest
   * @return Manager.
   */
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
  
  /**
   * Authentification method that invokes auth(login, mdp) on RMI server.
   * @param login - String with login 
   * @param mdp - String with mdp
   * @return boolean.
   */
  public boolean auth(String login, String mdp) {
    boolean res = false;
    try {
      res = serveur.auth(login, mdp);
      // System.out.println("AUTH "+login+" "+mdp+" "+res);
    } catch (RemoteException e) {
      e.printStackTrace();
    }
    return res;
  }
  
  /**
   * meteoDuJour.
   * @return String table.
   */
  public String[] meteoDuJour() {
    String[] res = null;  
    LocalDateTime now = LocalDateTime.now();
    try {
      res = serveur.readData(dtf.format(now));
    } catch (RemoteException e) {
      e.printStackTrace();
    }
    return res;
  }
  
  /**
   * meteoMensuelle.
   * @return String[][].
   */
  public String[][] meteoMensuelle() {
    String[][] res = null; 
    // LocalDateTime now = LocalDateTime.now(); 
    try {
      res = serveur.MonthlyReport("2018-04-");
    } catch (RemoteException e) {
      e.printStackTrace();
    }
    return res;
  }
  
  /**
   * Add line in DataBase.
   * @param date.
   * @param loc.
   * @param tmin.
   * @param tmax.
   * @param tmoy.
   * @param rain.
   * @param sun.
   * @param wind.
   * @param rafale.
   * @param dir.
   * @return bool.
   */
  public boolean addLigne(String date, String loc, String tmin, 
      String tmax, String tmoy, String rain, String sun, 
      String wind, String rafale, String dir) {
    boolean res = false;
    
    int Tmin = Integer.parseInt(tmin);
    int Tmax = Integer.parseInt(tmax);
    int Tmoy = Integer.parseInt(tmoy);
    int Sun = Integer.parseInt(sun);
    int Rain = Integer.parseInt(rain);
    int Wind = Integer.parseInt(wind);
    int raf = Integer.parseInt(rafale);
    try {
      res = serveur.addData(date, loc, Tmin, Tmax, 
          Tmoy,  Rain, Sun, Wind, raf, dir);
    } catch (RemoteException e) {
      e.printStackTrace();
    }
    return res;
  }
   
  //ajouter une photo dans la BDD
  public boolean addPhoto(InputStream fis, String date) {
    boolean res = false;
    
    byte[] buffer = new byte[8192];
    int bytesRead;
    ByteArrayOutputStream output = new ByteArrayOutputStream();
    
    try {
      while ((bytesRead = fis.read(buffer)) != -1)
      {
          output.write(buffer, 0, bytesRead);
      }
    } catch (IOException e1) {
      e1.printStackTrace();
    }
    
    buffer = output.toByteArray();
          
    try {
      res = serveur.receiveImage(buffer, date);
    } catch (RemoteException e) {
      e.printStackTrace();
    }
    
    return res;
  }
  
  public static ArrayList<Meteo> extractData(InputStream is) throws IOException {
    ArrayList<Meteo> lMeteo = new ArrayList<Meteo>();
    BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
    br.readLine();
    String line;
    while((line=br.readLine()) != null) {
            String [] s = line.split("[\\t| ]");
            Meteo m = new Meteo();
            s[0]=s[0]+"-"+s[1]+"-"+s[2];
            m.setD(s[0]);
            m.setLocation(s[11]);
            m.setTemp_min(Double.parseDouble(s[3]));
            m.setTemp_max(Double.parseDouble(s[4]));
            m.setTemp_moy(Double.parseDouble(s[5]));
            m.setRain(Double.parseDouble(s[6]));
            m.setSun(Double.parseDouble(s[7]));
            m.setWind(Double.parseDouble(s[8]));
            m.setRafale(Double.parseDouble(s[9]));
            m.setDirection(s[10]);
            lMeteo.add(m);
    }
    br.close();
    return lMeteo;
  }
  
  public boolean addMultipleLines(InputStream is) throws IOException {
    
    boolean res = false; 
    ArrayList<Meteo> lst = null;
    lst = extractData(is);
    
    try {
      res = serveur.addMultipleData(lst);
    } catch (RemoteException e) {
      e.printStackTrace();
    }
    return res;
  }
  
  public boolean updateMeteo (String d,String location,double temp_min,double temp_max,
      double temp_moy,double rain,double sun,double wind,double rafale,String dir) {
    boolean res = false;
    
    try {
      res = serveur.updateMeteo(d,location,temp_min,temp_max,temp_moy,rain,sun,wind,rafale,dir);
    } catch (RemoteException e) {
      e.printStackTrace();
    }
    return res;
  }

  public static void main(String [] args) {
    Manager m = new Manager();
    try {
      m.serveur.connect();
    } catch (RemoteException e) {
      e.printStackTrace();
    }
  }
}
