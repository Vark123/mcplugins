package me.Vark123.EpicRPG.Teachers;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import me.Vark123.EpicRPG.Main;
import me.Vark123.EpicRPG.RpgPlayer;

public class Teachers implements Listener {
	
	@EventHandler
	public void onClick(PlayerInteractEntityEvent e) {
		RpgPlayer rpg = Main.getListaRPG().get(e.getPlayer());
		if(e.getRightClicked().getName().equals("§6Thor")) {
			TeachersInventory inv = new TeachersInventory(rpg);
			e.getPlayer().openInventory(inv.openThor());
		}
		if(e.getRightClicked().getName().equals("§4Magor")) {
			TeachersInventory inv = new TeachersInventory(rpg);
			e.getPlayer().openInventory(inv.openMagor());
		}
		if(e.getRightClicked().getName().equals("§4§lDargoth")) {
			TeachersInventory inv = new TeachersInventory(rpg);
			e.getPlayer().openInventory(inv.openDargoth());
		}
		if(e.getRightClicked().getName().equals("§aTavin")) {
			TeachersInventory inv = new TeachersInventory(rpg);
			e.getPlayer().openInventory(inv.openTavin());
		}
		if(e.getRightClicked().getName().equals("§2§lRonin")) {
			TeachersInventory inv = new TeachersInventory(rpg);
			e.getPlayer().openInventory(inv.openRonin());
		}
		if(e.getRightClicked().getName().equals("§2Thorin")) {
			TeachersInventory inv = new TeachersInventory(rpg);
			e.getPlayer().openInventory(inv.openThorin());
		}
		if(e.getRightClicked().getName().equals("§c§lCanthar")) {
			TeachersInventory inv = new TeachersInventory(rpg);
			e.getPlayer().openInventory(inv.openCanthar());
		}
		if(e.getRightClicked().getName().equals("§eSoggoth")) {
			TeachersInventory inv = new TeachersInventory(rpg);
			e.getPlayer().openInventory(inv.openSoggoth());
		}
		if(e.getRightClicked().getName().equals("§8Karrypto")) {
			TeachersInventory inv = new TeachersInventory(rpg);
			e.getPlayer().openInventory(inv.openKarrypto());
		}
		if(e.getRightClicked().getName().equals("§7Frithjof")) {
			TeachersInventory inv = new TeachersInventory(rpg);
			e.getPlayer().openInventory(inv.openFrithjof());
		}
		if(e.getRightClicked().getName().equals("§8Udar")) {
			TeachersInventory inv = new TeachersInventory(rpg);
			e.getPlayer().openInventory(inv.openUdar());
		}
		if(e.getRightClicked().getName().equals("§1Saturas")) {
			TeachersInventory inv = new TeachersInventory(rpg);
			e.getPlayer().openInventory(inv.openSaturas());
		}
		if(e.getRightClicked().getName().equals("§b§lCronos")) {
			TeachersInventory inv = new TeachersInventory(rpg);
			e.getPlayer().openInventory(inv.openCronos());
		}
		if(e.getRightClicked().getName().equals("§7§lCarl")) {
			TeachersInventory inv = new TeachersInventory(rpg);
			e.getPlayer().openInventory(inv.openCarl());
		}
		if(e.getRightClicked().getName().equals("§a§lJasuo")) {
			TeachersInventory inv = new TeachersInventory(rpg);
			e.getPlayer().openInventory(inv.openJasuo());
		}
		if(e.getRightClicked().getName().equals("§8Xardas")) {
			TeachersInventory inv = new TeachersInventory(rpg);
			e.getPlayer().openInventory(inv.openXardas());
		}
		if(e.getRightClicked().getName().equals("§eHassan")) {
			TeachersInventory inv = new TeachersInventory(rpg);
			e.getPlayer().openInventory(inv.openHassan());
		}
		if(e.getRightClicked().getName().equals("§4Reg")) {
			TeachersInventory inv = new TeachersInventory(rpg);
			e.getPlayer().openInventory(inv.openReg());
		}
		if(e.getRightClicked().getName().equals("§4Olivier")) {
			TeachersInventory inv = new TeachersInventory(rpg);
			e.getPlayer().openInventory(inv.openOlivier());
		}
		if(e.getRightClicked().getName().equals("§b§lTyrael")) {
			TeachersInventory inv = new TeachersInventory(rpg);
			e.getPlayer().openInventory(inv.openTyrael());
		}
		if(e.getRightClicked().getName().equals("§e§lNers")) {
			TeachersInventory inv = new TeachersInventory(rpg);
			e.getPlayer().openInventory(inv.openNers());
		}
		if(e.getRightClicked().getName().equals("§4Nars")) {
			TeachersInventory inv = new TeachersInventory(rpg);
			e.getPlayer().openInventory(inv.openNars());
		}
		if(e.getRightClicked().getName().equals("§7Cobryn")) {
			TeachersInventory inv = new TeachersInventory(rpg);
			e.getPlayer().openInventory(inv.openCobryn());
		}
	}
}