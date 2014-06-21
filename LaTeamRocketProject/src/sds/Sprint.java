package sds;

public class Sprint extends Conteneur {

	public Sprint(String name) {
		super(name);
	}

	/**
	 * Ajoute un �l�ment au sprint
	 * cet Element ne peut pas �tre un projet
	 * @param e, l'element � ajouter
	 */
	public void addElement(Element e){
		if(!(e instanceof Project)){
			elts.add(e);
		}
	}
}
