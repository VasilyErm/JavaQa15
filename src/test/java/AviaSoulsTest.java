import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class AviaSoulsTest {

    @Test
    public void ticketSortTest() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 7_000, 12, 14);
        Ticket ticket2 = new Ticket("KZN", "MSK", 14_000, 11, 16);
        Ticket ticket3 = new Ticket("MSK", "SPB", 8_000, 8, 10);
        Ticket ticket4 = new Ticket("KRD", "BRY", 12_000, 14, 16);
        Ticket ticket5 = new Ticket("MSK", "SPB", 7_000, 9, 12);
        Ticket ticket6 = new Ticket("NSK", "KHB", 16_000, 13, 18);
        Ticket ticket7 = new Ticket("MSK", "SPB", 6_000, 7, 9);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] expected = {ticket7, ticket1,ticket5, ticket3};
        Ticket[] actual = manager.search("MSK", "SPB");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ticketSortTest2() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 7_000, 12, 14);
        Ticket ticket2 = new Ticket("KZN", "MSK", 14_000, 11, 16);
        Ticket ticket3 = new Ticket("MSK", "SPB", 8_000, 8, 10);
        Ticket ticket4 = new Ticket("KRD", "BRY", 12_000, 14, 16);
        Ticket ticket5 = new Ticket("MSK", "SPB", 7_000, 9, 12);
        Ticket ticket6 = new Ticket("NSK", "KHB", 16_000, 13, 18);
        Ticket ticket7 = new Ticket("MSK", "SPB", 6_000, 7, 9);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] expected = {ticket2};
        Ticket[] actual = manager.search("KZN", "MSK");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ticketSortTest3() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 7_000, 12, 14);
        Ticket ticket2 = new Ticket("KZN", "MSK", 14_000, 11, 16);
        Ticket ticket3 = new Ticket("MSK", "SPB", 8_000, 8, 10);
        Ticket ticket4 = new Ticket("KRD", "BRY", 12_000, 14, 16);
        Ticket ticket5 = new Ticket("MSK", "SPB", 7_000, 9, 12);
        Ticket ticket6 = new Ticket("NSK", "KHB", 16_000, 13, 18);
        Ticket ticket7 = new Ticket("MSK", "SPB", 6_000, 7, 9);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] expected = {};
        Ticket[] actual = manager.search("KZN", "SPB");

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void ticketSortComparatorTest() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 7_000, 11, 14);   //3
        Ticket ticket2 = new Ticket("KZN", "MSK", 14_000, 11, 16);
        Ticket ticket3 = new Ticket("MSK", "SPB", 8_000, 8, 9);     //1
        Ticket ticket4 = new Ticket("KRD", "BRY", 12_000, 14, 16);
        Ticket ticket5 = new Ticket("MSK", "SPB", 7_000, 9, 13);    //4
        Ticket ticket6 = new Ticket("NSK", "KHB", 16_000, 13, 18);
        Ticket ticket7 = new Ticket("MSK", "SPB", 6_000, 7, 9);     //2

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Comparator <Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("MSK", "SPB", comparator);
        Ticket[] expected = {ticket3, ticket7,ticket1, ticket5};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ticketSortComparatorTest2() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 7_000, 11, 14);   //3
        Ticket ticket2 = new Ticket("KZN", "MSK", 14_000, 11, 16);
        Ticket ticket3 = new Ticket("MSK", "SPB", 8_000, 8, 9);     //1
        Ticket ticket4 = new Ticket("KRD", "BRY", 12_000, 14, 16);
        Ticket ticket5 = new Ticket("MSK", "SPB", 7_000, 9, 13);    //4
        Ticket ticket6 = new Ticket("NSK", "KHB", 16_000, 13, 18);
        Ticket ticket7 = new Ticket("MSK", "SPB", 6_000, 7, 9);     //2

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Comparator <Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("KZN", "MSK", comparator);
        Ticket[] expected = {ticket2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ticketSortComparatorTest3() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 7_000, 11, 14);   //3
        Ticket ticket2 = new Ticket("KZN", "MSK", 14_000, 11, 16);
        Ticket ticket3 = new Ticket("MSK", "SPB", 8_000, 8, 9);     //1
        Ticket ticket4 = new Ticket("KRD", "BRY", 12_000, 14, 16);
        Ticket ticket5 = new Ticket("MSK", "SPB", 7_000, 9, 13);    //4
        Ticket ticket6 = new Ticket("NSK", "KHB", 16_000, 13, 18);
        Ticket ticket7 = new Ticket("MSK", "SPB", 6_000, 7, 9);     //2

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Comparator <Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("KZN", "KHB", comparator);
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }
}