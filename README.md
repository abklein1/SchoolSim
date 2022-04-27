# SER316-Indvidual-Project-abklein1

This repo covers assignments 5a-b

For this project I made a detailed RPG simulator of a high school using Design Patterns from GoF.

I used a builder design pattern to proceedurally generate a high school and all specific rooms/ classrooms.
From the builder, I used the school size (via number of classrooms and offices) to calculate the maximum number of
students and minimum number of staff needed to run a school.

Next, I developed an Abstract Factory to build different types of People (staff and students) using components that
make up a person, defined through an Interface. Students and staff are stored in separate hash maps for quick reference.
People are then generated with attributes and stats.

I used a Singleton design pattern to generate days. The days act as a form of step within the state machine that is 
the school and the people that attend/work at the school. Each day of the week defines a different Boss in the form of
an Exam, Quiz, or homework, which each student in the school must face. The student has stats that are calculated against
the stats of the Boss. The student may walk away with a grade and some experience or a bad status effect. Grades can be
calculated to receive an average.
