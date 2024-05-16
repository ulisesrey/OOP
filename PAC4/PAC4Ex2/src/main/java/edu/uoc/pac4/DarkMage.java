package edu.uoc.pac4;

import edu.uoc.pac4.exception.EntityException;
import edu.uoc.pac4.exception.PlayerException;

public class DarkMage extends Player {
    public static final int VITALITY = 4;
    public static final int INTELLIGENCE = 8;
    public static final int STRENGTH = 2;
    public static final int AGILITY = 5;
    public static final int MAX_STEP = 2;

    public DarkMage(String name, int level, Position position, int maxHP, Empire empire) throws EntityException, PlayerException {
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
        return sayName() + "Let the darkness reign!";
    }

    @Override
    public String deathCry() {
        return sayName() + "The dark arts will live on...";
    }
}
