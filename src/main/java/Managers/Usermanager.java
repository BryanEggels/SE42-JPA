package Managers;

import DAO.CommandDAO;
import DAO.UserDAO;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Usermanager {
    protected EntityManager em = Persistence.createEntityManagerFactory("database").createEntityManager();

    public void getUserById(int userId) {

        UserDAO userDAO = new UserDAO(em);
        em.getTransaction().begin();
        try {
            userDAO.getByid(userId);
            em.getTransaction().commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
    }

    public void getUserByName(){

    }
}
