package sds;

import java.util.ArrayList;
import Util.Util;


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
	
	/**
	 * ajout d'un �l�ment au conteneur
	 * @param e l'element � ajouter
	 */
	public void addElement(Element e){
		elts.add(e);
		reCalculate();
	}

	public Element getElement(int i) {
		return elts.size()<=i || i<0 ?null:elts.get(i);
	}
	
	/**
	 * Copie d'un �l�ment (param�tre) dans note conteneur courant
	 * La copie vise � faire des r�f�rences entre Sprints et/ou projets 
	 * (Un sprint du projet principal contenant lui-m�me un ou plusieurs sprints du sous projet)
	 * On ne modifie pas le parent pour garder la r�f�rence vers le sous-projet et ainsi pouvoir l'afficher
	 * si l'utilisateur le demande
	 * @param element l'�l�ment � copier
	 * @param i l'indice d'insertion dans le conteneur courant
	 */
	public void copyElement(Element element, int i) {
		if (i<elts.size() && i>=0)
			elts.add(i,element);
		else
			elts.add(element);
	}

	/**
	 * D�placement d'un sprint d'un Conteneur (param�tre) � un autre (courant)
	 * Comme le d�placement est d�finitif, on modifie le parent de l'�l�ment d�plac�
	 * @param parent le Conteneur de l'�l�ment � d�placer
	 * @param source l'indice de l'Element � d�placer dans parent
	 * @param dest l'indice d'insertion au sein du Conteneur courant
	 */
	public void moveElement(Conteneur parent, int source, int dest) {
		Element elt;
		if (dest<elts.size() && dest>=0 && source<parent.elts.size() && source>=0){
			elt = parent.getElement(source);
			parent.removeElement(source);
			elt.setParent(this);
			elts.add(dest,elt);
		} else if (source<parent.elts.size() && source >=0){
			elt = parent.getElement(source);
			parent.removeElement(source);
			elt.setParent(this);
			elts.add(elt);
		}
	}

	/**
	 * Suppression d'un �l�ment au sein de note conteneur
	 * @param i l'indice de l'�l�ment � supprimer
	 */
	public void removeElement(int i) {
		if(i<elts.size() && i>=0)
			elts.remove(i);
		
	}
	
	@Override
	void print(int indent){
		if(indent==0){
			System.out.println("Name                |Est|Rem|");
		}
		System.out.println(Util.gFS(getName(),indent,20)+"|"+Util.gFS(getEstimation()+"",0,3)+"|"+Util.gFS(getRemaining()+"",0,3)+"|");
		if (elts.size()>0){
			for(Element elt : elts){
				elt.print(indent+1);
			}
		}
	}
	
	@Override
	void reCalculate(){
		int rem=0, est=0;
		for (Element elt:elts){
			est+=elt.getEstimation();
			rem+=elt.getRemaining();
		}
		setEstimation(est);
		setRemaining(rem);
		if (parent != null)
			parent.reCalculate();
	}
}
