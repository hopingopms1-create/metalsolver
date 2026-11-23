package com.metalsolver;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;

public class MetalCommand extends CommandBase {

    @Override
    public String getCommandName() {
        return "metal";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/metal debug <on|off>";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        if (args.length >= 1 && args[0].equalsIgnoreCase("debug")) {
            if (args.length >= 2 && args[1].equalsIgnoreCase("on")) {
                MetalSolver.debug = true;
            } else if (args.length >= 2 && args[1].equalsIgnoreCase("off")) {
                MetalSolver.debug = false;
            } else {
                MetalSolver.debug = !MetalSolver.debug; // /metal debug = toggle
            }
            sender.addChatMessage(new ChatComponentText(
                    "\u00a7e[Solver] Debug " + (MetalSolver.debug ? "ON" : "OFF")));
        } else {
            sender.addChatMessage(new ChatComponentText("\u00a7e" + getCommandUsage(sender)));
        }
    }
}
