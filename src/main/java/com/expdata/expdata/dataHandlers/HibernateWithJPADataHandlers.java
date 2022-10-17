package com.expdata.expdata.dataHandlers;

import com.expdata.expdata.pojo.Employee;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;
import java.util.List;

@Component
public class HibernateWithJPADataHandlers implements IDataHandlers {


    @Override
    public List<Employee> getEmployees(String name) throws ClassNotFoundException, SQLException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        List<Employee> result = null;

        try {
            em.getTransaction().begin();
            result = em.createNativeQuery(getQueryFetchEmployees(name)).getResultList();

            em.getTransaction().commit();
        } catch (Exception e)
        {
            System.out.println(e);
        }

        return result;
    }

    @Override
    public void addEmployees(Employee employee) throws ClassNotFoundException, SQLException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(employee);
        em.getTransaction().commit();

    }
}
