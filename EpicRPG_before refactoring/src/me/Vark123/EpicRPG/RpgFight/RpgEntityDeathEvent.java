package me.Vark123.EpicRPG.RpgFight;

import java.io.IOException;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import me.Vark123.EpicRPG.Main;
import me.Vark123.EpicRPG.RpgPlayer;
import me.Vark123.EpicRPG.RpgSystem;

public class RpgEntityDeathEvent implements Listener {
	
	@EventHandler
	public void onDeath(EntityDeathEvent e) throws IOException {
		if(e.getEntity().getKiller() instanceof Player) {
		
			Player p = e.getEntity().getKiller();
			RpgPlayer rpg = Main.getListaRPG().get(p);
			if(e.getEntity().getName().contains("Mud")) {
				RpgSystem.addXp(0, 1, rpg);
				return;
			}
			if(e.getEntity().getName().contains("Dziki wilk")) {
				RpgSystem.addXp(10, 25, rpg);
				return;
			}
			if(e.getEntity().getName().contains("Samiec ALFA")) {
				RpgSystem.addXp(100, 150, rpg);
				return;
			}
			if(e.getEntity().getName().contains("Rabus")) {
				RpgSystem.addXp(8, 18, rpg);
				return;
			}
			if(e.getEntity().getName().contains("Kieszonkowiec")) {
				RpgSystem.addXp(15, 25, rpg);
				return;
			}
			if(e.getEntity().getName().contains("Bandyta")) {
				RpgSystem.addXp(24, 40, rpg);
				return;
			}
			if(e.getEntity().getName().contains("Herszt Bandytow")) {
				RpgSystem.addXp(120, 140, rpg);
				return;
			}
			if(e.getEntity().getName().contains("ORTEGA")) {
				RpgSystem.addXp(150, 250, rpg);
				return;
			}
			if(e.getEntity().getName().contains("Pajak lesny")) {
				RpgSystem.addXp(16, 26, rpg);
				return;
			}
			if(e.getEntity().getName().contains("Czarna wdowa")) {
				RpgSystem.addXp(22, 44, rpg);
				return;
			}
			if(e.getEntity().getName().contains("Maexxna")) {
				RpgSystem.addXp(180, 260, rpg);
				return;
			}
			if(e.getEntity().getName().contains("Goblin Berserker")) {
				RpgSystem.addXp(12, 20, rpg);
				return;
			}
			if(e.getEntity().getName().contains("Goblini wojownik")) {
				RpgSystem.addXp(20, 35, rpg);
				return;
			}
			if(e.getEntity().getName().contains("Goblini Krol")) {
				RpgSystem.addXp(80, 190, rpg);
				return;
			}
			if(e.getEntity().getName().contains("Mlody Goblin")) {
				RpgSystem.addXp(3, 10, rpg);
				return;
			}
			if(e.getEntity().getName().contains("Goblin")) {
				RpgSystem.addXp(6, 15, rpg);
				return;
			}
			if(e.getEntity().getName().contains("Ludojad")) {
				RpgSystem.addXp(140, 220, rpg);
				return;
			}
			if(e.getEntity().getName().contains("Rybik")) {
				RpgSystem.addXp(28, 40, rpg);
				return;
			}
			if(e.getEntity().getName().contains("Szakal")) {
				RpgSystem.addXp(34, 44, rpg);
				return;
			}
			if(e.getEntity().getName().contains("Egipski wojownik")) {
				RpgSystem.addXp(35, 50, rpg);
				return;
			}
			if(e.getEntity().getName().contains("Nieumarly kaplan")) {
				RpgSystem.addXp(39, 45, rpg);
				return;
			}
			if(e.getEntity().getName().contains("MUMIA")) {
				RpgSystem.addXp(42, 53, rpg);
				return;
			}
			if(e.getEntity().getName().contains("Straznik Slonca")) {
				RpgSystem.addXp(170, 250, rpg);
				return;
			}
			if(e.getEntity().getName().contains("Kleopatra")) {
				RpgSystem.addXp(1000, 2500, rpg);
				return;
			}
			if(e.getEntity().getName().contains("§3Zombie")) {
				RpgSystem.addXp(44, 55, rpg);
				return;
			}
			if(e.getEntity().getName().contains("Husk minion")) {
				RpgSystem.addXp(10, 20, rpg);
				return;
			}
			if(e.getEntity().getName().contains("§2§lHUSK")) {
				RpgSystem.addXp(80, 120, rpg);
				return;
			}
			if(e.getEntity().getName().contains("GIANT HUSK")) {
				RpgSystem.addXp(190, 300, rpg);
				return;
			}
			if(e.getEntity().getName().contains("Przeklety Gornik")) {
				RpgSystem.addXp(41, 60, rpg);
				return;
			}
			if(e.getEntity().getName().contains("Zarazony")) {
				RpgSystem.addXp(49, 70, rpg);
				return;
			}
			if(e.getEntity().getName().contains("Klikacz")) {
				RpgSystem.addXp(60, 80, rpg);
				return;
			}
			if(e.getEntity().getName().contains("Purchlak")) {
				RpgSystem.addXp(200, 280, rpg);
				return;
			}
			if(e.getEntity().getName().contains("Gomez")) {
				RpgSystem.addXp(250, 380, rpg);
				return;
			}
			if(e.getEntity().getName().contains("Warg")) {
				RpgSystem.addXp(73, 100, rpg);
				return;
			}
			if(e.getEntity().getName().contains("Orkowy Pies")) {
				RpgSystem.addXp(88, 116, rpg);
				return;
			}
			if(e.getEntity().getName().contains("Tserebus")) {
				RpgSystem.addXp(300, 450, rpg);
				return;
			}
			if(e.getEntity().getName().contains("§2§lGorski ork")) {
				RpgSystem.addXp(93, 121, rpg);
				return;
			}
			if(e.getEntity().getName().contains("§a§lGorski Szaman")) {
				RpgSystem.addXp(97, 114, rpg);
				return;
			}
			if(e.getEntity().getName().contains("§2Ork")) {
				RpgSystem.addXp(66, 90, rpg);
				return;
			}
			if(e.getEntity().getName().contains("§cOrk wojownik")) {
				RpgSystem.addXp(80, 112, rpg);
				return;
			}
			if(e.getEntity().getName().contains("§a§lOrkowy Szaman")) {
				RpgSystem.addXp(88, 107, rpg);
				return;
			}
			if(e.getEntity().getName().contains("§c§lElitarny Ork Wojownik")) {
				RpgSystem.addXp(98, 125, rpg);
				return;
			}
			if(e.getEntity().getName().contains("Orkowy General")) {
				RpgSystem.addXp(260, 375, rpg);
				return;
			}
			if(e.getEntity().getName().contains("Naczelny Orkow")) {
				RpgSystem.addXp(400, 700, rpg);
				return;
			}
			if(e.getEntity().getName().contains("najwyzszy szaman")) {
				RpgSystem.addXp(350, 525, rpg);
				return;
			}
			if(e.getEntity().getName().contains("§cAssasyn")) {
				RpgSystem.addXp(70, 85, rpg);
				return;
			}
			if(e.getEntity().getName().contains("§4Assasyn - morderca")) {
				RpgSystem.addXp(84, 107, rpg);
				return;
			}
			if(e.getEntity().getName().contains("Czarny Mag")) {
				RpgSystem.addXp(90, 102, rpg);
				return;
			}
			if(e.getEntity().getName().contains("§4§lElitarny Assasyn")) {
				RpgSystem.addXp(105, 119, rpg);
				return;
			}
			if(e.getEntity().getName().contains("Nizar")) {
				RpgSystem.addXp(300, 500, rpg);
				return;
			}
			if(e.getEntity().getName().contains("§cZywiolak Ognia")) {
				RpgSystem.addXp(100, 230, rpg);
				return;
			}
			if(e.getEntity().getName().contains("Zarzyciel")) {
				RpgSystem.addXp(134, 179, rpg);
				return;
			}
			if(e.getEntity().getName().contains("Wulkaniczny Furiat")) {
				RpgSystem.addXp(151, 200, rpg);
				return;
			}
			if(e.getEntity().getName().contains("Wulkaniczny Olbrzym")) {
				RpgSystem.addXp(177, 240, rpg);
				return;
			}
			if(e.getEntity().getName().contains("Baron Geddon")) {
				RpgSystem.addXp(475, 666, rpg);
				return;
			}
			if(e.getEntity().getName().contains("Majordomus")) {
				RpgSystem.addXp(300, 450, rpg);
				return;
			}
			if(e.getEntity().getName().contains("RAGNAROS")) {
				RpgSystem.addXp(2500, 5000, rpg);
				return;
			}
			if(e.getEntity().getName().contains("Zniewolona dusza")) {
				RpgSystem.addXp(129, 152, rpg);
				return;
			}
			if(e.getEntity().getName().contains("Upadly aniol")) {
				RpgSystem.addXp(147, 194, rpg);
				return;
			}
			if(e.getEntity().getName().contains("Mroczny Aniol")) {
				RpgSystem.addXp(188, 233, rpg);
				return;
			}
			if(e.getEntity().getName().contains("Nefarian")) {
				RpgSystem.addXp(500, 7000, rpg);
				return;
			}
			if(e.getEntity().getName().contains("Straznik wod")) {
				RpgSystem.addXp(111, 143, rpg);
				return;
			}
			if(e.getEntity().getName().contains("Straznik Swiatynny")) {
				RpgSystem.addXp(162, 199, rpg);
				return;
			}
			if(e.getEntity().getName().contains("Neptulon")) {
				RpgSystem.addXp(440, 700, rpg);
				return;
			}
			if(e.getEntity().getName().contains("Bukanier")) {
				RpgSystem.addXp(40, 55, rpg);
				return;
			}
			if(e.getEntity().getName().contains("Silny pirat")) {
				RpgSystem.addXp(53, 68, rpg);
				return;
			}
			if(e.getEntity().getName().contains("Korsarz")) {
				RpgSystem.addXp(56, 84, rpg);
				return;
			}
			if(e.getEntity().getName().contains("Przeklety Pirat")) {
				RpgSystem.addXp(190, 230, rpg);
				return;
			}
			if(e.getEntity().getName().contains("Barbossa")) {
				RpgSystem.addXp(230, 350, rpg);
				return;
			}
			if(e.getEntity().getName().contains("Davy Jones")) {
				RpgSystem.addXp(500, 770, rpg);
				return;
			}
			if(e.getEntity().getName().contains("Zywiolak powietrza")) {
				RpgSystem.addXp(50, 75, rpg);
				return;
			}
			if(e.getEntity().getName().contains("Zywiolak skaly")) {
				RpgSystem.addXp(68, 90, rpg);
				return;
			}
			if(e.getEntity().getName().contains("Zywiolak wody")) {
				RpgSystem.addXp(82, 100, rpg);
				return;
			}
			if(e.getEntity().getName().contains("§4Zywiolak ognia")) {
				RpgSystem.addXp(95, 111, rpg);
				return;
			}
			if(e.getEntity().getName().contains("Sluga Kalimosa")) {
				RpgSystem.addXp(102, 130, rpg);
				return;
			}
			if(e.getEntity().getName().contains("Pierwotny Wladca")) {
				RpgSystem.addXp(2000, 4000, rpg);
				return;
			}
			if(e.getEntity().getName().contains("Dzika swinia")) {
				RpgSystem.addXp(1, 3, rpg);
				return;
			}
			if(e.getEntity().getName().contains("Krowa")) {
				RpgSystem.addXp(1, 3, rpg);
				return;
			}
			if(e.getEntity().getName().contains("Hodowlana kura")) {
				RpgSystem.addXp(1, 3, rpg);
				return;
			}
			if(e.getEntity().getName().contains("Owca nizinna")) {
				RpgSystem.addXp(1, 3, rpg);
				return;
			}
		}
	}
	
}
