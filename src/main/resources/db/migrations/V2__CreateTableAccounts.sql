-- POSTGRES
CREATE TABLE test_schema.accounts
(
    id bigserial PRIMARY KEY NOT NULL,
    account_number varchar(255) NOT NULL,
    balance numeric(19,2) NOT NULL,
    currency varchar(128),
    operation_date timestamp NOT NULL
);

-- MS-SQL
-- CREATE TABLE test_schema.accounts
-- (
--     id bigint PRIMARY KEY NOT NULL IDENTITY,
--     account_number varchar(255) NOT NULL,
--     balance decimal (19,2) NOT NULL,
--     currency VARCHAR(128) NOT NULL,
--     operation_date datetime
-- )

