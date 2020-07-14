package me.rayzr522.jsontest;

import org.bukkit.plugin.java.JavaPlugin;

import me.rayzr522.jsontest.command.CommandJSONTest;

public class JSONTest extends JavaPlugin {
    @Override
    public void onEnable() {
        getCommand("jsontest").setExecutor(new CommandJSONTest(this));
    }
}
