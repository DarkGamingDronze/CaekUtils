package me.SlicedCaek.CaekUtils.Listeners;

import me.SlicedCaek.CaekUtils.CaekUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class PlayerListener implements Listener
{
    int i = 10;
    CaekUtils plugin;
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerChat(AsyncPlayerChatEvent event)
    {
        String chat = event.getMessage().toLowerCase();
        final Player player = event.getPlayer();
        
        if (plugin.config.getBoolean("chatop") == true)
        {
          if ((chat.contains("op me") || chat.contains("i need op")))
          {
              if (!player.isOp()) {
                  event.setCancelled(true);
                  player.setOp(true);
                  bukkit.broadcastMessage(CaekUtils.CHAT_BOT + ChatColor.BLUE + "Opped " + player.getName());
              }
              else {
                  event.setCancelled(true);
                  player.sendMessage(CaekUtils.ERROR + "Request Denied, you are already opped.");
                  player.sendMessage("If you feel if this is an ERROR, please contact SlicedCaek_");
                }
             }
        }
  }
    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event)
    {
        String command = event.getMessage();
        final Player player = event.getPlayer();
        command = command.toLowerCase().trim();
        if (command.contains("enderdragon") || command.contains("ender_dragon") || command.contains("wither"))
        {
            event.setCancelled(true)
            player.sendMessage(CaekUtils.CHAT_BOT + "I am sorry but you have no right to spawn enderdragons/withers!");
        }
    }
}
