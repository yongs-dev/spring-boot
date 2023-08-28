create table if not exists users (
                       username varchar(50) not null primary key,
                       password varchar(500) not null,
                       enabled boolean not null
);

create table if not exists authorities (
                             username varchar(50) not null,
                             authority varchar(50) not null,
                             foreign key (username) references users(username),
                             unique key ix_auth_username (username, authority)
);