package core;

import commands.Clear;
import commands.Heil;
import commands.cmdPing;
import commands.say;
import listeners.commandListener;
import listeners.readyListener;
import listeners.voiceListener;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import util.SECRETS;

import javax.security.auth.login.LoginException;

public class Main {
        public static JDABuilder builder;
        public static void main(String[] Args) {

            builder = new JDABuilder(AccountType.BOT);

            builder.setToken(SECRETS.TOKEN);
            builder.setAutoReconnect(true);

            builder.setStatus(OnlineStatus.ONLINE);


            addListeners();
            addCommands();

            try {
                JDA jda = builder.buildBlocking();
            } catch (LoginException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (RateLimitedException e) {
                e.printStackTrace();
            }


        }
        public static void addCommands(){
            commandHandler.commands.put("ping", new cmdPing());
            commandHandler.commands.put("say", new say());
            commandHandler.commands.put("clear", new Clear());
            commandHandler.commands.put("Heil", new Heil());
        }

        public static void addListeners() {

        // LISTENERS
        builder.addEventListener(new readyListener());
        builder.addEventListener(new voiceListener());
        builder.addEventListener(new commandListener());


    }
}
