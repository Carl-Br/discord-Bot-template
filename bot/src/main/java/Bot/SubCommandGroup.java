package Bot;

import net.dv8tion.jda.api.interactions.commands.build.SubcommandData;
import net.dv8tion.jda.api.interactions.commands.build.SubcommandGroupData;

import java.util.ArrayList;
import java.util.List;

public class SubCommandGroup {
    public SubcommandGroupData subcommandGroupData;
    public List<SlashSubCommand> subCommandList= new ArrayList<SlashSubCommand>();

    public SubCommandGroup(String name, String description){
        subcommandGroupData = new SubcommandGroupData(name,description);
    }

    public void addSlashSubCommand(SlashSubCommand slashSubCommand){
        subcommandGroupData.addSubcommands(slashSubCommand.subcommandData);
        subCommandList.add(slashSubCommand);
    }

    public SubcommandGroupData getSubcommandGroupData(){
        return  subcommandGroupData;
    }

    public void setSubcommandGroupData(SubcommandGroupData  scgd){
        subcommandGroupData = scgd;
    }
}
