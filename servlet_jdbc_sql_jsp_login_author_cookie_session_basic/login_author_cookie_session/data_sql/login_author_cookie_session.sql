create database if not exists fishsell;
CREATE TABLE IF NOT EXISTS Fish (
    id INT AUTO_INCREMENT PRIMARY KEY,
    price INT NOT NULL,
    `name` VARCHAR(50) NOT NULL,
    `type` VARCHAR(50) NOT NULL,
    gender BOOLEAN,
    avatar VARCHAR(200)
);
CREATE TABLE IF NOT EXISTS order_fish (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fish_id INT NOT NULL,
    account_username VARCHAR(50) NOT NULL,
    amount INT,
    total_money INT,
    FOREIGN KEY (fish_id)
        REFERENCES Fish (id),
    FOREIGN KEY (account_username)
        REFERENCES accounts (username)
);

CREATE TABLE IF NOT EXISTS decentralization (
    id INT AUTO_INCREMENT PRIMARY KEY,
    author VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS accounts (
    username VARCHAR(50) PRIMARY KEY,
    passwords VARCHAR(50),
    decentralization_id INT,
    FOREIGN KEY (decentralization_id)
        REFERENCES decentralization (id)
);

INSERT INTO decentralization (`id`, `author`) VALUES ('1', 'admin'),('2', 'newbie');

INSERT INTO accounts VALUES ('admin', 'admin',1),('newbie', 'newbie',2);

