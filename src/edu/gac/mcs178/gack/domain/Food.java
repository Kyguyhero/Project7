package edu.gac.mcs178.gack.domain;

import java.util.ArrayList;
import java.util.List;

import edu.gac.mcs178.gack.Utility;

public class Food extends Thing {
	
	public Food(String title) {
		super(title);
	}

	public void beEaten() {
		Person owner = getOwner();
		if (owner == null) {
			Utility.displayMessage("No one has " + getName());
		} else {
			owner.say("I have eaten " + getName() + ". I don't feel good.");
			owner.lose(this);
		}
	}
	
	public static List<Food> FoodIn(Place place) {
		ArrayList<Food> FoodIn = new ArrayList<Food>();
		for (Thing thing : place.getContents()) {
			if (thing instanceof Food) {
				FoodIn.add((Food) thing);
			}
		}
		return FoodIn;
	}
}