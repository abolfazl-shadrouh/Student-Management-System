# Base44 Setup Notes

## What this is
A single-file **Java console (CLI) application** (`StudentManager.java`). It uses `Scanner` for stdin interaction — there is no web server, no HTTP endpoint, and no UI. It cannot render in the browser preview (which expects a web server on port 3000).

## How it runs
- Docker Compose (`docker-compose.base44.yml`) uses `eclipse-temurin:21-jdk`, bind-mounts the repo at `/app`, compiles `StudentManager.java` on startup, then sleeps to keep the container alive.
- The healthcheck confirms the `.class` file exists after compilation.

## Verifying it works
```bash
# Compile check
docker compose -f docker-compose.base44.yml exec -T app sh -c 'test -f /app/StudentManager.class && echo OK'

# Run with piped input (add two students, list, exit)
printf '1\nAlice\n90\n85\n1\nBob\n70\n80\n2\n3\n' | docker compose -f docker-compose.base44.yml exec -T app java StudentManager
```

## No external credentials needed
The app is self-contained — no databases, APIs, or external services.
