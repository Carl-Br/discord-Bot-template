package commands;

import Bot.Bot;
import Bot.SlashSubCommand;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.interactions.commands.build.SubcommandData;

public class TestSubcommandOne extends SlashSubCommand {
    public TestSubcommandOne(SubcommandData scd) {
        super(scd);
    }

    @Override
    public void run(SlashCommandEvent event) throws Exception {
        event.replyEmbeds(Bot.getReplyEmbed("Test","This is a test subcommand 1").build()).queue();
    }
}
