package me.Vark123.EpicRPG.Runes;

import org.bukkit.entity.Player;

public abstract class Rune {

	protected DynamicRune dr;
	protected Player p;
	
	public Rune(DynamicRune dr, Player p) {
		this.dr = dr;
		this.p = p;
	}
	
	public abstract void castSpell();
	
}
