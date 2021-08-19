ALTER TABLE ONLY task.book_author
    ADD CONSTRAINT book_author_author_id_fk FOREIGN KEY (author_id)
        REFERENCES task.author(author_id) ON UPDATE CASCADE ON DELETE CASCADE NOT VALID;
ALTER TABLE ONLY task.book_author
    ADD CONSTRAINT book_author_book_id_fk FOREIGN KEY (book_id)
        REFERENCES task.book(book_id) ON UPDATE CASCADE ON DELETE CASCADE NOT VALID;
