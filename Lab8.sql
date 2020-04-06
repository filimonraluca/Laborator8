create database if not exists MusicAlbum;

use MusicAlbum;

drop table if exists albums;
drop table if exists artists;

CREATE TABLE IF NOT EXISTS  artists(
id int not null auto_increment,
name varchar(100) not null,
country varchar(100),
primary key (id)
) engine=InnoDB auto_increment=1 default charset=latin1;


CREATE TABLE IF NOT EXISTS  albums(
id int not null auto_increment,
name varchar(100) not null,
artist_id int not null,
release_year int,
primary key (id),
FOREIGN KEY (artist_id)
        REFERENCES artists (id)
        ON UPDATE RESTRICT ON DELETE CASCADE
) engine=InnoDB auto_increment=1 default charset=latin1;