package data;

import java.time.LocalDateTime;

public class StudyGroup implements Comparable {
    private Long id;
    private String name;
    private Coordinates coordinates;
    private LocalDateTime creationDate;
    private Long studentsCount;
    private Long transferredStudents;
    private int averageMark;
    private Semester semesterEnum;
    private Person groupAdmin;

    public StudyGroup(Long id, String name, Coordinates coordinates,
                      LocalDateTime creationDate,Long studentsCount,
                      Long transferredStudents,int averageMark,Semester semesterEnum,Person groupAdmin) {

        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.studentsCount=studentsCount;
        this.transferredStudents = transferredStudents;
        this.averageMark = averageMark;
        this.semesterEnum = semesterEnum;
        this.groupAdmin= groupAdmin ;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public Long getstudentsCount(){
        return studentsCount;
    }

    public Long gettransferredStudents() {
        return transferredStudents;
    }

    public int getaverageMark() {
        return averageMark;
    }

    public Semester getsemesterEnum() {
        return semesterEnum;
    }

    public Person getgroupAdmin() {
        return groupAdmin;
    }

    @Override
    public String toString() {
        String info = "";
        info += "Person : " + id;
        info += " Time " + creationDate.toLocalDate() + " " + creationDate.toLocalTime() + ")";
        info += "\n Name: " + name;
        info += "\n Coordinates : " + coordinates;
        info += "\n Creation day: " + creationDate;
        info += "\n Average mark: " + averageMark;
        info += "\n Student count: " + studentsCount;
        info += "\n Semester: " + semesterEnum;
        info += groupAdmin;

        return info;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + coordinates.hashCode() + creationDate.hashCode()  + (int) averageMark + groupAdmin.hashCode() + semesterEnum.hashCode()+ studentsCount.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof StudyGroup) {
            StudyGroup studyGroupObj = (StudyGroup) obj;
            return name.equals(studyGroupObj.getName()) && coordinates.equals(studyGroupObj.getCoordinates())
                    && (transferredStudents == studyGroupObj.gettransferredStudents()) && (studentsCount == studyGroupObj.getstudentsCount())
                    && (semesterEnum == studyGroupObj.getsemesterEnum()) && groupAdmin.equals(studyGroupObj.getgroupAdmin())
                    && groupAdmin.equals(studyGroupObj.getgroupAdmin());
        }
        return false;
    }

    @Override
    public int compareTo(Object studyGroup) {
        StudyGroup studyG = (StudyGroup) studyGroup;
        if(transferredStudents > studyG.gettransferredStudents())
            return 1;
        else if (transferredStudents == studyG.gettransferredStudents())
            return 0;
        else if (transferredStudents > studyG.gettransferredStudents())
            return -1;
        return 0;
    }

}