package com.aegis.cms.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "post")
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column(name = "post_id")
    private int postId;
    @Column(name = "title")
    private String title;
    @Column(name = "body")
    private String body;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private Set<Tag> tags;

    @Column(name = "postDate")
    private Date postDate;
    @Column(name = "expiration")
    private Date expiration;
//    private boolean isPublished;

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
        for (int i = 0; i < tempArray.length; i++) {
            Tag tempTag = new Tag();
            tempTag.setTagName(tempArray[i]);
            tagSet.add(tempTag);
        }
        this.tags.addAll(tagSet);
    }
//    

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }
//

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }
//
//    public boolean getIsApproved() {
//        return isPublished;
//    }
//
//    public void setIsPublished(boolean isPublished) {
//        this.isPublished = isPublished;
//    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}
