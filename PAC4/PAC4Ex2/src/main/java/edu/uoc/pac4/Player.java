package edu.uoc.pac4;

import edu.uoc.pac4.exception.EntityException;
import edu.uoc.pac4.exception.PlayerException;

public abstract class Player extends Entity implements Speakable {
    public static final int MAX_STAT = 30;

    private int currentGold;
    private int currentExperience;
    private int vitality;
    private int intelligence;
    private int strength;
    private int agility;
    private Empire empire;

    public Player(String name, int level, Position position, int maxHP, int vitality, int intelligence, int strength, int agility, Empire empire) throws EntityException, PlayerException {
        super(name, level, position, maxHP);
        setVitality(vitality);
        setIntelligence(intelligence);
        setStrength(strength);
        setAgility(agility);
        setEmpire(empire);
        setCurrentGold(0);
        setCurrentExperience(0);
    }

    public int getCurrentGold() {
        return currentGold;
    }

    public void setCurrentGold(int currentGold) {
        this.currentGold = Math.max(currentGold, 0);
    }

    public int getCurrentExperience() {
        return currentExperience;
    }

    public void setCurrentExperience(int currentExperience) {
        this.currentExperience = Math.max(currentExperience, 0);
    }

    public int getVitality() {
        return vitality;
    }

    public void setVitality(int vitality) {
        if (vitality < 0) {
            this.vitality = 0;
        } else if (vitality > MAX_STAT) {
            this.vitality = MAX_STAT;
        } else {
            this.vitality = vitality;
        }
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        if (intelligence < 0) {
            this.intelligence = 0;
        } else if (intelligence > MAX_STAT) {
            this.intelligence = MAX_STAT;
        } else {
            this.intelligence = intelligence;
        }
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        if (strength < 0) {
            this.strength = 0;
        } else if (strength > MAX_STAT) {
            this.strength = MAX_STAT;
        } else {
            this.strength = strength;
        }
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        if (agility < 0) {
            this.agility = 0;
        } else if (agility > MAX_STAT) {
            this.agility = MAX_STAT;
        } else {
            this.agility = agility;
        }
    }

    public Empire getEmpire() {
        return empire;
    }

    public void setEmpire(Empire empire) throws PlayerException {
        if (empire == null) {
            throw new PlayerException(PlayerException.EMPIRE_NULL);
        }
        this.empire = empire;
    }

    @Override
    public String sayName() {
        return getName() + ": ";
    }

    // Note: The implementation of battleCry and deathCry should be done in the subclasses
    @Override
    public abstract String battleCry();

    @Override
    public abstract String deathCry();
}
