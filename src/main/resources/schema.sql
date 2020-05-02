CREATE TABLE IF NOT EXISTS student (
    task_id int(5) NOT NULL AUTO_INCREMENT,
    task_name varchar(50) DEFAULT NULL,
    task_desc varchar(50) DEFAULT NULL,
    task_due varchar(50) DEFAULT NULL,
    task_create varchar(50) DEFAULT NULL,
    task_creator varchar(50) DEFAULT NULL,
    task_status varchar(50) DEFAULT NULL,
    PRIMARY KEY(task_id)
    );