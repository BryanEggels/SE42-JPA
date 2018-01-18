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
}
