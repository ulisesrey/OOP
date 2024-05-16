package edu.uoc.pac4;

import edu.uoc.pac4.exception.EntityException;
import edu.uoc.pac4.exception.PlayerException;

public class Ninja extends Player {
    public static final int VITALITY = 5;
    public static final int INTELLIGENCE = 3;
    public static final int STRENGTH = 5;
    public static final int AGILITY = 7;
    public static final int MAX_STEP = 3;

    public Ninja(String name, int level, Position position, int maxHP, Empire empire) throws EntityException, PlayerException {
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
        return sayName() + "Strike swift, strike silent!";
    }

    @Override
    public String deathCry() {
        return sayName() + "Silence, at last...";
    }
}
