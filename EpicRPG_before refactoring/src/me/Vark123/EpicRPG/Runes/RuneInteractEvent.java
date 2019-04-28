package me.Vark123.EpicRPG.Runes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import me.Vark123.EpicRPG.Main;

public class RuneInteractEvent implements Listener{
	
	@EventHandler
	public void onClick(PlayerInteractEvent e) {
		if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			if(e.getPlayer().getItemInHand() != null && e.getPlayer().getItemInHand().getType().equals(Material.RECORD_7)) {
				if(e.getPlayer().getItemInHand().getItemMeta().hasDisplayName() && e.getPlayer().getItemInHand().getItemMeta().hasLore()) {
					Rune r;
					DynamicRune dr = new DynamicRune(e.getPlayer().getItemInHand());
					if(!Main.getListaRPG().get(e.getPlayer()).getProffesion().equalsIgnoreCase(dr.getKlasa())) {
						e.getPlayer().sendMessage("§7[§6EpicRPG§7] §c Tylko "+dr.getKlasa()+" §cmoze uzyc tej runy!");
						return;
					}
					if(!RunesTimerCheck.TimeLeft(dr, e.getPlayer())) {
						return;
					}
					if(!EnoughMana.hasMana(dr, e.getPlayer())) {
						return;
					}
					EnoughMana.spendMana(dr, e.getPlayer());
					RunesTimerCheck.newTime(dr, e.getPlayer());
					if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§cOgnista strzala")) {
						r = new OgnistaStrzala(dr, e.getPlayer());
						r.castSpell();
						return;
					}
					if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§cPirokineza")) {
						r = new Pirokineza(dr, e.getPlayer());
						r.castSpell();
						return;
					}
					if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§cKula ognia")) {
						r = new KulaOgnia(dr, e.getPlayer());
						r.castSpell();
						return;
					}
					if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§cOgnista sfera")) {
						r = new OgnistaSfera(dr, e.getPlayer());
						r.castSpell();
						return;
					}
					if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§cBurza ognista")) {
						r = new BurzaOgnista(dr, e.getPlayer());
						r.castSpell();
						return;
					}
					if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§cOgnista fala")) {
						r = new OgnistaFala(dr, e.getPlayer());
						r.castSpell();
						return;
					}
					if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§cMeteor")) {
						r = new Meteor(dr, e.getPlayer());
						r.castSpell();
						return;
					}
					if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§6§lDeszcz ognia")) {
						r = new DeszczOgnia(dr, e.getPlayer());
						r.castSpell();
						return;
					}
					return;
				}
				return;
			}
			if(e.getPlayer().getItemInHand() != null && e.getPlayer().getItemInHand().getType().equals(Material.RECORD_3)) {
				Rune r;
				DynamicRune dr = new DynamicRune(e.getPlayer().getItemInHand());
				if(!Main.getListaRPG().get(e.getPlayer()).getProffesion().equalsIgnoreCase(dr.getKlasa())) {
					e.getPlayer().sendMessage("§7[§6EpicRPG§7] §c Tylko "+dr.getKlasa()+" §cmoze uzyc tej runy!");
					return;
				}
				if(!RunesTimerCheck.TimeLeft(dr, e.getPlayer())) {
					return;
				}
				if(!EnoughMana.hasMana(dr, e.getPlayer())) {
					return;
				}
				EnoughMana.spendMana(dr, e.getPlayer());
				RunesTimerCheck.newTime(dr, e.getPlayer());
				if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§ePiach w oczy")) {
					r = new PiachWOczy(dr, e.getPlayer());
					r.castSpell();
					return;
				}
				if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§bHaduoken")) {
					r = new Haduoken(dr, e.getPlayer());
					r.castSpell();
					return;
				}
				if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§bGejzer")) {
					r = new Gejzer(dr, e.getPlayer());
					r.castSpell();
					return;
				}
				if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§bWodna piesc")) {
					r = new WodnaPiesc(dr, e.getPlayer());
					r.castSpell();
					return;
				}
				return;
			}
			if(e.getPlayer().getItemInHand() != null && e.getPlayer().getItemInHand().getType().equals(Material.RECORD_4)) {
				Rune r;
				DynamicRune dr = new DynamicRune(e.getPlayer().getItemInHand());
				if(!Main.getListaRPG().get(e.getPlayer()).getProffesion().equalsIgnoreCase(dr.getKlasa())) {
					e.getPlayer().sendMessage("§7[§6EpicRPG§7] §c Tylko "+dr.getKlasa()+" §cmoze uzyc tej runy!");
					return;
				}
				if(!RunesTimerCheck.TimeLeft(dr, e.getPlayer())) {
					return;
				}
				if(!EnoughMana.hasMana(dr, e.getPlayer())) {
					return;
				}
				EnoughMana.spendMana(dr, e.getPlayer());
				RunesTimerCheck.newTime(dr, e.getPlayer());
				if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§bLodowa strzala")) {
					r = new LodowaStrzala(dr, e.getPlayer());
					r.castSpell();
					return;
				}
				if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§bLodowa lanca")) {
					r = new LodowaLanca(dr, e.getPlayer());
					r.castSpell();
					return;
				}
				if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§bBryla lodu")) {
					r = new BrylaLodu(dr, e.getPlayer());
					r.castSpell();
					return;
				}
				if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§bLodowa fala")) {
					r = new LodowaFala(dr, e.getPlayer());
					r.castSpell();
					return;
				}
				if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§6§lGrom")) {
					r = new Grom(dr, e.getPlayer());
					r.castSpell();
					return;
				}
				return;
			}
			if(e.getPlayer().getItemInHand() != null && e.getPlayer().getItemInHand().getType().equals(Material.RECORD_5)) {
				if(e.getPlayer().getItemInHand().getItemMeta().hasDisplayName() && e.getPlayer().getItemInHand().getItemMeta().hasLore()) {
					Rune r;
					DynamicRune dr = new DynamicRune(e.getPlayer().getItemInHand());
					if(!Main.getListaRPG().get(e.getPlayer()).getProffesion().equalsIgnoreCase(dr.getKlasa())) {
						e.getPlayer().sendMessage("§7[§6EpicRPG§7] §c Tylko "+dr.getKlasa()+" §cmoze uzyc tej runy!");
						return;
					}
					if(!RunesTimerCheck.TimeLeft(dr, e.getPlayer())) {
						return;
					}
					if(!EnoughMana.hasMana(dr, e.getPlayer())) {
						return;
					}
					EnoughMana.spendMana(dr, e.getPlayer());
					RunesTimerCheck.newTime(dr, e.getPlayer());
					if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§3Swieta strzala")) {
						r = new SwietaStrzala(dr, e.getPlayer());
						r.castSpell();
						return;
					}
					if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§3Wypedzanie zla")) {
						r = new WypedzanieZla(dr, e.getPlayer());
						r.castSpell();
						return;
					}
					if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§3Trans")) {
						r = new Trans(dr, e.getPlayer());
						r.castSpell();
						return;
					}
					if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§3Zniszczenie zla")) {
						r = new ZniszczenieZla(dr, e.getPlayer());
						r.castSpell();
						return;
					}
					if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§3Szal bitewny")) {
						r = new SzalBitewny(dr, e.getPlayer());
						r.castSpell();
						return;
					}
					if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§3Gruboskornosc")) {
						r = new Gruboskornosc(dr, e.getPlayer());
						r.castSpell();
						return;
					}
					return;
				}
				return;
			}
			if(e.getPlayer().getItemInHand() != null && e.getPlayer().getItemInHand().getType().equals(Material.RECORD_6)) {
				if(e.getPlayer().getItemInHand().getItemMeta().hasDisplayName() && e.getPlayer().getItemInHand().getItemMeta().hasLore()) {
					Rune r;
					DynamicRune dr = new DynamicRune(e.getPlayer().getItemInHand());
					if(!Main.getListaRPG().get(e.getPlayer()).getProffesion().equalsIgnoreCase(dr.getKlasa())) {
						e.getPlayer().sendMessage("§7[§6EpicRPG§7] §c Tylko "+dr.getKlasa()+" §cmoze uzyc tej runy!");
						return;
					}
					if(!RunesTimerCheck.TimeLeft(dr, e.getPlayer())) {
						return;
					}
					if(!EnoughMana.hasMana(dr, e.getPlayer())) {
						return;
					}
					EnoughMana.spendMana(dr, e.getPlayer());
					RunesTimerCheck.newTime(dr, e.getPlayer());
					if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§aWyostrzone zmysly")) {
						r = new WyostrzoneZmysly(dr, e.getPlayer());
						r.castSpell();
						return;
					}
					if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§aOgnista strzala")) {
						r = new OgnistaStrzalaLcz(dr, e.getPlayer());
						r.castSpell();
						return;
					}
					if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§aZatruta strzala")) {
						r = new ZatrutaStrzala(dr, e.getPlayer());
						r.castSpell();
						return;
					}
					if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§aPrecyzyjny strzal")) {
						r = new PrecyzyjnyStrzal(dr, e.getPlayer());
						r.castSpell();
						return;
					}
					if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§aLodowa strzala")) {
						r = new LodowaStrzalaLcz(dr, e.getPlayer());
						r.castSpell();
						return;
					}
					return;
				}
				return;
			}
			if(e.getPlayer().getItemInHand() != null && e.getPlayer().getItemInHand().getType().equals(Material.RECORD_8)) {
				Rune r;
				DynamicRune dr = new DynamicRune(e.getPlayer().getItemInHand());
				if(!Main.getListaRPG().get(e.getPlayer()).getProffesion().equalsIgnoreCase(dr.getKlasa())) {
					e.getPlayer().sendMessage("§7[§6EpicRPG§7] §c Tylko "+dr.getKlasa()+" §cmoze uzyc tej runy!");
					return;
				}
				if(!RunesTimerCheck.TimeLeft(dr, e.getPlayer())) {
					return;
				}
				if(!EnoughMana.hasMana(dr, e.getPlayer())) {
					return;
				}
				EnoughMana.spendMana(dr, e.getPlayer());
				RunesTimerCheck.newTime(dr, e.getPlayer());
				if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§7Wir")) {
					r = new Wir(dr, e.getPlayer());
					r.castSpell();
					return;
				}
				return;
			}
			if(e.getPlayer().getItemInHand() != null && e.getPlayer().getItemInHand().getType().equals(Material.RECORD_9)) {
				if(e.getPlayer().getItemInHand().getItemMeta().hasDisplayName() && e.getPlayer().getItemInHand().getItemMeta().hasLore()) {
					Rune r;
					DynamicRune dr = new DynamicRune(e.getPlayer().getItemInHand());
					if(!Main.getListaRPG().get(e.getPlayer()).getProffesion().equalsIgnoreCase(dr.getKlasa())) {
						e.getPlayer().sendMessage("§7[§6EpicRPG§7] §c Tylko "+dr.getKlasa()+" §cmoze uzyc tej runy!");
						return;
					}
					if(!RunesTimerCheck.TimeLeft(dr, e.getPlayer())) {
						return;
					}
					if(!EnoughMana.hasMana(dr, e.getPlayer())) {
						return;
					}
					EnoughMana.spendMana(dr, e.getPlayer());
					RunesTimerCheck.newTime(dr, e.getPlayer());
					if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§2Uderzenie wiatru")) {
						r = new UderzenieWiatru(dr, e.getPlayer());
						r.castSpell();
						return;
					}
					if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§2Uderzenie burzy")) {
						r = new UderzenieBurzy(dr, e.getPlayer());
						r.castSpell();
						return;
					}
					return;
				}
				return;
			}
			if(e.getPlayer().getItemInHand() != null && e.getPlayer().getItemInHand().getType().equals(Material.RECORD_10)) {
				Bukkit.broadcastMessage("Record_10");
				return;
			}
			if(e.getPlayer().getItemInHand() != null && e.getPlayer().getItemInHand().getType().equals(Material.RECORD_11)) {
				Rune r;
				DynamicRune dr = new DynamicRune(e.getPlayer().getItemInHand());
				if(!Main.getListaRPG().get(e.getPlayer()).getProffesion().equalsIgnoreCase(dr.getKlasa())) {
					e.getPlayer().sendMessage("§7[§6EpicRPG§7] §c Tylko "+dr.getKlasa()+" §cmoze uzyc tej runy!");
					return;
				}
				if(!RunesTimerCheck.TimeLeft(dr, e.getPlayer())) {
					return;
				}
				if(!EnoughMana.hasMana(dr, e.getPlayer())) {
					return;
				}
				EnoughMana.spendMana(dr, e.getPlayer());
				RunesTimerCheck.newTime(dr, e.getPlayer());
				if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§0Smierc ozywiencom")) {
					r = new SmiercOzywiencom(dr, e.getPlayer());
					r.castSpell();
					return;
				}
				if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§0Tchnienie smierci")) {
					r = new TchnienieSmierci(dr, e.getPlayer());
					r.castSpell();
					return;
				}
				if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§0Uderzenie cienia")) {
					r = new UderzenieCienia(dr, e.getPlayer());
					r.castSpell();
					return;
				}
				if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§5§lSmiertelna fala")) {
					r = new SmiertelnaFala(dr, e.getPlayer());
					r.castSpell();
					return;
				}
				if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§6§lUkazanie Smierci")) {
					r = new UkazanieSmierci(dr, e.getPlayer());
					r.castSpell();
					return;
				}
				return;
			}
			if(e.getPlayer().getItemInHand() != null && e.getPlayer().getItemInHand().getType().equals(Material.RECORD_12)) {
				Bukkit.broadcastMessage("Record_12");
				return;
			}
			if(e.getPlayer().getItemInHand() != null && e.getPlayer().getItemInHand().getType().equals(Material.GOLD_RECORD)) {
				if(e.getPlayer().getItemInHand().getItemMeta().hasDisplayName() && e.getPlayer().getItemInHand().getItemMeta().hasLore()) {
					Rune r;
					DynamicRune dr = new DynamicRune(e.getPlayer().getItemInHand());
					if(!Main.getListaRPG().get(e.getPlayer()).getProffesion().equalsIgnoreCase(dr.getKlasa())) {
						e.getPlayer().sendMessage("§7[§6EpicRPG§7] §c Tylko "+dr.getKlasa()+" §cmoze uzyc tej runy!");
						return;
					}
					if(!RunesTimerCheck.TimeLeft(dr, e.getPlayer())) {
						return;
					}
					if(!EnoughMana.hasMana(dr, e.getPlayer())) {
						return;
					}
					EnoughMana.spendMana(dr, e.getPlayer());
					RunesTimerCheck.newTime(dr, e.getPlayer());
					if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§5Magiczny pocisk")) {
						r = new MagicznyPocisk(dr, e.getPlayer());
						r.castSpell();
						return;
					}
					if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§eMala blyskawica")) {
						r = new MalaBlyskawica(dr, e.getPlayer());
						r.castSpell();
						return;
					}
					if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§eBlyskawica")) {
						r = new MalaBlyskawica(dr, e.getPlayer());
						r.castSpell();
						return;
					}
					if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§eWiazka elektryczna")) {
						r = new WiazkaElektryczna(dr, e.getPlayer());
						r.castSpell();
						return;
					}
					if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§ePiorun kulisty")) {
						r = new PiorunKulisty(dr, e.getPlayer());
						r.castSpell();
						return;
					}
					return;
				}
				return;
			}
			if(e.getPlayer().getItemInHand() != null && e.getPlayer().getItemInHand().getType().equals(Material.GREEN_RECORD)) {
				Rune r;
				DynamicRune dr = new DynamicRune(e.getPlayer().getItemInHand());
				if(!Main.getListaRPG().get(e.getPlayer()).getProffesion().equalsIgnoreCase(dr.getKlasa())) {
					e.getPlayer().sendMessage("§7[§6EpicRPG§7] §c Tylko "+dr.getKlasa()+" §cmoze uzyc tej runy!");
					return;
				}
				if(!RunesTimerCheck.TimeLeft(dr, e.getPlayer())) {
					return;
				}
				if(!EnoughMana.hasMana(dr, e.getPlayer())) {
					return;
				}
				EnoughMana.spendMana(dr, e.getPlayer());
				RunesTimerCheck.newTime(dr, e.getPlayer());
				if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§aLeczenie")) {
					r = new Leczenie(dr, e.getPlayer());
					r.castSpell();
					return;
				}
				if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§5Wyssanie")) {
					r = new Wyssanie(dr, e.getPlayer());
					r.castSpell();
					return;
				}
				if(e.getPlayer().getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§6§lGrupowe leczenie")) {
					r = new GrupoweLeczenie(dr, e.getPlayer());
					r.castSpell();
					return;
				}
				return;
			}
		}
	}

}
