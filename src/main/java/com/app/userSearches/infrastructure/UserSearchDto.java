package com.app.userSearches.infrastructure;

public class UserSearchDto {
    private Long id;
    private String userId;
    private String searchDate;
    private String destinationId;

    // Empty constructor
    public UserSearchDto() {
    }

    // Constructor with parameters
    public UserSearchDto(Long id, String userId, String searchDate, String destinationId) {
        this.id = id;
        this.userId = userId;
        this.searchDate = searchDate;
        this.destinationId = destinationId;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String geSearchDate() {
        return searchDate;
    }

    public void seSearchDate(String searchDate) {
        this.searchDate = searchDate;
    }

    public String getDestinationId() {
        return this.destinationId;
    }

    public void setDestinationId(String destinationId) {
        this.destinationId = destinationId;
    }

    // toString() method
    @Override
    public String toString() {
        return "UserSearchDto{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", searchDate='" + searchDate + '\'' +
                ", destinationId='" + destinationId + '\'' +
                '}';
    }
}
