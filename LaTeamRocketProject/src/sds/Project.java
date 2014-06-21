package sds;

public class Project extends Conteneur {

	public Project(String name) {
		super(name);
	}

	/**
	 * Ajoute un element au projet
	 * cet element ne peut pas être une tâche
	 */
	public void addElement(Element e){
		if(!(e instanceof Task)){
			elts.add(e);
		}
	}

	public Element getElement(int i) {
		return elts.size()<=i?null:elts.get(i);
	}
}
