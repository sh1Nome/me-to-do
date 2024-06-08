DROP TABLE IF EXISTS user_setting;

CREATE TABLE user_setting (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    user_id INT UNSIGNED NOT NULL,
    kanban_flg CHAR(1) DEFAULT 'N' NOT NULL,
    PRIMARY KEY(id)
);