--liquibase formatted sql

--changeset pnowacki:populate_muscle_parts
insert into muscle_part (name)
values ('CALF'),
       ('QUAD'),
       ('HAMSTRING'),
       ('GLUTES'),
       ('ABS'),
       ('BACK_EXTENSORS'),
       ('LATS'),
       ('CHEST'),
       ('FRONT_DELT'),
       ('SIDE_DELT'),
       ('REAR_DELT'),
       ('BICEPS'),
       ('TRICEPS'),
       ('FOREARM');

--changeset pnowacki:populate_resistance_tools
insert into resistance_tool (name)
values ('DUMBBELL'),
       ('BARBELL'),
       ('DOUBLE_DUMBBELLS'),
       ('RESISTANCE_BAND'),
       ('WEIGHT_BELT'),
       ('NONE');

-- changeset pnowacki:populate_exercise_types
INSERT INTO exercise_type (id, name, description)
VALUES
    (1, 'COMPOUND', 'Engages multiple joints and muscles.'),
    (2, 'ISOLATED', 'Targets a single muscle group.'),
    (3, 'STATIC', 'Requires holding a position.'),
    (4, 'STRENGTH', 'Focuses on building strength.'),
    (5, 'ENDURANCE', 'Improves muscular endurance.'),
    (6, 'HYPERTROPHY', 'Aims to increase muscle size.'),
    (7, 'MOBILITY', 'Enhances flexibility and movement.'),
    (8, 'FREE_WEIGHT', 'Uses free weights as resistance.'),
    (9, 'BODY_WEIGHT', 'Relies on body weight for resistance.');

-- changeset pnowacki:populate_exercises
INSERT INTO exercise (id, name, description, intensity)
VALUES
    (1, 'PUSH_UP', 'Body weight exercise targeting chest, shoulders, and triceps.', 6),
    (2, 'PULL_UP', 'Body weight exercise for upper back and biceps.', 8),
    (3, 'SQUAT', 'Body weight or weighted exercise for lower body.', 9),
    (4, 'DEADLIFT', 'Free weight exercise for posterior chain.', 9),
    (5, 'OVERHEAD_PRESS', 'Free weight exercise targeting shoulders and triceps.', 7),
    (6, 'LUNGE', 'Unilateral leg exercise with bodyweight or weights.', 6),
    (7, 'HIP_BRIDGE', 'Body weight exercise to strengthen glutes and lower back.', 4),
    (8, 'SHOULDER_DISLOCATES', 'Mobility exercise to improve shoulder flexibility.', 2),
    (9, 'BICEP_CURL', 'Free weight exercise for biceps', 6),
    (10, 'BULGARIAN_SQUAT', 'Free weight exercise for lower body', 10);

-- changeset pnowacki:populate_exercises_types
INSERT INTO exercises_types (exercise_id, exercise_type_id)
VALUES
    -- Push-Up
    (1, 9),  -- Bodyweight
    (1, 1),  -- Compound
    (1, 6),  -- Hypertrophy

    -- Pull-Up
    (2, 9),  -- Bodyweight
    (2, 1),  -- Compound
    (2, 6),  -- Hypertrophy

    -- Squat
    (3, 9),  -- Bodyweight
    (3, 1),  -- Compound
    (3, 8),  -- Free Weight
    (3, 6),  -- Hypertrophy

    -- Deadlift
    (4, 8),  -- Free Weight
    (4, 1),  -- Compound
    (4, 4),  -- Strength

    -- Overhead Press
    (5, 8),  -- Free Weight
    (5, 1),  -- Compound
    (5, 4),  -- Strength
    (5, 6),  -- Hypertrophy

    -- Lunge
    (6, 9),  -- Bodyweight
    (6, 8),  -- Free Weight
    (6, 1),  -- Compound
    (6, 6),  -- Hypertrophy

    -- Hip Bridge
    (7, 9),  -- Bodyweight
    (7, 3),  -- Static
    (7, 6),  -- Hypertrophy

    -- Shoulder Dislocates
    (8, 7),  -- Mobility
    (8, 3),  -- Static

    -- Bicep curl
    (9, 8),  -- Free Weight
    (9, 3),  -- Static
    (9, 6),  -- Hypertrophy

    -- Bulgarian squat
    (10, 6),  -- Hypertrophy
    (10, 8),  -- Free Weight
    (10, 6)   -- Hypertrophy
    ;