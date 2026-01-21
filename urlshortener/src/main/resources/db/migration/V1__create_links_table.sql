CREATE TABLE links (
    shorturl VARCHAR(8) PRIMARY KEY,
    originalurl TEXT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT now()
);

