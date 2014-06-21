package sds;

import java.util.ArrayList;

public abstract class Conteneur extends Element{

	/**
	 * Liste d'�l�ments contenus par le projet
	 * ne peut pas �tre des t�ches
	 */
	ArrayList<Element> elts;
	
	public Conteneur(String name) {
		super(name);
		elts = new ArrayList<Element> ();
	}
	
	public void addElement(Element e){
		elts.add(e);
	}

	
}
