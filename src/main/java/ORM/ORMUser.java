package ORM;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


@NamedQueries({
        @NamedQuery(name = "User.getAll",
                query = "select a from ORMUser as a"),

})

@Entity
public class ORMUser {
    @Id
    private long id;
    private String name;

    public ORMUser(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ORMUser() {
    }

    public long getId() {
        return id;
    }


    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
}
