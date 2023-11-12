
CREATE TABLE user (
                      id bigint AUTO_INCREMENT PRIMARY KEY,
                      username VARCHAR(50) NOT NULL,
                      password VARCHAR(50) NOT NULL,
                      avatar VARCHAR(250),
                      gmt_create datetime,
                      gmt_modified datetime,
                      is_deleted char
);