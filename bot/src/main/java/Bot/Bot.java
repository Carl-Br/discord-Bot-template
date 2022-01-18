package Bot;

import commands.Test;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.cache.CacheFlag;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.security.auth.login.LoginException;
import java.awt.*;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Bot {

    //config
    private static String token = "";
    public static Color embedColor = Color.blue;

    //debug stuff
    static boolean debug = true;
    static Long debugGuildId = 817346279771340851L;
    static Guild debugGuild = null;


    public static JDA jda= null;
    public static List<SlashCommand> commandList = new ArrayList<SlashCommand>();
    public static void start() throws LoginException, InterruptedException {

        //gets the config from the config.json
        setupConfig();

        // Note: It is important to register your ReadyListener before building
        jda = JDABuilder.createDefault(token, GatewayIntent.GUILD_PRESENCES,GatewayIntent.GUILD_MEMBERS)
                .disableCache(CacheFlag.VOICE_STATE, CacheFlag.EMOTE)
                .addEventListeners(new CommandListener())
                //.setMemberCachePolicy(MemberCachePolicy.ALL)
                //.enableCache(CacheFlag.ACTIVITY)
                .build();



        // optionally block until JDA is ready
        jda.awaitReady();

        //add commands
        commandList.add(new Test("test", "this is a test command"));

        //set all my Commands from the commandList
        debugGuild = jda.awaitReady().getGuildById(debugGuildId);
        updateCommands();
        System.out.println("The discord Bot.Bot is now online");
    }
    public  static void shutdown(){
        jda.shutdown();
        System.out.println("The discord Bot.Bot is now offline");
    }
    public static void updateCommands(){

        //jda.updateCommands();
        debugGuild.updateCommands().queue();

        if(debug){
            for (SlashCommand slashCommand:commandList) {
                jda.upsertCommand(slashCommand.getCommandData()).queue();
            }
        }
        //jda.getGuildById(guildId).updateCommands().queue();
        for (SlashCommand slashCommand:commandList) {
            debugGuild.upsertCommand(slashCommand.getCommandData()).queue();
        }
    }

    public static EmbedBuilder getReplyEmbed(String title, String description){
        EmbedBuilder embed = new EmbedBuilder();
        embed.setColor(embedColor);
        embed.setTitle(title);
        embed.setDescription(description);


        if(title.toLowerCase().contains("success"))
            embed.setThumbnail("https://cdn.discordapp.com/attachments/817346280250540034/925874866257801256/hook-1727484.png");
        else if(title.toLowerCase().contains("error"))
            embed.setThumbnail("https://cdn.discordapp.com/attachments/817346280250540034/925875821971922944/false-2061132.png");

        return embed;
    }

    public static void setupConfig(){
        JSONParser parser = new JSONParser();
        try{
            JSONObject jsonObject = (JSONObject)parser.parse(new FileReader(".//config.json"));
            token = (String)jsonObject.get("token");
            System.out.println("token: "+token);

            String[] rgb = jsonObject.get("embedColor").toString().split(",");
            embedColor = new Color(Integer.parseInt(rgb[0]),Integer.parseInt(rgb[1]),Integer.parseInt(rgb[2]));
        }catch(Exception e){
            e.printStackTrace();
            shutdown();
        }


    }

}
