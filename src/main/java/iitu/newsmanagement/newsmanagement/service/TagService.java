package iitu.newsmanagement.newsmanagement.service;

import iitu.newsmanagement.newsmanagement.entity.Author;
import iitu.newsmanagement.newsmanagement.entity.Tag;
import iitu.newsmanagement.newsmanagement.exception.ResourceNotFoundException;
import iitu.newsmanagement.newsmanagement.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TagService {
    private final TagRepository tagRepository;


    public Tag addTag(Tag tag) {
        log.info("Adding a new tag: {}", tag.getName());
        return tagRepository.save(tag);
    }

    public List<Tag> getAllTags() {
        log.info("Fetching all tags.");
        return tagRepository.findAll();
    }


    public Tag getTagById(Integer id) {
        log.info("Fetching tag by ID: {}", id);
        return tagRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tag not found for ID: " + id));
    }


    public Tag updateTag(Tag tag) {
        log.info("Updating tag with ID: {}", tag.getId());
        if (!tagRepository.existsById(tag.getId())) {
            throw new ResourceNotFoundException("Tag not found for ID: " + tag.getId());
        }
        return tagRepository.save(tag);
    }


    public void deleteTag(Integer id) {
        log.info("Deleting tag with ID: {}", id);
        if (!tagRepository.existsById(id)) {
            throw new ResourceNotFoundException("Tag not found for ID: " + id);
        }
        tagRepository.deleteById(id);
    }

    public List<Tag> getTagsByBlogId(Integer blogId) {
        log.info("Fetching tags for blog ID: {}", blogId);
        List<Tag> tags = tagRepository.findByBlogsId(blogId);  // Assuming 'findByBlogsId' works for your setup
        if (tags.isEmpty()) {
            throw new ResourceNotFoundException("No tags found for blog ID: " + blogId);
        }
        return tags;
    }

    //searching
    public List<Tag> searchTagssByName(String query) {
        log.info("Searching for tags with query {}", query);
        List<Tag> tags = tagRepository.searchTagsByName(query);
        return tags;
    }
}
