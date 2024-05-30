# Overview 
This simple java app is to highlight two key details in unit testing.
1. Code quality cannot be measured by test coverage.
2. [ParameterizedTest](https://junit.org/junit5/docs/5.0.2/api/org/junit/jupiter/params/ParameterizedTest.html)(Formerly [Theories](https://junit.org/junit4/javadoc/4.12/org/junit/experimental/theories/Theories.html)) as a way to write way more test cases w/o adding even a single extra line in your test.


## On test coverage

The test coverage metrics often *receives* dangerously high credit. I have seen leaders setting the bar and teams taking victory laps on 100% test coverage. The assumption that your test coverage equates to code quality is flawed, and unfortunately, prevalent across companies of all shapes and sizes.


Even with 100% test coverage, your code may still have bugs and flaws. Therefore, test coverage alone should not be used as the assurance metrics. During the PR reviews, test coverage should be use as a stepping stone to further the discussion on test code quality. For example, reviewer might say something like this - 
* "I don’t 100% test coverage on your changes. Will you update your tests, and then I can resume my review?"
* "Thanks for 100% test coverage. Let me review if these test cover all the use cases."

The quality of your code can be best determined by scenario coverage. Simply speaking, this means writing test cases to represent different ways your user will interact with the system. Unfortunately, there isn't a tool that can measure the scenario-coverage because different systems are used differently. A good way is to break down how your users will use the system, aka scenario. 

Consider a hypothetical sign-up system. You could organize your scenarios like this -  

| Scenario | Anticipated usage | Scenario coverage notes |
| - | - |- |
| User fills out all form fields correctly | 60% of the time |  Must have |
| User submits blank form | 20% of the time |  Must have |
| User enters invalid email | 30% of the time |  Must have |
| User enters invalid password | 30% of the time |  Must have |
| User enters special character in password | 50% of the time | Must have |
| User enters an emoji in the middle name | 1% of the time |  Deferrable |

This can take some time in the early attempts, but it becomes intuitive with repeated practice.


## On ParameterizedTest
[ParameterizedTest](https://junit.org/junit5/docs/5.0.2/api/org/junit/jupiter/params/ParameterizedTest.html), equivalent to [Theories](https://junit.org/junit4/javadoc/4.12/org/junit/experimental/theories/Theories.html) in junit4, provides a mechanism to write lot more test cases w/o much increase in lines of code. Magic, right!!

## ParameterizedTest metrics
| Test | Number of test cases | Lines of code | Note |
| - | - |- |- |
| V1 | 1 | 30 | 100% test coverage but minuscle scenario coverage |
| V2 | 12 | 80 | 100% test, a good deal of scenario |
| V3 | 22 | 60 | 100% test, lot more scenario |
| V3 | Add as many as you want | 60 | Lot more scenario. No increase in lines of code |
