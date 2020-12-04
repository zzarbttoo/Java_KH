import json

import cv2
import requests
import sys
import matplotlib.pyplot as plt
import numpy as np

LIMIT_PX = 1024
LIMIT_BYTE = 1024*1024  # 1MB
LIMIT_BOX = 40


#image_path = './engTest1.PNG'
#appkey = 'f40be23a0183befcdd925726da9fa7d7'

#이미지 대비 높이기 
def img_enhanced(image_path:str):
    image = cv2.imread(image_path)
    image_enhanced = cv2.equalizeHist(image)
    




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
def adaptivee_threadholding():
    pass

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



def main(image_path, appkey):

    '''
    #image_resize
    resize_impath = kakao_ocr_resize(image_path)
    if resize_impath is not None:
        image_path = resize_impath
        print("원본 대신 리사이즈된 이미지를 사용합니다.")
    '''
    #image_filter2D
    filter2D_impath = img_filter2D(image_path)

    output = kakao_ocr(image_path, appkey).json()
    for i in output['result']:
        print(i['recognition_words'])


if __name__ == "__main__":
    appkey = 'f40be23a0183befcdd925726da9fa7d7'
    #값이 넘어올 수 있도록 할 것이다
    image_path = './engTest1.PNG'
    main(image_path, appkey)
