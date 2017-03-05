package com.nutztest.service;

import org.nutz.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nutztest.bean.Ticket;

@Transactional
@Service
public class TicketService {

  @Autowired
  private Dao dao;
  
  /**
   * 级联获取ticket.
   * @param ticketId ticket primary key
   * @return ticket
   */
  public Ticket getTicketById(String ticketId) {
    return dao.fetchLinks(dao.fetch(Ticket.class, ticketId), null);
  }
  
  /**
   * 级联插入ticket.
   * @param ticket ticket object
   * @return ticket
   */
  public Ticket insertTicket(Ticket ticket) {
    return dao.insertLinks(ticket, null);
  }
}

