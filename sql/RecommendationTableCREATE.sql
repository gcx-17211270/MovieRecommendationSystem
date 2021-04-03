-- 推荐算法对应的推荐结果内容

USE movies_data2;

CREATE TABLE userBasedCF(
    id INT unsigned NOT NULL,
    recommendation INT,
    score FLOAT
) COMMENT='基于用户的协同过滤推荐算法';

CREATE TABLE itemBasedCF(
    id INT unsigned NOT NULL,
    recommendation INT,
    score FLOAT
) COMMENT='基于项目的协同过滤推荐算法';

CREATE TABLE LFM(
	id INT unsigned NOT NULL,
    recommendation INT,
    score FLOAT
) COMMENT='矩阵分解模型——潜在因子模型(Latent Factor Model)';

show tables;
