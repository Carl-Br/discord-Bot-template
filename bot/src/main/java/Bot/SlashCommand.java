package Bot;

import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.interactions.commands.privileges.CommandPrivilege;

import java.util.Collection;

public abstract class SlashCommand {
    protected String name = null;
    protected  String description = null;
    protected CommandPrivilege commandPrivilege;


    protected Collection<OptionData> optionDataCollection = null;

    public  SlashCommand(String name, String description){
        if (name == null) throw new NullPointerException("Name may not be null");
        if (description == null) throw new NullPointerException("Description may not be null");
        this.name = name;
        this.description=description;
    }
    public abstract void run(SlashCommandEvent event) throws Exception;

    public void setOptionDataCollection(Collection<OptionData> c){
        optionDataCollection = c;
    }

    public CommandData getCommandData(){
        CommandData commandData  = new CommandData(name,description);
        if(optionDataCollection!= null){
            for(OptionData optionData : optionDataCollection){
                commandData.addOptions(optionData);
            }
        }
        return commandData;
    }
}
