package com.astrotalk.assignment.dao.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "friends")
public class Friend {

  /**
   * The Id.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "friendGenerator")
  @SequenceGenerator(name = "friendGenerator", sequenceName = "friend_id_seq", allocationSize = 1)
  @Column(name = "id")
  private long id;

  /**
   * The User Id.
   */
  @Column(name = "user_id")
  private long userId;

  /**
   * The Friend Id.
   */
  @Column(name = "friend_id")
  private long friendId;
}
