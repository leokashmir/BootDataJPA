CREATE DATABASE  IF NOT EXISTS 'Tarefasbd';
USE 'tarefasbd';

--
-- Table structure for table 't_tasks'
--

DROP TABLE IF EXISTS 'tarefa';

CREATE TABLE 'tarefas' (
  'id' int(11) NOT NULL AUTO_INCREMENT,
  'nome' varchar(45) DEFAULT NULL,
  'descricao' varchar(45) DEFAULT NULL,
  'data_criacao' datetime DEFAULT NULL,
  'finalizado' bit(1) DEFAULT b'0',
  PRIMARY KEY ('id')
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

