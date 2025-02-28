package B4F2.PetStagram.feed.controller;

import B4F2.PetStagram.feed.domain.*;
import B4F2.PetStagram.feed.service.FeedService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/feed")
@RequiredArgsConstructor
public class FeedController {

    private final FeedService feedService;


    @PostMapping("/write")
    public WriteFeedRes writeFeed(@RequestBody WriteFeedRes writeFeed,
                                  HttpServletRequest request){

        return WriteFeedRes.form(feedService.writeFeed(
                writeFeed.getMainText(),
                (String) request.getAttribute("email")
        ));

    }

    @DeleteMapping("/delete")
    public boolean deleteFeed(@RequestParam("feedId") Long feedId,
                              HttpServletRequest request) {

        return feedService.deleteFeed(feedId,
                (String)request.getAttribute("email"));
    }

    @PutMapping("/update")
    public UpdateFeedRes updateFeed(@RequestParam("feedId") Long feedId,
                                    @RequestBody UpdateFeedReq updateRequest,
                                    HttpServletRequest request) {

        return UpdateFeedRes.form(
                feedService.updateFeed(updateRequest,
                        feedId,
                        (String)request.getAttribute("email"))
        );
    }

    @GetMapping("/detail")
    public DetailFeedRes detailFeed(@RequestParam("feedId") Long feedId) {

        return DetailFeedRes.form(
                feedService.detailFeed(feedId)
        );
    }

    @GetMapping("/like")
    public boolean likeFeed(@RequestParam Long feedId) {

        return feedService.likeFeed(feedId);
    }

    @GetMapping("/unlike")
    public boolean unLikeFeed(@RequestParam Long feedId) {

        return feedService.unLikeFeed(feedId);
    }

}
