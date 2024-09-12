package com.femcoders.movienight.controllers;

import com.femcoders.movienight.models.Content;
import com.femcoders.movienight.services.ContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/content")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class ContentController {

    private final ContentService contentService;

    @PostMapping("/{profileId}/addToWatchlist")
    public ResponseEntity<Object> addContentToProfile(@PathVariable int profileId,
                                                      @RequestBody Content content) {
        return contentService.addProfileContent(profileId, content);
    }

}
