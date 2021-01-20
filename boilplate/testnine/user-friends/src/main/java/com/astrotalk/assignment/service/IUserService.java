package com.astrotalk.assignment.service;

import com.astrotalk.assignment.dao.dto.User;

import java.util.List;

/**
 * The interface User service.
 */
public interface IUserService {

  /**
   * Create user string.
   *
   * @param user the user
   * @return user user
   */
  User createUser(final User user);

  /**
   * Gets all user.
   *
   * @return the all user
   */
  List<User> getAllUser();

  /**
   * Gets user.
   *
   * @param email the email
   * @return the user
   */
  User getUser(final String email);

  /**
   * Update user user.
   *
   * @param user the user
   * @return the user
   */
  User updateUser(final User user);

  /**
   * Delete user string.
   *
   * @param userId the user id
   * @param email  the email
   * @return the string
   */
  Boolean deleteUser(final Long userId, final String email);
}
