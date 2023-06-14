package me.jonot.aaronalerts;

import me.jonot.aaronalerts.AaronCommand;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import java.time.LocalTime;
import java.time.ZoneId;

import net.minecraft.client.Minecraft;
import net.minecraft.world.World;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.FontRenderer;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.Pre;
import net.minecraftforge.client.ClientCommandHandler;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;

@Mod(modid = AaronAlerts.MODID, version = AaronAlerts.VERSION)
public class AaronAlerts {
    public static final String MODID = "aaronalerts";
    public static final String VERSION = "1.0";

    public static boolean shouldAlert = false;
    
    private boolean alreadyAlerted = false;

    @EventHandler
    public void init(FMLInitializationEvent event) {
	MinecraftForge.EVENT_BUS.register(this);

	ClientCommandHandler.instance.registerCommand(new AaronCommand());
    }

    @SubscribeEvent
    public void update(TickEvent event) {
	if (!shouldAlert) {
	    return;
	}
	LocalTime now = LocalTime.now(ZoneId.systemDefault());
	int minute = now.getMinute();
	if (minute % 5 != 0) {
	    alreadyAlerted = false;
	    return;
	}
	if (alreadyAlerted) {
	    return;
	}
	alreadyAlerted = true;
	Minecraft minecraft = Minecraft.getMinecraft();
	if (minecraft == null) {
	    System.out.println("No minecraft");
	    return;
	}
	GuiIngame gui = minecraft.ingameGUI;
	if (gui == null) {
	    System.out.println("No gui");
	    return;
	}
	System.out.println("About to display");
	gui.displayTitle(null, null, 10, 70, 20);
	gui.displayTitle("§dKill Sea Creatures!!!§r", null, 0, 0, 0);
    }
}
