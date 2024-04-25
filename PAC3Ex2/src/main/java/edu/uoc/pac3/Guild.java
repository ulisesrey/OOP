package edu.uoc.pac3;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class Guild {
    public static final String INVALID_NAME = "[ERROR] The name cannot be null, has less than the minimum number of characters, exceeds the maximum number of characters or contains only whitespaces.";
    public static final String INVALID_LEVEL = "[ERROR] The level must be between 1 and the predefined maximum.";
    public static final String INVALID_DESCRIPTION = "[ERROR] The description cannot be null and cannot exceed the predefined maximum number of characters.";
    public static final String INVALID_CREATION_DATE = "[ERROR] The creation date cannot be null or in the future.";
    public static final String INVALID_MAX_MEMBERS = "[ERROR] The number of members cannot exceed the predefined maximum.";
    public static final String MEMBER_NULL = "[ERROR] The member cannot be null.";
    public static final String MEMBER_ALREADY_EXISTS = "[ERROR] The member already exists in the guild.";
    public static final String MEMBER_NOT_FOUND = "[ERROR] The member does not exist in the guild.";
    public static final String MEMBER_NO_PET = "[ERROR] The member does not have a pet.";

    private static final int MIN_NAME_LENGTH = 5;
    private static final int MAX_NAME_LENGTH = 25;
    private static final int MAX_LEVEL = 20;
    private static final int MAX_DESCRIPTION_LENGTH = 100;
    private final int NUM_MAX_MEMBERS;

    private int id;

    private static int nextId = 1;
    private String name;
    private int level;
    private String description;
    private LocalDate creationDate;
    private boolean recruiting;
    private int numMembers;
    private int sumLevels;

    private Player[] members;

    private void setId() {
        this.id = nextId++;
    }

    public static int getNextId() {
        return nextId;
    }

    private static void incNextId() {
        nextId++;
    }



    public Guild(String name, int level, String description, LocalDate creationDate, boolean recruiting, int numMaxMembers) {
        setId();
        setName(name);
        setLevel(level);
        setDescription(description);
        setCreationDate(creationDate);
        setRecruiting(recruiting);
        this.NUM_MAX_MEMBERS = numMaxMembers; // Initialize NUM_MAX_MEMBERS
        this.members = new Player[numMaxMembers];
    }

    // getters and setters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_NAME);
        }
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    private void setLevel(int level) {
        if (level < 1 || level > MAX_LEVEL) {
            throw new IllegalArgumentException(INVALID_LEVEL);
        }
        this.level = level;
    }

    public String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        if (description == null || description.length() > MAX_DESCRIPTION_LENGTH) {
            throw new IllegalArgumentException(INVALID_DESCRIPTION);
        }
        this.description = description;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    private void setCreationDate(LocalDate creationDate) {
        if (creationDate == null || creationDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException(INVALID_CREATION_DATE);
        }
        this.creationDate = creationDate;
    }

    public boolean isRecruiting() {
        return recruiting;
    }

    private void setRecruiting(boolean recruiting) {
        this.recruiting = recruiting;
    }

    public int getDaysOfLife() {
        return (int) ChronoUnit.DAYS.between(creationDate, LocalDate.now());
    }

    public int getMaxMembers() {
        return members.length;
    }

    public Player[] getMembers() {
        return members;
    }

    public int getNumMembers() {
        return numMembers;
    }

    private int findMember(Player member) {
        for (int i = 0; i < members.length; i++) {
            if (members[i] != null && members[i].equals(member)) {
                return i;
            }
        }
        return -1;
    }

    private int findFirstEmptySlot() {
        for (int i = 0; i < members.length; i++) {
            if (members[i] == null) {
                return i;
            }
        }
        return -1;
    }

    public boolean containsMember(Player member) {
        if (member == null) {
            throw new NullPointerException(MEMBER_NULL);
        }
        if (member.getPet() == null) {
            throw new NullPointerException(MEMBER_NO_PET);
        }
        return Arrays.asList(members).contains(member);
    }
    public void addMember(Player member) {
        if (member == null) {
            throw new IllegalArgumentException(MEMBER_NULL);
        }
        if (containsMember(member)) {
            throw new IllegalArgumentException(MEMBER_ALREADY_EXISTS);
        }
        int firstEmptySlot = findFirstEmptySlot();
        if (firstEmptySlot == -1) {
            throw new IllegalArgumentException(INVALID_MAX_MEMBERS);
        }
        members[firstEmptySlot] = member;
        numMembers++;
        sumLevels += member.getLevel();
    }

    public void removeMember(Player member) {
        if (member == null) {
            throw new IllegalArgumentException(MEMBER_NULL);
        }
        int memberIndex = Arrays.asList(members).indexOf(member);
        if (memberIndex == -1) {
            throw new IllegalArgumentException(MEMBER_NOT_FOUND);
        }
        members[memberIndex] = null;
        numMembers--;
        sumLevels -= member.getLevel();
    }

    public double getAverageLevel() {
        return (double) sumLevels / numMembers;
    }
}