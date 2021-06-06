
--

-- --------------------------------------------------------

DROP TABLE IF EXISTS Picture;
CREATE TABLE Picture (
  id int(11) PRIMARY KEY auto_increment,
  title varchar(100) NOT NULL,
  artist varchar(100) NOT NULL,
  fecha date NOT NULL,
  price double NOT NULL,
  Shop_Id int(11) NOT NULL
);


DROP TABLE IF EXISTS Shop;
CREATE TABLE Shop (
  Id int(11) primary key auto_increment,
  Name varchar(45) NOT NULL,
  Capacity int(11) NOT NULL
);

ALTER TABLE Picture
  ADD CONSTRAINT fk_Picture_Shop FOREIGN KEY (Shop_Id) REFERENCES Shop (Id);


