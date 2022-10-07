package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testJobConstructorSetsAllFields() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(testJob instanceof Job);
        assertEquals("Product tester", testJob.getName());
        assertTrue(testJob.getEmployer() instanceof Employer);
        assertEquals("ACME", testJob.getEmployer().getValue());
        assertTrue(testJob.getLocation() instanceof Location);
        assertEquals("Desert", testJob.getLocation().getValue());
        assertTrue(testJob.getPositionType() instanceof PositionType);
        assertEquals("Quality control", testJob.getPositionType().getValue());
        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", testJob.getCoreCompetency().getValue());
    }
    @Test
    public void testJobsForEquality(){
        Job job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(job3.equals(job4));
    }

    //Part 5 Use TDD to build the toString method...
    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String toString = job.toString();
        String output = "\n"  +
                "ID:" + " " + job.getId() + '\n' +
                "Name:" + " " + job.getName() + '\n' +
                "Employer:" + " " + job.getEmployer() + '\n' +
                "Location:" + " " + job.getLocation() + '\n' +
                "Position Type:" + " " + job.getPositionType() + '\n' +
                "Core Competency:" + " " + job.getCoreCompetency() +"\n";

//trying to fix test assertion error but not sure how to...
        assertEquals(toString.charAt(0), output.charAt(0));
        assertEquals(toString.charAt(toString.length() - 1), output.charAt(toString.length() - 1));
    }
    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job job = new Job ("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String output = "\n"  +
                "ID:" + " " +job.getId() + '\n' +
                "Name:" + " " + job.getName() + '\n' +
                "Employer:" + " " + job.getEmployer() + '\n' +
                "Location:" + " " + job.getLocation() + '\n' +
                "Position Type:" + " " + job.getPositionType() + '\n' +
                "Core Competency:" + " " + job.getCoreCompetency() +"\n";
        assertEquals(output, job.toString());
    }
//    @Test
//    public void testToStringHandlesEmptyField(){
//        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
//        String toString = job.toString();
//        String emptyName = job.getName().equals("") ? " Data not available": job.getName();
//        String emptyEmployer = job.getEmployer().getValue().equals("") ? "Data not available": job.getEmployer().toString();
//        String emptyLocation = job.getLocation().getValue().equals("") ? "Data not available": job.getLocation().toString();
//        String emptyPosition = job.getPositionType().getValue().equals("") ? "Data not available": job.getPositionType().toString();
//        String emptyCore = job.getCoreCompetency().getValue().equals("") ? "Data not available": job.getCoreCompetency().toString();
//        String output = "\n"  +
//                "ID:" + " " + job.getId() + '\n' +
//                "Name:" + " " + emptyName + '\n' +
//                "Employer:" + " " + emptyEmployer + '\n' +
//                "Location:" + " " + emptyLocation + '\n' +
//                "Position Type:" + " " + emptyPosition + '\n' +
//                "Core Competency:" + " " + emptyCore + '\n';
//
//
//
//
//        //assertEquals(output.toString(), job.toString());
//    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job = new Job(
                "Web Developer",
                new Employer(""),
                new Location("StL"),
                new PositionType(""),
                new CoreCompetency("Java"));
        String output = String.format("\nID: %d\n" +
                "Name: %s\n" +
                "Employer: Data not available\n" +
                "Location: %s\n" +
                "Position Type: Data not available\n" +
                "Core Competency: %s\n",job.getId(), job.getName(), job.getLocation(), job.getCoreCompetency());
        assertEquals(output, job.toString());
    }

    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());
    }
}





