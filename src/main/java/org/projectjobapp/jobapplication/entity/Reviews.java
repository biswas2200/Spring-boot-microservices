package org.projectjobapp.jobapplication.entity;


import jakarta.persistence.*;

@Entity
public class Reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;
    private String name;
    private String description;
    private Double rating;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    public Reviews() {
    }

    public Reviews(Long reviewId, String name, String description, Double rating, Company company) {
        this.reviewId = reviewId;
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.company = company;
    }

    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }


    @Override
    public String toString() {
        return "Reviews{" +
                "reviewId=" + reviewId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                ", company=" + (company != null ? company.getCompanyName() : "null") +
                '}';
    }
}
