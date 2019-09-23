package com.eagle.ykm.service;

import com.eagle.ykm.dao.TicketDAO;
import com.eagle.ykm.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description
 * @auth YKM
 * @date 2019/9/23 20:00
 **/
@Service
public class TicketService {
    @Autowired
    private TicketDAO ticketDAO;

    public void addTicket(Ticket ticket) {
        ticketDAO.addTicket(ticket);
    }

    public  Ticket selectByTicket(String t) {
        return ticketDAO.selectByTicket(t);
    }


    public Ticket selectByUserId(int uid) {
        return ticketDAO.selectByUserId(uid);
    }

    public void deleteTicketById(int tid) {
        ticketDAO.deleteTicketById(tid);
    }

    public void deleteTicket(String t) {
        ticketDAO.deleteTicket(t);
    }

}