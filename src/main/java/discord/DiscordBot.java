package discord;

import discord.commands.WebsiteCommand;
import jdk.internal.org.jline.reader.ConfigurationPath;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.itzsave.SpigotJDA;

import javax.security.auth.login.LoginException;

public class DiscordBot extends ListenerAdapter {



    public static void main() throws LoginException, InterruptedException {
        SpigotJDA plugin = SpigotJDA.getPlugin(SpigotJDA.class);
        JDA jda = JDABuilder.createDefault(plugin.getConfig().getString("settings.discord-bot-token"))
                .setActivity(Activity.playing("Now running on Spigot!"))
                .addEventListeners(new WebsiteCommand())
                .setStatus(OnlineStatus.DO_NOT_DISTURB)
                .build();

        jda.awaitReady();
        System.out.println("JDA successfully loaded!");
    }

}
