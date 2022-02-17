package Bot;

import Bot.Bot;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.SlashCommandEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.SubcommandData;

import java.awt.*;


public class CommandListener extends ListenerAdapter {


    @Override
    public void onSlashCommand(SlashCommandEvent event)
    {
        for (SlashCommand slashCommand : Bot.commandList) {
            if(event.getName().equals(slashCommand.commandData.getName())){

                Runnable CommandRunMethode;

                System.out.println(event.getName());
                System.out.println(event.getSubcommandGroup());
                System.out.println(event.getSubcommandName());


                try {
                    if(event.getSubcommandName()!=null){
                        for(SlashSubCommand sscmd : slashCommand.slashSubCommands){
                            if(sscmd.subcommandData.getName().equals(event.getSubcommandName())){
                                sscmd.run(event);
                                return;
                            }
                        }
                    }

                    slashCommand.run(event);
                }catch (Exception e){
                    e.printStackTrace();
                    EmbedBuilder embed = new EmbedBuilder();
                    embed.setTitle("ayayayayyy :( .... An error occurred!");
                    embed.setColor(Color.RED);
                    embed.addField("Exception",e.getMessage(),true);
                    event.getChannel().sendMessageEmbeds(embed.build()).queue();
                }
            }
        }
    }
}
