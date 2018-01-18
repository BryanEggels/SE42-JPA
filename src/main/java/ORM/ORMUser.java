package ORM;

import Entities.Account;

import javax.persistence.*;


@NamedQueries({
        @NamedQuery(name = "User.getAll",
                query = "select a from ORMUser as a"),

        @NamedQuery(name =  "User.getName",
        query = "select a from Account as a WHERE a.username = :name")
})

@Entity
@DiscriminatorValue("user")
public class ORMUser extends Account {



    public ORMUser(long id, String name) {
        super(id, name);
    }


    public ORMUser() {
    }



}
