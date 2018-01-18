package DAO;

import ORM.ORMCommand;

import javax.persistence.EntityManager;

public class CommandDAO {

    private final EntityManager em;

    public CommandDAO(EntityManager em) {
        this.em = em;
    }


    public ORMCommand getByid(int id) {
        return em.find(ORMCommand.class,id);
    }

    public void addCommand(ORMCommand cmd){
        em.persist(cmd);
    }
}
