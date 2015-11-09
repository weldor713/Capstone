package com.aegis.cms.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

public class Post {
//    private int postId;

    private String title;
    private String body;
//    private User author;
    private Set<Tag> tags = new HashSet<>();
    private LocalDate postDate;
    private LocalDate expiration;
//    private boolean isPublished;

//    public int getPostId() {
//        return postId;
//    }
//
//    public void setPostId(int postId) {
//        this.postId = postId;
//    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

//    public User getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(User author) {
//        this.author = author;
//    }
//
    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(String tagnames) {
        Set<Tag> tagSet = new HashSet<>();
        String[] tempArray = tagnames.split(",");
        for(int i = 0; i < tempArray.length; i++){
            Tag tempTag = new Tag();
            tempTag.setTagName(tempArray[i]);
            tempTag.setTagId(i);
            tagSet.add(tempTag);
        }
        this.tags.addAll(tagSet);
    }
    
    public String getPostDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        return postDate.format(dtf);
    }

    public void setPostDate(String postDate) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        this.postDate = LocalDate.parse(postDate, dtf);
    }
//
    public LocalDate getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        this.expiration = LocalDate.parse(expiration, dtf);
    }
//
//    public boolean getIsApproved() {
//        return isPublished;
//    }
//
//    public void setIsPublished(boolean isPublished) {
//        this.isPublished = isPublished;
//    }
}
