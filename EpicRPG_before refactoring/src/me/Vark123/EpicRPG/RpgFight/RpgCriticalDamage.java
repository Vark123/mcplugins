package me.Vark123.EpicRPG.RpgFight;

import java.util.Random;

import me.Vark123.EpicRPG.RpgPlayer;

public class RpgCriticalDamage {

	private static Random rand = new Random();
	private static int los;
	private static double attack;
	
	public static boolean checkCrit(RpgPlayer rpg) {
		los = rand.nextInt(100);
		if(los < rpg.getFinalwalka()) {
			return true;
		}
		return false;
	}
	
	public static double onAttack() {
		attack = ((double)(rand.nextInt(20)+90))/100;
		return attack;
	}
	
}
