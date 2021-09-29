CREATE SCHEMA `task15`;

CREATE TABLE `task15`.`agent`
(
    `id`            INT         NOT NULL AUTO_INCREMENT,
    `agent_id`      INT         NOT NULL,
    `user_id`       INT         NOT NULL,
    `active`        VARCHAR(45) NOT NULL,
    `create_date`   DATETIME NULL,
    `modified_date` DATETIME NULL,
    PRIMARY KEY (`id`)
);

INSERT INTO `task15`.`agent` (`id`, `agent_id`, `user_id`, `active`, `create_date`, `modified_date`)
VALUES ('1', '1', '1', 'Success', '2021-09-28', '2021-09-28');
INSERT INTO `task15`.`agent` (`id`, `agent_id`, `user_id`, `active`, `create_date`, `modified_date`)
VALUES ('2', '2', '2', 'Pending', '2021-09-29', '2021-09-29');
