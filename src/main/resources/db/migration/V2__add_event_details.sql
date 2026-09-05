ALTER TABLE events
    ADD COLUMN capacity INTEGER;

ALTER TABLE events
    ADD COLUMN event_date TIMESTAMP;

ALTER TABLE events
    ADD COLUMN status VARCHAR(255);

UPDATE events
SET capacity = 100
WHERE capacity IS NULL;

UPDATE events
SET event_date = CURRENT_TIMESTAMP
WHERE event_date IS NULL;

UPDATE events
SET status = 'DRAFT'
WHERE status IS NULL;

ALTER TABLE events
    ALTER COLUMN capacity SET NOT NULL;

ALTER TABLE events
    ALTER COLUMN event_date SET NOT NULL;

ALTER TABLE events
    ALTER COLUMN status SET NOT NULL;

ALTER TABLE events
    ADD CONSTRAINT chk_event_status
    CHECK (status IN ('DRAFT', 'PUBLISHED', 'CANCELLED'));
