package edu.uoc.pac4;

import edu.uoc.pac4.exception.EntityException;
import edu.uoc.pac4.exception.PlayerException;

public class Shaman extends Player {
    public static final int VITALITY = 6;
    public static final int INTELLIGENCE = 6;
    public static final int STRENGTH = 3;
    public static final int AGILITY = 5;
    public static final int MAX_STEP = 2;

    public Shaman(String name, int level, Position position, int maxHP, Empire empire) throws EntityException, PlayerException {
        super(name, level, position, maxHP, VITALITY, INTELLIGENCE, STRENGTH, AGILITY, empire);

