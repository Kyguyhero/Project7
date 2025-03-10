package edu.gac.mcs178.gack.domain;

import java.util.List;
import java.util.Random;


public class Wizard extends AutoPerson {
	
	private Place chamber;
	
	public Wizard(String name, Place place, int threshold, Place chamber) {
		super(name, place, threshold);
		this.chamber = chamber;
	}
	
	@Override
	public void act() {
		List<Scroll> scrolls = Scroll.scrollsIn(getPlace());
		if ((!scrolls.isEmpty()) && (!getPlace().equals(chamber))) {
			Random rand = new Random(); 
        	int randomIndex = rand.nextInt(scrolls.size()); // Generate a random index

        	take(scrolls.get(randomIndex)); //Get the random scroll
        	moveTo(chamber);
        	lose(scrolls.get(randomIndex)); // lose the random scroll 
		} else {
			super.act();
		}
	}
	
	public static void main(String[] args) {
		Place chamberOfWizards = new Place("Chamber of Wizards");
		Place karlsOffice = new Place("Karl's Office");
		new Wizard("Elvee", karlsOffice, 2, chamberOfWizards);
		
		karlsOffice.gain(new Scroll("Scroll of Enlightenment"));
		karlsOffice.gain(new Thing("Karl's phone"));
		
		System.out.println(karlsOffice.getContents());
		System.out.println(karlsOffice.getOccupants());
	}
}
