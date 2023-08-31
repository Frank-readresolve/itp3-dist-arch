# Database privileges

By default on our apps we have an admin user on our database, who is a superuser and has all rights.

However for security reasons we must apply the principle of least privilege: a user or an entity should only have access to the specific data, resources and applications needed to complete a required task.

For a project, the user who enters data into a table might not have the right to drop this table or to create another one.
Also, if within a database we have several other databases, we don't want every user to be able to access all databases. Only the specific database that they must work on.

There are different kinds of privileges: SELECT, INSERT, UPDATE, DELETE, TRUNCATE, REFERENCES, TRIGGER, CREATE, CONNECT, TEMPORARY, EXECUTE, USAGE, SET and ALTER SYSTEM. The privileges applicable to a particular object vary depending on the object's type (table, function, etc.).

## Default privileges and public schema

### Default privileges

**Ownership:**
The right to modify or destroy an object is inherent in being the object's owner, and cannot be granted or revoked in itself. However, like all privileges, that right can be inherited by members of the owning role.

### Public schema

The public schema has particular protections. In order to override them, use:

`GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA public TO username;` (be careful to choose the privileges that apply in your context).

## How to grant database privileges

### Before granting database privileges, create a role or a user

[Create a role - official Postgresql doc](https://www.postgresql.org/docs/current/sql-createrole.html)
[Create a user - official Postgresql doc](https://www.postgresql.org/docs/8.0/sql-createuser.html)

`CREATE USER username WITH PASSWORD 'password';`

### Grant the user the right privileges

[Privileges - official Postgresql doc](https://www.postgresql.org/docs/current/ddl-priv.html)

Examples:

`GRANT SELECT, INSERT, UPDATE, DELETE ON TABLE table_name TO username;` grant privileges on a table.
`GRANT USAGE, SELECT, INSERT, UPDATE, DELETE ON SEQUENCE table_name_id_seq TO username;` grant privileges on a sequence on a table.

`GRANT ALL ON DATABASE database_name TO username;` grant all privileges on a database. Not on public schema unless specified though.
`GRANT SELECT, INSERT, UPDATE, DELETE ON DATABASE database_name TO username;` grant specific privileges on a table. Not on public schema unless specified though.

`GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA schema_name TO username;` grant specific privileges on all tables in a schema.
`GRANT USAGE, SELECT ON ALL SEQUENCES IN SCHEMA schema_name TO username;` grant specific privileges on all sequences in a schema.

**Sequences** are sequence number generators. Having the serial type on a table automatically creates a sequence for instance, with a sequence table. In order to be able to change a row of a table with a serial type on it, a user must also have access to the sequence table associated to this table.

### Revoking privileges

[Revoke - official Postgresql doc](https://www.postgresql.org/docs/current/sql-revoke.html)

REVOKE ALL ON accounts FROM PUBLIC;

Ordinarily, only the object's owner (or a superuser) can grant or revoke privileges on an object. However, it is possible to grant a privilege “with grant option”, which gives the recipient the right to grant it in turn to others.

### Connect to a specific database with a user

`psql -d database -U username`
