package hello;

import Managers.Commandmanager;
import Managers.Usermanager;
import ORM.ORMCommand;
import ORM.ORMUser;
import com.sun.istack.internal.Nullable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sx.blah.discord.api.ClientBuilder;
import sx.blah.discord.api.IDiscordClient;
import sx.blah.discord.api.events.EventDispatcher;
import sx.blah.discord.util.DiscordException;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        IDiscordClient client = createClient("MzgyNDU3NjY5NzU3NDM1OTA0.DPW74g.SHxzshdBFF83Zm2v5XrvYW3sCNI",true);

        EventDispatcher dispatcher = client.getDispatcher();
        dispatcher.registerListener(new MessageListener());



    }
    @Nullable
    public static IDiscordClient createClient(String token, boolean login) { // Returns a new instance of the Discord client
        ClientBuilder clientBuilder = new ClientBuilder(); // Creates the ClientBuilder instance
        clientBuilder.withToken(token); // Adds the login info to the builder


        try {
            if (login) {
                return clientBuilder.login(); // Creates the client instance and logs the client in
            } else {
                return clientBuilder.build(); // Creates the client instance but it doesn't log the client in yet, you would have to call client.login() yourself
            }
        }
        catch (DiscordException e) { // This is thrown if there was a problem building the client
            e.printStackTrace();
            return null;


        }
    }
}