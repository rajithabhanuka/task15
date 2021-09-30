CREATE TABLE agent
(
    `id`            INT         NOT NULL AUTO_INCREMENT,
    `agent_id`      INT         NOT NULL,
    `user_id`       INT         NOT NULL,
    `active`        VARCHAR(45) NOT NULL,
    `create_date`   DATETIME NULL,
    `modified_date` DATETIME NULL,
    PRIMARY KEY (`id`)
);