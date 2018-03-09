# Quiz

This was a homework assignment for a program structures course at Clackamas Community College. 

This command line application delivers a quiz from a user supplied data file.

# Data File Format

- Must be a .txt file.
- Comments begin with a "#" or "//"
- Quesiont should be one line
- Questions are delimited by "|"
- Multiple choice answers are delimited by ":"
- There are three question types denoted as Short answer "SA, Multiple choice "MC, or True/False "TF"
- Each question should be formatted with fields in the following order:
0. quesiton type
1. question level
2. question text
3a. if TF or SA, answer
3b. if MC, a colon delimited list of possible answers
4b. if MC, the letter of the correct answer
