package com.astrotalk.assignment.controller;

import static com.astrotalk.assignment.constants.Constants.FRIENDS_CREATION_FAILURE;
import static com.astrotalk.assignment.constants.Constants.FRIENDS_CREATION_SUCCESS;
import static com.astrotalk.assignment.constants.Constants.FRIENDS_REMOVE_FAILED;
import static com.astrotalk.assignment.constants.Constants.FRIENDS_REMOVE_SUCCESS;
import static com.astrotalk.assignment.constants.Constants.SUCCESS;

import com.astrotalk.assignment.dao.dto.User;
import com.astrotalk.assignment.service.IFriendsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import javax.validation.constraints.NotNull;

/**
 * The type Friends controller.
 */
@RequestMapping("friends")
@RestController
public class FriendsController {

  /**
   * The Logger.
   */
  private Logger LOGGER = LoggerFactory.getLogger(FriendsController.class);

  /**
   * The Friends service.
   */
  @Autowired
  private IFriendsService friendsService;

  /**
   * Add friend response entity.
   *
   * @param friendsList the friends list
   * @param userId      the user id
   * @return the response entity
   */
  @PostMapping
  public ResponseEntity<String> addFriend(@RequestBody @NotNull final List<Long> friendsList,
                                          @RequestParam @NotNull final Long userId) {

    LOGGER.debug("The friends to be added : {}", friendsList);
    final String response = friendsService.addFriends(friendsList, userId);
    if (SUCCESS.equals(response)) {
      return ResponseEntity.status(HttpStatus.OK)
          .body(FRIENDS_CREATION_SUCCESS);
    } else {
      return ResponseEntity.status(HttpStatus.OK)
          .body(FRIENDS_CREATION_FAILURE);
    }
  }

  /**
   * Remove friends response entity.
   *
   * @param friendId the friend id
   * @param userId   the user id
   * @return the response entity
   */
  @DeleteMapping
  public ResponseEntity<String> removeFriends(@RequestParam @NotNull final Long friendId,
                                              @RequestParam @NotNull final Long userId) {

    LOGGER.debug("The friend to be removed : {}, user: {}", friendId, userId);
    final String response = friendsService.removeFriends(friendId, userId);
    if (SUCCESS.equals(response)) {
      return ResponseEntity.status(HttpStatus.OK)
          .body(FRIENDS_REMOVE_SUCCESS);
    } else {
      return ResponseEntity.status(HttpStatus.OK)
          .body(FRIENDS_REMOVE_FAILED);
    }
  }

  /**
   * Gets friends.
   *
   * @param userId the user id
   * @return the friends
   */
  @GetMapping
  public ResponseEntity<Set<User>> getFriendsByDistance(
      @RequestParam @NotNull final Long userId,
      @RequestParam(required = false) @NotNull Integer distance) throws Exception {

    if (!Optional.ofNullable(distance).isPresent()) {
      distance = 0;
    }
    LOGGER.debug("The get friends by distance : {}, user: {}", distance, userId);
    final Set<User> response = friendsService.getFriendsByDistance(userId, distance);
    return ResponseEntity.status(HttpStatus.OK)
        .body(response);
  }
}
