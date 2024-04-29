package edu.uoc.pac3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EnemyTest {

    @Test
    @Order(1)
    @DisplayName("Enemy creation - Valid parameters")
    void testCreateEnemy() {
        Enemy enemy = new Enemy("Enemy_one", 103, 10, 20, 500, 251);

        assertNotNull(enemy);
        assertEquals("Enemy_one", enemy.getName());
        assertEquals(103, enemy.getHealth());
        assertEquals(10, enemy.getMinDamage());
        assertEquals(20, enemy.getMaxDamage());
        assertEquals(500, enemy.getPosition().getX());
        assertEquals(251, enemy.getPosition().getY());
    }

    @Test
    @Order(2)
    @DisplayName("Set Name - Valid parameters")
    void testSetNameValidParameters() {
        Enemy enemy = new Enemy("Enemy_number_one", 100, 10, 20, 500, 250);
        enemy.setName("Enemy_number_two");
        assertEquals("Enemy_number_two", enemy.getName());
    }

    @Test
    @Order(3)
    @DisplayName("Set Name - Invalid parameters")
    void testSetNameInvalidParameters() {
        Enemy enemy = new Enemy("Enemy_the_one", 100, 10, 20, 500, 250);
        assertThrows(IllegalArgumentException.class, () -> enemy.setName(""));
        assertThrows(IllegalArgumentException.class, () -> enemy.setName(null));
    }

    @Test
    @Order(4)
    @DisplayName("Set Health - Valid parameters")
    void testSetHealthValidParameters() {
        Enemy enemy = new Enemy("my_first_enemy", 100, 10, 20, 500, 250);
        enemy.setHealth(50);
        assertEquals(50, enemy.getHealth());
    }

    @Test
    @Order(5)
    @DisplayName("Set Damage - Valid parameters")
    void testSetDamageValidParameters() {
        Enemy enemy = new Enemy("Dracula", 100, 10, 20, 500, 250);
        enemy.setDamage(15, 25);
        assertEquals(15, enemy.getMinDamage());
        assertEquals(25, enemy.getMaxDamage());
    }

    @Test
    @Order(6)
    @DisplayName("Set Damage - Invalid parameters")
    void testSetDamageInvalidParameters() {
        Enemy enemy = new Enemy("Voldemort", 100, 10, 20, 500, 250);
        assertThrows(IllegalArgumentException.class, () -> enemy.setDamage(0, 20));
        assertThrows(IllegalArgumentException.class, () -> enemy.setDamage(10, 5));
    }

    @Test
    @Order(7)
    @DisplayName("Set Position - Valid parameters")
    void testSetPositionValidParameters() {
        Enemy enemy = new Enemy("Vegeta", 100, 10, 20, 500, 250);
        enemy.setPosition(600, 300);
        assertEquals(600, enemy.getPosition().getX());
        assertEquals(300, enemy.getPosition().getY());
    }

    @Test
    @Order(8)
    @DisplayName("Is Dead?")
    void testIsDead() {
        Enemy enemy = new Enemy("Goku", 100, 10, 20, 500, 250);
        enemy.setHealth(0);
        assertTrue(enemy.isDead());
    }

    @Test
    @Order(9)
    @DisplayName("Move - Valid parameters")
    void testMoveValidParameters() {
        Enemy enemy = new Enemy("Sauron", 100, 10, 20, 500, 250);
        assertTrue(enemy.move(505, 255));
        assertEquals(505, enemy.getPosition().getX());
        assertEquals(255, enemy.getPosition().getY());
    }

    @Test
    @Order(10)
    @DisplayName("Move - Invalid parameters")
    void testMoveInvalidParameters() {
        Enemy enemy = new Enemy("Saruman", 100, 10, 20, 500, 250);
        assertFalse(enemy.move(600, 300));
    }

    @Test
    @Order(11)
    @DisplayName("Attack")
    void testAttack() {
        Enemy enemy = new Enemy("Gollum", 100, 10, 20, 500, 250);
        int damage = enemy.attack();
        assertTrue(damage >= 10 && damage <= 20);
    }

    @Test
    @Order(12)
    @DisplayName("Receive Damage")
    void testReceiveDamage() {
        Enemy enemy = new Enemy("Smeagol", 100, 10, 20, 500, 250);
        enemy.receiveDamage(50);
        assertEquals(50, enemy.getHealth());
    }
}