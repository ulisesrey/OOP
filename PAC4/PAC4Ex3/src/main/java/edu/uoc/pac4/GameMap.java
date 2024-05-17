package edu.uoc.pac4;

import edu.uoc.pac4.exception.GameMapException;

import java.util.Hashtable;
import java.util.Map;
import java.util.Optional;

public class GameMap {
    public static final int MAX_ENTITIES = 1000;
    private int gameMapId;
    private String name;
    private int width;
    private int height;
    private int depth;
    private GameMapType gameMapType;
    private Map<Integer, Entity> entities;

    public GameMap(int gameMapId, String name, int width, int height, int depth, GameMapType gameMapType) throws GameMapException {
        setGameMapId(gameMapId);
        setName(name);
        setWidth(width);
        setHeight(height);
        setDepth(depth);
        setGameMapType(gameMapType);
        entities = new Hashtable<>();
    }

    public int getGameMapId() {
        return gameMapId;
    }

    private void setGameMapId(int gameMapId) throws GameMapException {
        if (gameMapId <= 0) {
            throw new GameMapException(GameMapException.INVALID_GAME_MAP_ID);
        }
        this.gameMapId = gameMapId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws GameMapException {
        if (name == null || name.isEmpty()) {
            throw new GameMapException(GameMapException.INVALID_NAME);
        }
        this.name = name;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) throws GameMapException {
        if (width <= 0) {
            throw new GameMapException(GameMapException.INVALID_WIDTH);
        }
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) throws GameMapException {
        if (height <= 0) {
            throw new GameMapException(GameMapException.INVALID_HEIGHT);
        }
        this.height = height;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) throws GameMapException {
        if (depth <= 0) {
            throw new GameMapException(GameMapException.INVALID_DEPTH);
        }
        this.depth = depth;
    }

    public GameMapType getGameMapType() {
        return gameMapType;
    }

    public void setGameMapType(GameMapType gameMapType) throws GameMapException {
        if (gameMapType == null) {
            throw new GameMapException(GameMapException.MAP_TYPE_NULL);
        }
        this.gameMapType = gameMapType;
    }

    public void addEntity(Entity entity) throws GameMapException {
        if (entities.size() >= MAX_ENTITIES) {
            throw new GameMapException("Maximum number of entities reached");
        }
        entities.put(entity.getVid(), entity);
    }

    public void removeEntity(Integer vid) {
        entities.remove(vid);
    }

    public Entity getEntity(Integer vid) {
        return entities.get(vid);
    }

    public long getNumPlayers() {
        // Use the Stream API to filter and count entities that are instances of Player
        return entities.values().stream()
                .filter(entity -> entity instanceof Player)
                .count();
    }

    public long getNumEnemiesById(int id) {
        // Use the Stream API to filter and count entities that are instances of Enemy with the specified id
        return entities.values().stream()
                .filter(entity -> entity instanceof Enemy)
                .filter(enemy -> ((Enemy) enemy).getId() == id)
                .count();
    }

    public Optional<Entity> findNearestEnemy(Position position) {
        // Use the Stream API to filter entities to only enemies, then find the nearest one
        return entities.values().stream()
                .filter(entity -> entity instanceof Enemy)
                .min((entity1, entity2) -> {
                    double distance1 = entity1.getPosition().euclideanDistance(position);
                    double distance2 = entity2.getPosition().euclideanDistance(position);
                    return Double.compare(distance1, distance2);
                });
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        GameMap gameMap = (GameMap) obj;
        return gameMapId == gameMap.gameMapId;
    }

    @Override
    public String toString() {
        return gameMapId + " | " + name + " (" + width + "x" + height + "x" + depth + ") | " + gameMapType;
    }
}
