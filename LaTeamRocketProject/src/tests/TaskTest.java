package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import sds.Project;
import sds.Sprint;
import sds.Task;

public class TaskTest {

	@Test
	public void test() {
		Project p = new Project("Projet Scrum");
		assertEquals("Projet Scrum",p.getName());
		
		// test création auto du Backlog
		assertEquals("Backlog",p.getBacklog().getName());
				
		Sprint s = new Sprint("Sprint 0");
		Sprint s1 = new Sprint("Sprint 00");
		s1.addElement(new Task("Task 001", 5, 3));
		s1.addElement(new Task("Task 002", 3, 3));
		s.addElement(s1);
		p.addElement(s);
		
		// test de l'insertion du sprint
		assertEquals("Sprint 0",p.getElement(0).getName());
		// test de présence du sous-sprint
		assertEquals("Sprint 00",((Sprint)p.getElement(0)).getElement(0).getName());
		// test de présence des tâches
		assertEquals("Task 001",((Sprint)((Sprint)p.getElement(0)).getElement(0)).getElement(0).getName());
		assertEquals("Task 002",((Sprint)((Sprint)p.getElement(0)).getElement(0)).getElement(1).getName());
		
		p.print(0);
		
		// test de mise à jour des estimations
		assertEquals(8,p.getEstimation());
		assertEquals(6,p.getRemaining());

		
	}

}
