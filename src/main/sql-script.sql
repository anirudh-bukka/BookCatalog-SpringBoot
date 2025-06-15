DROP SCHEMA IF EXISTS `bookstore_one`;

CREATE SCHEMA `bookstore_one`;

use `bookstore_one`;

SET FOREIGN_KEY_CHECKS = 0;

CREATE TABLE `author_detail` (
	`id` int NOT NULL AUTO_INCREMENT,
    `youtube_channel` varchar(128) DEFAULT NULL,
    `hobby` varchar(64) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `author` (
	`id` int NOT NULL AUTO_INCREMENT,
    `first_name` varchar(32) DEFAULT NULL,
    `last_name` varchar(32) DEFAULT NULL,
    `email` varchar(64) DEFAULT NULL,
    `author_detail_id` int DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `FK_DETAIL_idx` (`author_detail_id`),
    CONSTRAINT `FK_DETAIL` FOREIGN KEY (`author_detail_id`) REFERENCES `author_detail` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `book` (
	`id` int NOT NULL AUTO_INCREMENT,
    `title` varchar(32) DEFAULT NULL,
    `author_id` int DEFAULT NULL,
    `price` int DEFAULT NULL,
    `genre` varchar(16) DEFAULT NULL,
    `quantity` int DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `TITLE_UNIQUE` (`title`),
    KEY `FK_AUTHOR_idx` (`author_id`),
    CONSTRAINT `FK_AUTHOR` FOREIGN KEY (`author_id`) REFERENCES `author` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `reader` (
	`id` int NOT NULL AUTO_INCREMENT,
    `first_name` varchar(32) DEFAULT NULL,
    `last_name` varchar(32) DEFAULT NULL,
    `email` varchar(64) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `review` (
	`id` int NOT NULL AUTO_INCREMENT,
    `review` varchar(128) DEFAULT NULL,
    `book_id` int DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `FK_BOOK_idx` (`book_id`),
    CONSTRAINT `FK_BOOK` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `book_reader` (
	`book_id` int NOT NULL,
    `reader_id` int NOT NULL,

    PRIMARY KEY (`book_id`, `reader_id`),

    KEY `FK_READER_idx` (`reader_id`),

    CONSTRAINT `FK_BOOK_ONE` FOREIGN KEY (`book_id`) REFERENCES `book` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT `FK_READER_ONE` FOREIGN KEY (`reader_id`) REFERENCES `reader` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION

) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;