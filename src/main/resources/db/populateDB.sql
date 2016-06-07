ALTER SEQUENCE global_seq_points RESTART WITH 100000;
DELETE FROM points;

INSERT INTO points (name, coords) VALUES
  ('point-1', '(59.943233, 30.501555999999937)'),
  ('point-2', '(59.934280, 30.335098600000038)');
