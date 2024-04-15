CREATE TABLE IF NOT EXISTS `Users`(
   `user_id` UUID DEFAULT random_uuid() PRIMARY KEY,
  `login_id` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255)  NOT NULL,
  `security_role` VARCHAR(255)  NOT NULL,
  `first_name` VARCHAR(255) NOT NULL,
  `last_name` VARCHAR(255) NOT NULL,
  `email_address` VARCHAR(255) NOT NULL
);
