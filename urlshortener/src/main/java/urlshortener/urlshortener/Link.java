package urlshortener.urlshortener;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "links")
public class Link {
    @Id
    @Column(name = "shortUrl", length = 8)
    private String shortUrl;

    @Column(name = "originalUrl", nullable = false)
    private String originalUrl;

    @Column(name = "createdAt", nullable = false)
    private Date createdAt;

    public Link() {}

    public Link(String shortUrl, String originalUrl, Date createdAt) {
        this.shortUrl = shortUrl;
        this.originalUrl = originalUrl;
        this.createdAt = createdAt;
    }

    // Getters and Setters
    public String getshortUrl() {
        return shortUrl;
    }

    public void setshortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String toString() {
        return "Link{shortUrl='" + shortUrl + "', originalUrl='" + originalUrl + "', createdAt=" + createdAt + "}";
    }
}
