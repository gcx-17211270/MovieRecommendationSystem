# coding=UTF-8

import utils

from LFM import LFM
from dataset import DataSet

from utils import LogTime


def run_model(model_name, dataset_name, test_size=0.3, clean=False):
    print('*' * 70)
    print('\tThis is %s model trained on %s with test_size = %.2f' % (model_name, dataset_name, test_size))
    print('*' * 70 + '\n')
    model_manager = utils.ModelManager(dataset_name, test_size)
    try:
        trainset = model_manager.load_model('trainset')
        testset = model_manager.load_model('testset')
    except OSError:
        ratings = DataSet.load_dataset(name=dataset_name)
        trainset, testset = DataSet.train_test_split(ratings, test_size=test_size)
        model_manager.save_model(trainset, 'trainset')
        model_manager.save_model(testset, 'testset')
    '''Do you want to clean workspace and retrain model again?'''
    '''if you want to change test_size or retrain model, please set clean_workspace True'''
    model_manager.clean_workspace(clean)
    if model_name == 'LFM':
        # K, epochs, alpha, lamb, n_rec_movie
        model = LFM(10, 10, 0.05, 0.01, 10)
        """
        epochs=30
        precision=0.3151	recall=0.0632	
        coverage=0.0689		popularity=4.3273
        
        epochs=20
        precision=0.2528	recall=0.0507	
        coverage=0.0730		popularity=4.0068
        
        epochs=10
        precision=0.1580	recall=0.0317	
        coverage=0.0706		popularity=3.7611
        """
    else:
        raise ValueError('No model named ' + model_name)
    model.fit(trainset)
    # recommend_test(model, [1, 100, 233])
    model.test(testset)

def recommend_test(model, user_list):
    for user in user_list:
        recommend, movie_arr = model.recommend(str(user))
        print("recommend for userid = %s:" % user)
        print(recommend)
        print()


if __name__ == '__main__':
    main_time = LogTime(words="Main Function")
    dataset_name = 'ml-1m'
    model_type = 'LFM'
    test_size = 0.3
    run_model(model_type, dataset_name, test_size, False)
    main_time.finish()
