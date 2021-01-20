package com.astrotalk.assignment.dao;

import com.astrotalk.assignment.dao.dto.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * The interface Friend repository.
 */
@Repository
public interface IFriendRepository extends JpaRepository<Friend, Integer> {

  /**
   * Find by user id list.
   *
   * @param userId the user id
   * @return the list
   */
  Set<Friend> findByUserId(final Long userId);

  /**
   * Find by user id and friend id friend.
   *
   * @param userId   the user id
   * @param friendId the friend id
   * @return the friend
   */
  Friend findByUserIdAndFriendId(final Long userId, final Long friendId);
}