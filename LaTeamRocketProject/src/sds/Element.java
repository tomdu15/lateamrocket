package sds;

public abstract class Element {
	/**
	 * Nom du projet
	 */
	private String name;

	/**
	 * Constructeur de projet
	 * @param name le nom du projet
	 */
	public Element (String name){
		this.name=name;		
	}
	
	/**
	 * getter du nom
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter du nom
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
}
