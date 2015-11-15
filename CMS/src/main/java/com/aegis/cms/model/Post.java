package com.aegis.cms.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Post implements Serializable {

    private int postId;
    private String title;
    private String body;
    private String author;
    private Set<Tag> tags = new HashSet();
    private Date postDate;
    private Date expiration;
    private boolean isPublished;

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

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

    public void setTagsFromDb(Set<Tag> tagSet){
        tags = tagSet;
    }
    
    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(String tagString) {
        Set<Tag> tagSet = new HashSet<>();
        String[] tempArray = tagString.split(",");
        for (int i = 0; i < tempArray.length; i++) {
            Tag tempTag = new Tag();
            tempTag.setTagName(tempArray[i].trim());
            tagSet.add(tempTag);
        }
        this.tags.addAll(tagSet);
        tags = tagSet;
    }


    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }

    public boolean getIsPublished() {
        return isPublished;
    }

    public void setIsPublished(boolean isPublished) {
        this.isPublished = isPublished;
    }
    
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
