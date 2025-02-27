package edu.gac.mcs178.gack.domain;

import java.util.*;

import edu.gac.mcs178.gack.Utility;

public class ScrollOfTeleportation extends MagicScroll {
	
	ArrayList<Place> listOfPlaces;

	
	// Constructor 
	public ScrollOfTeleportation(String name, ArrayList<Place> listOfPlaces) {
		super(name);
		this.listOfPlaces = listOfPlaces;
	}
	
	public ScrollOfTeleportation(String name, ArrayList<Place> listOfPlaces, int uses) {
		super(name, uses);
		this.listOfPlaces = listOfPlaces;
	}
	
	public int getUses() {
		return super.getUses();
	}
	
	public void doMagic() {
		if (getUses() > 0) {
			Person owner = getOwner();
			Random random = new Random();
			int index = random.nextInt(listOfPlaces.size() - 1);
			owner.moveTo(listOfPlaces.get(index));
			useItem();
		} else {
			Utility.displayMessage("The " + getName() + " has no uses left!");
		}
	}
	
	public void beRead() {
		doMagic();
	}
}
