# 用户表
CREATE TABLE `user`(
	id BIGINT UNSIGNED NOT NULL PRIMARY key auto_increment COMMENT  '用户基本信息',
	username VARCHAR(20) NOT NULL UNIQUE,
	`password` VARCHAR(255) ,
	`phone` VARCHAR(11),
	`gender` TINYINT UNSIGNED COMMENT  '0：保密，1：男，2：女',
	`gmt_create` DATETIME COMMENT  '创建时间',
	`gmt_modified` DATETIME COMMENT  '修改时间',
	`is_delete` TINYINT UNSIGNED COMMENT  '是否删除 0：未删除，1删除'
);

# 客户端详情
#Drop table if exists oauth_client_details;
create table oauth_client_details (
client_id VARCHAR(255) PRIMARY KEY,
resource_ids VARCHAR(255),
client_secret VARCHAR(255),
scope VARCHAR(255),
authorized_grant_types VARCHAR(255),
web_server_redirect_uri VARCHAR(255),
authorities VARCHAR(255),
access_token_validity INTEGER,
refresh_token_validity INTEGER,
additional_information TEXT,
autoapprove VARCHAR (255) default 'false'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


# 令牌访问信息
#Drop table if exists oauth_access_token;
create table oauth_access_token (
token_id VARCHAR(255),
token BLOB,
authentication_id VARCHAR(255),
user_name VARCHAR(255),
client_id VARCHAR(255),
authentication BLOB,
refresh_token VARCHAR(255)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# 令牌刷新信息
#Drop table if exists oauth_refresh_token;
create table oauth_refresh_token (
token_id VARCHAR(255),
token BLOB,
authentication BLOB
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# 授权码信息
#Drop table if exists oauth_code;
create table oauth_code (
code VARCHAR(255),
authentication BLOB
) ENGINE=InnoDB DEFAULT CHARSET=utf8;