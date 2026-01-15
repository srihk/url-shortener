package urlshortener.urlshortener;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.sql.Date;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
public class Controller {

    private final LinksRepository linksRepository;
    public Controller(LinksRepository linksRepository) {
        this.linksRepository = linksRepository;
    }

    // 1. Long URL to short URL conversion
    // POST /convert/
    // Takes a long URL in request body and returns a short URL
    @PostMapping("/convert")
    public ResponseEntity<String> convertUrl(@RequestBody Map<String, String> request) {
        String originalUrl = request.get("url");
        if (originalUrl == null || originalUrl.isEmpty()) {
            return ResponseEntity.badRequest().body("URL is required");
        }
        String shortUrl = generateShortUrl();
        linksRepository.save(new Link(shortUrl, originalUrl, new Date(System.currentTimeMillis())));
        java.util.List<Link> links = linksRepository.findAll();
        return ResponseEntity.ok(links.toString());
    }

    // 2. Redirecting
    // GET /{shortUrl}
    // Redirects to the original long URL
    @GetMapping("/{shortUrl}")
    public RedirectView redirect(@PathVariable String shortUrl) {
        Optional<Link> link = linksRepository.findByShortUrl(shortUrl);
        if (link.isPresent()) {
            return new RedirectView(link.get().getOriginalUrl());
        } else {
            // Handle not found, perhaps redirect to a 404 page or return error
            return new RedirectView("/not-found"); // Assuming a not-found endpoint
        }
    }

    private String generateShortUrl() {
        // Simple generation using UUID, take first 8 characters
        return UUID.randomUUID().toString().substring(0, 8);
    }
}
