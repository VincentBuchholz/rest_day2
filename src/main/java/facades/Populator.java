/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.RenameMeDTO;
import entities.Employee;
import entities.RenameMe;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import utils.EMF_Creator;

/**
 *
 * @author tha
 */
public class Populator {
    public static void populate(){
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        EntityManager em = emf.createEntityManager();

        Employee e1 = new Employee("Vincent","Ulrikkenborg alle 33",5000);
        Employee e2 = new Employee("Andreas","Ulrikkenborg plads 15",65000);
        Employee e3 = new Employee("Thomas","Gl. bagsværdvej 24",28000);

        em.getTransaction().begin();
        em.persist(e2);
        em.getTransaction().commit();
        em.getTransaction().begin();
        em.persist(e3);
        em.getTransaction().commit();
        em.getTransaction().begin();
        em.persist(e1);
        em.getTransaction().commit();
        em.close();
    }
    
    public static void main(String[] args) {
        populate();
    }
}
