package urlshortener.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class Controller {

    private static final Map<String, String> urlMap = new HashMap<>();

    // 1. Long URL to short URL conversion
    // POST /convert/
    // Takes a long URL in request body and returns a short URL
    @PostMapping("/convert")
    public ResponseEntity<String> convertUrl(@RequestBody Map<String, String> request) {
        String longUrl = request.get("url");
        if (longUrl == null || longUrl.isEmpty()) {
            return ResponseEntity.badRequest().body("URL is required");
        }
        String shortUrl = generateShortUrl();
        urlMap.put(shortUrl, longUrl);
        return ResponseEntity.ok(shortUrl);
    }

    // 2. Redirecting
    // GET /{shortUrl}
    // Redirects to the original long URL
    @GetMapping("/{shortUrl}")
    public RedirectView redirect(@PathVariable String shortUrl) {
        String longUrl = urlMap.get(shortUrl);
        if (longUrl != null) {
            return new RedirectView(longUrl);
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
