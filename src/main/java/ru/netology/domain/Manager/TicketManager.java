package ru.netology.domain.Manager;

import ru.netology.domain.data.Ticket;
import ru.netology.domain.repository.TicketRepository;

import java.util.Arrays;

public class TicketManager {

    protected TicketRepository repository = new TicketRepository();

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public TicketManager() {
        this.repository = repository;
    }

    public TicketRepository getRepository() {
        return repository;
    }

    public void setRepository(TicketRepository repository) {
        this.repository = repository;
    }

    public void add(Ticket ticket) {
        repository.add(ticket);
    }

    public Ticket[] findAll() {
        return repository.findAll();
    }

    public Ticket[] findAll(String from, String to) {
        Ticket result[] = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            if (matches(ticket, from, to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];

                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }

        }
        Arrays.sort(result);
        return result;
    }


    public boolean matches(Ticket ticket, String from, String to) {
        if (ticket.getFrom() != from) {
            return false;
        }
        if (ticket.getTo() != to) {
            return false;
        }
        return true;

    }


}
