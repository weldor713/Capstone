package com.aegis.cms.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//@Entity
//@Table(name = "post")
public class Post implements Serializable {

//    @Id
//    @GeneratedValue
//    @Column(name = "post_id")
    private int postId;
//    @Column(name = "title")
    private String title;
//    @Column(name = "body")
    private String body;

//    private User author;
//    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
//    @JoinTable(name = "post_tag",
//            joinColumns = {
//                @JoinColumn(name = "post_id")},
//            inverseJoinColumns = {
//                @JoinColumn(name = "tag_id")})
    //@JsonManagedReference
    private Set<Tag> tags;

//    @Temporal(value = TemporalType.DATE)
//    @Column(name = "postDate")
    private Date postDate;

//    @Temporal(value = TemporalType.DATE)
//    @Column(name = "expiration")
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
    public void setTags(Set<Tag> tagSet){
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
            tempTag.setTagName(tempArray[i]);
            tagSet.add(tempTag);
        }
        this.tags.addAll(tagSet);
//        //tags = tagSet;
    }

//    public void setTags(String g) {
//        Tag gg = new Tag();
//        gg.setTagName(g);
//        this.tags.add(gg);
//        
//    }
    /*
     public void setTags(Set<Tag> tagnames) {
     this.tags = tagnames;
     Set<Tag> tagSet = new HashSet<>();
     String[] tempArray = tagnames.split(",");
     for(int i = 0; i < tempArray.length; i++){
     Tag tempTag = new Tag();
     tempTag.setTagName(tempArray[i]);
     tagSet.add(tempTag);
     }
     this.tags.addAll(tagSet);
     //tags = tagSet;
     }
     */
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
}
