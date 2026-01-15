# URL Shortener

# Build Instructions

- To build the SpringBoot app jar, run the command: `./mvnw clean package -DskipTests`.
- Update DB username and password in `compose.yaml`.
    - `SPRING_DATASOURCE_USERNAME`
    - `SPRING_DATASOURCE_PASSWORD`
    - `POSTGRES_USER`
    - `POSTGRES_PASSWORD`
- Run `docker compose up`.

# Usage

## Endpoints

- `/convert` (`POST`):
    - Body: `{ 'url': 'original_url' }`
    - Response: short 8 character alphanumeric endpoint.
- Any `GET` endpoint:
    - Response: Redirect to the original URL if mapping is available.
