package IWant100.IWant100_BE.vote.repository;

import IWant100.IWant100_BE.vote.domain.Voter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VoterRepositoryJPA extends JpaRepository<Voter, UUID> {
    // voteId와 userId를 통해 투표한 사람 찾기
    Voter findByVoteIdAndUserId(UUID voteId, UUID userId);
}
