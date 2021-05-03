# 자동차 경주 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 기능 목록
- [x] 사용자로 부터 자동차의 이름들을 입력받는다.
    - 이름을 입력하지 않으면 안된다. 
    - 공백으로 입력하면 안된다. 
    - 6자 이상을 입력하면 안된다. 
    - 잘못된 이름을 입력받은 경우 안내 후 다시 입력받는다.
- [x] 사용자로 부터 몇 번의 이동을 할 것인지를 입력받는다.
- [x] 0에서 9사이에서 random 값을 구한 후 random 값이 4 이상일 경우에만 전진해야 한다.
- [x] 경주 게임을 완료한 후 게임 결과를 표시한다.
- [x] 우승자를 표시한다. 우승자는 한 명 이상일 수 있다.

## 프로그래밍 요구사항
- [x] indent 2를 넘지 않는다.
- [x] stream api를 사용하지 않는다.
- [x] else 예약어를 사용하지 않는다.
- [x] 함수의 길이가 10라인을 넘어가지 않도록 구현한다.
- [x] 일급컬렉션을 활용한다.
- [x] 모든 원시값과 문자열을 포장한다.
- [x] 단위 테스트를 구현한다.

## MVC를 지키면서 코딩하는 방법
1. Model은 Controller와 View에 의존하지 않아야 한다.
2. View는 Model에만 의존해야 하고, Controller에는 의존하면 안된다.
3. View가 Model로부터 데이터를 받을 때는, 사용자마다 다르게 보여주어야 하는 데이터에 대해서만 받아야한다.
4. Controller는 Model과 View에 의존해도 된다.
5. View가 Model로부터 데이터를 받을 때, 반드시 Controller에서 받아야한다.

## 개선하기
- [x] 구체화된 Exception을 사용한다.
- [x] `,,`을 입력했을 때 Exception이 나지 않는다.
- [x] CarName validate로직에서 View의존을 없앤다.
- [x] cars객체 생성으로 Exception을 잡기 보다 input 검증로직을 별도로 만든다. (view, domain 분리)
- [x] getCarNames(), getTryCount() 메서드를 view 레이어가 가지도록 한다.
- [ ] race를 Controller가 아닌 Service 레이어가 하도록 변경한다.
- [ ] Car의 이동 경로를 for문 안에서 출력하기 보다 이동 경로를 담는 객체에 담아놓고 나중에 출력하도록 해보자.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)
