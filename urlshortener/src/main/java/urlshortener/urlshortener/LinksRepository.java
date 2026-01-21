package urlshortener.urlshortener;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LinksRepository extends JpaRepository<Link, Long> {
    java.util.Optional<Link> findByShortUrl(String shortUrl);
}
