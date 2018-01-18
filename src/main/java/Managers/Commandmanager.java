package Managers;

import DAO.CommandDAO;
import ORM.ORMCommand;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class Commandmanager {


    //private  EntityManagerFactory emf = Persistence.createEntityManagerFactory("database");
    @PersistenceContext(name = "database")
    protected EntityManager em = Persistence.createEntityManagerFactory("database").createEntityManager();

    public void getCommandById(int commandId) {

        CommandDAO cmd = new CommandDAO(em);
        em.getTransaction().begin();
        try {
            cmd.getByid(commandId);
            em.getTransaction().commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }
    }
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
