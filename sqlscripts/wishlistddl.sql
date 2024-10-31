drop database if exists wishlist;
create database if not exists wishlist;
use wishlist;

create table tag(tag_name varChar(255) NOT NULL, tag_id INT AUTO_INCREMENT PRIMARY KEY);

create table role(role_id int auto_increment primary key), name varChar(255);

create table user(name varChar(255),
user_id int PRIMARY KEY);

create table user_role(user_id int , role_id int,
PRIMARY KEY (user_id, role_id),
FOREIGN KEY (user_id) REFERENCES user(user_id),
FOREIGN KEY (role_id) REFERENCES role(role_id));

create table wishlist(wishlist_name varChar(255) NOT NULL,
wishlist_id INT auto_increment PRIMARY KEY, user_id int, role_id int,
FOREIGN KEY (user_id, role_id) REFERENCES user_role(user_id, role_id));

create table wish(wish_name varChar(255) NOT NULL, description varChar(255), price INT, wishlist_id INT, role_id INT, user_id int,
wish_id INT AUTO_INCREMENT PRIMARY KEY,
FOREIGN KEY (user_id, role_id) REFERENCES user_role(user_id, role_id),
FOREIGN KEY (wishlist_id) REFERENCES wishlist(wishlist_id));

create table wish_tag(tag_id int , wish_id int,
PRIMARY KEY (tag_id, wish_id),
FOREIGN KEY (tag_id) REFERENCES tag(tag_id),
FOREIGN KEY (wish_id) REFERENCES wish(wish_id));



