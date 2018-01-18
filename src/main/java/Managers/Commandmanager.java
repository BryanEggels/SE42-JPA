package Managers;

import DAO.CommandDAO;
import ORM.ORMCommand;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class Commandmanager {


    //private  EntityManagerFactory emf = Persistence.createEntityManagerFactory("database");

    protected EntityManager em = Persistence.createEntityManagerFactory("database").createEntityManager();


    public void addCommand(ORMCommand command){

        CommandDAO cmddao = new CommandDAO(em);
        em.getTransaction().begin();
        try {

            cmddao.addCommand(command);
            em.getTransaction().commit();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
