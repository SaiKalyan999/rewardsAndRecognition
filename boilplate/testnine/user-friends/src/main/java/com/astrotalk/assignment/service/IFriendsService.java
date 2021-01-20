package com.astrotalk.assignment.service;

import com.astrotalk.assignment.dao.dto.User;

import java.util.List;
import java.util.Set;
import javax.transaction.Transactional;

/**
 * The interface Friends service.
 */
public interface IFriendsService {

  /**
   * Add friends string.
   *
   * @param friendIds the friend ids
   * @param userId    the user id
   * @return the string
   */
  @Transactional(rollbackOn = Exception.class)
  String addFriends(final List<Long> friendIds, final Long userId);

  /**
   * Remove friends string.
   *
   * @param friendId the friend id
   * @param userId   the user id
   * @return the string
   */
  @Transactional(rollbackOn = Exception.class)
  String removeFriends(Long friendId, Long userId);

  /**
   * Gets friends by distance.
   *
   * @param userId   the user id
   * @param distance the distance
   * @return the friends by distance
   */
  Set<User> getFriendsByDistance(final Long userId, final int distance) throws Exception;
}
