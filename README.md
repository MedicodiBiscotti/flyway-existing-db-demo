# Flyway demo for existing DB

This is a test to see how Flyway works with an existing DB.

If we already have a DB with a table, and then add Flyway to the project, how will it behave? How can we bring the DB up
to date with the current migration.

Will need to use baseline to initialize the migration history table.

Baseline version should be the current migration script that the DB is at.

## What happens if the schema doesn't even exist?

Flyway can create the schemas automatically, but it needs to be told which schemas in configuration.

Schema can then either be hard-coded as part of the application's config, or hidden in `.env` / environment variables.

It can create and manage multiple schemas, but it can only migrate one at a time.

It doesn't make sense for the production config to also create a test database, so we'd probably have just the one
schema in each config, and then have a separate config for the test database.

Trouble is that `flyway.url` defaults to `datasource.url` which includes the schema that doesn't exist yet, so
connection fails. We then have to override `flyway.url` to remove the schema. When we do that, Flyway then also changes
the credentials, so we have to provide them also.

For a total of:

```properties
spring.datasource.url=${DB_URL}/flyway_existing_db_demo
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
spring.flyway.url=${DB_URL}
spring.flyway.user=${DB_USERNAME}
spring.flyway.password=${DB_PASSWORD}
spring.flyway.schemas=flyway_existing_db_demo
```

It would be nice if `datasource.url` could be used as the default for `flyway.url`, but with the schema removed, or
if `datasource.url` didn't need schema, and it could be provided separately.
This doesn't seem possible. `spring.jpa.properties.hibernate.default_schema` didn't work.
