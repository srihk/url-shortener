CREATE TABLE links (
    shortUrl VARCHAR(8) PRIMARY KEY,
    originalUrl TEXT NOT NULL,
    createdAt TIMESTAMP NOT NULL DEFAULT now()
);
