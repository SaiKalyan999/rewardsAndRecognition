package com.astrotalk.assignment.controller;

import com.astrotalk.assignment.dao.dto.User;
import com.astrotalk.assignment.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import javax.validation.constraints.NotNull;

/**
 * The type User controller.
 */
@RequestMapping("user")
@RestController
public class UserController {

  /**
   * The Logger.
   */
  private Logger LOGGER = LoggerFactory.getLogger(UserController.class);

  /**
   * The User service.
   */
  @Autowired
  private IUserService userService;

  /**
   * Create user.
   *
   * @param user the user
   * @return response entity
   */
  @PostMapping
  public ResponseEntity<User> createUser(@RequestBody @NotNull final User user) {

    LOGGER.debug("The user: {}", user);
    final User userResponse = userService.createUser(user);
    return ResponseEntity.status(HttpStatus.OK)
        .body(userResponse);
  }

  /**
   * Gets all user.
   *
   * @return the all user
   */
  @GetMapping
  public ResponseEntity<List<User>> getAllUser() {

    LOGGER.info("The get all user call");
    final List<User> userList = userService.getAllUser();
    return ResponseEntity.status(HttpStatus.OK)
        .body(userList);
  }

  /**
   * Gets user.
   *
   * @param email the email
   * @return the user
   */
  @GetMapping("/")
  public ResponseEntity<User> getUser(@RequestParam(required = true) @NotNull String email) {

    LOGGER.info("The get user by email : {}", email);
    final User user = userService.getUser(email);
    LOGGER.info("The user fetched : {}", user);
    return ResponseEntity.status(HttpStatus.OK)
        .body(user);
  }

  /**
   * Update user response entity.
   *
   * @param user the user
   * @return the response entity
   */
  @PutMapping
  public ResponseEntity<User> updateUser(@RequestBody @NotNull final User user) {

    LOGGER.info("The update user request : {}", user);
    final User userResponse = userService.updateUser(user);
    return ResponseEntity.status(HttpStatus.OK)
        .body(userResponse);
  }

  /**
   * Delete user response entity.
   *
   * @param email  the email
   * @param userId the user id
   * @return the response entity
   */
  @DeleteMapping
  public ResponseEntity<String> deleteUser(@RequestParam @NotNull final String email,
                                           @RequestParam @NotNull final Long userId) {

    LOGGER.info("The delete user id : {}, email: {}", userId, email);
    if (userService.deleteUser(userId, email)) {
      LOGGER.info("The user is delete successfully");
      return ResponseEntity.status(HttpStatus.OK)
          .body("Delete was successfully");
    } else {
      LOGGER.info("The user is delete unsuccessful");
      return ResponseEntity.status(HttpStatus.OK)
          .body("Delete was unsuccessful");
    }
  }
}


