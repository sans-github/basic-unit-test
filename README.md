# Overview 
This simple java app is to highlight two key details in unit testing.
1. Code quality cannot be measured by test coverage.
2. Using ParameterizedTest(Formerly Theory) to write way more test cases w/o having to add even a single extra line in your test file.


## On test coverage

The test coverage metrics often *receives* dangerously high credit. I have often seen leaders setting the bar and teams taking victory lap on 100% coverage. Just because your code has 100% test coverage does not mean your code will work in all conditions. This is misguided, and unfortunately, prevalant across companies of all shapes and sizes. 

The quality of your code can be best determined by scenario coverage. Simply speaking, this means envisioning different ways your user will interact with the system, and writing test cases representative of those scenario. Unfortunately, there isn't a tool that can measure the scenario-coverage. This can be specially challenging for new developers, but it becomes intuitive with repeated practice.


## On ParameterizedTest
[ParameterizedTest](https://junit.org/junit5/docs/5.0.2/api/org/junit/jupiter/params/ParameterizedTest.html), equivalent to [Theories](https://junit.org/junit4/javadoc/4.12/org/junit/experimental/theories/Theories.html) in junit4, provides a mechanism to write lot more test cases w/o much increase in lines of code. Magic, right!!

## ParameterizedTest metrics
| Test | Number of test cases | Lines of code | Note |
| - | - |- |- |
| V1 | 1 | 30 | 100% test coverage but minuscle scenario coverage |
| V2 | 12 | 80 | 100% test, a good deal of scenario |
| V3 | 22 | 60 | 100% test, lot more scenario |
| V3 | Add as many as you want | 60 | Lot more scenario. No increase in lines of code |
