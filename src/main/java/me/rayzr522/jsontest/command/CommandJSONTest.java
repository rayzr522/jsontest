package me.rayzr522.jsontest.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.rayzr522.jsonmessage.JSONMessage;
import me.rayzr522.jsontest.JSONTest;

public class CommandJSONTest implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can use this.");
            return true;
        }

        Player player = (Player) sender;

        JSONMessage.create("Go to the ")
                .color(ChatColor.GOLD)
                .then("best website ever!")
                .color(ChatColor.BLUE)
                .tooltip("Click to go")
                .openURL("http://www.youtube.com/")
                .send(player);

        JSONMessage.create("This has a fancy tooltip!")
                .color(ChatColor.GOLD)
                .tooltip(JSONMessage.create("Green text!")
                        .color(ChatColor.GREEN)
                        .style(ChatColor.BOLD)
                        .then("\nUse the newline character to\nadd lines to the tooltip")
                        .color(ChatColor.YELLOW))
                .send(player);

        JSONMessage.create("Click")
                .color(ChatColor.GOLD)
                .then(" here ")
                .color(ChatColor.RED)
                .runCommand("/warp spawn")
                .then("to go to spawn")
                .color(ChatColor.GOLD)
                .send(player);

        JSONMessage.create("I am a title")
                .color(ChatColor.GREEN)
                .style(ChatColor.ITALIC)
                .title(10, 20, 10, player);

        JSONMessage.create("A wild subtitle has appeared!")
                .color(ChatColor.GOLD)
                .subtitle(player);

        JSONMessage.create("I am an actionbar")
                .color(ChatColor.RED)
                .style(ChatColor.UNDERLINE)
                .actionbar(player);

        JSONMessage.create("I am either UGLY or a lovely purple")
                // https://en.wikipedia.org/wiki/Pantone_448_C
                .color("#4A412A", ChatColor.LIGHT_PURPLE)
                .send(player);

        return true;
    }
}