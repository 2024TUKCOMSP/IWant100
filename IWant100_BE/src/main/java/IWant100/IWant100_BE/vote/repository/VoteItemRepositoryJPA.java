package IWant100.IWant100_BE.vote.repository;

import IWant100.IWant100_BE.vote.domain.VoteItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface VoteItemRepositoryJPA extends JpaRepository<VoteItem, UUID> {

    // voteId를 통해 원하는 투표 항목 전체 조회
    List<VoteItem> findAllByVoteId(UUID voteId);

    // voteId를 통해 voteItem 항목들 찾고 제일 많은 투표한 항목 조회
    VoteItem findTop1ByVoteIdOrderByVoteItemCountDesc(UUID voteId);
}