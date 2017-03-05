package com.nutztest.bean;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("ticket_unit")
public class TicketUnit {
  @Id
  private int unitId;
  @Column
  private String ticketId;
  @Column
  private int selectionNo;
}
