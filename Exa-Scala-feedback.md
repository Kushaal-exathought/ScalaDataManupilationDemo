# Project: ScalaData

## CAVEATS
So I don't repeat the same thing over and over with each point below, let me say up front that I know you write this as
a way to actually use what you have learned reading up on Scala, so you took shortcuts you wouldn't otherwise. I am going
to point out these shortcuts that I do not like as for me, I would have to consciously force myself to take those
shortcuts and likely would never do so as I treat all my code as something I would want to put in production and that
way I don't have to think about not taking shortcuts, etc.

## General
1. `gitignore` - You had a gitignore but only under the .idea folder. Best to put one at the root and to make your life
   easier, go to gitignore.io to generate the base that you can then add to with your specific project structure.
2. `Code cleanliness`
    * if you have the Scala plugin installed in your IntelliJ IDE, much of what I will say below would have been easily
      visible
    * Always keep your code as clean as possible and getting rid of compiler warnings is one of the easiest things to do
      toward that end.
3. `Coding conventions` - You should always follow a defined style guide to make your code more readable so anyone else looking at it just reads the code instead of first trying to decipher how you wrote it and then seeing the logic you implemented. I just ran the default Format Code within intelliJ to make it a little easier to read but more can be done.
4. `semi-colons` - This is a habit from I have too since I learned Java first but in Scala you only need to use
   semicolons if you have multiple statements on the same line.

## Design
1. `Scala is a JVM language` - You can use any Java library in your code. For example, there are a million CSV Parsers out there that would have simplified your code and saved you time.
2. As a general statement, I like what you have done. I would have use some libraries to make things a little easier but otherwise pretty good. 
3. `Hardcoded paths` - You placed the files in the resources folder but didn't use then read the file as a resource

## Unit Tests
1. `Tests should be in same package a class being tested` - Avoids some unnecessary imports.
2. `Use a template` -
   * I always follow a template for how I structure each of my tests. Common templates are `Given-When-Then` or `Arrange-Act-Assert` this makes your tests easier to understand.
   * ScalaTest actually has a support for FeatureSpec and GivenWhenThen, so you can add split up your tests and make them more explicit. https://www.scalatest.org/getting_started_with_feature_spec
3. `Each test should cover a scenario` - You covered some, but you could have checked some more (empty file, etc)


