package entity.Rooms;//*******************************************************************
//  entity.Rooms.Classroom.java
//  Description: This represents a classroom object. Implements entity.Rooms.Room
//  Bugs:
//
//  @author     Alex Klein
//  @version    04242022
//*******************************************************************

import entity.Staff;
import entity.StaffType;
import entity.StandardSchool;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Classroom implements Room, Serializable {

    private int roomCapacity;
    private int numOfConnections;
    private int windowCount;
    private String roomName;
    private int numOfDoors;
    private int staffCap;
    private int studentCap;
    private String roomNumber;
    private boolean studentRestriction;
    private String classRoomType;
    private final List<Staff> staffAssign;

    public Classroom() {
        this.roomCapacity = 0;
        this.numOfConnections = 0;
        this.windowCount = 0;
        this.roomName = null;
        this.numOfDoors = 0;
        this.staffCap = 0;
        this.studentCap = 0;
        this.roomNumber = null;
        this.studentRestriction = false;
        this.classRoomType = null;
        this.staffAssign = new ArrayList<>();
    }

    @Override
    public void reset() {

    }

    @Override
    public void setRoomCapacity(int capacity) {
        this.roomCapacity = capacity;
    }

    @Override
    public void setWindowCount(int windows) {
        this.windowCount = windows;
    }

    @Override
    public void setDoors(int doors) {
        this.numOfDoors = doors;
    }

    @Override
    public void setInitialStaff(int staffCount) {
        this.staffCap = staffCount;
    }

    @Override
    public void setInitialStudents(int studentCount) {
        this.studentCap = studentCount;
    }

    @Override
    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    @Override
    public void setStudentRestriction(boolean studentRestriction) {
        this.studentRestriction = studentRestriction;
    }

    public String getRoomName() {
        return this.roomName;
    }

    @Override
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public void setClassroomType(int select) {
        switch (select) {
            case 0 -> this.classRoomType = "Math";
            case 1 -> this.classRoomType = "English";
            case 2 -> this.classRoomType = "Science";
            case 3 -> this.classRoomType = "History";
            case 4 -> this.classRoomType = "Language";
            case 5 -> this.classRoomType = "Electives";
            case 6 -> this.classRoomType = "Study Hall";
        }
    }

    public void setClassRoomType(String type) {
        this.classRoomType = type;
    }

    public void setDetention() {
        this.classRoomType = "Detention";
    }

    @Override
    public int getStudentCapacity() {
        return studentCap;
    }

    @Override
    public int getStaffCapacity() {
        return staffCap;
    }

    public String getClassRoomType() {
        return classRoomType;
    }

    public String getClassTypeAbbr() {
        String abbr = null;
        String type = getClassRoomType();

        switch (type) {
            case "Math" -> abbr = "MAT";
            case "English" -> abbr = "ENG";
            case "Science" -> abbr = "SCI";
            case "History" -> abbr = "HST";
            case "Language" -> abbr = "LNG";
            case "Vocational" -> abbr = "VOC";
            case "Consumer Science", "Business", "Computer Science" -> abbr = "ELC";
            case "Study Hall" -> abbr = "STY";
            default -> System.out.println("No known class type!");
        }

        return abbr;

    }

    @Override
    public int getConnections() {
        return this.numOfConnections;
    }

    @Override
    public void setConnections(int connections) {
        this.numOfConnections = connections;
    }

    @Override
    public String toString() {
        return this.roomName;
    }

    @Override
    public List<Staff> getAssignedStaff() {
        return this.staffAssign;
    }

    @Override
    public void setAssignedStaff(Staff staff) {
        staffAssign.add(staff);
    }

    @Override
        public void removeAssignedStaff(Staff staff) {
            staffAssign.remove(staff);
        }

        public void reassignClassroomByTeacher() {
            String staffType = getAssignedStaff().get(0).teacherStatistics.getStaffType().toString();
        String roomType = getClassRoomType();

        if (!roomType.equals(staffType)) {
            setClassRoomType(staffType);
        }
    }

    public void setStudentCap() {this.studentCap = roomCapacity - staffCap;}

}
