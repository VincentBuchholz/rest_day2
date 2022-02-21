package facades;

import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class EmployeeFacade {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

    public Employee getEmpById(int id){
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Employee.class,id);
        } finally {
            em.close();
        }
    }

    public Employee getEmployeesByName(String name){
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Employee> tq = em.createQuery("select e from Employee e where e.name=:name",Employee.class);
            tq.setParameter("name",name);
            return tq.getSingleResult();
        } finally {
            em.close();
        }
    }

    public List<Employee> getAllEmployees(){
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Employee> tq = em.createQuery("select e from Employee e",Employee.class);
            return tq.getResultList();
        } finally {
            em.close();
        }
    }

    public Employee getEmployeesWithHighestSalary(){
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Employee> tq = em.createQuery("select e from Employee e order by e.salary desc",Employee.class);
            return tq.setMaxResults(1).getSingleResult();
        } finally {
            em.close();
        }
    }

    public void createEmployee(Employee emp){
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.persist(emp);
            em.getTransaction().commit();
        }
        finally {
            em.close();
        }
    }

}
