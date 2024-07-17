package IWant100.IWant100_BE.vote.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class VoteItem {
    @Id
    UUID voteItemId;
    UUID voteId;
    String voteItemContent;
    Integer voteItemCount;
}