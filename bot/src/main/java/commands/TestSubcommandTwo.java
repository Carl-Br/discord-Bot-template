package commands;

import Bot.Bot;
import Bot.SlashSubCommand;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.interactions.commands.build.SubcommandData;

public class TestSubcommandTwo extends SlashSubCommand {
    public TestSubcommandTwo(SubcommandData scd) {
        super(scd);
    }

    @Override
    public void run(SlashCommandEvent event) throws Exception {
        event.replyEmbeds(Bot.getReplyEmbed("Test","This is a test subcommand 2").build()).queue();
    }
}