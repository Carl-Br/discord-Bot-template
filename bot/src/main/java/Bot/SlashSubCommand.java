package Bot;

import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.interactions.commands.build.SubcommandData;
import net.dv8tion.jda.api.interactions.commands.privileges.CommandPrivilege;

import java.util.Collection;

public abstract class SlashSubCommand {
    protected CommandPrivilege commandPrivilege;
    protected SubcommandData subcommandData;

    public  SlashSubCommand(SubcommandData scd){
        subcommandData = scd;
    }
    public abstract void run(SlashCommandEvent event) throws Exception;

    public void setSlashSubCommand(SubcommandData scd){
        subcommandData = scd;
    }

    public void setCommandPrivilege(CommandPrivilege cp){
        commandPrivilege = cp;
    }
    public CommandPrivilege getCommandPrilvilege(){
        return commandPrivilege;
    }
}