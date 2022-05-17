package ru.netology.domain.repository;

import ru.netology.domain.data.Ticket;

public class TicketRepository {

    public TicketRepository(Ticket[] tickets) {
        this.tickets = tickets;
    }

    public TicketRepository() {
        this.tickets = tickets;
    }

    protected Ticket[] tickets = new Ticket[0];

    public Ticket[] findAll() {
        return tickets;
    }

    public void add(Ticket ticket) {
        Ticket[] tmp = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];

        }
        tmp[tmp.length - 1] = ticket;
        tickets = tmp;
    }

}
