package sds;

public abstract class Element {
	/**
	 * Nom du projet
	 */
	private String name;
	
	/**
	 * Parent de l'element
	 */
	protected Element parent;
	
	/**
	 * Estimation de charge pour l'element
	 */
	private int estimation;
	
	/**
	 * Reste à faire pour l'élément
	 */
	private int remaining;

	/**
	 * Constructeur d'Element
	 * @param name le nom de l'element
	 */
	public Element (String name){
		this.name=name;	
		estimation=0;
		remaining=0;
	}
	
	public Element(String name, int estimation, int remaining) {
		this(name);
		this.estimation=estimation;
		this.remaining=remaining;
	}

	/**
	 * Affichage de l'Element
	 * @param indent le niveau d'indentation de l'element courant
	 */
	abstract void print(int i);

	/**
	 * Met à jour remaining et estimation
	 */
	abstract void reCalculate();
	
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
	
	public Element getParent() {
		return parent;
	}
	
	public void setParent(Element parent) {
		this.parent=parent;
	}


	
	public int getRemaining() {
		return remaining;
	}

	public void setRemaining(int remaining) {
		this.remaining = remaining;
	}

	public int getEstimation() {
		return estimation;
	}

	public void setEstimation(int estimation) {
		this.estimation = estimation;
	}
}
