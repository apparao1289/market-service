DROP TABLE IF EXISTS vegetable_bag;

CREATE TABLE vegetable_bag  (
    id VARCHAR(36),
    quantity INT,
    suppiler_name VARCHAR(50),
    package_date TIMESTAMP,
    price DOUBLE,
    created_on TIMESTAMP,
    created_by VARCHAR(50),
    last_updated_on TIMESTAMP,
    last_updated_by VARCHAR(50),
    PRIMARY KEY (id)
);

