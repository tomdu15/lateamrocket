package Util;

public class Util {

	/**
	 * Retourne une string bas�e sur la string param�tre avec un certain nombre d'espaces avant 
	 * et faisant un certain nombre de caract�res
	 * @param s la string � traiter
	 * @param before le nombre d'espaces avant
	 * @param total le nombre total de caract�res
	 * @return s la string format�e
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
