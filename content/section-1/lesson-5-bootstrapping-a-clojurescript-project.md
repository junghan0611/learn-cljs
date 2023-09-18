---
title: "Bootstrapping a ClojureScript Project | Lesson 5"
type: "docs"
date: 2019-09-19T20:45:29-06:00
---

# Lesson 5: Bootstrapping a ClojureScript Project

지금까지 클로저스크립트에 대한 논의는 대부분 이론적인 측면이 강했습니다. 왜
클로저스크립트를 사용해야 하는지는 알겠지만 실제로는 어떤 모습일까요? 이
섹션에서는 작은 일기 예보 애플리케이션을 처음부터 개발해 보겠습니다. 세부적인
내용은 나중으로 미루고 높은 수준의 개념에 집중하겠습니다. 이 시점에서는
클로저스크립트 코드의 모양에 익숙해지고, 자바스크립트에서 어려운 작업을 더 쉽게
만드는 방법과 도구가 개발 프로세스를 간소화하는 데 어떻게 도움이 되는지 파악하는
데 관심이 있습니다. 애플리케이션의 구문이 아직은 다소 낯설게 느껴질 수 있지만,
ClojureScript 프로젝트가 얼마나 재미있고 생산적인지 느끼기 시작할 것입니다.

---

**In this lesson:**

- Walk through setting up a project from scratch
- Learn how to use the ClojureScript compiler to build your code
- Bootstrapping with clj-new

---

먼저 클로저스크립트 프로젝트를 생성하고 빌드하는 방법을 배워보겠습니다. 목수가
모든 도구에 익숙해야 걸작을 만들 수 있듯이, 우리도 우리가 사용하는 도구에
익숙해져야 합니다. 자바스크립트 개발에 필요한 도구가 너무 많다는 점을 고려하면,
클로저스크립트 프로젝트에 필요한 핵심 도구가 몇 가지 밖에 없다는 점이 안심이 될
것입니다.

## Meeting clj

각 언어에는 배울 수 있는 고유한 도구 세트가 있으며, 클로저스크립트도 다르지
않습니다. 이 책에서는 범용 빌드 작업을 위한 `clj`와 코드의 실시간 리로딩을 위한
피그휠이라는 두 가지 매우 중요한 도구에 초점을 맞출 것입니다. 먼저 종속성을
관리하고 코드를 빌드하기 위한 내장 명령줄 도구인 새로운 친구 `clj`에 대해
살펴보겠습니다. 자바스크립트의 `npm`과 마찬가지로 `clj`는 구성 기반 종속성
관리자이자 간단한 빌드 도구입니다. 소프트웨어 프로젝트 빌드에 어느 정도 익숙한
독자라면 금방 익숙해질 수 있지만, 빌드 프로세스를 처음 접하는 경우에도 걱정하지
마세요. 클로저스크립트 애플리케이션을 편안하게 빌드할 수 있도록 필수적인 내용을
충분히 자세히 설명하겠습니다.

클로저 언어에는 클로저와 클로저스크립트를 모두 컴파일하는 데 사용할 수 있는
명령줄 도구가 함께 제공됩니다. 다른 빌드 도구도 존재하지만, `clj` 도구가 사실상
유일한 옵션입니다. 간단한 도구이지만 큰 프로젝트에서도 사용할 수 있을 만큼
강력합니다. 우리는 종속성 관리, 컴파일 및 프로젝트 테스트에 이 도구를 사용할
것입니다. 이러한 모든 문제에 대해 단일 도구를 사용하는 것은 자바스크립트
환경에서 도구가 확산되는 상황에서 환영할 만한 변화입니다. 더 진행하기 전에
Java와 Clojure를 설치해야 합니다. 각 릴리스마다 지침이 조금씩 바뀌기 때문에
독자들은 공식
[Clojure 시작 가이드](https://clojure.org/guides/getting_started)에서 가장 최신
지침을 따르는 것이 좋습니다. ClojureScript의 흥미로운 기능 중 하나는 수동으로
설치할 필요 없이 프로젝트의 종속성으로 지정하기만 하면 된다는 것입니다. 클로저가
설치되면 새 프로젝트를 생성할 수 있습니다.

### Creating a Project Manually

템플릿에서 스켈레톤 프로젝트를 만드는 데 사용할 수 있는 도구가 있지만, 먼저
프로젝트를 수동으로 설정하여 내부에서 무슨 일이 일어나고 있는지 더 잘 이해할 수
있도록 하겠습니다. 먼저 새 디렉터리를 만들고 그 안에 들어가야 합니다.

```shell
$ mkdir my-cljs-project
$ cd my-cljs-project
```

다음으로, 이 디렉토리에 `deps.edn` 파일이 필요합니다. 이 파일은 자바스크립트
툴링 커뮤니티에서 `package.json` 에 해당하는 파일로, 프로젝트에 필요한 종속성
목록과 소스 코드 및 스크립트 별칭의 위치를 지정합니다. 확장자 '.edn'은 파일이
ClojureScript 데이터 구조가 포함된 파일 형식인 *Extensible Data Notation*을
사용한다는 것을 나타냅니다. 이제 베어본 개발 파일을 만들어 보겠습니다:

```clojure
{:deps {org.clojure/clojurescript {:mvn/version "1.10.773"}}
 :paths ["src"]}
```

_deps.edn_

`:deps` 항목에는 프로젝트에 필요한 모든 종속성이 포함되어 있습니다. 이 경우에는
최신(이 글을 쓰는 시점 기준) 버전의 ClojureScript를 요청하고 있습니다. 대부분의
패키지는 deps 파일에 붙여넣을 수 있는 항목을 제공하므로 deps 맵의 형식에 대해
너무 걱정하지 마세요.

`:paths` 항목은 클로저스크립트 컴파일러에 코드를 찾을 위치를 지시합니다.
테스트가 있는 경우 테스트 경로도 이 벡터에 추가합니다.

이제 첫 번째 소스 파일을 생성하고 컴파일해 보겠습니다!
`src/my_cljs_project/core.cljs`라는 파일을 생성하고 다음 내용을 입력합니다:

```clojure
(ns my-cljs-project.core)                                  ;; <1>

(js/alert "Hello World")                                   ;; <2>
```

_src/my_cljs_project/core.cljs_

1. Namespace declaration
2. Trigger an alert

By default, our application will get compiled to `out/main.js`, so let's create
a simple HTML page to load this application.

기본적으로 애플리케이션은 `out/main.js` 로 컴파일되므로 이 애플리케이션을 로드할
간단한 HTML 페이지를 만들어 보겠습니다.

```html
<!doctype html>
<html>
  <head>
    <meta charset="UTF-8" />
  </head>
  <body>
    <script src="out/main.js" type="text/javascript"></script>
  </body>
</html>
```

_index.html_

이제 클로저스크립트 파일을 컴파일하고 브라우저에서 스크립트를 로드하겠습니다. 이
모든 작업은 하나의 명령으로 수행할 수 있습니다:

```shell
$ clj -m cljs.main --compile my-cljs-project.core --repl
```

이 명령을 실행하면 빈 페이지가 나타나고 "Hello World" 알림이 표시됩니다! 이
명령이 무엇을 하는 것인지 이해할 수 있도록 자세히 살펴보겠습니다.

- `clj` 클로저 명령줄 도구를 호출합니다.

- `-m cljs.main` 이 플래그는 실행할 함수를 지정합니다. 우리가 `deps.edn` 파일에
  종속성으로 `org.clojure/clojurescript`를 포함시켰을 때, 이는 `clj`에게
  ClojureScript 컴파일러를 다운로드하도록 지시했습니다. `cljs.main`은 컴파일러
  자체를 호출하는 함수입니다. 나머지 플래그는 `clj` 자체가 아니라 ClojureScript
  컴파일러가 해석합니다.

- `--compile my-cljs-project.core` 이것은 애플리케이션의 "진입점"의
  네임스페이스를 지정합니다. 파일이 하나뿐이므로 네임스페이스를 지정합니다.
  네임스페이스는 `core.cljs` 파일 상단에 지정한 것과 일치합니다.

- `--repl` 이 플래그는 두 가지 작업을 수행합니다. 첫째, `index.html` 파일과
  컴파일된 JavaScript를 제공하기 위해 웹 서버를 시작하고 둘째, [레슨 7]에서 배울
  대화형 인터프리터인 REPL을 시작합니다
  [Lesson 7](/section-1/lesson-7-repl-crash-course/).

> **NOTE** 이 책의 터미널 예제는 OSX 또는 Linux와 같은 유닉스 환경용입니다.
> Windows 사용자는 명령어를 약간 수정해야 할 수도 있습니다.

### Using Aliases

`clj` 도구는 코드를 빌드하고 실행하는 데 필요한 모든 옵션을 제공하지만,
애플리케이션을 시작하려면 매번
`clj -m cljs.main --compile my-cljs-project.core --repl`을 입력해야 하는
번거로움이 있습니다. 하지만 `deps.edn` 파일을 사용하면 여러 명령의 약어를
선언하거나 Clojure 파일을 실행할 수 있는 스크립트 별칭을 지정할 수 있습니다.

```clojure
:aliases
  {:dev {:main-opts ["-m" "cljs.main"
                     "--compile" "my-cljs-project.core"
                     "--repl"]}}
```

_deps.edn_

이 별칭을 사용하면 다음 명령으로 애플리케이션을 실행할 수 있습니다:
`clj -M:dev`.

#### Quick Review

- `deps.edn` 파일이란 무엇이며, 자바스크립트 생태계에서 이에 해당하는 파일은
  무엇인가요?
- 애플리케이션을 실행하기 위해 `clj`에 전달된 각 플래그를 설명합니다.

### Understanding clj

작고 단순한 조각으로 고급 기능을 구성한다는 Clojure 철학을 고수하는 `clj`는
종속성 관리와 Clojure 코드(ClojureScript 컴파일러 포함) 실행이라는 잘 정의된
목적을 가진 빌딩 블록입니다. 프로젝트 관리를 위한 더 완전한 기능을 갖춘 다른
도구도 있지만, 기능이 많을수록 복잡해집니다. 이 책에서는 다음 단원에서 소개할
`clj`와 Figwheel이라는 도구를 사용하겠습니다.

`clj -m cljs.main ...`을 호출하면 몇 가지 일이 발생합니다. 먼저, `deps.edn`에
지정된 모든 종속성이 다운로드됩니다. 이 다운로드는 처음 실행할 때만 이루어지며
패키지는 이후 실행을 위해 로컬에 캐시됩니다. 둘째, Java 가상 머신이 시작되고
Clojure 컴파일러가 로드됩니다. 다음으로, Clojure는 `-m` 플래그로 지정된 코드를
로드합니다. 여기서는 ClojureScript 컴파일러의 진입점인 `cljs.main`을
지정했습니다. 이 코드를 사용할 수 있는 이유는 `deps.edn`에 ClojureScript
컴파일러용 패키지(`org.clojure/clojurescript`)를 추가했기 때문입니다.

`-m cljs.main` 플래그 뒤의 나머지 플래그는 `clj` 자체가 아닌 ClojureScript
컴파일러에 의해 해석됩니다. 여기서는 ClojureScript 컴파일러 옵션에 대한 참조를
제시하지 않겠지만 https://clojurescript.org/reference/repl-and-main 에 훌륭한
공식 참조가 있습니다. 대신 앞으로의 강의를 통해 필요한 옵션에 대해 논의할
것입니다.

## Bootstrapping a Project

이제 `clj`에 대해 간략히 살펴봤으니, 이제 첫 번째 간단한 프로젝트인 일기 예보
앱을 만들어 보겠습니다. 모든 것을 수동으로 구성하는 번거로움을 없애기 위해
템플릿에서 프로젝트를 생성하기 위해
[clj-new](https://github.com/seancorfield/clj-new)라는 도구를 사용하겠습니다.
클로저스크립트 컴파일러와 마찬가지로, 우리는 명시적으로 아무것도 설치하지 않고도
clj-new를 사용할 수 있습니다. `clj`의 한 가지 추가 기능은 항상 사용할 수 있는
별칭을 `~/.clojure/deps.edn`에 정의할 수 있다는 것입니다. 다음 내용으로 이
파일을 생성합니다:

```clojure
{:aliases
 {:new {:extra-deps {seancorfield/clj-new
                     {:mvn/version "1.1.243"}}
        :exec-fn clj-new/create
        :exec-args {}}}}
```

_~/.clojure/deps.edn_

: ~/.config/clojure/deps.edn 을 사용한다.

이렇게 하면 `clj -X:new` 명령을 사용하여 `seancorfield/clj-new` 패키지에서
제공하는 `clj-new/create` 함수를 호출할 수 있습니다. clj-new는 프로젝트의
스캐폴딩을 생성하기 위해 템플릿 이름과 프로젝트 이름을 필요로 합니다. 피그휠을
사용하여 코드를 자동으로 컴파일하고 변경할 때 다시 로드할 것이므로, 생성할 파일
및 디렉토리 구조에 대한 청사진인 clj-new *template*을 사용할 수 있습니다.
기본적으로 Clojure 애플리케이션 라이브러리 생성을 위한 몇 가지 기본 제공
템플릿이 있지만 다른 템플릿도 지정할 수 있습니다. 템플릿 이름으로 clj-new를
호출하면 템플릿이 기본 제공 템플릿인지 여부를 확인합니다. 기본 제공 템플릿을
찾을 수 없는 경우 중앙 저장소에서 적절한 템플릿을 찾아 다운로드한 후 프로젝트를
생성합니다.

_Figwheel_ 프로젝트는 라이브 리로딩에 필요한 모든 배관이 포함된 ClojureScript
프로젝트를 생성하는 템플릿을 제공합니다. UI를 빌드하기 위해 React의 관용적
ClojureScript 래퍼인 Reagent 라이브러리를 사용할 것이며, 다행히도 Figwheel
템플릿을 사용하면 생성된 프로젝트에 Reagent 상용구 코드를 포함하기 위한 추가
인수를 전달할 수 있습니다. 이제 앱용 프로젝트를 생성할 수 있습니다.

```
$ clj -X:new :template figwheel-main :name learn-cljs/weather :args '["+deps" "--reagent"]'
```

```
Generating fresh figwheel-main project.
  To get started:
  -->  Change into the 'weather' directory
  -->  Start build with 'clojure -M:fig:build'
```

이 명령에는 익숙하지 않은 구문이 포함되어 있으므로 잠시 시간을 내어 분석해
보겠습니다. 방금 배운 것처럼 명령의 첫 번째 부분인 `clj -X:new`는
`clj-new/create` 함수를 호출하고 나머지 인수는 이 함수에 전달됩니다. Clojure
키워드 구문을 사용하여 `:template`, `:name` 및 `:args` 옵션을 전달합니다.
템플릿`은 당연히 사용할 템플릿의 이름을 지정하고,`:이름`은 생성할 프로젝트의 이름을 지정하며,`:args`는`figwheel-main`템플릿이 해석할 추가 인수를 지정합니다.`figwheel-main`은
기본 제공 템플릿이 아니므로, clj-new는 Clojure의 중앙 저장소인
[Clojars](https://clojars.org/)에서 템플릿을 가져옵니다.

생성된 프로젝트의 구조를 이해하기 위해서는 약간의 규칙을 이해해야 합니다.
대부분의 Clojure 및 ClojureScript 프로젝트는 중앙 레지스트리에 푸시되는 프로젝트
간의 이름 충돌 가능성을 줄이기 위해 네임스페이스 정규화된 패키지 이름을
사용합니다. 네임스페이스는 슬래시 앞 부분으로, 일반적으로 개발자의 GitHub 사용자
이름 또는 코드를 소유한 조직의 역방향 도메인 이름을 사용하지만 원하는 대로
사용할 수 있습니다. 이 책에서는 모든 프로젝트의 네임스페이스로 `learn-cljs`를
사용하겠습니다. [^1]

![Project Namespace and Name](./img/lesson5/namespace-and-name.png)

_Project Namespace and Name_

마지막 인수는 약간 이상하게 생겼습니다: `:args '["+deps" "--reagent"]'`. 이것은
문자열 벡터를 인자로 `figwheel-main` 템플릿에 전달합니다. 지원되는 정확한 인수는
템플릿마다 다르지만, 피그휠은 이를 사용하여 기본 템플릿에 대한 선택적 확장을
구성합니다. 여기서는 종속성을 관리하기 위해 `deps.edn` 파일을 사용하도록
지정하고, Reagent 웹 프레임워크를 포함하도록 지정하고 있습니다.

## Exploring the Project

이제 실행 중인(비록 골격은 있지만) ClojureScript 프로젝트가 생겼습니다.
clj-new가 생성한 애플리케이션을 확인하려면 프로젝트 디렉토리로 이동하여 어떤
파일이 생성되었는지 확인할 수 있습니다.

```
$ cd weather
$ tree -a
.
├── .gitignore
├── README.md
├── deps.edn
├── dev.cljs.edn
├── figwheel-main.edn
├── resources
│   └── public
│       ├── css
│       │   └── style.css
│       ├── index.html
│       └── test.html
├── src
│   └── learn_cljs
│       └── weather.cljs
├── target
│   └── public
├── test
│   └── learn_cljs
│       ├── test_runner.cljs
│       └── weather_test.cljs
└── test.cljs.edn
```

_Exploring the Generated Project_

이제 각 파일과 디렉토리의 용도를 살펴보겠습니다. 우리는 이미 `deps.edn` 파일에
익숙하고, `README.md` 및 `.gitignore` 파일은 설명이 필요 없지만 다른 EDN 파일에
대해서는 약간의 설명이 필요할 수 있습니다:

- `dev.cljs.edn` - 빌드 파일. 피그휠을 사용하면 다양한 옵션을 클로저스크립트
  컴파일러에 전달하는 데 사용할 수 있는 별도의 빌드 구성을 사용할 수 있습니다.
  예를 들어 이 파일을 사용하여 개발 빌드를 구성하고, 다른 파일은 프로덕션 빌드에
  사용할 수 있습니다.

- `figwheel-main.edn` - 피그휠 설정 파일. 이 파일은 피그휠 자체에 대한 구성
  옵션을 제공합니다.

- `test.cljs.edn` - 빌드 파일. Dev.cljs.edn`과 마찬가지로 이 파일은 특정 빌드(이
  경우 테스트 빌드)를 구성합니다.

`src` 디렉토리에는 프로젝트의 모든 ClojureScript 소스 파일이 들어 있습니다.
일반적으로 `src` 아래에는 프로젝트의 네임스페이스와 같은 이름을 공유하는 단일
폴더가 있으며, 이 폴더 아래에는 `*.cljs` 파일 및 기타 폴더가 얼마든지 있을 수
있습니다. 기본적으로 `figwheel-main` 템플릿은 이 디렉터리에 단일
`<project-name>.cljs` 파일을 생성합니다. 텍스트 편집기나 클로저스크립트 [^2]를
지원하는 IDE에서 `weather.cljs`를 열면 다음과 같은 내용을 볼 수 있습니다:

    ![Editing core.cljs with VS Code](/img/lesson5/vscode-screenshot.png)

_Editing `core.cljs` with VS Code_

일기 예보 앱을 구축하기 시작하면서 다음 두 강의에서 이 파일의 나머지 부분을
자세히 살펴볼 것입니다. 지금은 프로젝트의 구조와 밀접하게 연관되어 있으므로 파일
맨 위에 있는 네임스페이스 선언을 살펴보겠습니다. 각 클로저스크립트 파일에는
데이터와 함수의 집합인 *namespace*가 하나씩 포함되어 있습니다. 네임스페이스는
클로저스크립트에서 모듈의 단위입니다. 생성된 `weather.cljs` 파일을 열면 첫 번째
줄에 선언된 네임스페이스를 볼 수 있습니다 (지금은 `^:figwheel-hooks` 비트는
무시): `(ns ^:figwheel-hooks learn-cljs.weather)`. 클로저스크립트 컴파일러는
파일 이름을 기반으로 간단한 네임스페이스 명명 규칙을 사용합니다:

1. Take the file path relative to the source directory
2. Replace the path separator ("/" on Unix-like systems and "\\" on Windows)
   with a dot, "."
3. Replace underscores, "\_", with hyphens "-"
4. Drop the filename extension, ".cljs"

5. 소스 디렉터리를 기준으로 파일 경로를 가져옵니다
6. 경로 구분 기호(유닉스 계열 시스템에서는 "/", Windows에서는 "\\")를 점 "."
   으로 바꿉니다.
7. 밑줄(underscores) "\_"을 하이픈(hyphens) "-"로 바꿉니다
8. 파일 이름 확장자 ".cljs"를 삭제합니다

![Filename to Namespace Convention](/img/lesson5/namespace-transformation.png)

_Filename to Namespace Convention_

> _Hyphen or Underscore?_

> ClojureScript를 처음 접하는 사람들이 가끔 당황하는 한 가지 세부 사항은
> 프로젝트의 디렉터리 이름은 밑줄로 표시하지만 네임스페이스 이름은 하이픈으로
> 표시한다는 사실입니다. 이는 네임스페이스를 Java 클래스로 컴파일하여 파일
> 경로에 따라 클래스 이름을 지정하는 Clojure에서 차용한 규칙입니다. Java 클래스
> 이름에는 하이픈이 허용되지 않으므로 파일 경로에도 하이픈이 허용되지 않습니다.
> 클로저스크립트는 클로저를 따라 네임스페이스의 하이픈을 파일 시스템 경로에서
> 밑줄로 변환해야 합니다. 조금 불편한 점이긴 하지만 일단 알고 나면 쉽게 적응할
> 수 있는 부분입니다.

`resources/` 디렉토리에는 `index.html` 파일, 스타일시트(기본적으로 비어 있음),
프로젝트를 빌드한 후 테스트 런처를 호스팅하기 위한 페이지를 포함하여 웹 사이트를
제공하는 데 필요한 모든 리소스가 포함되어 있습니다. `index.html`은
애플리케이션을 로드할 수 있는 단일 div로 생성되었으며, 여기에는 애플리케이션의
의존 요소와 함께 로드할 JavaScript 파일이 포함되어 있습니다.

### Quick Review

- What file would you change to tweak the markup of the page that will load your
  app?
- What file would you change to add project dependencies?
- What file would you create to add a `learn-cljs.weather.sunny-day` namespace?

## Summary

이 단원에서는 처음부터 새로운 ClojureScript 프로젝트를 만드는 과정을
살펴봤습니다. 내장된 클로저(및 클로저스크립트) 빌드 도구인 clj에 대해
소개했습니다. 그런 다음 프로젝트 스캐폴딩 도구인 'clj-new'를 살펴보고, 이 도구가
생성하는 프로젝트 구조를 살펴봤습니다. 다음으로 개발하는 동안 즉각적인 피드백을
받을 수 있는 또 다른 핵심 도구인 피그휠에 대해 알아볼 것입니다. 그 후에는 두
발로 뛰어들어 코드 작성을 시작할 수 있을 것입니다. 이제 알게 된 것들:

- How to set up a brand new ClojureScript project from scratch
- What sort of tasks are handled by the `clj` tool
- How to use `clj-new` to to bootstrap a project from a template
- How a typical ClojureScript project is laid out

[^1]:
    You will sometimes see the namespace referred to as the "groupId" and the
    name as the "artifactId". This has to do with the naming conventions used by
    Java's Maven project management tool, which is what much Clojure tooling is
    built on top of. [^2]: Most programmers' text editors have a Clojure language
    package that can be used for ClojureScript, but if you prefer working with IDEs,
    Cursive is by far the most fully featured Clojure(Script) IDE available.
