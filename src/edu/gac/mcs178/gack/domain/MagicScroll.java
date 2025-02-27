package edu.gac.mcs178.gack.domain;

public abstract class MagicScroll extends Scroll {
	
	int uses = 0;
	
	// Constructor for initiating name of scroll
	public MagicScroll(String name) {
		super(name);
	}
	
	public MagicScroll(String name, int uses) {
		super(name);
		this.uses = uses;
	}

	// Abstract method
	protected abstract void doMagic();
	
	public int getUses() {
		return uses;
	}
	
	public void useItem() {
		uses--;
	}
}
