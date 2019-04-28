package me.Vark123.EpicRPG;

import java.io.IOException;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Firework;
import org.bukkit.inventory.meta.FireworkMeta;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle.EnumTitleAction;

public class RpgSystem {
	private static Random rand = new Random();
	private static int wynik;
	
	public static void addXp(int min, int max, RpgPlayer rpg) throws IOException {
		wynik = rand.nextInt(max-min)+min;
		if(rpg.getP().hasPermission("rpg.vip")) {
			rpg.getP().sendMessage("§7[§6§lVIP§a: " + wynik + " xp x2§7]");
			wynik = wynik*2;
		}
		rpg.addXP(wynik);
		checklvl(rpg);
		rpg.getP().sendMessage("§a+"+ wynik +" xp §7[§a"+rpg.getExp()+" xp§7/§a"+rpg.getNextLevel()+" xp§7]");
	}
	
	public static void checklvl(RpgPlayer rpg) throws IOException {
		if(rpg.getExp() >= rpg.getNextLevel()) {
			RpgSystem.updatelvl(rpg);
			return;
		}
	}
	
	public static void updatelvl(RpgPlayer rpg) throws IOException {
		rpg.addPN(10);
		IChatBaseComponent title = ChatSerializer.a("{\"text\":\"§6§lGRATULACJE!\",\"underlined\":\"true\"}");
		IChatBaseComponent subtitle = ChatSerializer.a("{\"text\":\"§aAwansowales na §6"+(1+rpg.getLevel())+" §apoziom\",\"bold\":\"true\",\"italic\":\"true\",\"bold\":\"green\"}");
		PacketPlayOutTitle titlep = new PacketPlayOutTitle(EnumTitleAction.TITLE, title, 5, 10, 15);
		PacketPlayOutTitle subtitlep = new PacketPlayOutTitle(EnumTitleAction.SUBTITLE, subtitle, 10, 5, 15);
		((CraftPlayer)rpg.getP()).getHandle().playerConnection.sendPacket(titlep);
		((CraftPlayer)rpg.getP()).getHandle().playerConnection.sendPacket(subtitlep);
		Firework f1 = rpg.getP().getWorld().spawn(rpg.getP().getLocation().add(1, 1, 0), Firework.class);
		Firework f2 = rpg.getP().getWorld().spawn(rpg.getP().getLocation().add(-1, 1, 0), Firework.class);
		Firework f3 = rpg.getP().getWorld().spawn(rpg.getP().getLocation().add(1, -1, 0), Firework.class);
		Firework f4 = rpg.getP().getWorld().spawn(rpg.getP().getLocation().add(-1, -1, 0), Firework.class);
		FireworkMeta fm = f1.getFireworkMeta();
		fm.addEffect(FireworkEffect.builder()
				.flicker(true)
				.trail(true)
				.with(Type.BALL_LARGE)
				.withColor(Color.BLUE)
				.withColor(Color.RED)
				.withColor(Color.GREEN)
				.withFade(Color.FUCHSIA)
				.build());
		fm.setPower(1);
		f1.setFireworkMeta(fm);
		f2.setFireworkMeta(fm);
		f3.setFireworkMeta(fm);
		f4.setFireworkMeta(fm);
		rpg.getP().getWorld().playSound(rpg.getP().getLocation(), Sound.PORTAL_TRAVEL, 1, 1);
		Bukkit.broadcastMessage("§6§lGracz " + rpg.getP().getName() + " awansowal na " + (1+rpg.getLevel()) + " poziom!!!");
		if(rpg.getLevel() == 1) {
			rpg.addLevel(1);
			rpg.setNextLevel(1000);
			return;
		}
		if(rpg.getLevel() == 2) {
			rpg.addLevel(1);
			rpg.setNextLevel(2500);
			return;
		}
		if(rpg.getLevel() == 3) {
			rpg.addLevel(1);
			rpg.setNextLevel(5000);
			return;
		}
		if(rpg.getLevel() == 4) {
			rpg.addLevel(1);
			rpg.setNextLevel(7500);
			return;
		}
		if(rpg.getLevel() == 5) {
			rpg.addLevel(1);
			rpg.setNextLevel(10000);
			return;
		}
		if(rpg.getLevel() == 6) {
			rpg.addLevel(1);
			rpg.setNextLevel(13000);
			return;
		}
		if(rpg.getLevel() == 7) {
			rpg.addLevel(1);
			rpg.setNextLevel(16500);
			return;
		}
		if(rpg.getLevel() == 8) {
			rpg.addLevel(1);
			rpg.setNextLevel(20000);
			return;
		}
		if(rpg.getLevel() == 9) {
			rpg.addLevel(1);
			rpg.setNextLevel(24000);
			return;
		}
		if(rpg.getLevel() == 10) {
			rpg.addLevel(1);
			rpg.setNextLevel(28500);
			return;
		}
		if(rpg.getLevel() == 11) {
			rpg.addLevel(1);
			rpg.setNextLevel(33000);
			return;
		}
		if(rpg.getLevel() == 12) {
			rpg.addLevel(1);
			rpg.setNextLevel(38000);
			return;
		}
		if(rpg.getLevel() == 13) {
			rpg.addLevel(1);
			rpg.setNextLevel(45500);
			return;
		}
		if(rpg.getLevel() == 14) {
			rpg.addLevel(1);
			rpg.setNextLevel(53500);
			return;
		}
		if(rpg.getLevel() == 15) {
			rpg.addLevel(1);
			rpg.setNextLevel(63000);
			return;
		}
		if(rpg.getLevel() == 16) {
			rpg.addLevel(1);
			rpg.setNextLevel(73000);
			return;
		}
		if(rpg.getLevel() == 17) {
			rpg.addLevel(1);
			rpg.setNextLevel(85000);
			return;
		}
		if(rpg.getLevel() == 18) {
			rpg.addLevel(1);
			rpg.setNextLevel(100000);
			return;
		}
		if(rpg.getLevel() == 19) {
			rpg.addLevel(1);
			rpg.setNextLevel(114000);
			return;
		}
		if(rpg.getLevel() == 20) {
			rpg.addLevel(1);
			rpg.setNextLevel(130000);
			return;
		}
		if(rpg.getLevel() == 21) {
			rpg.addLevel(1);
			rpg.setNextLevel(150000);
			return;
		}
		if(rpg.getLevel() == 22) {
			rpg.addLevel(1);
			rpg.setNextLevel(175000);
			return;
		}
		if(rpg.getLevel() == 23) {
			rpg.addLevel(1);
			rpg.setNextLevel(200000);
			return;
		}
		if(rpg.getLevel() == 24) {
			rpg.addLevel(1);
			rpg.setNextLevel(230000);
			return;
		}
		if(rpg.getLevel() == 25) {
			rpg.addLevel(1);
			rpg.setNextLevel(260000);
			return;
		}
		if(rpg.getLevel() == 26) {
			rpg.addLevel(1);
			rpg.setNextLevel(300000);
			return;
		}
		if(rpg.getLevel() == 27) {
			rpg.addLevel(1);
			rpg.setNextLevel(345000);
			return;
		}
		if(rpg.getLevel() == 28) {
			rpg.addLevel(1);
			rpg.setNextLevel(390000);
			return;
		}
		if(rpg.getLevel() == 29) {
			rpg.addLevel(1);
			rpg.setNextLevel(440000);
			return;
		}
		if(rpg.getLevel() == 30) {
			rpg.addLevel(1);
			rpg.setNextLevel(490000);
			return;
		}
		if(rpg.getLevel() == 31) {
			rpg.addLevel(1);
			rpg.setNextLevel(550000);
			return;
		}
		if(rpg.getLevel() == 32) {
			rpg.addLevel(1);
			rpg.setNextLevel(625000);
			return;
		}
		if(rpg.getLevel() == 33) {
			rpg.addLevel(1);
			rpg.setNextLevel(700000);
			return;
		}
		if(rpg.getLevel() == 34) {
			rpg.addLevel(1);
			rpg.setNextLevel(790000);
			return;
		}
		if(rpg.getLevel() == 35) {
			rpg.addLevel(1);
			rpg.setNextLevel(890000);
			return;
		}
		if(rpg.getLevel() == 36) {
			rpg.addLevel(1);
			rpg.setNextLevel(1000000);
			return;
		}
		if(rpg.getLevel() == 37) {
			rpg.addLevel(1);
			rpg.setNextLevel(1120000);
			return;
		}
		if(rpg.getLevel() == 38) {
			rpg.addLevel(1);
			rpg.setNextLevel(1250000);
			return;
		}
		if(rpg.getLevel() == 39) {
			rpg.addLevel(1);
			rpg.setNextLevel(1400000);
			return;
		}
		if(rpg.getLevel() == 40) {
			rpg.addLevel(1);
			rpg.setNextLevel(1550000);
			return;
		}
		if(rpg.getLevel() == 41) {
			rpg.addLevel(1);
			rpg.setNextLevel(1700000);
			return;
		}
		if(rpg.getLevel() == 42) {
			rpg.addLevel(1);
			rpg.setNextLevel(1900000);
			return;
		}
		if(rpg.getLevel() == 43) {
			rpg.addLevel(1);
			rpg.setNextLevel(2150000);
			return;
		}
		if(rpg.getLevel() == 44) {
			rpg.addLevel(1);
			rpg.setNextLevel(2400000);
			return;
		}
		if(rpg.getLevel() == 45) {
			rpg.addLevel(1);
			rpg.setNextLevel(2700000);
			return;
		}
		if(rpg.getLevel() == 46) {
			rpg.addLevel(1);
			rpg.setNextLevel(3000000);
			return;
		}
		if(rpg.getLevel() == 47) {
			rpg.addLevel(1);
			rpg.setNextLevel(3450000);
			return;
		}
		if(rpg.getLevel() == 48) {
			rpg.addLevel(1);
			rpg.setNextLevel(3900000);
			return;
		}
		if(rpg.getLevel() == 49) {
			rpg.addLevel(1);
			rpg.setNextLevel(4400000);
			return;
		}
	}
}