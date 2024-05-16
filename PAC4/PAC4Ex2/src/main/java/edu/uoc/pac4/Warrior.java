package edu.uoc.pac4;

import edu.uoc.pac4.exception.EntityException;
import edu.uoc.pac4.exception.PlayerException;

public class Warrior extends Player {
    public static final int VITALITY = 7;
    public static final int INTELLIGENCE = 1;
    public static final int STRENGTH = 8;
    public static final int AGILITY = 4;
    public static final int MAX_STEP = 2;

    public Warrior(String name, int level, Position position, int maxHP, Empire empire) throws EntityException, PlayerException {
        super(name, level, position, maxHP, VITALITY, INTELLIGENCE, STRENGTH, AGILITY, empire);
    }

    @Override
    public boolean move(Position position) {
        if (getPosition().euclideanDistance(position) <= MAX_STEP) {
            setPosition(position);
            return true;
        }
        return false;
    }

    @Override
    public String battleCry() {
        return sayName() + "To victory or death!";
    }

    @Override
    public String deathCry() {
        return sayName() + "I shall return, stronger than ever...";
    }
}
