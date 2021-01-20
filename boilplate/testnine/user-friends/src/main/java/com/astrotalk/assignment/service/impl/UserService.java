package com.astrotalk.assignment.service.impl;

import com.astrotalk.assignment.dao.IUserRepository;
import com.astrotalk.assignment.dao.dto.User;
import com.astrotalk.assignment.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

/**
 * The type User service.
 */
@Service
public class UserService implements IUserService {

  /**
   * The Logger.
   */
  private Logger LOGGER = LoggerFactory.getLogger(UserService.class);

  /**
   * The User repository.
   */
  @Autowired
  private IUserRepository userRepository;

  /**
   * Create user string.
   *
   * @param user the user
   * @return the user
   */
  @Override
  @Transactional(rollbackOn = Exception.class)
  public User createUser(final User user) {

    if (Optional.ofNullable(user).isPresent()) {
      if (Optional.ofNullable(user.getId()).isPresent()) {
        LOGGER.info("The user id is present invoking update user call.");
        return updateUser(user);
      } else {
        if (Optional.ofNullable(user.getEmail()).isPresent()
            && Optional.ofNullable(user.getName()).isPresent()) {
          final User userResponse = userRepository.saveAndFlush(user);
          LOGGER.debug("The user created successfully: {}", userResponse);
          return userResponse;
        } else {
          LOGGER.error("The user details provided are: {}", user);
          throw new IllegalArgumentException("Invalid User Details Passed.");
        }
      }
    } else {
      LOGGER.error("The user details provided are: {}", user);
      throw new IllegalArgumentException("Invalid User Details Passed.");
    }
  }

  /**
   * Gets all user.
   *
   * @return the all user
   */
  @Override
  public List<User> getAllUser() {
    return userRepository.findAll();
  }

  /**
   * Gets user.
   *
   * @param email the email
   * @return the user
   */
  @Override
  public User getUser(String email) {
    return userRepository.findByEmail(email);
  }

  /**
   * Update user user.
   *
   * @param user the user
   * @return the user
   */
  @Override
  @Transactional(rollbackOn = Exception.class)
  public User updateUser(final User user) {

    if (Optional.ofNullable(user).isPresent()
        && Optional.ofNullable(user.getId()).isPresent()) {
      final User userResponse = userRepository.saveAndFlush(user);
      LOGGER.info("The user update successfully : {}", userResponse);
      return userResponse;
    } else {
      throw new IllegalArgumentException("Invalid user to update.");
    }
  }

  /**
   * Delete user string.
   *
   * @param userId the user id
   * @param email  the email
   * @return the string
   */
  @Override
  @Transactional(rollbackOn = Exception.class)
  public Boolean deleteUser(final Long userId, final String email) {

    if (Optional.ofNullable(userId).isPresent()
        && Optional.ofNullable(email).isPresent()) {
      final User user = userRepository.findByEmailAndId(email, userId);
      if (Optional.ofNullable(user).isPresent()) {
        userRepository.delete(user);
        return Boolean.TRUE;
      } else {
        return Boolean.FALSE;
      }
    } else {
      return Boolean.FALSE;
    }
  }
}
