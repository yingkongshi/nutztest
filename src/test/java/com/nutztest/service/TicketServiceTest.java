package com.nutztest.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nutz.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.nutztest.bean.PoolType;
import com.nutztest.bean.Ticket;
import com.nutztest.bean.TicketUnit;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Transactional
public class TicketServiceTest {

  @Autowired
  private TicketService ticketService;
  
  @Autowired
  private Dao nutDao;
  
//  @Before
//  public void before() {
//    nutDao.create(Ticket.class, false);
//    nutDao.create(TicketUnit.class, false);
//  }
  
  @Transactional
  @Test
  public void test() {
    TicketUnit u1 = new TicketUnit();
    u1.setTicketId("111bbb");
    u1.setSelectionNo(1);
    
    TicketUnit u2 = new TicketUnit();
    u2.setTicketId("111bbb");
    u2.setSelectionNo(2);
    
    nutDao.insert(u1);
    nutDao.insert(u2);
    
    List<TicketUnit> unitList = new ArrayList<>();
    unitList.add(u1);
    unitList.add(u2);
    
    Ticket t = new Ticket("111bbb", PoolType.HAD, unitList);
    nutDao.insert(t);
  }

  @Test
  public void testGetTicket() {
    System.out.println(nutDao.fetchLinks(nutDao.fetch(Ticket.class, "111aaa"), null));
  }
}
