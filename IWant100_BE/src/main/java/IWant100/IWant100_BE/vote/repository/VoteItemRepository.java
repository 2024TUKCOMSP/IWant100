package IWant100.IWant100_BE.vote.repository;

import IWant100.IWant100_BE.vote.domain.VoteItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VoteItemRepository extends JpaRepository<VoteItem, UUID> {
}
