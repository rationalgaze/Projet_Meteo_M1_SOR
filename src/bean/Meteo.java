package bean;

import java.io.Serializable;

import annotation.Regexp;

public class Meteo implements Serializable {

  private static final long serialVersionUID = 1L;
  
  @Regexp(expr="^[0-9]{1,}[.][0-9]{1,}$" , value="Le champ doit contenir une chiffre en format '0.0'")
  double temp_min;
  @Regexp(expr="^[0-9]{1,}[.][0-9]{1,}$" , value="Le champ doit contenir une chiffre en format '0.0'")
  double temp_max;
  @Regexp(expr="^[0-9]{1,}[.][0-9]{1,}$" , value="Le champ doit contenir une chiffre en format '0.0'")
  double temp_moy;
  @Regexp(expr="^[0-9]{1,}[.][0-9]{1,}$" , value="Le champ doit contenir une chiffre en format '0.0'")
  double wind;
  @Regexp(expr="^[0-9]{1,}[.][0-9]{1,}$" , value="Le champ doit contenir une chiffre en format '0.0'")
  double sun;
  @Regexp(expr="^[0-9]{1,}[.][0-9]{1,}$" , value="Le champ doit contenir une chiffre en format '0.0'")
  double rain;
  @Regexp(expr="^[0-9]{1,}[.][0-9]{1,}$" , value="Le champ doit contenir une chiffre en format '0.0'")
  double rafale;
  @Regexp(expr="^[a-z]{1,3}$", value="Choisissez la direction du vent")
  String dir;
  @Regexp(expr="^[0-9]{2}/[0-9]{2}/[0-9]{4}$" , value="Le champ doit contenir une date en format 'jj/mm/yyyy'")
  String date;
  
  public Meteo () {}

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

  public double getTemp_min() {
    return temp_min;
  }

  public void setTemp_min(double temp_min) {
    this.temp_min = temp_min;
  }

  public double getTemp_max() {
    return temp_max;
  }

  public void setTemp_max(double temp_max) {
    this.temp_max = temp_max;
  }

  public double getTemp_moy() {
    return temp_moy;
  }

  public void setTemp_moy(double temp_moy) {
    this.temp_moy = temp_moy;
  }

  public double getWind() {
    return wind;
  }

  public void setWind(double wind) {
    this.wind = wind;
  }

  public double getSun() {
    return sun;
  }

  public void setSun(double sun) {
    this.sun = sun;
  }

  public double getRain() {
    return rain;
  }

  public void setRain(double rain) {
    this.rain = rain;
  }

  public double getRafale() {
    return rafale;
  }

  public void setRafale(double rafale) {
    this.rafale = rafale;
  }

  public String getDirection() {
    return dir;
  }

  public void setDirection(String direction) {
    this.dir = direction;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

}
