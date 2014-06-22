package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import sds.Project;
import sds.Sprint;
import sds.Task;

public class ProjectTest {

	@Test
	public void test() {
		Project p = new Project("Projet Scrum");
		assertEquals("Projet Scrum",p.getName());
		p.addElement(new Project("Sous projet 1"));
		assertEquals("Sous projet 1",p.getElement(0).getName());
		p.addElement(new Sprint("Sprint 0"));
		assertEquals("Sprint 0",p.getElement(1).getName());
		p.addElement(new Task("Task 1"));
		assertEquals(null,p.getElement(2));
	}

}
