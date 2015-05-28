package me.SlicedCaek.CaekUtils.Commands;

import me.SlicedCaek.CaekUtils.CaekUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(source = SourceType.ANY, permission = "caekutils.*")
public class Command_owner extends BukkitPlugin {
    
    @Override
    public boolean run(CommandSender sender, Command command, String commandLabel, String[] args) {
        Player owner = Bukkit.getServer().getPlayer("RedEastWood");
        Player player = (Player) sender;
      if (owner != null) {
          player.sendMessage(ChatColor.BLUE + "The owner is RedEastWood");
          player.sendMessage(ChatColor.GOLD + "The owner is " + ChatColor.GREEN + "Online!");
          return true;
      }
      else if (owner == null) {
          player.sendMessage(ChatColor.BLUE + "The owner is RedEastWood");
          player.sendMessage(ChatColor.GOLD + "The owner is " + ChatColor.RED + "Offline!");
          return true;
      }
      return false;
    }
}
      
