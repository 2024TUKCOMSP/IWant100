package IWant100.IWant100_BE.vote.repository;

import IWant100.IWant100_BE.vote.domain.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface VoteRepositoryJPA extends JpaRepository<Vote, UUID> {
    Vote findByVoteIdAndUserId(UUID voteId, UUID userId);

    List<Vote> findAllByOrderByEndAtAsc();

    // 제일 많은 투표 수를 가진 투표 객체 찾기
    Vote findTop1ByOrderByVoteCountDesc();
}