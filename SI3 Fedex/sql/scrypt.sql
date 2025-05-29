CREATE DATABASE FEDEXX

USE FEDEXX

CREATE TABLE REMETENTE(
	id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    CPF VARCHAR(20) NOT NULL,
    endereco TEXT NOT NULL,
    telefone VARCHAR(20) NOT NULL
);

CREATE TABLE DESTINATARIO(
	id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    CPF VARCHAR(20) NOT NULL,
    endereco TEXT NOT NULL,
    telefone VARCHAR(20) NOT NULL
);

CREATE TABLE ENVIO(
	id INT AUTO_INCREMENT PRIMARY KEY,
    remetente_id int,
    destinatario_id int,
    endereco_entrega TEXT,
    tipo_entrega ENUM('Aéreo', 'Rodoviário') NOT NULL,
    peso DECIMAL(10,2) NOT NULL,
    data_envio DATE NOT NULL,
    codigo_rastreamento VARCHAR(30) NOT NULL,
    status_atual VARCHAR(30) NOT NULL,
    FOREIGN KEY (remetente_id) REFERENCES remetente(id),
    FOREIGN KEY (destinatario_id) REFERENCES destinatario(id)
);