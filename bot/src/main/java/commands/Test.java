package commands;

import Bot.*;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.SubcommandData;
import net.dv8tion.jda.api.interactions.commands.build.SubcommandGroupData;

public class Test extends  SlashCommand{
    public Test(CommandData cd) {

        super(cd);

        //
        //adding sub commands
        //

        //1
        SubcommandData subcommandData_one = new SubcommandData("one", "this is a test sub command");
        //addSubCommand(new TestSubcommandOne(subcommandData_one));
        //2
        SubcommandData subcommandData_two = new SubcommandData("two", "this is a test sub command");

        //adds the sub commands to this command
        //addSubCommand(new TestSubcommandTwo(subcommandData_two));


        //
        //Subcommand groups
        //

        //create the group
       SubCommandGroup subCommandGroup = new SubCommandGroup("group","This is a test group");

       //add commands to the group
       subCommandGroup.addSlashSubCommand(new TestSubcommandOne(subcommandData_one));
       subCommandGroup.addSlashSubCommand(new TestSubcommandTwo(subcommandData_two));

       //add the group to the command
       addSubCommandGroup(subCommandGroup);
    }

    @Override
    public void run(SlashCommandEvent event) throws Exception {
       event.replyEmbeds(Bot.getReplyEmbed("Test","This is a test command").build()).queue();
    }
}
