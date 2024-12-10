package iitu.newsmanagement.newsmanagement.controller;

import iitu.newsmanagement.newsmanagement.dto.BlogDto;
import iitu.newsmanagement.newsmanagement.entity.Tag;
import iitu.newsmanagement.newsmanagement.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tags")
public class TagController {

    private final TagService tagService;


    @GetMapping
    public List<Tag> getAllTags() {
        return tagService.getAllTags();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tag> getTagById(@PathVariable Integer id) {
        Tag tag = tagService.getTagById(id);
        return new ResponseEntity<>(tag, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Tag> addTag(@RequestBody Tag tag) {
        Tag createdTag = tagService.addTag(tag);
        return new ResponseEntity<>(createdTag, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Tag> updateTag(@PathVariable Integer id, @RequestBody Tag tag) {
        Tag updatedTag = tagService.updateTag(tag);
        return new ResponseEntity<>(updatedTag, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTag(@PathVariable Integer id) {
        tagService.deleteTag(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/by-blog/{blogId}")
    public ResponseEntity<List<Tag>> getTagsByBlogId(@PathVariable Integer blogId) {
        List<Tag> tags = tagService.getTagsByBlogId(blogId);
        return new ResponseEntity<>(tags, HttpStatus.OK);
    }

    //searching...
    @GetMapping("/search")
    public List<Tag> searchTagsByName(@RequestParam("query") String query) {
        return tagService.searchTagssByName(query);
    }
}
