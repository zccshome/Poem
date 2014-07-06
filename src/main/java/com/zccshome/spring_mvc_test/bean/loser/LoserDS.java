package com.zccshome.spring_mvc_test.bean.loser;

public class LoserDS {
	
	private static LoserGroup loserGroup;
	
	static {
		loserGroup = new LoserGroup("10ss", 2);
		Loser m1 = new Loser("Wang Tianyi", "704");
		Loser m2 = new Loser("Chen Hanyang", "608");
		loserGroup.addItem(m1);
		loserGroup.addItem(m2);
	}
	
	public LoserGroup getLoserGroup() {
		return loserGroup;
	}
}
