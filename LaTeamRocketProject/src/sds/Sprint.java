package sds;

public class Sprint extends Conteneur {

	public Sprint(String name) {
		super(name);
	}

	/**
	 * Ajoute un élément au sprint
	 * cet Element ne peut pas être un projet
	 * @param e, l'element à ajouter
	 */
	public void addElement(Element e){
		if(!(e instanceof Project)){
			elts.add(e);
		}
	}
}
