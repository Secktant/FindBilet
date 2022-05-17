package data;

import ru.netology.domain.Manager.TicketManager;
import org.junit.jupiter.api.Test;
import ru.netology.domain.data.Ticket;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest {

    Ticket ticketOne = new Ticket(1, 100, "Moscow", "SPB", 150);
    Ticket ticketTwo = new Ticket(2, 500, "NewYork", "Antalia", 400);
    Ticket ticketThree = new Ticket(3, 350, "Tallint", "Budapesht", 50);

    Ticket ticketFor = new Ticket(4, 50, "Moscow", "SPB", 25);

    @Test
    void addTicket() {
        TicketManager manager = new TicketManager();

        manager.add(ticketOne);
        manager.add(ticketTwo);
        manager.add(ticketThree);

        Ticket[] expected = new Ticket[]{ticketOne, ticketTwo, ticketThree};
        Ticket[] actual = manager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void addTicketsAndFind() {
        TicketManager manager = new TicketManager();

        manager.add(ticketOne);
        manager.add(ticketTwo);
        manager.add(ticketThree);

        manager.findAll("Moscow", "SPB");

        Ticket[] expected = new Ticket[]{ticketOne};
        Ticket[] actual = manager.findAll("Moscow", "SPB");

        assertArrayEquals(expected, actual);


    }

    @Test
    void findTwoTickets() {
        TicketManager manager = new TicketManager();

        manager.add(ticketOne);
        manager.add(ticketTwo);
        manager.add(ticketThree);
        manager.add(ticketFor);

        manager.findAll("Moscow", "SPB");

        Ticket[] expected = new Ticket[]{ticketFor, ticketOne};
        Ticket[] actual = manager.findAll("Moscow", "SPB");

        assertArrayEquals(expected, actual);

    }

    @Test
    void FindZeroTickets() {
        TicketManager manager = new TicketManager();

        manager.add(ticketOne);
        manager.add(ticketTwo);
        manager.add(ticketThree);
        manager.add(ticketFor);

        manager.findAll("Moscow", "Tallin");

        Ticket[] expected = new Ticket[]{};
        Ticket[] actual = manager.findAll("Moscow", "Tallint");

        assertArrayEquals(expected, actual);

    }

}