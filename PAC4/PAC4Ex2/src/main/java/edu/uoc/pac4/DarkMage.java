package edu.uoc.pac4;

import edu.uoc.pac4.exception.EntityException;
import edu.uoc.pac4.exception.PlayerException;

public class DarkMage extends Player {
    public static final double MAX_STEP = 12.0;
    public static final int VITALITY = 3;
    public static final int INTELLIGENCE = 5;
    public static final int STRENGTH = 5;
    public static final int AGILITY = 3;
    public static final int MAX_HP = 200;

    public DarkMage(String name, Position position, Empire empire) throws EntityException, PlayerException {
        this(name, 1, MAX_HP, position, 0, 0, VITALITY, INTELLIGENCE, STRENGTH, AGILITY, empire);
    }

    public DarkMage(String name, int level, int maxHP, Position position, int currentGold, int currentExperience,
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
        return sayName() + "Let the darkness reign!";
    }

    @Override
    public String deathCry() {
        return sayName() + "The dark arts will live on...";
    }
}