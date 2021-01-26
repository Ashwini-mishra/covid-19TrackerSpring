
-- Table structure for table `statedata`


DROP TABLE IF EXISTS `statedata`;

CREATE TABLE `statedata` (
  `id` INT  NOT NULL AUTO_INCREMENT,
  `state` VARCHAR(45) NOT NULL,
  `confirmed` VARCHAR(45) NOT NULL,
  `death` VARCHAR(45)  NOT NULL,
  `active` VARCHAR(45) NOT NULL,
  `recovered` VARCHAR(45)  NOT NULL,
 
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);


 ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;

CREATE TABLE `login` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(64) NOT NULL,
  PRIMARY KEY (`user_id`)
);

ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Table structure for table `login2` login with token
--

DROP TABLE IF EXISTS `login2`;

CREATE TABLE `login2` (
  `user_Id` int NOT NULL AUTO_INCREMENT,
  `userName` varchar(100) NOT NULL,
  `tokan` varchar(265) NOT NULL,
  `password` varchar(100) NOT NULL,
  `timeStamp` timestamp(6) NOT NULL,
  PRIMARY KEY (`user_Id`)
)