DROP DATABASE IF EXISTS `dormitory`;

CREATE DATABASE `dormitory` DEFAULT CHARACTER SET utf8;
USE `dormitory`;

CREATE TABLE `dormitory` (
  `id` INTEGER NOT NULL AUTO_INCREMENT,
  `address` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARACTER SET utf8;

CREATE TABLE `room` (
  `id` INTEGER NOT NULL AUTO_INCREMENT,
  `number` INTEGER NOT NULL,
  `dormitoryID` INTEGER NOT NULL,
  `countFree` INTEGER NOT NULL,
  `gender` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (dormitoryID) REFERENCES dormitory(id)
) ENGINE=INNODB DEFAULT CHARACTER SET utf8;

CREATE TABLE `student` (
  `id` INTEGER NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `surName` VARCHAR(255) NOT NULL,
  `lastName` VARCHAR(255) NOT NULL,
  `course` INTEGER NOT NULL,
  `roomID` INTEGER NOT NULL,
  `gender` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (roomID) REFERENCES room(id)
) ENGINE=INNODB DEFAULT CHARACTER SET utf8;



INSERT INTO `dormitory`
(`id`, `address`)
VALUES
  (1,    "Чкалова 7"),
  (2,    "Чапаева 34"),
  (3,    "Лучеса Крайний переулок д.3");

INSERT INTO `room`
(`id`, `number`, `dormitoryID`, `countFree`, `gender`)
VALUES
  (1, 203, 1, 3, "men"),
  (2, 305, 2, 2, "women"),
  (3, 134, 3, 1, "men");

INSERT INTO `student`
(`id`, `name`, `surName`, `lastName`, `course`, `roomID`, `gender`)
VALUES
  (1, "Олег", "Мымин", "Юрьевич", 4, 1, "men"),
  (2, "Олег", "Мымин", "Юрьевич", 4, 2, "women"),
  (3, "Олег", "Мымин", "Юрьевич", 4, 3, "men");