# accounts_info_webservice
Spring boot application.

Requirements:
- Postgres database installed.
- MS-SQL database installed.
- Credentials for connection to database to be configured in application.properties
	spring.datasource.username, spring.datasource.password
- Configure JDBC url for database connection spring.datasource.url
- Running instance of database with created schema 'test_schema' and created function 'get_accounts()'