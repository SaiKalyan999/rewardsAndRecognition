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
import javax.validation.constraints.NotNull;

/**
 * The type Users.
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

  /**
   * The Serial version uid.
   */
  private static final Long serialVersionUID = 1L;

  /**
   * The Id.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userGenerator")
  @SequenceGenerator(name = "userGenerator", sequenceName = "user_id_seq", allocationSize = 1)
  @Column(name = "id")
  private Long id;

  /**
   * The Name.
   */
  @Column(name = "name")
  @NotNull
  private String name;

  /**
   * The Email.
   */
  @Column(name = "email")
  @NotNull
  private String email;

  /**
   * The Phone number.
   */
  @Column(name = "phone_number")
  private Long phoneNumber;

  /**
   * The Address.
   */
  @Column(name = "address")
  private String address;
}
