-- POSTGRES
CREATE FUNCTION test_schema.get_accounts()
  RETURNS SETOF test_schema.accounts
LANGUAGE 'sql'
AS $BODY$
select * from test_schema.accounts;
$BODY$;
ALTER FUNCTION test_schema.get_accounts()
  OWNER TO postgres;

-- MS-SQL
-- CREATE FUNCTION test_schema.get_accounts()
--   returns table
--   as
--   return ( select * from test_schema.accounts );