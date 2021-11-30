package discord.commands;

import net.dv8tion.jda.api.entities.ChannelType;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.itzsave.SpigotJDA;

public class WebsiteCommand extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent event){

        SpigotJDA plugin = SpigotJDA.getPlugin(SpigotJDA.class);

        if (event.getAuthor().isBot()){
            return;
        }

        if (event.isFromType(ChannelType.PRIVATE)){
            return;
        }

        Message msg = event.getMessage();


        if(msg.getContentRaw().equalsIgnoreCase("!website")){
            MessageChannel channel = event.getChannel();
            channel.sendMessage(plugin.getConfig().getString("messages.discord-website-message")).queue();
        }

    }
}
