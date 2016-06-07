DROP TABLE IF EXISTS points;
DROP TABLE IF EXISTS userspoints;
DROP SEQUENCE IF EXISTS global_seq_points;
CREATE SEQUENCE global_seq_points START 100000;

CREATE TABLE points (
  id     INTEGER PRIMARY KEY DEFAULT nextval('global_seq_points'),
  name   VARCHAR NOT NULL,
  coords VARCHAR NOT NULL
);
