package commands;

import Bot.*;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;

public class Test extends  SlashCommand{
    public Test(String name, String description) {
        super(name, description);
    }

    @Override
    public void run(SlashCommandEvent event) throws Exception {
       event.replyEmbeds(Bot.getReplyEmbed("Test","This is a test command").build()).queue();
    }
}
