package sds;

import java.util.ArrayList;

import Util.Util;

public class Task extends Element {

	ArrayList<Task> tasks;
	
	public Task (String name) {
		super(name);
		tasks=new ArrayList<Task>();
	}
	
	public Task (String name, int estimation, int remaining){
		super(name, estimation, remaining);
		tasks= new ArrayList<Task>();
	}
	
	/**
	 * Ajout d'une sous t�che � la t�che
	 * @param t la sous t�che � ajouter
	 */
	public void addTask(Task t){
		t.setParent(this);
		tasks.add(t);
		reCalculate();
	}

	@Override
	public void reCalculate() {
		int rem=0, est=0;
		for (Task elt:tasks){
			est+=elt.getEstimation();
			rem+=elt.getRemaining();
		}
		setEstimation(est);
		setRemaining(rem);
		parent.reCalculate();
	}
	
	/**
	 * Suppression d'une t�che
	 * @param i indice de la t�che � supprimer
	 */
	public void removeTask(int i){
		if(i<tasks.size() && i>=0){
			tasks.remove(i);
		}
	}
	
	/**
	 * Copie d'une t�che
	 * @param t la t�che � copier
	 * @param i indice d'insertion de la t�che
	 */
	public void copyTask (Task t, int i){
		if(i<tasks.size() && i>=0)
			tasks.add(i,t);
		else
			tasks.add(t);
	}
	
	/**
	 * D�placement d'une sous t�che d'une t�che � la t�che courante
	 * @param t la t�che contenant la t�che � d�placer
	 * @param s l'indice de la t�che source
	 * @param d l'indice d'insertion dans la t�che courante
	 */
	public void moveTask (Task t, int s, int d){
		Task elt;
		if (d<tasks.size() && d>=0 && s<t.tasks.size() && s>=0){
			elt = t.getTask(s);
			t.removeTask(s);
			elt.setParent(this);
			tasks.add(d,elt);
		} else if (s<t.tasks.size() && s >=0){
			elt = t.getTask(s);
			t.removeTask(s);
			elt.setParent(this);
			tasks.add(elt);
		}
	}

	@Override
	public void print(int indent) {
		System.out.println(Util.gFS(getName(),indent,20)+"|"+Util.gFS(getEstimation()+"",0,3)+"|"+Util.gFS(getRemaining()+"",0,3)+"|");
		if (tasks.size()>0){
			for(Task elt : tasks){
				elt.print(indent+1);
			}
		}		
	}
	
	/**
	 * Getter de t�che
	 * @param s l'indice de la t�che � r�cup�rer
	 * @return la t�che correspondant � l'indice s'il est valide, null sinon
	 */
	public Task getTask(int s) {
		return tasks.size()<=s || s<0 ?null:tasks.get(s);
	}
}
