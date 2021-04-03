# -*- coding = utf-8 -*-
"""
Descripttion: 根据数据文件名，定义数据内部格式
    BUTLITIN_DATASETS是从Movies_len网站上提供的不同数据集，内部的分隔符等各有不同
version:
Author: 32353
Date: 2021-04-01 13:57:07
LastEditors: 32353
LastEditTime: 2021-04-01 14:26:47
"""
import collections
import os
import itertools
import random
from collections import namedtuple

BuiltinDataset = namedtuple('BuiltinDataset', ['url', 'path', 'sep', 'reader_params'])

BUILTIN_DATASETS = {
    'ml-100k':
        BuiltinDataset(
            url='http://files.grouplens.org/datasets/movielens/ml-100k.zip',
            path='data/ml-100k/u.data',
            sep='\t',
            reader_params=dict(line_format='user item rating timestamp',
                               rating_scale=(1, 5),
                               sep='\t')
        ),
    'ml-1m':
        BuiltinDataset(
            url='http://files.grouplens.org/datasets/movielens/ml-1m.zip',
            path='data/ml-1m/ratings.dat',
            sep='::',
            reader_params=dict(line_format='user item rating timestamp',
                               rating_scale=(1, 5),
                               sep='::')
        ),
    'ml-latest-small':
        BuiltinDataset(
            url='http://files.grouplens.org/datasets/movielens/ml-latest-small.zip',
            path='../data/ml-latest-small/ratings.csv',
            sep=',',
            reader_params=dict(line_format='user item rating timestamp',
                               rating_scale=(1, 5),
                               sep=',')
        )
}

# modify the random seed will change dataset spilt.
# if you want to use the model saved before, please don't modify this seed.
random.seed(0)


class DataSet:
    """
    加载各种数据集的工具类
    直接使用其中的静态方法，而不要创造这个类的任何实例

    Base class for loading datasets.

    Note that you should never instantiate the :class:`Dataset` class directly
    (same goes for its derived classes), but instead use one of the below
    available methods for loading datasets."""

    def __init__(self):
        pass

    @classmethod
    def load_dataset(cls, name):
        """加载数据集，返回其中内容，BUTLTIN_DATASETS中包含了可能存在的几种数据集的格式定义
            可以根据名称直接判断出其中的数据格式（相当于返回表头）
        """
        try:
            dataset = BUILTIN_DATASETS[name]
        except KeyError:
            raise ValueError('unknown dataset ' + name +
                             '. Accepted values are ' +
                             ', '.join(BUILTIN_DATASETS.keys()) + '.')
        if not os.path.isfile(dataset.path):
            raise OSError(
                "Dataset data/" + name + " could not be found in this project.\n"
                                         "Please download it from " + dataset.url +
                ' manually and unzip it to data/ directory.')
        with open(dataset.path) as f:
            ratings = [cls.parse_line(line, dataset.sep) for line in itertools.islice(f, 0, None)]
        print("Load " + name + " dataset success.")
        return ratings

    @classmethod
    def parse_line(cls, line: str, sep: str):
        """
        对每一行的解析
        """
        user, movie, rate = line.strip('\r\n').split(sep)[:3]
        return user, movie, rate

    @classmethod
    def train_test_split(cls, ratings, test_size=0.2):
        """
        切分训练集与测试集
        """
        train, test = collections.defaultdict(dict), collections.defaultdict(dict)
        trainset_len = 0
        testset_len = 0
        for user, movie, rate in ratings:
            if user == 'userId':
                continue
            if random.random() <= test_size:
                test[user][movie] = float(rate)
                testset_len += 1
            else:
                train[user][movie] = float(rate)
                trainset_len += 1
        print('split rating data to training set and test set success.')
        print('train set size = %s' % trainset_len)
        print('test set size = %s\n' % testset_len)
        return train, test
