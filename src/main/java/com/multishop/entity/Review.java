package com.multishop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "reviews")
@Getter
@Setter
public class Review extends Base {
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
    
	@ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;

	@Column(name = "rating")
    private Integer rating;
	
	@Lob
	@Column(name = "comment", columnDefinition = "TEXT")
    private String comment;
	
	@Column(name = "video_url")
	private String videoUrl;
	
	@Lob
	@Column(name = "image_urls", columnDefinition = "TEXT")
	private String imageUrls;
	
	@Column(name = "is_approved")
	private Boolean isApproved; // Co the can admin duyet
	
	@Column(name = "helpful_votes")
	private Integer helpfulVotes; // so luong vote tot
	
	@Column(name = "unhelpful_votes")
	private Integer unhelpfulVotes; // so luong vote xau 
	
}

