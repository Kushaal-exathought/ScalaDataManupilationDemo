# Project: ScalaData

## CAVEATS

So I don't repeat the same thing over and over with each point below, let me say up front that I know you write this as
a way to actually use what you have learned reading up on Scala so you took shortcuts you wouldn't otherwise. I am going
to point out these shortcuts that I do not like as for me, I would have to consciously force myself to take those
shortcuts and likely would never do so as I treat all my code as something I would want to put in production and that
way I don't have to think about not taking shortcuts, etc.

## General

1. `gitignore` - You had a gitignore but only under the .idea folder. Best to put one at the root and to make your life
   easier, go to gitignore.io to generate the base that you can then add to with your specific project structure.
1. `Code cleanliness`
    * if you have the Scala plugin installed in your IntelliJ IDE, much of what I will say below would have been easily
      visible
    * Always keep your code as clean as possible and getting rid of compiler warnings is one of the easiest things to do
      toward that end.
1. `semi-colons` - This is a habit from I have too since I learned Java first butin Scala you only need to use
   semi-colons if you have multiple statements on the same line.

## Design

1. `Hardcoded paths` - You placed the files in the resources folder but didn't use then read the file as a resource.
1.

## Units Tests

1. `Tests should be in same package a class being tested` - Avoids some unnecessary imports.


