USE test;
DROP TABLE IF EXISTS book;
CREATE TABLE book (
  id INT(11) NOT NULL AUTO_INCREMENT,
  title VARCHAR(100) NOT NULL,
  description VARCHAR(255) DEFAULT NULL,
  author VARCHAR(100) NOT NULL,
  isbn VARCHAR(20) DEFAULT NULL,
  printYear INT(4) DEFAULT NULL,
  readAlready BIT DEFAULT 0,
  PRIMARY KEY (id)
) ENGINE = InnoDB DEFAULT CHARACTER SET = utf8;
INSERT INTO book (title, description, author, isbn, printYear, readAlready) VALUES
  ('Book title 1', 'Book desription', 'Good Author', '6-234765-23-9', 2007, false),
  ('Book title 2', 'Book desription', 'Stephen King', '1-264948-76-4', 2007, false),
  ('Book title 3', 'Book desription', 'Linus Torvalds', '4-234234-45-9', 2007, false),
  ('Book title 4', 'Book desription', 'Robert Lafore', '1-123321-67-7', 2007, false),
  ('Book title 5', 'Book desription', 'Bruce Eckel', '9-456789-03-2', 2007, false),

  ('Book title 6', 'Book desription', 'Good Author', '4-456456-443-6', 2009, false),
  ('Book title 7', 'Book desription', 'Stephen King', '9-123456-03-2', 2009, false),
  ('Book title 8', 'Book desription', 'Linus Torvalds', '4-456456-897-6', 2009, false),
  ('Book title 9', 'Book desription', 'Robert Lafore', '1-908678-83-0', 2009, false),
  ('Book title 10', 'Book desription','Bruce Eckel', '1-623945-83-0', 2009, false),

  ('Book title 11', 'Book desription', 'Good Author',  '1-943876-83-0', 2013, false),
  ('Book title 12', 'Book desription', 'Stephen King',  '7-123123-90-0', 2013, false),
  ('Book title 13', 'Book desription', 'Linus Torvalds', '6-789765-03-2', 2013, false),
  ('Book title 14', 'Book desription', 'Robert Lafore', '7-648934-90-0', 2013, false),
  ('Book title 15', 'Book desription', 'Bruce Eckel', '6-904506-03-2', 2013, false),

  ('Book title 16', 'Book desription', 'Good Author',  '0-123567-43-4', 2015, false),
  ('Book title 17', 'Book desription', 'Stephen King',  '4-2831092-22-2', 2015, false),
  ('Book title 18', 'Book desription', 'Linus Torvalds', '0-938487-43-4', 2015, false),
  ('Book title 19', 'Book desription', 'Robert Lafore', '4-738322-22-2', 2015, false),
  ('Book title 20', 'Book desription', 'Bruce Eckel', '0-456028-43-4', 2015, false),

  ('Book title 21', 'Book desription', 'Good Author',  '5-228228-22-8', 2016, false),
  ('Book title 22', 'Book desription', 'Stephen King',  '9-000777-00-7', 2016, false),
  ('Book title 23', 'Book desription', 'Linus Torvalds', '5-123123-22-8', 2016, false),
  ('Book title 24', 'Book desription', 'Robert Lafore', '9-777000-00-7', 2016, false),
  ('Book title 25', 'Book desription', 'Bruce Eckel', '5-321321-22-8', 2016, false),

  ('Book title 26', 'Book desription', 'Good Author',  '0-000000-00-1', 2017, false),
  ('Book title 27', 'Book desription', 'Stephen King',  '0-000000-00-2', 2017, false),
  ('Book title 28', 'Book desription', 'Linus Torvalds', '0-000000-00-3', 2017, false),
  ('Book title 29', 'Book desription', 'Robert Lafore', '0-000000-00-4', 2017, false),
  ('Book title 30', 'Book desription', 'Bruce Eckel', '0-000000-00-5', 2017, false);