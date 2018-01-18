package ORM;

import javax.persistence.Entity;
import javax.persistence.Id;

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
}
