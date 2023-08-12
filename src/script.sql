CREATE DATABASE IF NOT EXISTS retail_store;

USE retail_shop;

CREATE TABLE customer(
                         customerID VARCHAR(255),
                         firstName VARCHAR(255),
                         lastName VARCHAR(255),
                         nic VARCHAR(255),
                         address VARCHAR(255),
                         contactNumber VARCHAR(255),
                         CONSTRAINT PRIMARY KEY (customerID)
);

DESC customer;

CREATE TABLE item(
                     itemID VARCHAR(255),
                     itemName VARCHAR(255),
                     batchNumber VARCHAR(255),
                     price DOUBLE,
                     qty DOUBLE,
                     supplier VARCHAR(255),
                     expireDate DATE,
                     CONSTRAINT PRIMARY KEY (itemID)
);

CREATE TABLE orders(
                       orderID VARCHAR(255),
                       customerID VARCHAR(255),
                       time TIME,
                       date DATE,
                       cashierID VARCHAR(255),
                       total DOUBLE,
                       CONSTRAINT PRIMARY KEY (orderID),
                       CONSTRAINT FOREIGN KEY (customerID) REFERENCES customer(customerID)
);

CREATE TABLE orderDetails(
                             orderID VARCHAR(255),
                             itemID VARCHAR(255),
                             qty DOUBLE,
                             unitPrice DOUBLE,
                             discountedAmount DOUBLE,
                             CONSTRAINT FOREIGN KEY (orderID) REFERENCES orders(orderID)
);

CREATE TABLE users (
                       fullName VARCHAR(255),
                       username VARCHAR(255),
                       password VARCHAR(255)
);
