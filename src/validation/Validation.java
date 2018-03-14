package validation;

import java.lang.reflect.Field;
import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import annotation.Regexp;

public class Validation {

	boolean valide = true;
	// indique si une erreur a été détectée
	
	Hashtable<String, String> valeurs = new Hashtable<String, String>();
	
	Hashtable<String, String> erreurs = new Hashtable<String, String>();	
	
	@SuppressWarnings("rawtypes")
  public boolean regexp(Class c, String param, String val) {
		boolean res = false;
		
		try {
		  System.out.println("valeur saisie : "+val);
			Field f = c.getDeclaredField(param);
			Regexp ann = f.getAnnotation(Regexp.class);
			
			Pattern pattern = Pattern.compile(ann.expr());
			Matcher matcher = pattern.matcher(val);
			if (!matcher.matches()) {
				// valeur incorrecte
				System.out.println("Erreur détectée : "+ann.value());
				erreurs.put(param, ann.value());
				valide = false;
			}
			else {
			  res = true;
				System.out.println("Pas d 'erreur");
			}
			
			valeurs.put(param, val);			
		}
		catch (Exception e) {
			valide = false;
			System.out.println("Erreur Validation.regexp "+e.getMessage());
		}		
		
		return res;
	}
	
	public static void main(String [] args) {
	  
    // exemples appels  
    Validation v = new Validation();
    boolean res;
//    res = v.regexp(beans.Compte.class, "mail", "login@1234.ru");
//    System.out.println("res = "+res);
//    
//    res = v.regexp(beans.Compte.class, "password", "1a3b2345b2345b2345");
//    System.out.println("res2 = "+res);
    
    res = v.regexp(bean.Meteo.class, "temp_min", "12.1");
    System.out.println("res temp_min = "+res);
    
    res = v.regexp(bean.Meteo.class, "temp_min", "12.1");
    System.out.println("res temp_moy = "+res);
  }
	
	public boolean isValide() {
		return valide;
	}

	public void setValide(boolean valide) {
		this.valide = valide;
	}

	public Hashtable<String, String> getValeurs() {
		return valeurs;
	}

	public void setValeurs(Hashtable<String, String> valeurs) {
		this.valeurs = valeurs;
	}

	public Hashtable<String, String> getErreurs() {
		return erreurs;
	}

	public void setErreurs(Hashtable<String, String> erreurs) {
		this.erreurs = erreurs;
	}
}
