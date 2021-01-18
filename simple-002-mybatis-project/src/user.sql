create table if not exists `mybatis-test`.user
(
    id      int          not null comment 'id' primary key,
    name    varchar(50)  null comment 'name',
    age     int          null comment 'age',
    address varchar(100) null comment 'address'
) charset = utf8mb4;

