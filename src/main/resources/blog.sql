CREATE TABLE blog
(
  id INT(20) AUTO_INCREMENT COMMENT 'id'
    PRIMARY KEY ,
  create_time VARCHAR(60) NULL COMMENT '创建时间' ,
  title VARCHAR(60) NULL COMMENT '文章标题' ,
  content VARCHAR(60) NULL COMMENT '内容' ,
  status INT(20) NULL COMMENT '是否被举报，是否被禁止' ,
  CONSTRAINT blog_id_uindex
  UNIQUE (id)
)
  COMMENT 'blog' ENGINE = InnoDB;

CREATE TABLE blog_comment
(
  id INT(20) AUTO_INCREMENT COMMENT 'id'
    PRIMARY KEY ,
  blog_id INT(20) NULL COMMENT '文章表主键' ,
  comment_id INT(20) NULL COMMENT '评论表主键' ,
  CONSTRAINT blog_comment_id_uindex
  UNIQUE (id)
)
  COMMENT 'comment' ENGINE = InnoDB;

CREATE TABLE blog_sort
(
  id INT(20) AUTO_INCREMENT
    PRIMARY KEY ,
  blog_id INT(20) NULL COMMENT '文章表主键' ,
  sort_id INT(20) NULL COMMENT '分类表主键' ,
  CONSTRAINT blog_sort_id_uindex
  UNIQUE (id)
)
  ENGINE = InnoDB;

CREATE TABLE blog_user
(
  id INT(20) UNSIGNED AUTO_INCREMENT COMMENT 'id'
    PRIMARY KEY ,
  blog_id INT(20) NULL COMMENT '文章主键' ,
  user_id INT(20) NULL COMMENT '用户主键' ,
  status INT(20) NULL COMMENT '赞/踩/'
)
  COMMENT 'blog_status' ENGINE = InnoDB;

CREATE TABLE comment
(
  id INT(20) AUTO_INCREMENT
    PRIMARY KEY ,
  create_time VARCHAR(60) NULL COMMENT '创建时间' ,
  content VARCHAR(60) NULL COMMENT '内容' ,
  status INT(20) NULL COMMENT '状态  被举报/点赞' ,
  parent_id INT(20) NULL COMMENT '树状显示用到的父级评论' ,
  CONSTRAINT comment_id_uindex
  UNIQUE (id)
)
  ENGINE = InnoDB;

CREATE TABLE comment_user
(
  id INT(20) AUTO_INCREMENT
    PRIMARY KEY ,
  comment_id INT(20) NULL COMMENT '评论主键' ,
  user_id INT(20) NULL COMMENT '用户主键' ,
  status INT(20) NULL COMMENT '评论状态  赞/被举报' ,
  CONSTRAINT user_comment_id_uindex
  UNIQUE (id)
)
  ENGINE = InnoDB;

CREATE TABLE notice
(
  id INT(20) AUTO_INCREMENT
    PRIMARY KEY ,
  create_time VARCHAR(60) NULL ,
  msg VARCHAR(60) NULL ,
  status INT(20) NULL ,
  CONSTRAINT public_message_id_uindex
  UNIQUE (id)
)
  ENGINE = InnoDB;

CREATE TABLE permission
(
  id INT(20) UNSIGNED AUTO_INCREMENT COMMENT 'id'
    PRIMARY KEY ,
  permission_name VARCHAR(60) NULL COMMENT 'permissionName'
)
  COMMENT 'permission' ENGINE = InnoDB;

CREATE TABLE role
(
  id INT(20) UNSIGNED AUTO_INCREMENT COMMENT 'id'
    PRIMARY KEY ,
  role_name VARCHAR(60) NULL COMMENT 'roleName'
)
  COMMENT 'role' ENGINE = InnoDB;

CREATE TABLE role_permission
(
  id INT(20) UNSIGNED AUTO_INCREMENT COMMENT 'id'
    PRIMARY KEY ,
  role_id INT(20) NULL COMMENT 'roleId' ,
  permission_id INT(20) NULL COMMENT 'permissionId'
)
  COMMENT 'role_permission' ENGINE = InnoDB;

CREATE TABLE sort
(
  id INT(20) UNSIGNED AUTO_INCREMENT COMMENT '主键'
    PRIMARY KEY ,
  sort_name VARCHAR(60) NULL COMMENT '分类名'
)
  COMMENT 'sort' ENGINE = InnoDB;

CREATE TABLE user
(
  id INT(20) AUTO_INCREMENT COMMENT 'id'
    PRIMARY KEY ,
  username VARCHAR(60) NULL COMMENT 'username' ,
  password VARCHAR(60) NULL COMMENT 'password' ,
  email VARCHAR(60) NULL COMMENT 'email' ,
  mobile VARCHAR(60) NULL COMMENT 'mobile' ,
  sex INT(20) NULL COMMENT 'sex' ,
  description VARCHAR(60) NULL COMMENT 'description' ,
  img_url VARCHAR(60) NULL COMMENT 'imgUrl' ,
  country VARCHAR(60) NULL COMMENT 'country' ,
  birthday VARCHAR(60) NULL COMMENT 'birthday' ,
  CONSTRAINT user_email_uindex
  UNIQUE (email)
)
  COMMENT 'user' ENGINE = InnoDB;

CREATE TABLE user_fan
(
  id INT(20) AUTO_INCREMENT
    PRIMARY KEY ,
  user_id INT(20) NULL COMMENT '用户id' ,
  fan_id INT(20) NULL COMMENT '粉丝id' ,
  CONSTRAINT user_fan_id_uindex
  UNIQUE (id)
)
  ENGINE = InnoDB;

CREATE TABLE user_focus
(
  id INT(20) AUTO_INCREMENT COMMENT '主键'
    PRIMARY KEY ,
  user_id INT(20) NULL COMMENT '用户id' ,
  focus_id INT(20) NULL COMMENT '关注人的id' ,
  CONSTRAINT user_focus_id_uindex
  UNIQUE (id)
)
  ENGINE = InnoDB;

CREATE TABLE user_role
(
  id INT(20) AUTO_INCREMENT COMMENT 'id'
    PRIMARY KEY ,
  user_id INT(20) NULL COMMENT 'userId' ,
  role_id INT(20) NULL COMMENT 'roleId' ,
  CONSTRAINT user_role_id_uindex
  UNIQUE (id)
)
  COMMENT 'user_role' ENGINE = InnoDB;

