# Seating-Chart
In 6th grade out lunch tables had assigned seating. However, each student was allowed to name three friends to sit with and the teachers would try their best to meet everyones wants. I did not like the table I was assigned very much. Now having taken an optimization class, I plan to make a program to rectify this issue. 

## MiniZinc
To solve the optimization part of this problem, I used MiniZinc. MiniZinc is a high-level constraint modelling language that allows you to easily express and solve discrete optimisation problems.

## Java Part
The java part reads in a csv. This csv is just the downloaded data from the googleform students filled out. It then populates the whole grade with students and their friends and saves the information in a way MiniZinc can read.
