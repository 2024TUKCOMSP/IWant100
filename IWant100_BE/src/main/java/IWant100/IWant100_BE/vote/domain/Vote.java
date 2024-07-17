package IWant100.IWant100_BE.vote.domain;

import IWant100.IWant100_BE.vote.others.StringConverter;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Vote {
    @Id
    UUID voteId;

    UUID userId;
    String voteIntro;
    Integer voteCount;
    LocalDateTime createAt;
    LocalDateTime endAt;
    Boolean isDuplication;
    Boolean isAnonymous;

    @Convert(converter = StringConverter.class)
    List<VoteItem> voteItemList;
}