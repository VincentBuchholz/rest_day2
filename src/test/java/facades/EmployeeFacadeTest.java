package facades;

import entities.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.EMF_Creator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeFacadeTest {
EmployeeFacade ef = new EmployeeFacade();


    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getEmpById() {
        System.out.println("testing");
        assertEquals("Andreas",ef.getEmpById(1).getName());
    }

    @Test
    void getEmployeesByNameTest(){
        assertEquals(3,ef.getEmployeesByName("Vincent").getId());
    }

    @Test
    void getAllEmployeesTest(){
        assertEquals(3,ef.getAllEmployees().size());
    }

    @Test
    void getEmployeesWithHighestSalaryTest(){
        assertEquals("Andreas",ef.getEmployeesWithHighestSalary().getName());
    }

//    @Test
//    void createEmployeeTest(){
//        Employee e1 = new Employee("Viktor","Amager",2000);
//        ef.createEmployee(e1);
//        assertEquals(4,ef.getAllEmployees().size());
//    }
}