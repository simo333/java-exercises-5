CREATE TABLE `user_group` (
  `id` int(11) NOT NULL,
  `name` varchar(255) COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

ALTER TABLE `user_group`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `user_group`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

CREATE TABLE `exercises` (
                              `id` int(11) PRIMARY KEY NOT NULL,
                              `title` varchar(255) COLLATE utf8_polish_ci NOT NULL,
                              `description` varchar(255) COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

CREATE TABLE `users` (
                             `id` int(11) PRIMARY KEY NOT NULL,
                             `username` varchar(255) COLLATE utf8_polish_ci NOT NULL,
                             `created` DATETIME COLLATE utf8_polish_ci NOT NULL,
                             `group_id` int(11) NOT NULL,
                             FOREIGN KEY (group_id) REFERENCES user_group(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;