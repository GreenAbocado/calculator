# 계산기 프로그램 🧮
___
콘솔 기반 계산기 프로그램입니다

## 💻 프로젝트 소개
___
내일배움캠프 CH3 과제 수행 목적으로 구현한 프로그램입니다.

요구사항 분석을 통해 사칙 연산 및 예외 처리 등의 주요 기능들을 구현합니다.
<br>
현재 STEP3 <도전 기능 구현하기>입니다.

각 STEP별로 릴리즈 노트 발행할 예정입니다.

## 👨‍💻개발 기간 및 기술 스택
___
### 개발 기간
- 2026.09.16일 ~ 2026.09.18일

### 기술 스택
- JDK 17
- IntelliJ
- Git / GitHub

## 📁 폴더 구조 및 클래스 설계
___
```
.
├── .github/
│   └── PULL_REQUEST_TEMPLATE/
│       └── default-review.md
├── images/
│   ├── screenshot_fail.png
│   └── screenshot_success.png
├── src/
│   ├── calculator/
│   │   ├── ArithmeticCalculator.java
│   │   ├── CalculateResult.java
│   │   └── Operator.java
│   ├── exception/
│   │   ├── ExceptionHandler.java
│   │   └── ExceptionMessage.java
│   ├── io/
│   │   ├── InputValidator.java
│   │   ├── MenuOption.java
│   │   └── OutputMessage.java
│   └── Main.java
├── .gitignore
└── README.md
```
<br>

|          클래스          |                      역할                       |
|:------------------------:|:-----------------------------------------------:|
|         **Main**         |             흐름제어 및 입출력 담당             
| **ArithmeticCalculator** |       계산 수행 및 Deque기반 저장소 관리        |
|   **CalculateResult**    |   연산 결과(피연산자, 연산자, 결과) 보관 객체   |
|       **Operator**       |             연산자, 연산 로직 보관              |
|    **InputValidator**    |           입력 검증 및 파싱 결과 반환           |
|   **ExceptionHandler**   | 글로벌 예외 처리(입력, 계산, 저장) 및 예외 전환 |
|   **ExceptionMessage**   |             예외 관련 메시지 상수화             |
|    **OutputMessage**     |             출력 관련 메시지 상수화             |
|      **MenuOption**      |               메뉴 옵션 관리 Enum               |


## 📌 주요 기능 및 특징
___
- **기본 연산** : 입력 형식에 따른 정수/실수 타입 변환 및 사칙연산 수행


- **연산 결과 관리** :
  - 전체 연산 결과 조회
  - 가장 오래된 기록 삭제
  - 입력값 초과 결과 필터링


- **다양한 입력 검증** :
  - 공백/다중 토큰 방지
  - 연산자 문자수/일치 검증
  - 피연산자 숫자 확인
  - 피연산자 타입 확인 및 범위 초과 검증
  - 메뉴 옵션 검증

- **다양한 예외 상황 가정**
  - 위의 다양한 입력 검증 포함
  - n/0 상황
  - 연산 중 오버플로우
  - 빈 결과 저장소에 조회/삭제 수행


- **글로벌 예외 처리를 통한 주요 로직 가독성 향상**
  - 분류 : IllegalArgumentException(입력), ArithmeticException(연산), NotSuchElementException (빈 저장소)
  - 분류에 해당하지 않는 예외가 터질 경우, ExceptionHandler.translateException()을 통한 예외 전환


- **예외/출력 메시지, 메뉴 옵션 상수화를 통해 관리 복잡도 해소**


- **피연산자 입력값 자동 타입 변환** (형식 및 소속 범위에 따라 Integer, Long, Double ...)
  - InputValidator.getNumByType()
  - 실수/정수 구분 후 정수의 경우 범위에 따라 구분


- **Number 상속 관계를 이용한 다형성 지원**
  - Calculator, CalculateResult 모두 Number 사용
  - InputValidator로 피연산자 자동 파싱 -> Calculator로 다양한 래퍼 전달 가능
  - CalculateResult의 피연산자, 결과 필드 모두 Number
    - 피연산자의 경우 자동 파싱된 입력값, 결과의 경우 Long/Double 분리


- **Operator 생성 및 연산 로직 집중화**
  - 연산 기호 및 연산 로직 저장
  - 실제 연산 주체이기에 double로 캐스팅하여 연산 수행
  - Calculator는 내부 연산 구현을 몰라도 사용 가능
  - 정적 팩토리 메서드를 통해 문자에 따른 Operator 반환
    - 문자만 넘기면 알아서 values()와 Stream을 통해 찾다가 없으면 예외
  - 이후 연산자 변경/추가시 해당 이넘 필드만 수정하면 전체 반영 가능
  
  
## 📺 실행 화면
___

### 🔗 [screen.md](./screen.md)

## 🕹️ 실행 방법
___
**JDK17 이상** 설치 필수

- 프로젝트 폴더 복제 후 이동
```
git clone https://github.com/GreenAbocado/calculator
cd calculator/src
```

- 컴파일 및 실행
```
javac Main.java
java Main
```