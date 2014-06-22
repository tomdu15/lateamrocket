package Util;

public class Util {

	/**
	 * Retourne une string basée sur la string paramètre avec un certain nombre d'espaces avant 
	 * et faisant un certain nombre de caractères
	 * @param s la string à traiter
	 * @param before le nombre d'espaces avant
	 * @param total le nombre total de caractères
	 * @return s la string formatée
	 */
	public static String gFS(String s, int before, int total){
		for (int i=0; i<before; i++){
			s=" "+s;
		}
		while (s.length()!=total){
			s+=" ";
		}
		return s.substring(0,total);
	}
}
