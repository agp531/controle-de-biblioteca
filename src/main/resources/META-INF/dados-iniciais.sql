insert into tb_users (id, name, email, password, type) VALUES (null,'allan','allan@crowtech.digital','allan12#','ADMIN');
insert into tb_users (id, name, email, password, type) VALUES (null,'claudia','claudia@crowtech.digital','claudia12#','COMMOM');

-- Inserir autores na tabela author
INSERT INTO author (name) VALUES ('J.R.R. Tolkien');
INSERT INTO author (name) VALUES ('George Orwell');
INSERT INTO author (name) VALUES ('J.K. Rowling');
INSERT INTO author (name) VALUES ('Gabriel García Márquez');
INSERT INTO author (name) VALUES ('Antoine de Saint-Exupéry');

-- Inserir livros na tabela livro
INSERT INTO book (name, date, id_author, bookStatus) VALUES ('O Senhor dos Anéis: A Sociedade do Anel', '1954-07-29', 1, 'AVAILABLE');
INSERT INTO book (name, date, id_author, bookStatus) VALUES ('1984', '1949-06-08', 2, 'AVAILABLE');
INSERT INTO book (name, date, id_author, bookStatus) VALUES ('Harry Potter e a Pedra Filosofal', '1997-06-26', 3, 'UNAVAILABLE');
INSERT INTO book (name, date, id_author, bookStatus) VALUES ('Cem Anos de Solidão', '1967-05-30', 4, 'UNAVAILABLE');
INSERT INTO book (name, date, id_author, bookStatus) VALUES ('O Pequeno Príncipe', '1943-04-06', 5, 'BORROWED');