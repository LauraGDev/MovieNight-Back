package com.femcoders.movienight.controllers;

import com.femcoders.movienight.controllers.responses.GlobalResponse;
import com.femcoders.movienight.models.Content;
import com.femcoders.movienight.services.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/content")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST,
        RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.OPTIONS})
public class ContentController {

    private final ContentService contentService;

    @PostMapping("/{profileId}/addToWatchlist")
    public ResponseEntity<GlobalResponse> addContentToProfile(@PathVariable int profileId,
                                                                       @RequestBody Content content) {
        return contentService.addProfileContent(profileId, content);
    }

    @PostMapping("/{profileId}/deleteFromWatchlist")
    public ResponseEntity<GlobalResponse> deleteContentProfile(@PathVariable int profileId,
                                                      @RequestBody Content content) {
        return contentService.addProfileContent(profileId, content);
    }

}
