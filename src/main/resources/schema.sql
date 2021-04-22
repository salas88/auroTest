CREATE TABLE IF NOT EXISTS `auroTest`.`kpac`(
    `id` INT NOT NULL AUTO_INCREMENT,
    `title` VARCHAR(250) NOT NULL,
    `description` VARCHAR(2000) NOT NULL,
    `createdAt` TIMESTAMP NOT NULL,
    PRIMARY KEY (`id`)
    );


CREATE TABLE IF NOT EXISTS `auroTest`.`set_entity`(
    `id` INT NOT NULL AUTO_INCREMENT,
    `title` VARCHAR(250) NOT NULL,
    PRIMARY KEY (`id`)
    );

CREATE TABLE IF NOT EXISTS `auroTest`.`set_kpacs`(
    `id_kpac` INT,
    `id_set_entity` INT,
    FOREIGN KEY (`id_kpac`) REFERENCES `kpac`(`id`),
    FOREIGN KEY (`id_set_entity`) REFERENCES `set_entity`(`id`)
);


