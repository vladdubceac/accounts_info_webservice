-- POSTGRES
insert into test_schema.accounts(account_number,balance,currency,operation_date)
values('test1',100.19,'EUR',now());
insert into test_schema.accounts(account_number,balance,currency,operation_date)
values('test2',120.50,'USD',now());
insert into test_schema.accounts(account_number,balance,currency,operation_date)
values('test3',2000.45,'MDL',now());
insert into test_schema.accounts(account_number,balance,currency,operation_date)
values('test4',3000.14,'RUR',now());
insert into test_schema.accounts(account_number,balance,currency,operation_date)
values('test5',1159.58,'RON',now());

-- MS-SQL
-- insert into test_schema.accounts(account_number,balance,currency,operation_date)
-- values('test1',100.19,'EUR',(select sysdatetime()));
-- insert into test_schema.accounts(account_number,balance,currency,operation_date)
-- values('test2',120.50,'USD',(select sysdatetime()));
-- insert into test_schema.accounts(account_number,balance,currency,operation_date)
-- values('test3',2000.45,'MDL',(select sysdatetime()));
-- insert into test_schema.accounts(account_number,balance,currency,operation_date)
-- values('test4',3000.14,'RUR',(select sysdatetime()));
-- insert into test_schema.accounts(account_number,balance,currency,operation_date)
-- values('test5',1159.58,'RON',(select sysdatetime()));