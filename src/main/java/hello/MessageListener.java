package hello;

import Managers.Commandmanager;
import Managers.Usermanager;
import ORM.ORMCommand;
import ORM.ORMUser;
import sx.blah.discord.api.events.IListener;
import sx.blah.discord.handle.impl.events.guild.channel.message.MessageEvent;

public class MessageListener implements IListener<MessageEvent>{


    @Override
    public void handle(MessageEvent event) {

        //filters de bot messages en messages die niet met '!' beginnen.
        if (event.getAuthor().isBot() == false){

            ORMCommand command = new ORMCommand(event.getMessage().getFormattedContent(),new ORMUser(event.getAuthor().getLongID(),event.getAuthor().getName()));

            Commandmanager mgr = new Commandmanager();
            mgr.addCommand(command);
            //filtert de tekst die na het command komt


            //event.getMessage().reply("gave the command: " + command);

            switch (command.getCommand()){
                case "uitschrijven":
                    event.getMessage().getChannel().sendMessage("hier is de link om je uit te schrijven:\n\n https://fontys.nl/Studeren/Aanmelden/Uitschrijven.htm");
                    break;
                case "meme":
                    //send random thrashmeme
                    break;
                case "getUsers":
                    Usermanager umgr = new Usermanager();


                    String gebruikers = "Dit zijn onze gebruikers: \n\n";
                    for (ORMUser user: umgr.getAllUsers()) {
                        gebruikers = gebruikers + user.getName() + "\n";
                    }
                    event.getMessage().getChannel().sendMessage(gebruikers);
            }

        }

    }
}
