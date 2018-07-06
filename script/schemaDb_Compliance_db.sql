--
-- Database: `Compliance_db`
--

CREATE DATABASE `Compliance_db`;
-- ENTITIES

--
-- Struttura della tabella `Compliance`
--

    CREATE TABLE `Compliance_db`.`Compliance` (	
        
        `ApprovedDate` date,

        
        `AprroverName` varchar(40),

        
        `Compliance_id` varchar(40),

        
        `CreatedBy` varchar(40),

        
        `IsActive` bool,

        
        `LawType` varchar(40),

        
        `Penalty` varchar(40),

        
        `PublishedBy` varchar(40),

        
        `PublishedOn` date,

        
        `Regulator` varchar(40),

        
        `Section` varchar(40),

        
        `Version` varchar(40),

        
        `createdDate` date,
        -- RELAZIONI
        
        `_id` DECIMAL(38,0)
    );
    
    
    CREATE UNIQUE INDEX `Compliance_PK` ON `Compliance_db`.`Compliance` (`_id`);
    ALTER TABLE `Compliance_db`.`Compliance` ADD CONSTRAINT `Compliance_PK` PRIMARY KEY (`_id`);
    ALTER TABLE `Compliance_db`.`Compliance` MODIFY `_id` DECIMAL(38,0) NOT NULL;

--
-- Struttura della tabella `User`
--

    CREATE TABLE `Compliance_db`.`User` (	
        
        `mail` varchar(40),
        

        
        `name` varchar(40),
        

        
        `password` varchar(40),
        

        

        
        `surname` varchar(40),
        

        
        `username` varchar(40),
        
        -- RELAZIONI
        
        `_id` DECIMAL(38,0)
    );
    
    
    CREATE UNIQUE INDEX `User_PK` ON `Compliance_db`.`User` (`_id`);
    ALTER TABLE `Compliance_db`.`User` ADD CONSTRAINT `User_PK` PRIMARY KEY (`_id`);
    ALTER TABLE `Compliance_db`.`User` MODIFY `_id` DECIMAL(38,0) NOT NULL;


-- RELATIONS

    -- RELATIONS TABLE Compliance
    
        
        
        
        



    -- RELATIONS TABLE User
    
        
        
        
        



INSERT INTO user (`_id`, `username`, `password`, `mail`, `name`, `surname`) VALUES (1, 'admin', '1a1dc91c907325c69271ddf0c944bc72', '', '', '');

CREATE TABLE `Compliance_db`.`roles` (	
    `role` VARCHAR(30), 
    `_user` DECIMAL(38, 0), 
    `_id` DECIMAL(38,0)
);

CREATE UNIQUE INDEX `ROLES_PK` ON `Compliance_db`.`roles` (`_id`);
ALTER TABLE `Compliance_db`.`roles` ADD CONSTRAINT `ROLES_PK` PRIMARY KEY (`_id`);
ALTER TABLE `Compliance_db`.`roles` MODIFY `_id` DECIMAL(38,0) NOT NULL;
ALTER TABLE `Compliance_db`.`roles` ADD CONSTRAINT `ROLES_FK1` FOREIGN KEY (`_user`)
	  REFERENCES `Compliance_db`.`user` (`_id`);

INSERT INTO roles (`role`, `_user`, `_id`) VALUES ('ADMIN', '1', 1);

