drop table members;
drop table authors;
drop table books;

CREATE TABLE members (
    member_id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL,
    email TEXT UNIQUE NOT NULL,
    password TEXT NOT NULL
);

CREATE TABLE authors (
    author_id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL,
    biography TEXT,
    birth_date DATE
);

CREATE TABLE books (
    book_id INTEGER PRIMARY KEY AUTOINCREMENT,
    title TEXT NOT NULL,
    genre TEXT,
    publication_date DATE,
    author_id INTEGER,
    checked_out_by INTEGER,
    FOREIGN KEY (author_id) REFERENCES authors(author_id),
    FOREIGN KEY (checked_out_by) REFERENCES members(member_id)
);

INSERT INTO members (name, email, password) VALUES
    ('John Doe', 'johndoe@example.com', 'password123'),
    ('Jane Smith', 'janesmith@example.com', 'password456');
   
INSERT INTO members (name, email, password) VALUES
    ('Henry Ni', 'henryni@example.com', 'password123!'),
    ('Thomas Kay', 'thomaskay@example.com', 'password456!');
    
INSERT INTO authors (name, biography, birth_date) VALUES
    ('Stephen King', 'A horror novelist', '1947-09-21'),
    ('J.K. Rowling', 'Author of the Harry Potter series', '1965-07-31');
    
INSERT INTO books (title, genre, publication_date, author_id) VALUES
    ('The Shining', 'Horror', '1977-01-01', 1),
    ('Harry Potter and the Sorcerers Stone', 'Fantasy', '1997-06-26', 2);

   
select * from members;
select * from authors;
select * from books;

