package edu.uoc.pac4;

import edu.uoc.pac4.exception.EntityException;
import edu.uoc.pac4.exception.PlayerException;

public class Shaman extends Player {
    public static final double MAX_STEP = 10.0;
    public static final int VITALITY = 4;
    public static final int INTELLIGENCE = 6;
    public static final int STRENGTH = 3;
    public static final int AGILITY = 3;
    public static final int MAX_HP = 150;

    public Shaman(String name, Position position, Empire empire) throws EntityException, PlayerException {
        this(name, 1, MAX_HP, position, 0, 0, VITALITY, INTELLIGENCE, STRENGTH, AGILITY, empire);
    }

    public Shaman(String name, int level, int maxHP, Position position, int currentGold, int currentExperience,
                  int vitality, int intelligence, int strength, int agility, Empire empire) throws EntityException, PlayerException {
        super(name, level, maxHP, position, null, vitality, intelligence, strength, agility, empire);
        setCurrentGold(currentGold);
        setCurrentExperience(currentExperience);
    }

    @Override
    public boolean move(Position position) throws EntityException {
        if (getPosition().euclideanDistance(position) <= MAX_STEP) {
            setPosition(position);
            return true;
        }
        return false;
    }

    @Override
    public String battleCry() {
        return sayName() + "Spirits guide us to victory!";
    }

    @Override
    public String deathCry() {
        return sayName() + "My soul joins the ancestors...";
    }
}
