---
title: "A First Look | Lesson 1"
type: "docs"
date: 2019-09-18T13:06:27-06:00
---

# Lesson 1: A First Look

In today's technology landscape, the web is king. Web apps are everywher, and
the _lingua franca_ of the web is JavaScript. Whether the task is adding
interactivity to a simple web page, creating a complex single-page application,
or even writing microservices, JavaScript is the defacto tool. Despite its age,
JavaScript has evolved to power an entire generation of web development. The
JavaScript community is also one of the most active and prolific software
development communities ever, with libraries and frameworks for any conceivable
use.

오늘날의 기술 환경에서는 웹이 왕입니다. 웹 앱은 어디에나 존재하며 웹의
'공용어'는 JavaScript입니다. 간단한 웹 페이지에 인터랙션을 추가하든, 복잡한 단일
페이지 애플리케이션을 만들든, 심지어 마이크로서비스를 작성하든, 자바스크립트는
사실상의 도구입니다. 자바스크립트는 오래된 기술임에도 불구하고 전 세대의 웹
개발을 뒷받침할 정도로 발전해 왔습니다. 또한 자바스크립트 커뮤니티는 상상할 수
있는 모든 용도의 라이브러리와 프레임워크를 갖춘 가장 활발하고 생산적인
소프트웨어 개발 커뮤니티 중 하나입니다.

---

**In this lesson:**

- What is ClojureScript?
- What makes ClojureScript unique?
- What sort of problems are easier to solve in ClojureScript than in JavaScript?

- 클로저스크립트란 무엇인가요?
- 클로저스크립트가 특별한 이유는 무엇인가요?
- 자바스크립트보다 클로저스크립트에서 어떤 종류의 문제를 더 쉽게 해결할 수
  있나요?

---

However, JavaScript is not without its warts. We need books to tell us what are
the "Good Parts" and what parts we had best avoid. We have to deal with the
reality of varying levels of support by different browsers (yes, even today). We
need expend mental cycles deciding which of many viable UI frameworks we should
use on our next project... and which framework we should switch to when we grow
frustrated with the first framework we chose. While JavaScript has matured to
meet many of the challenges of large-scale web development, there are times when
another language is a better choice for a new project.

Over the course of this book, we will learn the ClojureScript programming
language and see how it is especially well-suited to developing large
single-page applications. While it may take a while to get used to all the
parentheses, we'll see that this odd-looking language excels at building
modular, high-performance user interfaces. Finally, we will see how the simple
elegance of the language makes ClojureScript a joy to work with.

하지만 자바스크립트에도 문제점이 없는 것은 아닙니다. "좋은 부분"이 무엇인지,
어떤 부분을 피하는 것이 가장 좋은지 알려주는 책이 필요합니다. 브라우저마다 지원
수준이 천차만별인 현실에 대처해야 합니다(지금도 마찬가지입니다). 우리는 다음
프로젝트에서 어떤 실행 가능한 UI 프레임워크를 사용할지, 처음 선택한 프레임워크에
좌절감을 느꼈을 때 어떤 프레임워크로 전환할지 결정하는 데 많은 시간을 투자해야
합니다. JavaScript는 대규모 웹 개발의 많은 과제를 해결할 수 있을 정도로
발전했지만, 새로운 프로젝트에는 다른 언어가 더 나은 선택일 때가 있습니다.

이 책에서는 클로저스크립트 프로그래밍 언어를 배우고 이 언어가 특히 대규모 단일
페이지 애플리케이션을 개발하는 데 어떻게 적합한지 살펴볼 것입니다. 모든 괄호
안에 익숙해지는 데 시간이 걸릴 수 있지만, 이 이상하게 생긴 언어가 모듈식 고성능
사용자 인터페이스를 구축하는 데 탁월하다는 것을 알게 될 것입니다. 마지막으로,
언어의 단순한 우아함이 어떻게 클로저스크립트를 작업의 즐거움으로 만드는지 살펴볼
것입니다.

## Introducing ClojureScript

At the fundamental level, ClojureScript is a dialect of the Clojure programming
language that compiles to JavaScript. Clojure was created in 2008 by Rich Hickey
as a general-purpose programming language with the goal of being pragmatic,
safe, and simple. While Clojure originally compiled only to Java Virtual Machine
bytecode, ClojureScript entered the scene in 2011 as an option to bring Clojure
to client side web development. While there are a few differences between
Clojure and ClojureScript, they are largely the same language running on
different platforms. ClojureScript inherits Clojure's pragmatism, safety, and
simplicity.

ClojureScript has all the buzzwords of an obscure, academic language - immutable
data structures, functional programming, Lisp, etc. - but that should not fool
us into thinking that it is a language designed for academia. It is an intensely
practical language that was born to address some of the issues that we as
JavaScript programmers find most troubling. ClojureScript specifically addresses
those pain points that we run into when building and maintaining large
applications. It has presented such successful solutions to asynchronous
programming, state management, and higher-level abstractions that numerous
JavaScript libraries have appeared that mimic certain features of ClojureScript.
It is a practical language that is especially well-suited to client-side web
development.

Beyond being a practical language, ClojureScript can be a very enjoyable
language to write. The terseness of a language like ClojureScript is a breath of
fresh air when we have grown so accustomed to writing the same boilerplate over
and over again. Additionally, ClojureScript comes with a much more extensive
standard library than JavaScript, so those simple tasks that require custom code
or a third-party library can often be accomplished without ever leaving core
ClojureScript.

While we will look at many features of ClojureScript that make it different from
JavaScript, we should not think that it is a totally alien language. After the
initial "parenthesis shock", we will see that its syntax is actually simpler
than that of JavaScript. Let's take a look at a couple of examples of code
translated from JavaScript to ClojureScript to get a feel for how the language
is structured. Below we have an example of a JavaScript function call. Since
JavaScript can be written in several different styles, we'll look at an objected
oriented example as well as a functional example.

기본적인 수준에서 ClojureScript는 JavaScript로 컴파일되는 Clojure 프로그래밍
언어의 방언입니다. Clojure는 실용적이고 안전하며 단순한 것을 목표로 하는 범용
프로그래밍 언어로 2008년에 Rich Hickey에 의해 만들어졌습니다. 원래는 자바 가상
머신 바이트코드로만 컴파일되었지만, 2011년에 클라이언트 측 웹 개발에 클로저를
도입하기 위한 옵션으로 클로저스크립트(ClojureScript)가 등장했습니다. Clojure와
ClojureScript에는 몇 가지 차이점이 있지만, 대체로 서로 다른 플랫폼에서 실행되는
동일한 언어입니다. ClojureScript는 Clojure의 실용성, 안전성 및 단순성을
계승합니다.

ClojureScript에는 불변 데이터 구조, 함수형 프로그래밍, Lisp 등 모호하고 학술적인
언어의 유행어가 모두 포함되어 있습니다. - 하지만 그렇다고 해서 학계를 위해
설계된 언어라고 오해해서는 안 됩니다. 클로저스크립트는 자바스크립트
프로그래머들이 가장 골치 아프게 생각하는 몇 가지 문제를 해결하기 위해 탄생한
매우 실용적인 언어입니다. 클로저스크립트는 특히 대규모 애플리케이션을 빌드하고
유지 관리할 때 직면하는 문제점을 해결합니다. 비동기 프로그래밍, 상태 관리,
고수준 추상화 등에 대한 성공적인 솔루션을 제시해 왔기 때문에 클로저스크립트의
특정 기능을 모방한 수많은 자바스크립트 라이브러리가 등장했습니다. 특히
클라이언트 측 웹 개발에 적합한 실용적인 언어입니다.

실용적인 언어라는 점 외에도 클로저스크립트는 작성하기 매우 즐거운 언어가 될 수
있습니다. 같은 상용구를 반복해서 쓰는 데 익숙해져 있는 우리에게 클로저스크립트와
같은 언어의 간결함은 신선한 바람을 불어넣어 줍니다. 또한, 클로저스크립트는
자바스크립트보다 훨씬 더 광범위한 표준 라이브러리와 함께 제공되므로 사용자 지정
코드나 타사 라이브러리가 필요한 간단한 작업은 핵심 클로저스크립트를 벗어나지
않고도 수행할 수 있는 경우가 많습니다.

자바스크립트와 다른 클로저스크립트의 여러 기능을 살펴보겠지만, 클로저스크립트가
완전히 이질적인 언어라고 생각해서는 안 됩니다. 초기의 "괄호 충격"이 지나면
실제로는 자바스크립트보다 구문이 더 간단하다는 것을 알게 될 것입니다.
자바스크립트에서 클로저스크립트로 변환된 코드의 몇 가지 예를 통해 언어가 어떻게
구조화되어 있는지 살펴봅시다. 아래에는 JavaScript 함수 호출의 예가 있습니다.
JavaScript는 여러 가지 스타일로 작성할 수 있으므로 객체 지향 예제와 함수형
예제를 살펴볼 것입니다.

![Object-Oriented JavaScript function calls](/img/lesson1/oop-js-func.png)

_Object-Oriented JavaScript function calls_

This object-oriented style is very familiar to most JavaScript programmers and
requires little explanation. Next, we'll look at the perhaps slightly less
familiar functional style. This style is widely used in _lodash_ and similar
libraries.

이 객체 지향 스타일은 대부분의 자바스크립트 프로그래머에게 매우 친숙하며 설명이
거의 필요하지 않습니다. 다음으로 조금 덜 친숙한 함수형 스타일을 살펴보겠습니다.
이 스타일은 lodash 및 유사한 라이브러리에서 널리 사용됩니다.

![Functional JavaScript function calls](/img/lesson1/func-js-func.png)

_Functional JavaScript function calls_

Next, let's look at a ClojureScript version of the same example. Notice that
there are the same number of parentheses in the ClojureScript version as there
were in the JavaScript versions. In fact, the only differences from the
functional JavaScript code is that the left parenthesis is moved to the left and
there is no comma between arguments.

다음으로 동일한 예제의 클로저스크립트 버전을 살펴보겠습니다. ClojureScript
버전에는 JavaScript 버전과 동일한 수의 괄호가 있다는 것을 알 수 있습니다. 실제로
함수형 JavaScript 코드와 유일한 차이점은 왼쪽 괄호가 왼쪽으로 이동하고 인수
사이에 쉼표가 없다는 것입니다.

![ClojureScript function call](/img/lesson1/cljs-func.png)

_ClojureScript function call_

While this is a trivial example, it should be enough to see that ClojureScript
should not be intimidating - different, yes, but not frightening. As we will see
over the coming lessons, we need to adjust our eyes to read ClojureScript, but
the process is not that different from learning a new library or programming
technique.

이것은 사소한 예시이지만, 클로저스크립트가 다르긴 하지만 무섭지는 않다는 것을
알기에 충분할 것입니다. 앞으로의 강의를 통해 살펴보겠지만, 클로저스크립트를
읽으려면 눈을 조정해야 하지만 그 과정은 새로운 라이브러리나 프로그래밍 기술을
배우는 것과 크게 다르지 않습니다.

### Quick Review

- Does ClojureScript or JavaScript come with a more extensive standard library?
- Does ClojureScript encourage an object-oriented style or a functional style
  like _lodash_ and _ramda_?

- 클로저스크립트나 자바스크립트 중 어느 쪽이 더 광범위한 표준 라이브러리와 함께
  제공되나요?
- 클로저스크립트는 객체 지향 스타일을 권장하나요, 아니면 _lodash_나
  _ramda_ 와 같은 함수형 스타일을 권장하나요?

## ClojureScript's Sweet Spots

While ClojureScript is a general-purpose programming language, it is not the best tool for every job. If we just want to animate one or two elements on a webpage or implement an analytics snippet, ClojureScript is probably overkill (in fact, even jQuery may be overkill for such simple examples). How are we to decide, then, when to use ClojureScript and when to stick with JavaScript? In order to decide whether to use ClojureScript on a project, we should have an idea of the types of projects in which it excels.

클로저스크립트가 범용 프로그래밍 언어이긴 하지만 모든 작업에 가장 적합한 도구는
아닙니다. 웹페이지에서 한두 개의 요소에 애니메이션을 적용하거나 분석 스니펫을
구현하려는 경우라면 ClojureScript는 과할 수 있습니다(사실, 이러한 간단한
예제에는 jQuery도 과할 수 있습니다). 그렇다면 언제 ClojureScript를 사용할지,
언제 JavaScript를 고수할지 어떻게 결정해야 할까요? 프로젝트에서 ClojureScript를
사용할지 여부를 결정하기 위해서는 ClojureScript가 뛰어난 프로젝트 유형을
파악해야 합니다.

### Writing Single-Page Applications

Clojure started out as a general-purpose application programming language for the JVM, so ClojureScript's heritage is based in application programming. Indeed we see that the constructs that make ClojureScript so valuable are precisely those that are necessary for application-type programs. Specifically, ClojureScript addresses JavaScript's issues that start as minor annoyances and escalate to major issues as an application grows. Anyone who has maintained a large JavaScript application knows how difficult it is to address strategic architecture, module loading, cross-browser compatibility, library selection, tooling, and a whole host of other issues simultaneously.

The problem with JavaScript is that each of these issues must be addressed separately, but your choice for solving one issue may affect others. For instance, the module system that we use is a separate concern from our build tool, which in turn is separate from our testing framework. However, we need to make sure that our build tool supports our testing framework, and both support our module system or can be easily integrated with it. Suddenly, the awesome app that we were planning to write gets stifled by the fact that we just spent 3 days trying to get the build set up. I can tell you that scenarios like this are commonplace, since I have experienced a number of them personally.

Paradoxically, ClojureScript makes things easier by taking away choices. The module system is built in to the language. There is a built-in test framework. Most libraries provide an API that works on common data structures in a functional style, so they are simple to integrate. Additionally, the Google Closure library that is built in will cover most common concerns such as handling dates, DOM manipulation, HTML5 history, graphics, and ajax. While building a ClojureScript application is not nearly the adventure that building a JavaScript one is, it is certainly more productive.

Clojure는 JVM을 위한 범용 애플리케이션 프로그래밍 언어로 시작되었기 때문에
ClojureScript의 유산은 애플리케이션 프로그래밍에 기반을 두고 있습니다. 실제로
ClojureScript를 가치 있게 만드는 구조는 바로 애플리케이션 유형 프로그램에 필요한
구조라는 것을 알 수 있습니다. 특히, 클로저스크립트는 애플리케이션이 성장함에
따라 사소한 성가심으로 시작하여 주요 문제로 확대되는 자바스크립트의 문제를
해결합니다. 대규모 JavaScript 애플리케이션을 유지 관리해 본 사람이라면 전략적
아키텍처, 모듈 로딩, 브라우저 간 호환성, 라이브러리 선택, 툴링 및 기타 여러 가지
문제를 동시에 해결하는 것이 얼마나 어려운지 잘 알고 있습니다.

자바스크립트의 문제점은 이러한 각 문제를 개별적으로 해결해야 하지만 한 가지
문제를 해결하기 위한 선택이 다른 문제에 영향을 미칠 수 있다는 것입니다. 예를
들어, 우리가 사용하는 모듈 시스템은 빌드 도구와는 별개의 문제이며, 테스트
프레임워크와는 별개의 문제입니다. 하지만 빌드 도구가 테스트 프레임워크를
지원하는지, 둘 다 모듈 시스템을 지원하거나 쉽게 통합할 수 있는지 확인해야
합니다. 갑자기 빌드를 설정하는 데 3일을 소비했다는 사실 때문에 계획했던 멋진
앱이 막혀 버립니다. 이와 같은 시나리오는 개인적으로 여러 번 경험했기 때문에 흔한
일이라고 말씀드릴 수 있습니다.

역설적이게도 클로저스크립트는 선택의 여지를 없애서 일을 더 쉽게 만들어줍니다.
모듈 시스템이 언어에 내장되어 있습니다. 테스트 프레임워크가 내장되어 있습니다.
대부분의 라이브러리는 함수형 스타일로 일반적인 데이터 구조에서 작동하는 API를
제공하므로 통합이 간단합니다. 또한 기본 제공되는 Google 클로저 라이브러리는 날짜
처리, DOM 조작, HTML5 기록, 그래픽 및 아약스와 같은 대부분의 일반적인 문제를
다룹니다. ClojureScript 애플리케이션을 빌드하는 것이 JavaScript 애플리케이션을
빌드하는 것만큼 모험적이지는 않지만, 확실히 더 생산적입니다.

### Optimizing UIs

We have alluded to the fact that ClojureScript's immutable data structures make some interesting UI optimizations possible, but we have not gone into detail as to how that works. It is really the combination of React's virtual DOM concept and ClojureScript's immutable data structures that make such optimizations possible. Since we know that ClojureScript's data structures are immutable, we know that any structure that we create cannot change. If we have some data structure backing a UI component, we know that we will not need to re-render the component as long as it is backed by the same data structure. This knowledge allows us to create highly optimized UIs.

Consider this: we are writing a contact management app, and we have a `ContactList` component that contains `ContactListItem` components. These components are all backed by a list of contacts and should re-render whenever a contact changes. If we were writing the component using a JavaScript framework, we would either have to put our data inside special objects that the framework provides so that it can track changes, use a dirty-checking mechanism to periodically find what we need to change, or render everything to an in-memory representation of the DOM and render any changes to the actual DOM. The ClojureScript community has adopted the last method, but the story is actually better in ClojureScript, because we can be selective about which components we even need to render to the virtual DOM, saving additional CPU cycles.

ClojureScript의 불변 데이터 구조가 몇 가지 흥미로운 UI 최적화를 가능하게 한다는
사실을 암시했지만, 그 작동 방식에 대해서는 자세히 설명하지 않았습니다. 실제로
이러한 최적화를 가능하게 하는 것은 React의 가상 DOM 개념과 ClojureScript의 불변
데이터 구조의 조합입니다. ClojureScript의 데이터 구조가 불변이라는 것을 알고
있기 때문에 우리가 생성한 구조는 변경할 수 없습니다. UI 컴포넌트를 뒷받침하는
데이터 구조가 있는 경우 동일한 데이터 구조가 뒷받침하는 한 컴포넌트를 다시
렌더링할 필요가 없다는 것을 알고 있습니다. 이러한 지식을 바탕으로 고도로
최적화된 UI를 만들 수 있습니다.

연락처 관리 앱을 작성 중이고 `ContactList` 컴포넌트가 `ContactListItem`
컴포넌트를 포함하고 있다고 가정해 봅시다. 이러한 컴포넌트는 모두 연락처 목록에
의해 뒷받침되며 연락처가 변경될 때마다 다시 렌더링되어야 합니다. 자바스크립트
프레임워크를 사용하여 컴포넌트를 작성한다면 프레임워크가 제공하는 특수 객체 안에
데이터를 넣어 변경 사항을 추적하고, 더티 검사 메커니즘을 사용하여 주기적으로
변경해야 할 사항을 찾거나, 모든 것을 DOM의 인메모리 표현으로 렌더링하고 모든
변경 사항을 실제 DOM에 렌더링해야 할 것입니다. ClojureScript 커뮤니티에서는
마지막 방법을 채택했지만, 실제로는 가상 DOM에 렌더링해야 하는 컴포넌트를
선택적으로 지정할 수 있어 추가 CPU 주기를 절약할 수 있다는 점에서
ClojureScript가 더 낫습니다.

![Optimizing a UI with immutable data structures](/img/lesson1/ui-optimization-tree.png)

_Optimizing a UI with immutable data structures_

In this example, whenever a `contact` is changed, we replace the map modeling that contact entirely. When it comes time to render to the virtual DOM, the `ContactList` is going to re-render, because the `contacts` list is now a new object entirely. Of the `ContactListItem` components, only the one that that reflects the contact we edited is going to re-render. The rest of the `ContactListItem`s can quickly see that their underlying data has not changed, so there is no work to be done. Furthermore, none of the other portions of the application need to render either. While this optimization may sound rather minor, we will see later that it can have a dramatic effect on the performance of an application.

이 예제에서는 '연락처'가 변경될 때마다 해당 연락처를 모델링하는 맵을 완전히
교체합니다. 가상 DOM에 렌더링할 때가 되면 '연락처' 목록이 완전히 새로운 객체가
되므로 '연락처 목록'이 다시 렌더링됩니다. 연락처 목록` 컴포넌트 중 우리가 편집한
연락처를 반영하는 컴포넌트만 다시 렌더링됩니다. 나머지 `ContactListItem`은 기본
데이터가 변경되지 않았음을 빠르게 확인할 수 있으므로 수행해야 할 작업이
없습니다. 또한 애플리케이션의 다른 부분도 렌더링할 필요가 없습니다. 이 최적화는
다소 사소하게 들릴 수 있지만 나중에 애플리케이션의 성능에 극적인 영향을 미칠 수
있다는 것을 알게 될 것입니다.

### Modernizing Async

JavaScript has now adopted `async/await` - which is a first-class syntax for dealing with promise-like objects - as the preferred way to achieve asynchronous programming. You will still find raw promises, callbacks, and generators in some places, but `async/await` has become more or less universal.

ClojureScript, on the other hand, has embraced a style of asynchronous programming called CSP, or _Communicating Sequential Processes_. This is the same style of async that has proven so effective in the Go programming language. Using CSP, we do not deal directly with promises or callbacks. Instead, we think about values and passing them around via _channels_. For now, you can think of channels as streams or promises that can deliver more than one value. Additionally, we can write asynchronous code that looks like synchronous code, tremendously reducing the cognitive load of writing async code. Performing requests or getting input sequentially or in parallel are both natural. Some ClojureScript developers consider async the single most important advantage that ClojureScript has over JavaScript. We will have to judge for ourselves when we see it in action later in this book, but know that it enables a completely new way of thinking about async.

자바스크립트는 이제 Promise 와 유사한 객체를 처리하기 위한 일류 구문인
`async/await`을 비동기 프로그래밍을 위한 기본 방법으로 채택했습니다. 일부에서는
여전히 원시 Promise, 콜백, 제너레이터를 찾을 수 있지만 `async/await`은 어느
정도 보편화되었습니다.

반면에 클로저스크립트에서는 CSP, 즉 '순차 프로세스 통신'이라는 비동기
프로그래밍 스타일을 채택했습니다. 이는 Go 프로그래밍 언어에서 매우 효과적인
것으로 입증된 비동기 스타일과 동일합니다. CSP를 사용하면 Promise 나 콜백을 직접
처리하지 않습니다. 대신 값을 생각하고 _채널_ 을 통해 전달합니다. 현재로서는
채널을 둘 이상의 값을 전달할 수 있는 스트림이나 프로미스로 생각할 수 있습니다.
또한 동기 코드처럼 보이는 비동기 코드를 작성할 수 있으므로 비동기 코드 작성에
따른 인지적 부하를 크게 줄일 수 있습니다. 요청을 수행하거나 입력을 순차적으로
또는 병렬로 받는 것은 모두 자연스러운 일입니다. 일부 클로저스크립트 개발자는
비동기화를 자바스크립트에 비해 클로저스크립트가 가진 가장 중요한 장점으로 꼽기도
합니다. 이 책의 뒷부분에서 실제로 사용해 보면 직접 판단해야겠지만, 비활성화에
대한 완전히 새로운 사고방식을 가능하게 해준다는 점은 분명합니다.

### Modularizing Design

In the early days of JavaScript, we probably wrote a single JavaScript file that we included in every page of a website that covered all of the scripting that we needed on the site. If the file got too big or different pages had entirely different requirements, we probably wrote several JavaScript files and included them on the applicable pages. Maybe eventually we heard about the "Module Pattern" or "Revealing Module Pattern" and separated our code into narrowly focused modules with one file per module. Now we had to worry about loading every file in the correct order on the page so that we would not try to reference a module that did not yet exist. At this point, we probably heard talk of module loaders that could asynchronously load only the modules we needed and figure out the correct order to load them in - they could even concatenate all of our modules into a single file for deployment. The problem was that there were once again several competing standards for module loading - AMD, CommonJS, and ES2015. Even today, finding the right tooling to integrate modules into our process can be painful, and every team needs at least one Webpack expert who is aware of the gotchas of bundling code for deployment.

ClojureScript, on the other hand, has the advantage of being a compiled language and can provide its own module system with no additional complexity. ClojureScript uses _namespaces_, which are named collections of functions and data, to organize code. Loading order, preventing circular dependencies, and compiling to a single asset for production are all part of the standard compiler toolchain. As an added benefit, the ClojureScript compiler outputs Google Closure modules, which it then passes off to the Google Closure compiler for additional optimization, including elimination of dead code paths. Having a good module system at the language level tremendously simplifies the setup process of any new project.

### Quick Review

- Which of the following projects would be a good fit for ClojureScript?
  - single-page app such as a dashboard for a CMS
  - adding animations to a static page
  - web-based game with complex asynchronous user interactions
  - CPU-intensive number-crunching simulations
- Does ClojureScript use the same module systems as JavaScript (CommonJS,
  and ES2015)?

## ClojureScript 101

Now that we have seen some of the advantages that ClojureScript can bring to front-end web development, let's take a step back and survey ClojureScript's distinct features. As with any technology that promises to bring significant improvement to the way we code, there will be new concepts. And as with any new concept, the first step towards mastery is familiarity. Let's get ready to explore what makes ClojureScript tick.

### A Compile-to-JavaScript Language

In 2008, if we were to do any client-side web programming, the only viable option was JavaScript. Over the next few years, languages that compiled to JavaScript started to appear. These languages either cleaned up JavaScript's cruft or added some features that were not present in JavaScript itself. Some of these languages were modest in their approach, retaining much of the feel of JavaScript. Others were radical departures from JavaScript that fell into the category of research languages. ClojureScript made significant improvements to JavaScript while sustaining the community support required of a language intended for professional use.

In addition to the other languages that compile to JavaScript, we must consider the fact that many of us are compiling newer versions of JavaScript to older versions so that we can take advantage of language features that make JavaScript more productive and enjoyable before they are supported by the major browsers. Starting with the ES2015 standard, JavaScript has accumulated many of the best ideas from more recent programming languages, but since new features are always introduced quicker than browsers can adopt them, we are perpetually at least a year away from using "Modern JavaScript", and we must unfortunately treat JavaScript itself as a compile-to-js language! In many fields, this sort of complexity would be considered insanity, but in web development, this is the status quo. In contrast to the constant flux of JavaScript, ClojureScript has remained remarkably stable as a language, with much of the innovation happening in libraries rather than the language itself.

As with any compile-to-js language, the fact that ClojureScript exists is a statement that JavaScript is not sufficient. CoffeeScript addressed JavaScript's verbose and inconsistent syntax (it was written in just over a week, after all). TypeScript, Dart, and PureScript address its lack of a type system, enabling developers to better reason about their code. JavaScript itself addresses the age of the language, bringing more modern features while maintaining some semblance to previous versions and providing an easy path to migrate old JavaScript applications. ClojureScript brings a simpler syntax, an arsenal of data structures that rule out a whole class of bugs, a better paradigm for asynchronous programming, and excellent integration with one of the most popular UI frameworks (React). In short, ClojureScript attempts to be a better general-purpose front-end language than JavaScript; and the larger the application, the more its benefits will be evident.

### A Simple Language

JavaScript is a chameleon language. Not only is it possible to write code in imperative, object-oriented, or functional style; it is possible to mix all of these styles in the same codebase. Even if we consider a task as simple as iterating over an array, there are quite a few methods to accomplish this, all of them fairly idiomatic in JavaScript. If we are most comfortable with the imperative style, we could use a `for` loop and manually access each element of the array. On the other hand, we could use the `Array.prototype.forEach()` function (provided we do not have to worry about supporting old browsers). Finally, if we were already using _lodash_ on a project, we could use one of its helper functions. Each of these methods are demonstrated below, and they should look familiar to most JavaScript programmers.

```javascript
const numbers = [4, 8, 15, 16, 23, 42];

for (let num of numbers) {
  // <1>
  console.log(`The number is ${num}`);
}

numbers.forEach(
  // <2>
  (num) => console.log(`The number is ${num}`)
);

const printNum = (num) => {
  // <3>
  console.log(`The number is ${num}`);
};
_.each(numbers, printNum);
```

_Iterating over an array in JavaScript_

1. Imperative
2. Object-oriented
3. Functional

Perhaps more problematic than allowing several styles of programming to coexist in the same codebase is JavaScript's "bad parts" - the quirks that are the subject of so many technical interview questions. When a developer first learns JavaScript, there are a number of pitfalls that she must learn to avoid. Somehow, we have learned to live with all of the additional complexity laid upon us by JavaScript because we have not had the luxury of choosing a simpler language. Consider this partial list of some of JavaScripts quirks and think whether we would be better off adopting a language without so many gotchas:

- variable hoisting
- several ways to set `this`
- `==` vs `===`
- the `void` operator
- `'ba' + + 'n' + 'a' + 's'`
- What does `xs.push(x)` return? What about `xs.concat([x])`?

When we consider all of JavaScript's complexity, we can see that we must code very cautiously or risk being bitten by one of these quirks. For some simple applications, we may be able to live with this, but as our codebases grow, the value of a simpler language becomes more and more apparent. Maintaining a consistent codebase without loads of unnecessary complexity takes a great deal of skill and discipline. While there are a lot of expert JavaScript developers out there who do have the requisite skill and discipline, it does not change the fact that it is **hard** to write good JavaScript at the application level. Thankfully, ClojureScript is a simpler option - admittedly with a learning curve - but it is generally the things with a steeper learning curve that ultimately prove the most valuable.

Whereas we have seen that JavaScript promotes a wide variety of programming styles, ClojureScript is opinionated and is designed to make the functional style of programming easy. In fact, we will see that idiomatic ClojureScript looks a great deal like JavaScript written in the functional style, but with less ceremony. Below is an example of how you could iterate over a vector, which is similar to a JavaScript array.

```clojure
(def numbers [4, 8, 15, 16, 23, 42])

(doseq [n numbers]
  (println "The number is" n))
```

_Iterating over a vector in ClojureScript_

Like the JavaScript code, this defines a sequence of numbers then logs a statement to the console for each of the numbers. It even looks pretty similar to the object-oriented version with the exception that `doseq` is not attached to a particular object prototype. However, this - along with some minor variations - is how you can expect it to look when you need to iterate over a collection in ClojureScript. Always.

### A Powerful Language

One of the spectrums in programming languages is that of how much functionality to include by default. At one extreme is assembly, which translates directly into CPU instructions and has no "standard library", and at the other end is highly-specialized languages that include everything necessary to accomplish most any given task in their problem domain. When it comes to front-end web programming languages, JavaScript leans more towards the spartan end of the spectrum, and ClojureScript leans toward the "batteries included" end, providing higher level tools by default. Between its variety of core data structures and an extensive collection API, macros that allow for extension of the language itself, and the entire Google Closure library available by default, ClojureScript provides more powerful tools for constructing applications.

![Spectrum of programming languages](/img/lesson1/lang-spectrum.png)

_Spectrum of programming languages_

The abstractions provided by ClojureScript are higher-level than those provided by JavaScript, enabling most code to be written more concisely and descriptively. While JavaScript provides numbers, strings, arrays, objects, and simple control structures, ClojureScript provides similar primitives as well as keywords, lists, vectors, sets, maps, protocols, records, and multimethods. Don't worry if you have no idea what any of these things are - after all, that is what this book is all about! While the additional tools mean that there are more things to learn, it also means that there are fewer occasions to learn a new library or write our own data structures and generic algorithms.

### A Functional Language

Love it or hate it, ClojureScript embraces the concept of functional programming. If "functional programming" sounds like an intimidating, academic topic, do not fear - we'll see that most of the functional programming concepts should be at least somewhat familiar for those of us who work with JavaScript on a regular basis. This should not be surprising, since JavaScript was heavily influenced by Scheme (a functional Lisp, just like ClojureScript). Functional programming is one of the three main styles of programming supported by JavaScript, with an emphasis on using functions in the mathematical sense of a mapping of some input value to some output value.

| Paradigm        | Description                                                                                                            | Key Concepts                                                     |
|-----------------|------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------|
| Imperative      | Describes a program as a sequence of statements that may modify the program state, receive input, or produce output.   | Variables, loops, assignment, statements, subroutines            |
| Object-Oriented | Models the real world in terms of objects, their behaviors, and their interactions with each other.                    | Objects, classes or prototypes, methods, messages, object graphs |
| Functional      | Describes a program as a transformation of some input value to some output value using functions that can be composed. | Pure functions, immutable values, higher-order functions         |

_Comparison of JavaScript programming paradigms_

While functional programming in JavaScript is gaining momentum, the majority of code that we are likely to find is either imperative or object-oriented. Without getting too far into the nitty-gritty of functional programming at this point, we can say that ClojureScript focuses on building programs by assembling small functions together that take some data and return some new data without modifying the arguments that were passed in or any global state.

One key feature of writing functions this way is that when you call a function with the same arguments, you always get the same result. While this may seem like an unimportant property for a function, it makes testing and debugging much easier. If most of a program is written as pure functions, tests can be written without any set-up. Contrast this with the typical way that object-oriented systems are tested: a number of objects must be constructed and put into just the right state before every test, or the test will not run correctly.

### Quick Review

- Is the ClojureScript language stable? Why or why not?
- List at least 3 ways in which ClojureScript improves upon JavaScript
- What is the difference between _simplicity_ and _familiarity_? What are some
  aspects of JavaScript that are not simple?
- Does ClojureScript or JavaScript operate at a higher level of abstraction?
- Of the 3 styles of programming that are common in JavaScript (imperative,
  object-oriented, and functional), which is encouraged by ClojureScript?

## Summary

ClojureScript is an incredible useful language, particularly for front-end web development. It shares many of JavaScript's functional programming concepts, but it is both a simpler and more productive language. ClojureScript may appear foreign with all its parentheses, but under the parenthesis-packed surface, it shares much in common with JavaScript. We should now understand:

- What ClojureScript is and what sets it apart from JavaScript
- What types of apps are the best fit for ClojureScript
