CREATE DATABASE movies_data2;

CREATE TABLE movies(
  movieId INT,
  title TEXT,
  genres TEXT
);

CREATE TABLE ratings(
    userId INT,
    movieId INT,
    rating  DOUBLE,
    timestamp INT
);

CREATE TABLE tags(
    userId INT,
    movieId INT,
    tag TEXT,
    timestamp INT
);

-- 有一个“MySQL server is running with the –secure-file-priv” Error
-- 应该是和路径有关，这里的text.csv路径是执行
-- show variables like "secure_file_priv";得到的路径
-- 或者用MySQL Workbench的图形界面可视化操作
-- 建立数据库后右键选中load spatial data
LOAD DATA INFILE "D:/ProgramData/MySQL/MySQL Server 8.0/Uploads/movies.csv"
INTO TABLE movies
CHARACTER SET utf8
FIELDS TERMINATED BY ",";

LOAD DATA INFILE "D:/ProgramData/MySQL/MySQL Server 8.0/Uploads/ratings.csv"
INTO TABLE ratings
CHARACTER SET utf8
FIELDS TERMINATED BY ",";

LOAD DATA INFILE "D:/ProgramData/MySQL/MySQL Server 8.0/Uploads/tags.csv"
INTO TABLE tags
CHARACTER SET utf8
FIELDS TERMINATED BY ",";