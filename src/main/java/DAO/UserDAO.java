package DAO;

import ORM.ORMUser;

import javax.persistence.EntityManager;

public class UserDAO {


    private final EntityManager em;

    public UserDAO(EntityManager em) {
        this.em = em;
    }


    public ORMUser getByid(int id) {
        return em.find(ORMUser.class,id);
    }
}
