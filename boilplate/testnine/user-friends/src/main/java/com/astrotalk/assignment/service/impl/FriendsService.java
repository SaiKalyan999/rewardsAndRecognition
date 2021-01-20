package com.astrotalk.assignment.service.impl;

import static com.astrotalk.assignment.constants.Constants.FAILED;
import static com.astrotalk.assignment.constants.Constants.SUCCESS;

import com.astrotalk.assignment.dao.IFriendRepository;
import com.astrotalk.assignment.dao.IUserRepository;
import com.astrotalk.assignment.dao.dto.Friend;
import com.astrotalk.assignment.dao.dto.User;
import com.astrotalk.assignment.service.IFriendsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import javax.transaction.Transactional;

/**
 * The type Friends service.
 */
@Service
public class FriendsService implements IFriendsService {

  /**
   * The Logger.
   */
  private Logger LOGGER = LoggerFactory.getLogger(FriendsService.class);

  /**
   * The Friend repository.
   */
  @Autowired
  private IFriendRepository friendRepository;

  /**
   * The User repository.
   */
  @Autowired
  private IUserRepository userRepository;

  /**
   * Add friends string.
   *
   * @param friendIds the friend ids
   * @param userId    the user id
   * @return the string
   */
  @Transactional(rollbackOn = Exception.class)
  @Override
  public String addFriends(final List<Long> friendIds, final Long userId) {

    final List<Friend> friends = new ArrayList();
    if (Optional.ofNullable(userId).isPresent()
        && Optional.ofNullable(friendIds).isPresent()) {
      friendIds.forEach(friendId -> {
        friends.add(Friend.builder()
            .userId(userId)
            .friendId(friendId)
            .build());
        friends.add(Friend.builder()
            .userId(friendId)
            .friendId(userId)
            .build());
      });
      if (Optional.ofNullable(friends).isPresent() && friends.size() > 0) {
        friendRepository.saveAll(friends);
        LOGGER.info("The friends added successfully");
        return SUCCESS;
      }
    } else {
      LOGGER.error("The userid: {} and friends id: {}", userId, friendIds);
      throw new IllegalArgumentException("Invalid Input");
    }
    LOGGER.info("The friends addition unsuccessful.");
    return FAILED;
  }

  /**
   * Remove friends string.
   *
   * @param friendId the friend id
   * @param userId   the user id
   * @return the string
   */
  @Override
  @Transactional(rollbackOn = Exception.class)
  public String removeFriends(final Long friendId, final Long userId) {

    if (Optional.ofNullable(userId).isPresent()
        && Optional.ofNullable(friendId).isPresent()) {
      final Friend friend = friendRepository.findByUserIdAndFriendId(userId, friendId);
      if (Optional.ofNullable(friend).isPresent()) {
        friendRepository.delete(friend);
        final Friend mutualDelete = friendRepository.findByUserIdAndFriendId(friendId, userId);
        if (Optional.ofNullable(mutualDelete).isPresent()) {
          friendRepository.delete(mutualDelete);
        }
        LOGGER.info("The friends removed successfully");
        return SUCCESS;
      }
    } else {
      LOGGER.error("The userid: {} and friend id: {}", userId, friendId);
      throw new IllegalArgumentException("Invalid Input");
    }
    LOGGER.info("The friend not present.");
    return FAILED;
  }

  /**
   * Gets friends by distance.
   *
   * @param userId   the user id
   * @param distance the distance
   * @return the friends by distance
   */
  @Override
  public Set<User> getFriendsByDistance(final Long userId, int distance) throws Exception {

    final Set<User> response = new HashSet();
    final Set<Long> friendIds;
    final Set<Long> removeFriends = new HashSet();
    if (Optional.ofNullable(userId).isPresent()) {
      Set<Friend> friendMapping = friendRepository.findByUserId(userId);
      if (distance > 0) {
        if (friendMapping.size() > 0) {
          while (distance > 0) {
            final Set<Long> tempFriends = friendMapping.stream()
                .map(friend -> friend.getFriendId())
                .collect(Collectors.toSet());
            removeFriends.addAll(tempFriends);
            final Set<Friend> newFriendMapping = new HashSet();
            tempFriends.forEach(friend -> {
              if (friend != userId) {
                final Set<Friend> resp = friendRepository.findByUserId(friend);
                newFriendMapping.addAll(resp);
              }
            });
            friendMapping = newFriendMapping;
            distance--;
          }
        } else {
          LOGGER.error("No friends exist at the distance: {}", distance);
          throw new Exception("No friends exist at the distance: " + distance);
        }

      }
      friendIds = friendMapping.stream()
          .map(friend -> friend.getFriendId())
          .collect(Collectors.toSet());
      friendIds.removeAll(removeFriends);
      friendIds.remove(userId);
      response.addAll(userRepository.findByIdIn(friendIds));
    } else {
      LOGGER.error("The userid: {}, distance: {}", userId, distance);
      throw new IllegalArgumentException("Invalid Input");
    }
    return response;
  }
}
