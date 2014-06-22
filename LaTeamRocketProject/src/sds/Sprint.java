package sds;

import java.util.Date;

public class Sprint extends Conteneur {

	private Date startDate;
	
	private Date endDate;
	
	
	public Sprint(String name) {
		super(name);
		startDate=new Date();
		endDate=new Date();
	}
	
	public Sprint(String name, Date startDate, Date endDate) {
		super(name);
		this.startDate=startDate;
		this.endDate=endDate;
	}

	/**
	 * Ajoute un élément au sprint
	 * cet Element ne peut pas être un projet
	 * @param e, l'element à ajouter
	 */
	public void addElement(Element e){
		if(!(e instanceof Project)){
			e.setParent(this);
			super.addElement(e);
			
		}
	}
	
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDDate) {
		this.endDate = endDDate;
	}

}
