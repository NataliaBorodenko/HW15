import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AviaSoulsTest {
    AviaSouls souls = new AviaSouls();
    Ticket ticket1 = new Ticket("Москва", " Сочи", 3000, 12, 14);
    Ticket ticket2 = new Ticket("Калуга", " Сочи", 4000, 16, 18);
    Ticket ticket3 = new Ticket("Санкт-Петербург", " Сочи", 6000, 10, 16);
    Ticket ticket4 = new Ticket("Москва", " Санкт-Петербург", 5000, 11, 13);
    Ticket ticket5 = new Ticket("Москва", " Сочи", 4000, 19, 22);

    @BeforeEach
    public void setup() {
        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);
        souls.add(ticket5);
    }

    @Test
    public void testCompareToTicketLess() {
        int expected = -1;
        int actual = ticket1.compareTo(ticket4);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testCompareToTicketMore() {
        int expected = 1;
        int actual = ticket4.compareTo(ticket2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testCompareToTicketEgual() {
        int expected = 0;
        int actual = ticket2.compareTo(ticket5);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSearchSortPrice() {
        Ticket[] actual = souls.search("Москва", " Сочи");
        Ticket[] expected = {ticket1, ticket5};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchDesiredTicket() {
        Ticket[] actual = souls.search("Калуга", " Сочи");
        Ticket[] expected = {ticket2};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchNotFoundTicket() {
        Ticket[] actual = souls.search("Калуга", "Москва");
        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }
    
}
