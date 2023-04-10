-- POSTGRES
CREATE schema if not exists test_schema;

-- MS-SQL
-- IF NOT EXISTS (SELECT * FROM sys.schemas WHERE name = 'test_schema')
-- BEGIN
--     EXEC('CREATE SCHEMA test_schema')
-- END;
