CREATE TABLE cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    endereco_id INT,
    FOREIGN KEY (endereco_id) REFERENCES endereco(id)
);

CREATE TABLE endereco (
    id INT AUTO_INCREMENT PRIMARY KEY,
    rua VARCHAR(255),
    cidade VARCHAR(255),
    cep VARCHAR(10)
);