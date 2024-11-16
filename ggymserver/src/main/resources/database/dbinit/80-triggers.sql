--liquibase formatted sql

--changeset pnowacki:update_modified_column_function
CREATE OR REPLACE FUNCTION update_modified_column()
    RETURNS trigger AS
'
    BEGIN
        NEW.modified := current_timestamp;
        RETURN NEW;
    END;
' LANGUAGE plpgsql;

--changeset pnowacki:update_modified_column_triggers
DO '
DECLARE
    tbl RECORD;
BEGIN
FOR tbl IN
    SELECT table_name
    FROM information_schema.columns
    WHERE column_name = ''modified''
        AND table_schema = ''public''
    LOOP
    EXECUTE format(
        ''CREATE TRIGGER update_modified_trigger
         BEFORE UPDATE ON %I
         FOR EACH ROW
         EXECUTE FUNCTION update_modified_column()'',
        tbl.table_name
        );
    END LOOP;
END;
' LANGUAGE plpgsql;