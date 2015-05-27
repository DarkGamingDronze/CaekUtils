package me.SlicedCaek.CaekUtils;

import java.util.logging.Logger;
import net.pravian.bukkitlib.BukkitLib;
import net.pravian.bukkitlib.config.YamlConfig;
import net.pravian.bukkitlib.implementation.BukkitPlugin;
import me.SlicedCaek.CaekUtils.Commands.Command_caekutils;
import me.SlicedCaek.CaekUtis.Commands.Command_owner;
import me.SlicedCaek.CaekUtils.Listener.PlayerListener;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginManager;

public class CaekUtils extends BukkitPlugin {
    public CaekUtils plugin;
    public Logger logger;
    public YamlConfig config;
    public BukkitCommandHandler handler;
    public static final String CHAT_BOT = ChatColor.WHITE + "[" + ChatColor.GREEN + "CaekUtils Bot" + CatColor.WHITE + "] ";
    public static final String ERROR = ChatColor.WHITE + "[" + ChatColor.RED + "ERROR" + ChatColor.WHITE + "] ";
    public static Server server;
    
    @Override
    public void onLoad() {
        plugin = this;
        config = new YamlConfig(plugin, "config.yml");
        logger = plugin.getLogger();
        handler = new BukkitCommandHandler(plugin);
        CaekUtils.server = plugin.getServer();
    }

    @Override
    public void onEnable() {
        BukkitLib.init(plugin);
        config.load();
        handler.setCommandLocation(Command_caekutils.class.getPackage());
        handler.setCommandLocation(Command_owner.class.getPackage());
        final PluginManager pm = server.getPluginManager();
        pm.registerEvents(new PlayerListener(), plugin);
        logger.info(plugin.getName() + " v" + plugin.getVersion() + " is enabled");
        logger.info("Created by SlicedCaek_");
    }
    
    @Override
    public void onDisable() {
        logger.info(plugin.getName() + " v" + plugin.Version() + " is disabled");
        logger.info("Have a good day");
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        return handler.handleCommand(sender, cmd, commandLabel, args);
    }
}
