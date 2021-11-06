# Programming Project: Max Scrabble

## Learning Objectives

1. Use inheritance to leverage the code provided in a superclass to perform a task (opening and reading in the lines of a text file).
2. Writing code that conforms to a specification.
3. Developing code that will work with existing code.
4. Creating code that correctly implements an algorithm as specified.
   Making essential use of a data structure (array) in your code to implement an algorithm.
5. Gaining further experience developing code incrementally: writing a small amount of code and then testing.
6. Gain further experience writing modular code: writing methods that perform small tasks in service of the larger task.

## Clone Project

Begin by cloning the provided project and importing it into your workspace.

`git clone <url for github repository>`

After cloning this repository you want to run these commands

`git checkout -b development`

This will create a branch named development and switch you to it. The development branch is where you will make all your commits.

## Import into Eclipse

You should then go to Eclipse, which hopefully has finished installing.

In the top toolbar, click File --> Import. Double-click on General and then `Projects from Folder or Archive`. Click `Directory` and find the folder inside the repository named `MaxScrabble` and click Open. The project should pop up in the text box Projects. Click Finish and you should be good to go!

## Complete Max Scrabble Project

The board game scrabble works by assigning points to wooden tiles arranged in cells on a board. It's described here: Scrabble.
We'll simplify this considerably, and consider the following question. We begin with the letter-scoring scheme from Scrabble:

`a = 1, b = 3, c = 3, d = 2, ..., z = 10.`

Given a text file - a novel for example, what is the highest-(or a highest-) scoring line in the the file? In keeping with the Scrabble style, we'll add double and triple letter scores: any letter that falls at a line (String) position that's evenly divisible by 4 will have its score doubled; and any letter that falls at a line (String) position that's evenly divisible by 9 will have its score tripled. A letter at a position that's evenly divisible by 4 and 9 will have its score doubled, not tripled. All non-letters (e.g., space, comma, etc.) have score 0.

Example: the line "now is the time" has a Scrabble score (by our rules) of 29. (Important: verify this with pencil and paper. Note that "n" is at position 0, which is a double letter score.)

Your solution is in two classes: A driver class called MaxScrabbleDriver, and a class called MaxScrabble, which does the heavy lifting for the application. The MaxScrabble class should extend TextFileAccessor, in the standard way we've indicated.

## Output

Your program should report the (or a) highest scoring line in the input file, along with the score for that line.

Two sample files are provided: sampletext.txt is silly but useful, and HeartOfDarkness.txt is the famous novella by Joseph Conrad.

Some sample output:

```
enter file name
 sampletext.txt
winner: "and aid. their. party?" score: 40
-------------------------------
enter file name
 HeartOfDarkness.txt
winner: "plenty time. i can manage. you take kurtz away quick--quick--i tell" score: 192
```

## Tips

Here is a list from a to z of the letter scores from Scrabble:

```
{1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10}
```

Notice that this list is in proper format for copying and pasting directly into your program as an int array.

It's far easier to convert lines of text to lowercase before processing.

Model your driver class after the ScrabbleDriver class in the ScrabbleFrequencies project (which means you should use a try-catch harness and a Scanner to read in the file)

You need to comment your methods according to this [Javadoc Guide](https://github.com/jd12/liferay-portal/blob/master/readme/ADVANCED_JAVADOC_GUIDELINES.markdown).
