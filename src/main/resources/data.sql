DROP TABLE IF EXISTS loans;

CREATE TABLE `loans` (
     `id` int NOT NULL AUTO_INCREMENT,
     `customer_id` int NOT NULL,
     `start_at` date NOT NULL,
     `loan_type` varchar(100) NOT NULL,
     `total_loan` int NOT NULL,
     `amount_paid` int NOT NULL,
     `outstanding_amount` int NOT NULL,
     `create_at` date DEFAULT NULL,
     PRIMARY KEY (`id`)
);

INSERT INTO `loans` ( `customer_id`, `start_at`, `loan_type`, `total_loan`, `amount_paid`, `outstanding_amount`, `create_at`)
VALUES ( 1, CURDATE()-250, 'Home', 200000, 50000, 150000, CURDATE()-250);

INSERT INTO `loans` ( `customer_id`, `start_at`, `loan_type`, `total_loan`, `amount_paid`, `outstanding_amount`, `create_at`)
VALUES ( 1, CURDATE()-376, 'Vehicle', 40000, 10000, 30000, CURDATE()-376);

INSERT INTO `loans` ( `customer_id`, `start_at`, `loan_type`, `total_loan`, `amount_paid`, `outstanding_amount`, `create_at`)
VALUES ( 1, CURDATE()-549, 'Home', 50000, 10000, 40000, CURDATE()-549);

INSERT INTO `loans` ( `customer_id`, `start_at`, `loan_type`, `total_loan`, `amount_paid`, `outstanding_amount`, `create_at`)
VALUES ( 1, CURDATE()-122, 'Personal', 10000, 3500, 6500, CURDATE()-122);