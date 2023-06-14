package me.jonot.aaronalerts;

import net.minecraft.client.Minecraft;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.world.World;

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

    @EventHandler
    public void init(FMLInitializationEvent event) {
	MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void update(TickEvent event) {
	Minecraft minecraft = Minecraft.getMinecraft(); // hmm yes, the minecraft is made of minecraft.
	if (minecraft == null) {
	    return;
	}
	World world = minecraft.theWorld;
	if (world == null) {
	    return;
	}
	Scoreboard scoreboard = world.getScoreboard();
    }
}
