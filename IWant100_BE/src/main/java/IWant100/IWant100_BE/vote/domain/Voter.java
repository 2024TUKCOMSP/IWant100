package IWant100.IWant100_BE.vote.domain;

import IWant100.IWant100_BE.vote.others.ListConverter;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Voter {
    @Id
    UUID voterId;

    UUID userId;
    UUID voteId;
    @Convert(converter = ListConverter.class)
    List<UUID> voteItemList;
}
