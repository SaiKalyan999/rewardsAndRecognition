package com.astrotalk.assignment.dao;

import com.astrotalk.assignment.dao.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * The interface User repository.
 */
@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

  /**
   * Find by email user.
   *
   * @param email the email
   * @return the user
   */
  User findByEmail(final String email);

  /**
   * Find by email and id user.
   *
   * @param email the email
   * @param id    the id
   * @return the user
   */
  User findByEmailAndId(final String email, final Long id);

  /**
   * Find by id in user.
   *
   * @param ids the ids
   * @return the user list
   */
  List<User> findByIdIn(final Set<Long> ids);
}
