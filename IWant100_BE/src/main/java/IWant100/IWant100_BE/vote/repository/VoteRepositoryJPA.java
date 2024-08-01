package IWant100.IWant100_BE.vote.repository;

import IWant100.IWant100_BE.vote.domain.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface VoteRepositoryJPA extends JpaRepository<Vote, UUID> {
    // voteId와 userId를 통해 원하는 객체 찾기
    Vote findByVoteIdAndUserId(UUID voteId, UUID userId);

    List<Vote> findAllByOrderByEndAtAscCreateAtAsc();

    // 제일 많은 투표 수를 가진 투표 객체 찾기
    Vote findTop1ByIsDeletedOrderByVoteCountDescCreateAtAsc(Boolean isDeleted);

    // userId를 통해 투표 전체 오래된 순으로 찾기
    List<Vote> findAllByUserIdOrderByEndAtAscCreateAtAsc(UUID userId);

    // 조회때마다 현재시간이랑 비교해 기간이 지난 투표를 찾기 위한 것
    List<Vote> findAllByIsDeleted(Boolean isDeleted);

}