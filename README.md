# exam-find-middle

The solution for challenge 7 form the Scala academy exam.

## What you need

* Java 11
* Scala 2.13.8
* Sbt 1.6.2

## How to run

* In order to run the application enter the command `sbt run`
* In order to run tests enter the command `sbt test `

## Explanation 

* To fix the algorithm you need to add the following lines at the beginning of the match clause
```java
case head :: tail if tail == Nil => Some(head)
case head :: tail if tail.tail == Nil => acc.headOption
```

* I came to this conclusion by running the app for some simple examples. I noticed that the algorithm always returns one value too late from the accumulator. Therefore, at the beginning I added line `case head :: tail if tail.tail == Nil => acc.headOption` which solves this problem. Then I had problem with the case when list has only one element, so I added line `case head :: tail if tail == Nil => Some(head)`. Then I wrote tests to check again that the code is working properly and in order to document it. Now, one can think how to simplify match clause, but I do not have time to do that during exam.
