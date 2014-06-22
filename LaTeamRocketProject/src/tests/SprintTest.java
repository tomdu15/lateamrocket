package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import sds.Conteneur;
import sds.Project;
import sds.Sprint;

public class SprintTest {

	@Test
	public void test() {
		Project p = new Project("Projet Scrum");
		assertEquals("Projet Scrum",p.getName());
		
		// test création auto du Backlog
		assertEquals("Backlog",p.getBacklog().getName());
				
		Sprint s = new Sprint("Sprint 0");
		s.addElement(new Sprint("Sprint 00"));
		p.addElement(s);
		
		
		// test de l'insertion du sprint
		assertEquals("Sprint 0",p.getElement(0).getName());
		// test de présence du sous-sprint
		assertEquals("Sprint 00",((Sprint)p.getElement(0)).getElement(0).getName());
		
		p.copyElement(((Sprint)p.getElement(0)).getElement(0),0);
		// test de copie du sprint et de l'insertion de celui-ci au bon indice
		assertEquals("Sprint 00", p.getElement(0).getName());
		// test de décalage des sprints
		assertEquals("Sprint 0",p.getElement(1).getName());

		p.print(0);
		
		System.out.println();
		System.out.println();
		p.moveElement(((Conteneur)p.getElement(1)),0,2);
		p.print(0);
		// test de déplacement d'un sprint

		assertEquals("Sprint 00", p.getElement(0).getName());
		assertEquals("Sprint 0", p.getElement(1).getName());
		assertEquals(null,((Conteneur) p.getElement(1)).getElement(0));
		assertEquals("Sprint 00",p.getElement(2).getName());
        
		// test de suppression d'un sprint
		p.removeElement(0);
		
		p.print(0);
		assertEquals("Sprint 0", p.getElement(0).getName());
		assertEquals("Sprint 00", p.getElement(1).getName());
		assertEquals(null, p.getElement(2));
		
		// test de déplacement au sein même d'un conteneur
		p.moveElement(p,0,1);
		
		assertEquals("Sprint 00", p.getElement(0).getName());
		assertEquals("Sprint 0", p.getElement(1).getName());
		assertEquals(null, p.getElement(2));
	}

}
