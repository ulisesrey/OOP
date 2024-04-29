package edu.uoc.pac3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PositionTest {

    @Test
    @Order(1)
    @DisplayName("Position creation - Valid parameters")
    void testCreatePosition() {
        Position position = new Position(500, 250);

        assertNotNull(position);
        assertEquals(500, position.getX());
        assertEquals(250, position.getY());
    }

    @Test
    @Order(2)
    @DisplayName("Position creation - Edge parameters")
    void testCreatePositionEdgeParameters() {
        Position position = new Position(0, 0);

        assertNotNull(position);
        assertEquals(0, position.getX());
        assertEquals(0, position.getY());

        position = new Position(1024, 512);

        assertNotNull(position);
        assertEquals(1024, position.getX());
        assertEquals(512, position.getY());
    }

    @Test
    @Order(3)
    @DisplayName("Position creation - Invalid parameters")
    void testCreatePositionInvalidParameters() {
        assertThrows(IllegalArgumentException.class, () -> new Position(-1, 0));
        assertThrows(IllegalArgumentException.class, () -> new Position(0, -1));
        assertThrows(IllegalArgumentException.class, () -> new Position(1025, 0));
        assertThrows(IllegalArgumentException.class, () -> new Position(0, 513));
    }

    @Test
    @Order(4)
    @DisplayName("Set X - Valid parameters")
    void testSetXValidParameters() {
        Position position = new Position(0, 0);
        position.setX(500);
        assertEquals(500, position.getX());
    }

    @Test
    @Order(5)
    @DisplayName("Set X - Invalid parameters")
    void testSetXInvalidParameters() {
        Position position = new Position(0, 0);
        assertThrows(IllegalArgumentException.class, () -> position.setX(2000));
        assertThrows(IllegalArgumentException.class, () -> position.setX(-1));
    }

    @Test
    @Order(6)
    @DisplayName("Set Y - Valid parameters")
    void testSetYValidParameters() {
        Position position = new Position(0, 0);
        position.setY(250);
        assertEquals(250, position.getY());
    }

    @Test
    @Order(7)
    @DisplayName("Set Y - Invalid parameters")
    void testSetYInvalidParameters() {
        Position position = new Position(0, 0);
        assertThrows(IllegalArgumentException.class, () -> position.setY(1000));
        assertThrows(IllegalArgumentException.class, () -> position.setY(-1));
    }

    @Test
    @Order(8)
    @DisplayName("Distance calculation")
    void testDistance() {
        Position position1 = new Position(0, 0);
        Position position2 = new Position(3, 4);
        assertEquals(5.0, Position.distance(position1, position2));
    }
}