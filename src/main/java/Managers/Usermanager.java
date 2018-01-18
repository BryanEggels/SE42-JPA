package Managers;

import DAO.CommandDAO;
import DAO.UserDAO;
import ORM.ORMUser;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.ArrayList;

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

    public ArrayList<ORMUser> getAllUsers() {

        UserDAO userDAO = new UserDAO(em);
        ArrayList<ORMUser> users = new ArrayList<>();
        em.getTransaction().begin();
        try {
            users = userDAO.getAllUsers();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return users;
    }

    public void getUserByName(){


    }
}
