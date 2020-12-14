import json

import cv2
import requests
import sys
import matplotlib.pyplot as plt
import numpy as np

LIMIT_PX = 1024
LIMIT_BYTE = 1024*1024  # 1MB
LIMIT_BOX = 40
APP_KEY = "f40be23a0183befcdd925726da9fa7d7"

#TODO : 이미지 저장 위치 및 io 처리 
#이미지 대비 높이기 
def img_enhanced(image_path:str):
    image = cv2.imread(image_path)
    grayimg = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)
    image_enhanced = cv2.equalizeHist(grayimg)

    image_path = "{}_enhanced.PNG".format(image_path)
    cv2.imwrite(image_path, image)

    return image_path

    
#이미지 선명도 높이기
def img_filter2D(image_path:str):

    image = cv2.imread(image_path)
    # sharpening 최대
    kernel = np.array([[-1.0, -1.0 , -1.0], [-1.0, 9.0, -1.0], [-1.0, -1.0, -1.0]])
    image_sharp = cv2.filter2D(image, -1, kernel)

    image_path = "{}_filter2D.PNG".format(image_path)
    cv2.imwrite(image_path, image)

    #이미지 띄워보기
    plt.imshow(image)
    plt.show()

    return image_path





#이미지 이진화
def adaptivee_threadholding(image_path:str):
    image = cv2.imread(image_path, cv2.IMREAD_GRAYSCALE)

    #Adaptive Threashlding
    max_output_value = 255
    neighborhood_size = 99
    subtract_from_mean = 10

    image_binarized = cv2.adaptiveThreshold(
    image,
    max_output_value,
    cv2.ADAPTIVE_THRESH_GAUSSIAN_C, 
    cv2.THRESH_BINARY,
    neighborhood_size,
    subtract_from_mean
    )

    plt.imshow(image_binarized, cmap = 'gray')
    plt.show()

    image_path = "{}_adaptive.PNG".format(image_path)
    cv2.imwrite(image_path, image)

    return image_path

    

    

def kakao_ocr_resize(image_path: str):
    """
    ocr detect/recognize api helper
    ocr api의 제약사항이 넘어서는 이미지는 요청 이전에 전처리가 필요.

    pixel 제약사항 초과: resize
    용량 제약사항 초과  : 다른 포맷으로 압축, 이미지 분할 등의 처리 필요. (예제에서 제공하지 않음)

    :param image_path: 이미지파일 경로
    :return:
    """
    image = cv2.imread(image_path)
    height, width, _ = image.shape


    if LIMIT_PX < height or LIMIT_PX < width:
        ratio = float(LIMIT_PX) / max(height, width)
        image = cv2.resize(image, None, fx=ratio, fy=ratio)
        height, width, _ = height, width, _ = image.shape

        # api 사용전에 이미지가 resize된 경우, recognize시 resize된 결과를 사용해야함.
        image_path = "{}_resized.PNG".format(image_path)
        cv2.imwrite(image_path, image)

        return image_path
    return None


def kakao_ocr(image_path: str, appkey: str):
    """
    OCR api request example
    :param image_path: 이미지파일 경로
    :param appkey: 카카오 앱 REST API 키
    """
    API_URL = 'https://dapi.kakao.com/v2/vision/text/ocr'

    headers = {'Authorization': 'KakaoAK {}'.format(appkey)}

    image = cv2.imread(image_path)
    jpeg_image = cv2.imencode(".PNG", image)[1]
    data = jpeg_image.tobytes()

    return requests.post(API_URL, headers=headers, files={"image": data})

def string_parse(output):

    append_string = ""

    # TODO: 알맞은 문자열 처리를 진행하기

    #문자열 병합 
    for i in output:
        append_string += i['recognition_words'][0] + " "

    return append_string


def image_main(image_path, appkey):

    #image_resize
    resize_impath = kakao_ocr_resize(image_path)
    if resize_impath is not None:
        image_path = resize_impath
        print("원본 대신 리사이즈된 이미지를 사용합니다.")

    #filter2D_impath = img_filter2D(image_path)
    #enhanced_impath = img_enhanced(image_path)
    adaptive_impath = adaptivee_threadholding(image_path)
    output = kakao_ocr(adaptive_impath, appkey).json()
    append_string = string_parse(output['result'])

    return append_string


from flask import Flask
from flask import request
import flask_cors

app = Flask(__name__)
flask_cors.CORS(app)

# post 요청 받음
# TODO : 사진 객체를 파라미터로 받음
@app.route('/', methods = ['POST'])
def image_info():
    
    #body parse
    params = json.loads(request.data, encoding='utf-8')
    print(params)
    print(type(params))
    filename=params['filename']
    path = params['path']
    filepath = path + filename
    print(filepath)

    image = cv2.imread(filepath)

    plt.imshow(image)
    plt.show()

    append_string = image_main(filepath, APP_KEY)
    print(append_string)
    # string 으로 넣을 것
    return append_string

if __name__ == "__main__":

    # img 값이 넘어올 수 있도록 할 것이다

    #append_string = image_main(image_path, appkey)
    app.run()


    

    

    
   




    
