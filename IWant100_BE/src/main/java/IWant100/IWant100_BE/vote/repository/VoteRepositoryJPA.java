package IWant100.IWant100_BE.vote.repository;

import IWant100.IWant100_BE.vote.domain.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VoteRepositoryJPA extends JpaRepository<Vote, UUID> {
    Vote findByVoteIdAndUserId(UUID voteId, UUID userId);
}