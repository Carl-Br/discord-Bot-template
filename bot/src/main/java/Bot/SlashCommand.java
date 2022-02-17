package Bot;

import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.privileges.CommandPrivilege;

import java.util.ArrayList;
import java.util.List;

public abstract class SlashCommand extends CommandData{
    protected CommandPrivilege commandPrivilege;
    protected CommandData commandData;
    protected List<SlashSubCommand> slashSubCommands = new ArrayList<SlashSubCommand>();
    protected boolean isSubCommand;

    public  SlashCommand(CommandData cd){
        super(cd);
        commandData = cd;
    }
    public abstract void run(SlashCommandEvent event) throws Exception;

    public void addSubCommand(SlashSubCommand ssc){
        slashSubCommands.add(ssc);
        commandData.addSubcommands(ssc.subcommandData);
    }
}
