package edu.uoc.pac4;

import edu.uoc.pac4.exception.EntityException;

public abstract class Entity implements Movable {
    public static final int MAX_LEVEL = 99;

    private static int vidCounter = 0;

    private final int vid;
    private String name;
    private int level;
    private Position position;
    private int maxHP;
    private int currentHP;

    public Entity(String name, int level, Position position, int maxHP) throws EntityException {
        this.vid = ++vidCounter;
        setName(name);
        setLevel(level);
        setPosition(position);
        setMaxHP(maxHP);
        setCurrentHP(maxHP);
    }

    public int getVid() {
        return vid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws EntityException {
        if (name == null || name.trim().isEmpty()) {
            throw new EntityException(EntityException.INVALID_NAME);
        }
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) throws EntityException {
        if (level < 1 || level > MAX_LEVEL) {
            throw new EntityException(EntityException.INVALID_LEVEL);
        }
        this.level = level;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) throws EntityException {
        if (position == null) {
            throw new EntityException(EntityException.INVALID_POSITION);
        }
        this.position = position;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = Math.max(maxHP, 1);
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int currentHP) {
        if (currentHP < 0) {
            this.currentHP = 0;
        } else if (currentHP > maxHP) {
            this.currentHP = maxHP;
        } else {
            this.currentHP = currentHP;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Entity entity = (Entity) obj;
        return vid == entity.vid;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "vid=" + vid +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", position=" + position +
                ", maxHP=" + maxHP +
                ", currentHP=" + currentHP +
                '}';
    }
}
