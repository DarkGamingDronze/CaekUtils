package me.SlicedCaek.CaekUtils.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

@CommandPermissions(source = SourceType.ANY, permission = "caekutils.*")
public class Command_caekutils extends BukkitPlugin {
    
    @Override
    public boolean run(CommandSender sender, Command command, String commandLabel, String[] args) {
        sender.sendMessage(ChatColor.RED + "CaekUtils Version v0.1");
        sender.sendMessage(ChatColor.GREEN + "Running on UltraRedFreedom Server");
        sender.sendMessage(ChatColor.BLUE + "Made by SlicedCaek_");
        sender.sendMessage(ChatColor.LIGHT_PURPLE + "CaekUtils was created to help the server to run smoothly");
        return true;
    }
}
