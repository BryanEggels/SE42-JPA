package DAO;

import ORM.ORMUser;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;

public class UserDAO {


    private final EntityManager em;

    public UserDAO(EntityManager em) {
        this.em = em;
    }


    public ORMUser getByid(int id) {
        return em.find(ORMUser.class,id);
    }
    public ArrayList<ORMUser> getAllUsers(){
        Query q = em.createNamedQuery("User.getAll", ORMUser.class);
        return (ArrayList<ORMUser>) q.getResultList();
    }
}
