import json

import cv2
import requests
import sys

def kakao_ocr():
    image_path = './test1.PNG'
    appkey = 'f40be23a0183befcdd925726da9fa7d7'
    
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


def main():
    output = kakao_ocr().json()
    #print(len(output['result']))

    for i in output['result']:
        print(i['recognition_words'])

    #print("[OCR] output:\n{}\n".format(json.dumps(output, sort_keys=True, indent=2)))


if __name__ == "__main__":
    main()


'''
한글은 잘 인식하는데 영어 + 한글이나
아예 영어는 오히려 인식 못하는 것 같다
'''