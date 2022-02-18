package Bot;

import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.privileges.CommandPrivilege;

import java.util.ArrayList;
import java.util.List;

public abstract class SlashCommand{
    protected CommandPrivilege commandPrivilege;
    protected CommandData commandData;
    protected List<SlashSubCommand> slashSubCommands = new ArrayList<SlashSubCommand>();
    protected List<SubCommandGroup> subCommandGroups = new ArrayList<SubCommandGroup>();

    public  SlashCommand(CommandData cd){
        commandData = cd;
    }

    //this methode gets executed, when the command has no sub commands
    public abstract void run(SlashCommandEvent event) throws Exception;

    public void addSubCommand(SlashSubCommand ssc){
        slashSubCommands.add(ssc);
        commandData.addSubcommands(ssc.subcommandData);
    }

    public void addSubCommandGroup (SubCommandGroup scg){
        commandData.addSubcommandGroups(scg.subcommandGroupData);
        subCommandGroups.add(scg);
    }

    public CommandData getCommandData(){
        return  commandData;
    }

    public void setCommandDate(CommandData  cd){
        commandData = cd;
    }
}
