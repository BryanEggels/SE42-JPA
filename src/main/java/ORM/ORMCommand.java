package ORM;


import Entities.Commandable;

import javax.persistence.*;
import java.util.List;

@Entity
//@Table(name="Command")

public class ORMCommand implements Commandable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String prefix;
    private String command;
    private String content;

    @ManyToOne (cascade = CascadeType.MERGE)
    private ORMUser user;
    public ORMCommand() {
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ORMCommand(String Message, ORMUser user) {
        this.prefix = Message.substring(0,1);
        this.user = user;
        if (prefix.equals("!")){
            if (Message.contains(" ")){
                command = Message.substring(1,Message.indexOf(" "));
                content = Message.substring(Message.indexOf(" "));
                content = content.substring(1);
            }
            else{
                command = Message.substring(1);
            }
        }
        else {
            return;
        }
    }
}
