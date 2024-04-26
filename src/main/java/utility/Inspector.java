package utility;

import entity.Staff;
import entity.Student;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Inspector {
    public static void studentInspection(Student student) {
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);

        StringBuilder sb = new StringBuilder();
        String firstName = student.studentName.getFirstName();
        String lastName = student.studentName.getLastName();
        String gender = student.studentStatistics.getGender();
        //String race = student.studentStatistics.getRace();
        String hairColor = student.studentStatistics.getHairColor();
        String eyeColor = student.studentStatistics.getEyeColor();
        String skinColor = student.studentStatistics.getSkinColor();
        String hairLength = student.studentStatistics.getHairLength();
        String hairType = student.studentStatistics.getHairType();
        double height = student.studentStatistics.getHeight();
        String grade = student.studentStatistics.getGradeLevel();
        LocalDate birth = student.studentStatistics.getBirthday();

        sb.append(firstName).append(" ").append(lastName).append("\n=====================================\n");
        sb.append(firstName).append(" is a ").append(gender.toLowerCase()).append(" with ");
        sb.append(skinColor).append(" colored skin and ");
        sb.append(hairLength.toLowerCase()).append(", ").append(hairType.toLowerCase()).append(", ").append(hairColor.toLowerCase());
        sb.append(" hair and ").append(eyeColor.toLowerCase()).append(" eyes. ");
        sb.append("They stand ").append(df.format(height)).append(" inches tall.\n");
        sb.append(firstName).append(" is a ").append(grade).append(".\n");
        sb.append(firstName).append(" was born on ").append(birth).append(".\n");
        sb.append("They have the following base stats:\n   INTELLIGENCE: ").append(student.studentStatistics.getIntelligence());
        sb.append("\n   CHARISMA: ").append(student.studentStatistics.getCharisma()).append("\n   AGILITY: ");
        sb.append(student.studentStatistics.getAgility()).append("\n   DETERMINATION: ").append(student.studentStatistics.getDetermination());
        sb.append("\n   PERCEPTION: ").append(student.studentStatistics.getPerception()).append("\n   STRENGTH: ");
        sb.append(student.studentStatistics.getStrength()).append("\n   EXP: ").append(student.studentStatistics.getExperience()).append("\n");
        sb.append("They have the following secondary stats:\n   Creativity: ").append(student.studentStatistics.getCreativity());
        sb.append("\n   Empathy: ").append(student.studentStatistics.getEmpathy()).append("\n   Adaptability: ");
        sb.append(student.studentStatistics.getAdaptability()).append("\n   Initiative: ").append(student.studentStatistics.getInitiative());
        sb.append("\n   Resilience: ").append(student.studentStatistics.getResilience()).append("\n   Curiosity: ");
        sb.append(student.studentStatistics.getCuriosity()).append("\n   Responsibility: ").append(student.studentStatistics.getResponsibility());
        sb.append("\n   Open-Mindedness: ").append(student.studentStatistics.getOpenMindedness()).append("\n");
        sb.append(firstName).append(" has the following status effects:\n");
        if (student.studentStatistics.getBoredom() == 0) {
            sb.append(firstName).append(" is not bored.\n");
        } else {
            sb.append(firstName).append(" is slightly bored.\n");
        }
        if (student.studentStatistics.getSleepState()) {
            sb.append(firstName).append(" is asleep!\n");
        } else {
            sb.append(firstName).append(" is not asleep.\n");
        }
        sb.append("Nice to meet you ").append(firstName).append("!");

        System.out.println(sb);
    }

    public static void staffInspection(Staff staff) {
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);

        StringBuilder sb = new StringBuilder();
        String firstName = staff.teacherName.getFirstName();
        String lastName = staff.teacherName.getLastName();
        String gender = staff.teacherStatistics.getGender().toLowerCase();
        String hairColor = staff.teacherStatistics.getHairColor().toLowerCase();
        String hairLength = staff.teacherStatistics.getHairLength().toLowerCase();
        String hairType = staff.teacherStatistics.getHairType().toLowerCase();
        String eyeColor = staff.teacherStatistics.getEyeColor().toLowerCase();
        double height = staff.teacherStatistics.getHeight();
        LocalDate birth = staff.teacherStatistics.getBirthday();

        sb.append(firstName).append(" ").append(lastName).append("\n=====================================\n");
        sb.append(firstName).append(" is a ").append(gender).append(" with ");
        sb.append(hairLength).append(", ").append(hairType).append(", ").append(hairColor);
        sb.append(" hair and ").append(eyeColor).append(" eyes. They stand ");
        sb.append(df.format(height)).append(" inches tall.\n");
        sb.append(firstName).append(" was born on ").append(birth).append(".\n");
        sb.append("They have the following stats:\n   INTELLIGENCE: ").append(staff.teacherStatistics.getIntelligence());
        sb.append("\n   CHARISMA: ").append(staff.teacherStatistics.getCharisma()).append("\n   AGILITY: ");
        sb.append(staff.teacherStatistics.getAgility()).append("\n   DETERMINATION: ").append(staff.teacherStatistics.getDetermination());
        sb.append("\n   PERCEPTION: ").append(staff.teacherStatistics.getPerception()).append("\n   STRENGTH: ");
        sb.append(staff.teacherStatistics.getStrength()).append("\n");
        sb.append("They have the following secondary stats:\n   Creativity: ").append(staff.teacherStatistics.getCreativity());
        sb.append("\n   Empathy: ").append(staff.teacherStatistics.getEmpathy()).append("\n   Adaptability: ");
        sb.append(staff.teacherStatistics.getAdaptability()).append("\n   Initiative: ").append(staff.teacherStatistics.getInitiative());
        sb.append("\n   Resilience: ").append(staff.teacherStatistics.getResilience()).append("\n   Curiosity: ");
        sb.append(staff.teacherStatistics.getCuriosity()).append("\n   Responsibility: ").append(staff.teacherStatistics.getResponsibility());
        sb.append("\n   Open-Mindedness: ").append(staff.teacherStatistics.getOpenMindedness()).append("\n");
        sb.append(firstName).append(" has the following status effects:\n");
        if (staff.teacherStatistics.getBoredom() == 0) {
            sb.append(firstName).append(" is not bored.\n");
        } else {
            sb.append(firstName).append(" is slightly bored.\n");
        }
        if (staff.teacherStatistics.getSleepState()) {
            sb.append(firstName).append(" is asleep!\n");
        } else {
            sb.append(firstName).append(" is not asleep.\n");
        }
        sb.append("Nice to meet you ").append(firstName).append("!");

        System.out.println(sb);
    }

    public static void gradeClassInspection(HashMap<Integer, Student> studentGradeClass) {
        for (Map.Entry<Integer, Student> entry : studentGradeClass.entrySet()) {
            System.out.println(entry.getValue().studentName.getFirstName() + " " + entry.getValue().studentName.getLastName());
        }
    }

    public static void findHighestStudent(HashMap<Integer, Student> studentHashMap) {
        Student temp;
        Student high = null;
        int total;
        int top = 0;

        for (Map.Entry<Integer, Student> entry : studentHashMap.entrySet()) {
            temp = entry.getValue();
            total = temp.studentStatistics.getIntelligence() + temp.studentStatistics.getCharisma()
                    + temp.studentStatistics.getAgility() + temp.studentStatistics.getDetermination()
                    + temp.studentStatistics.getPerception() + temp.studentStatistics.getStrength();
            if (total > top) {
                top = total;
                high = temp;
            }
        }

        assert high != null;
        studentInspection(high);
    }

    public static void findLowestStudent(HashMap<Integer, Student> studentHashMap) {
        Student temp;
        Student low = null;
        int total;
        int bottom = 1000;

        for (Map.Entry<Integer, Student> entry : studentHashMap.entrySet()) {
            temp = entry.getValue();
            total = temp.studentStatistics.getIntelligence() + temp.studentStatistics.getCharisma()
                    + temp.studentStatistics.getAgility() + temp.studentStatistics.getDetermination()
                    + temp.studentStatistics.getPerception() + temp.studentStatistics.getStrength();
            if (total < bottom) {
                bottom = total;
                low = temp;
            }
        }

        assert low != null;
        studentInspection(low);
    }
}
