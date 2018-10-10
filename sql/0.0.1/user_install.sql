CREATE TABLE `homebudget`.`user` (
  `id` INT NOT NULL,
  `login` VARCHAR(64) NOT NULL,
  `password` VARCHAR(64) NOT NULL,
  `email` VARCHAR(256) NOT NULL,
  PRIMARY KEY (`id`));
  
  