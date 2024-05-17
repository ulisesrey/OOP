package edu.uoc.pac4;

import edu.uoc.pac4.exception.EntityException;

public class Orc extends Enemy implements TransCloneable, Cloneable {
    public static final int ID = 101;
    public static final String NAME = "Orc";
    public static final int LEVEL = 46;
    public static final int MAX_HP = 190;
    public static final int MIN_GOLD = 150;
    public static final int MAX_GOLD = 200;
    public static final int EXPERIENCE = 488;
    public static final int MIN_DAMAGE = 10;
    public static final int MAX_DAMAGE = 15;
    public static final double MAX_STEP = 7.0;

    public Orc(Position position, Enemy groupLeader) throws EntityException {
        super(NAME, LEVEL, MAX_HP, position, position.getGameMap(), ID);
        setGold(MIN_GOLD, MAX_GOLD);
        setExperience(EXPERIENCE);
        setDamage(MIN_DAMAGE, MAX_DAMAGE);
        setGroupLeader(groupLeader);
    }

    @Override
    public boolean move(Position position) {
        if (getPosition().euclideanDistance(position) <= MAX_STEP) {
            try {
                setPosition(position);
                return true;
            } catch (EntityException e) {
                return false;
            }
        }
        return false;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Orc clonedOrc = (Orc) super.clone();
        Position newPosition = new Position(getPosition().getGameMap(), getPosition().getX(), getPosition().getY(), getPosition().getZ());
        try {
            clonedOrc.setPosition(newPosition);
        } catch (EntityException e) {
            e.printStackTrace();
        }
        return clonedOrc;
    }

    @Override
    public OrcReborn transClone() {
        try {
            Orc clonedOrc = (Orc) this.clone();
            Position newPosition = new Position(clonedOrc.getPosition().getGameMap(), clonedOrc.getPosition().getX(), clonedOrc.getPosition().getY(), clonedOrc.getPosition().getZ());
            return new OrcReborn(newPosition, clonedOrc);
        } catch (CloneNotSupportedException | EntityException e) {
            e.printStackTrace();
            return null;
        }
    }
}
