package game;/*
    File: game.Main.java
    Author: Alex Klein
    Date: 04/13/2022
    Description: Here is the driver for the program

 */

//TODO: Optimize Imports

import entity.*;
import utility.*;

import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    //TODO: Just a main run to see that the sim works. Revise this to make actual game loop
    public static void main(String[] args) {
        //Create hash maps for storage
        HashMap<Integer, Student> studentHashMap = new HashMap<Integer, Student>();
        HashMap<Integer, Staff> staffHashMap = new HashMap<Integer, Staff>();
        HashMap<Integer, String> fNameReference = new HashMap<Integer, String>();
        HashMap<Integer, String> lNameReference = new HashMap<Integer, String>();
        int student_cap;
        int staff_cap;
        int dungeon;
        //Generate a new standard school with rooms
        System.out.println("Starting by generating the school");
        StandardSchool standardSchool = new StandardSchool();
        Director director = new Director(standardSchool);
        //Pull capacities
        student_cap = standardSchool.getTotalStudentCapacity();
        staff_cap = standardSchool.getMinimumStaffRequirements();

        System.out.println("entity.Student capacity is " + student_cap);
        System.out.println("entity.Staff capacity is " + staff_cap);

        System.out.println("Connecting rooms");
        RoomConnector roomConnector = new RoomConnector(standardSchool);
        System.out.println("Show connections");
        roomConnector.getConnections();
        System.out.println("Populating school...");
        //Store student objects in hashmap
        for (int i = 0; i < student_cap; i++) {
            studentHashMap.put(i, new Student());
        }
        //Store staff objects in another hashmap
        for (int j = 0; j < staff_cap; j++) {
            staffHashMap.put(j, new Staff());
        }
        //Set for student randomization
        System.out.println("Randomizing " + student_cap + " students...");
        fNameReference.putAll(NameLoader.readCSVFirst(true));
        lNameReference.putAll(NameLoader.readCSVLast(true));
        for (int k = 0; k < student_cap; k++) {
            String f_name = fNameReference.get(setRandom(0, fNameReference.size() - 1));
            String l_name = lNameReference.get(setRandom(0, lNameReference.size() - 1));
            System.out.println("   Generating student " + f_name + " " + l_name);
            Student student = studentHashMap.get(k);
            student.studentName.setFirstName(f_name);
            student.studentName.setLastName(l_name);
            student.studentStatistics.setHairColor(TraitSelection.hairSelection(setRandom(0, 102)));
            student.studentStatistics.setEyeColor(TraitSelection.eyeSelection(setRandom(0, 109)));
            student.studentStatistics.setHeight(setRandom(48, 78));
            student.studentStatistics.setIntelligence(setRandom(0, 15));
            student.studentStatistics.setCharisma(setRandom(0, 15));
            student.studentStatistics.setAgility(setRandom(0, 15));
            student.studentStatistics.setDetermination(setRandom(0, 15));
            student.studentStatistics.setStrength(setRandom(0, 15));
            student.studentStatistics.setLevel(1);
            student.studentStatistics.setExperience(0);
            student.studentStatistics.setGradeLevel(setRandom(0,3));
        }
        //Clear map for new values
        fNameReference.clear();
        lNameReference.clear();
        //Set for staff randomization
        System.out.println("Randomizing " + staff_cap + " staff");
        fNameReference.putAll(NameLoader.readCSVFirst(false));
        lNameReference.putAll(NameLoader.readCSVLast(false));
        for (int l = 0; l < staff_cap; l++) {
            String f_name = fNameReference.get(setRandom(0, fNameReference.size() - 1));
            String l_name = lNameReference.get(setRandom(0, lNameReference.size() - 1));
            System.out.println("   Generating staff " + f_name + " " + l_name);
            Staff staff = staffHashMap.get(l);
            staff.teacherName.setFirstName(f_name);
            staff.teacherName.setLastName(l_name);
            staff.teacherStatistics.setHairColor(TraitSelection.hairSelection(setRandom(0, 102)));
            staff.teacherStatistics.setEyeColor(TraitSelection.eyeSelection(setRandom(0, 109)));
            staff.teacherStatistics.setHeight(setRandom(50, 84));
            staff.teacherStatistics.setIntelligence(setRandom(2, 22));
            staff.teacherStatistics.setCharisma(setRandom(1, 22));
            staff.teacherStatistics.setAgility(setRandom(1, 19));
            staff.teacherStatistics.setDetermination(setRandom(1, 20));
            staff.teacherStatistics.setStrength(setRandom(1, 20));
        }
        System.out.println("Done creating school and students");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++");
        //Welcome
        System.out.println("Welcome to " + standardSchool.getSchoolName());
        //Introduce me to random student
        System.out.println("Introduce me to a random student, please.");
        Inspector.studentInspection(studentHashMap.get(setRandom(0, studentHashMap.size() - 1)));
        //Introduce me to a random teacher
        System.out.println("Ok now introduce me to a random teacher, please.");
        Inspector.staffInspection(staffHashMap.get(setRandom(0, staffHashMap.size() - 1)));
        //This is the first Monday of school
        System.out.println("Alright time to get on with the time then...");
        Time time = new Time();
        System.out.println("Today is " + time.getFormattedDate());
        System.out.println("Each time might present a new challenge that every student must face");
        Homework first_homework = new Homework();
        //Each student must face the first boss
        for (int m = 0; m < student_cap; m++) {
            dungeonFight(studentHashMap.get(m), first_homework);
        }
        System.out.println("Alright let's see how a random student did...");
        Student day1 = studentHashMap.get(setRandom(0, studentHashMap.size() - 1));
        System.out.println("Hey " + day1.studentName.getFirstName());
        System.out.println("Ok so " + day1.studentName.getFirstName() + " got a " + day1.studentStatistics.getGradeAverage());
        System.out.println("Well tomorrow's a new time. Let's simulate another 10 of them!");
        time.incrementDayCounter();
        //Simulate the whole school for 10 days
        for (int n = 0; n < 9; n++) {
            System.out.println("Today is " + time.getDayName());
            dungeon = bossDecision(time);
            if (dungeon == 1) {
                Homework homework = new Homework();
                for (int o = 0; o < student_cap; o++) {
                    dungeonFight(studentHashMap.get(o), homework);
                }
                time.incrementDayCounter();
            } else if (dungeon == 2) {
                Quiz quiz = new Quiz();
                for (int p = 0; p < student_cap; p++) {
                    dungeonFight(studentHashMap.get(p), quiz);
                }
                time.incrementDayCounter();
            } else if (dungeon == 3) {
                Exam exam = new Exam();
                for (int q = 0; q < student_cap; q++) {
                    dungeonFight(studentHashMap.get(q), exam);
                }
                time.incrementDayCounter();
            } else {
                time.incrementDayCounter();
            }
        }
        System.out.println("Now let's check on a random student...");
        Student lastStudent = studentHashMap.get(setRandom(0, studentHashMap.size() - 1));
        Inspector.studentInspection(lastStudent);
        System.out.println("So " + lastStudent.studentName.getFirstName() + " you have the following grades:");
        lastStudent.studentStatistics.getAllGrades();
        System.out.println(lastStudent.studentName.getFirstName() + "'s average was " + lastStudent.studentStatistics.getGradeAverage());

    }

    //Not ideal design but need to add a few helpers here for simulation
    private static Integer setRandom(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    //TODO: Separate this from main
    //What type of boss will we get today
    private static int bossDecision(Time time) {
        if (time.getDayName().equals("Monday") || time.getDayName().equals("Tuesday") || time.getDayName().equals("Thursday")) {
            System.out.println("Today all students will have to face homework!");
            return 1;
        } else if (time.getDayName().equals("Wednesday")) {
            System.out.println("Today all students will have to be ready for a quiz!");
            return 2;
        } else if (time.getDayName().equals("Friday")) {
            System.out.println("Today the students better be ready for the dreaded exam!");
            return 3;
        } else {
            System.out.println("Today is the weekend. No school!");
            return 4;
        }
    }

    //TODO: Separate this from main
    //TODO: Revise stat vs grade system to create better dist of grades/abilities
    //The showdown between a student and exam/quiz/homework
    private static void dungeonFight(Student student, Boss boss) {
        int finalGrade = 0;
        int bossStat = 0;
        int bossHP = 0;
        double studentAtk = 0;
        double result = 0;
        int expGain = 0;
        //Start to calculate entity.Boss HP
        bossStat = boss.getStatsNumberOfQuestions() / boss.getStatsTime();
        bossHP = bossStat * boss.getStatsDifficulty();
        //Calculate student attack power
        studentAtk = student.studentStatistics.getIntelligence() * (student.studentStatistics.getDetermination() - student.studentStatistics.getBoredom() * .10);
        //Run the fight
        result = bossHP / studentAtk;

        //if student is asleep random chance to wake back up before test based on determination
        if (student.studentStatistics.getSleepState()) {
            int chance = setRandom(0, 10) * student.studentStatistics.getDetermination();
            if (chance >= 50) {
                student.studentStatistics.setSleepState(false);
                student.studentStatistics.setBoredom(0);
            }
        }
        if (result <= 0.5) {
            //entity.Student got an A
            finalGrade = setRandom(90, 100);
            student.studentStatistics.setExperience(15);
            //Chance for stat boost
            if (finalGrade == 100) {
                student.studentStatistics.setBoredom(0);
                student.studentStatistics.setDetermination(student.studentStatistics.getDetermination() + 1);
                student.studentStatistics.setExperience(20);
            }
        } else if (result >= .5 && result <= 1) {
            //entity.Student got a B
            finalGrade = setRandom(80, 89);
            student.studentStatistics.setExperience(12);
        } else if (result >= 4 && result <= 6) {
            //entity.Student got a C
            finalGrade = setRandom(70, 79);
            student.studentStatistics.setExperience(9);

        } else if (result >= 7 && result <= 8) {
            //entity.Student got a D
            finalGrade = setRandom(60, 69);
            student.studentStatistics.setExperience(5);
        } else if (result >= 9) {
            //entity.Student got an F
            finalGrade = setRandom(0, 59);
            //Chance for boredom to set in
            if (finalGrade < 3) {
                student.studentStatistics.setBoredom(student.studentStatistics.getBoredom() + 1);
            }
            if (finalGrade < 2) {
                student.studentStatistics.setSleepState(true);
            }
            student.studentStatistics.setExperience(2);
        }
        //Record student grade
        student.studentStatistics.setNewGrade(finalGrade);
        student.studentStatistics.setGradeAverage();
    }

}