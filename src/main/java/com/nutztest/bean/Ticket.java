package com.nutztest.bean;

import java.util.List;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Many;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("ticket")
public class Ticket {
  @Name
  private String ticketId;
  @Column
  private PoolType poolType;
  @Many(field = "ticketId")
  private List<TicketUnit> unitList;
}
