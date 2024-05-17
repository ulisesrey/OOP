package edu.uoc.pac4;

import edu.uoc.pac4.exception.EntityException;

public abstract class Enemy extends Entity {
    public static final double MAX_GROUP_LEADER_DISTANCE = 50.0;

    private int id;
    private int minGold;
    private int maxGold;
    private int experience;
    private int minDamage;
    private int maxDamage;
    private Enemy groupLeader;

    public Enemy(String name, int level, int maxHP, Position position, GameMap gameMap, int id) throws EntityException {
        super(name, level, maxHP, position, gameMap);
        setId(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMinGold() {
        return minGold;
    }

    public int getMaxGold() {
        return maxGold;
    }

    public void setGold(int minGold, int maxGold) {
        if (minGold < 0) {
            this.minGold = 0;
        } else {
            this.minGold = minGold;
        }

        if (maxGold < minGold) {
            this.maxGold = this.minGold;
        } else {
            this.maxGold = maxGold;
        }
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        if (experience < 0) {
            this.experience = 0;
        } else {
            this.experience = experience;
        }
    }

    public int getMinDamage() {
        return minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public void setDamage(int minDamage, int maxDamage) {
        if (minDamage < 0) {
            this.minDamage = 0;
        } else {
            this.minDamage = minDamage;
        }

        if (maxDamage < minDamage) {
            this.maxDamage = this.minDamage;
        } else {
            this.maxDamage = maxDamage;
        }
    }

    public Enemy getGroupLeader() {
        return groupLeader;
    }

    public void setGroupLeader(Enemy groupLeader) {
        this.groupLeader = groupLeader;
    }

    public boolean isFarFromGroupLeader() {
        if (groupLeader == null) {
            return false;
        }
        return getPosition().euclideanDistance(groupLeader.getPosition()) > MAX_GROUP_LEADER_DISTANCE;
    }

    @Override
    public abstract boolean move(Position position);
}
