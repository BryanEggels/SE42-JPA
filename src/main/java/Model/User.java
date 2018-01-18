package Model;

import Entities.Account;
import ORM.ORMCommand;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class User extends Account {

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<ORMCommand> commands;
    private int id;

    public User() {
    }

    public User(String username) {
        super(username);
    }

    public User(int id) {
        this.id = id;
    }

    public User(String username, int id) {
        super(username);
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }
}
