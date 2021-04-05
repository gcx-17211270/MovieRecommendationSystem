@echo off
echo "准备开始了"
cd ../Algorithm
echo "基于项目的协同过滤推荐算法"
python itemcf.py
echo "算法运算结束"
echo "基于用户的协同过滤推荐算法"
python usercf.py
echo "算法运算结束"
echo "基于矩阵分解的LFM推荐算法"
cd MF
python main.py
echo "算法运算结束"
echo "将推荐算法结果写入数据库中"
python ConnMySQL.py
pause
