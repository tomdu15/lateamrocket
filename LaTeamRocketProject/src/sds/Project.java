package sds;

import Util.Util;

public class Project extends Conteneur {

	private Sprint backlog;
	
	public Project(String name) {
		super(name);
		setBacklog(new Sprint("Backlog"));
	}

	/**
	 * Ajoute un element au projet
	 * cet element ne peut pas être une tâche
	 * @param e l'element à ajouter
	 */
	public void addElement(Element e){
		if(!(e instanceof Task)){
			e.setParent(this);
			super.addElement(e);
		}
	}
	
	@Override
	public void print(int indent){
		if(indent==0){
			System.out.println("Name                |Est|Rem|");
		}
		System.out.println(Util.gFS(getName(),indent,20)+"|"+Util.gFS(getEstimation()+"",0,3)+"|"+Util.gFS(getRemaining()+"",0,3)+"|");
		backlog.print(indent+1);
		for(Element elt : elts){
			elt.print(indent+1);
		}
	}

	public Sprint getBacklog() {
		return backlog;
	}

	public void setBacklog(Sprint backlog) {
		this.backlog = backlog;
	}
}
