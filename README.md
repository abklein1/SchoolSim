# SchoolSim

***Originally a school project that has been modified***

## Intro

For this project I made a detailed RPG simulator of a high school using Design Patterns from GoF.

I used a Builder design pattern to proceedurally generate a high school and all specific rooms/ classrooms.
Rooms are an interface that serve as a template for specific room objects. A director object assembles the school
by organizing a series of concrete builders.
From the builder, I used the school size (via number of classrooms and offices) to calculate the maximum number of
students and minimum number of staff needed to run a school.

Next, I developed an Abstract Factory to build different types of People (staff and students) using components that
make up a person, defined through an Interface. Students and staff are stored in separate hash maps for quick reference.
People are then generated with attributes and stats. There are no "races" in this, like a typical RPG, but students
and teachers have a chance at different base stats. Students and teachers can equip items to different parts of their bodies
which are objects in themselves. Items would have been implemented given more time. Teachers are meant to be trainers, but
their complete implementation was not finished. Student and teacher first and last names are generated using US census data.
Hair and eye colors are built using a real-ish distribution of hair/eye colors.

I used a Singleton design pattern to generate days. The days act as a form of step within the state machine that is 
the school and the people that attend/work at the school. Each time of the week defines a different Boss in the form of
an Exam, Quiz, or homework, which each student in the school must face. The student has stats that are calculated against
the stats of the Boss. The student may walk away with a grade and some experience or a bad status effect. Grades can be
calculated to receive an average. The days work in the way that "floors" should function.

## School Generation 

The layout of the high school is procedurally generated. First, individual rooms are created. Then the "backbone" of the school is constructed using hallways and courtyards. Hallways and courtyards are randomly connected using an undirected graph. A connectivity inspector ensures that all backbone rooms are traversable from any other room. After the backbone is constructed rooms are procedurally added to the backbone or other rooms in the following order:
- Athletic Fields
- Auditoriums
- Gyms
- Lunchrooms
- Libraries
- Music Rooms
- Art Rooms
- Drama Rooms
- Offices
- Student Bathrooms
- Classrooms
- Science Labs
- Computer Labs
- Utility Rooms
- Breakrooms
* Coming soon *
- Conference Rooms
- Parking Lots

The front office will always contain a connection to the principal and vice principal's office.

## Student and Staff Stat Generation
* TODO *
