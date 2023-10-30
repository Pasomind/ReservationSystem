package service;

import model.ConferenceRoom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ReservationSystemTest {

    private ReservationSystem system;

    @BeforeEach
    public void setUp() {
        system = new ReservationSystem();
    }

    @Test
    public void testReserveRoom() {
        assertTrue(system.reserveRoom("A1"));
        assertFalse(system.reserveRoom("A1"));
        assertFalse(system.reserveRoom("B1"));
    }

    @Test
    public void testCancelReservation() {
        assertTrue(system.reserveRoom("A1"));
        assertTrue(system.cancelReservation("A1"));
        assertFalse(system.cancelReservation("A1"));
        assertFalse(system.cancelReservation("B1"));
    }

    @Test
    public void testGetAvailableRooms() {
        assertEquals(2,system.getAvailableRooms().size());
        system.reserveRoom("A1") ;
        assertEquals (1,system.getAvailableRooms(). size());
        system. cancelReservation("A1");
        assertEquals (2,system. getAvailableRooms( ).size());
    }
}
