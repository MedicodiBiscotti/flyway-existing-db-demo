# Flyway demo for existing DB

This is a test to see how Flyway works with an existing DB.

If we already have a DB with a table, and then add Flyway to the project, how will it behave? How can we bring the DB up
to date with the current migration.

Will need to use baseline to initialize the migration history table.

Baseline version should be the current migration script that the DB is at.
