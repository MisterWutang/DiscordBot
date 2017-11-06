package commands;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

import java.awt.Color;


public class Heil implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        String message = "Sieg Heil, mein Kamerad";
        User memb = event.getMessage().getMentionedUsers().size() > 0 ? event.getMessage().getMentionedUsers().get(0) : null;
        User author = event.getAuthor();
        TextChannel chan = event.getTextChannel();

        memb.openPrivateChannel().queue(pc -> pc.sendMessage(
                new EmbedBuilder()
                .setColor(Color.ORANGE)
                .setAuthor(author.getName(), null, author.getAvatarUrl())
                .setDescription(":raising_hand: " + message + "!")
                .build()
        ).queue());

    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }

    @Override
    public String help() {
        return null;
    }
}
