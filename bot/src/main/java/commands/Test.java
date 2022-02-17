package commands;

import Bot.*;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.SubcommandData;

public class Test extends  SlashCommand{
    public Test(CommandData cd) {

        super(cd);

        //adding sub commands
        //1
        SubcommandData subcommandData_one = new SubcommandData("test_subcommand_one", "this is a test sub command");
        addSubCommand(new TestSubcommandOne(subcommandData_one));
        //2
        SubcommandData subcommandData_two = new SubcommandData("test_subcommand_two", "this is a test sub command");
        addSubCommand(new TestSubcommandTwo(subcommandData_two));
    }

    @Override
    public void run(SlashCommandEvent event) throws Exception {
       event.replyEmbeds(Bot.getReplyEmbed("Test","This is a test command").build()).queue();
    }
}
