package sds;

import java.util.ArrayList;

public abstract class Conteneur extends Element{

	/**
	 * Liste d'éléments contenus par le projet
	 * ne peut pas être des tâches
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
