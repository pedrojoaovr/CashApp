CREATE TABLE usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    senha VARCHAR(100) NOT NULL
);

CREATE TABLE controle_gastos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT,
    valor DECIMAL(10, 2) NOT NULL,
    descricao VARCHAR(255),
    data DATE NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);
