package IWant100.IWant100_BE.vote.repository;

import IWant100.IWant100_BE.vote.domain.VoteItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface VoteItemRepositoryJPA extends JpaRepository<VoteItem, UUID> {
    List<VoteItem> findAllByVoteId(UUID voteId);
}