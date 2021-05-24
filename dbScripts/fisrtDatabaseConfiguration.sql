CREATE DATABASE IF NOT EXISTS `equationSolverDB`;

USE `equationSolverDB`;

CREATE TABLE IF NOT EXISTS `results` (
    `id` int(11) NOT NULL auto_increment,
    `coefficienta` int(11) NOT NULL,
    `coefficientb` int(11) NOT NULL,
    `coefficientc` int(11) NOT NULL,
    `discriminant` DOUBLE(40,2) NOT NULL,
    `firstroot` varchar(100),
    `secondroot` varchar(100),
    `validequation` BOOLEAN,
    `logtime` varchar(100) NOT NULL,
    PRIMARY KEY  (`id`)
);

