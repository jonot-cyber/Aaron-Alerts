package me.jonot.aaronalerts;

import me.jonot.aaronalerts.AaronAlerts;

import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;

import java.util.ArrayList;
import java.util.List;

public class AaronCommand implements ICommand {
    private List aliases;
    
    public AaronCommand() {
	this.aliases = new ArrayList();
	this.aliases.add("aaronalerts");
    }

    @Override
    public String getCommandName() {
	return "aaronalerts";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
	return "aaronalerts <on|off>";
    }

    @Override
    public List getCommandAliases() {
	return this.aliases;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {
	if (args.length != 1) {
	    sender.addChatMessage(new ChatComponentText("Invalid Arguments!"));
	    return;
	}

	if (args[0].equals("on")) {
	    sender.addChatMessage(new ChatComponentText("§aEnabled Aaron Alerts!§r"));
	    AaronAlerts.shouldAlert = true;
	} else if (args[0].equals("off")) {
	    sender.addChatMessage(new ChatComponentText("§cDisabled Aaron Alerts!§r"));
	    AaronAlerts.shouldAlert = false;
	}
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
	return true;
    }

    @Override
    public List addTabCompletionOptions(ICommandSender sender, String[] astring, BlockPos loc) {
	return null;
    }

    @Override
    public boolean isUsernameIndex(String[] astring, int i) {
	return false;
    }

    @Override
    public int compareTo(ICommand o) {
	return 0;
    }
}
