package IWant100.IWant100_BE.vote.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VoteItem {
    @Id
    UUID voteItemId;
    String voteItemContent;
    Integer voteItemCount;
}