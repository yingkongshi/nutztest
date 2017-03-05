package com.nutztest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nutztest.bean.Ticket;
import com.nutztest.service.TicketService;

@RestController
public class TicketController {

  @Autowired
  private TicketService ticketService;
  
  @GetMapping("/")
  public Ticket getTicketById(@RequestParam String ticketId) {
    return ticketService.getTicketById(ticketId);
  }
  
  @PostMapping("/")
  public Ticket createTicket(@RequestBody Ticket ticket) {
    return ticketService.insertTicket(ticket);
  }
}
