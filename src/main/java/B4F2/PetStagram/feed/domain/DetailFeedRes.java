package B4F2.PetStagram.feed.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetailFeedRes {

    private Long feedId;
    private String userId;
    private String mainText;
    //private String[] comment 차후 댓글 기능

    public static DetailFeedRes form(FeedDto feedDto) {
        return DetailFeedRes.builder()
                .feedId(feedDto.getFeedId())
                .userId(feedDto.getUserId())
                .mainText(feedDto.getMainText())
                .build();
    }
}

