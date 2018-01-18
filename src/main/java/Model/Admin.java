package Model;

import Entities.Account;
import ORM.ORMCommand;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("admin")
public class Admin extends Account {

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<ORMCommand> commands;

    public Admin() {
    }

    public Admin(long id, String username) {
        super(id, username);
    }
}
