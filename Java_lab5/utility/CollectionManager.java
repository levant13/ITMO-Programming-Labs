package utility;

import data.Country;
import data.Semester;
import data.StudyGroup;
import exceptions.CollectionIsEmptyException;

import java.time.LocalDateTime;
import java.util.*;

public class CollectionManager {
    private ArrayDeque<StudyGroup> studyGroupCollection =  new ArrayDeque<>();
    private LocalDateTime lastInitTime;
    private LocalDateTime lastSaveTime;
    private FileManager fileManager;

    public CollectionManager(FileManager fileManager) {
        this.lastInitTime = null;
        this.lastSaveTime = null;
        this.fileManager = fileManager;

        loadCollection();
    }

    public ArrayDeque<StudyGroup> getCollection() {
        return studyGroupCollection;
    }

    public LocalDateTime getLastInitTime() {
        return lastInitTime;
    }

    public LocalDateTime getLastSaveTime() {
        return lastSaveTime;
    }

    public String collectionType() {
        return studyGroupCollection.getClass().getName();
    }

    public int collectionSize() {
        return studyGroupCollection.size();
    }

    public StudyGroup getFirst() {
        if (studyGroupCollection.isEmpty()) return null;
        return studyGroupCollection.getFirst();
    }

    public StudyGroup getLast() {
        if (studyGroupCollection.isEmpty()) return null;
        return studyGroupCollection.getLast();
    }

    public StudyGroup getById(Long id) {
        for (StudyGroup studyGroup : studyGroupCollection) {
            if (studyGroup.getId().equals(id)) return studyGroup;
        }
        return null;
    }

    public StudyGroup getByValue(StudyGroup studyGroupToFind) {
        for (StudyGroup studyGroup : studyGroupCollection) {
            if (studyGroup.equals(studyGroupToFind)) return studyGroup;
        }
        return null;
    }

    public ArrayList<StudyGroup> getMaxByID() throws CollectionIsEmptyException {
        Long maxID = Long.valueOf(0);
        ArrayList<StudyGroup> list = new ArrayList<>();
        if (studyGroupCollection.isEmpty()) throw new CollectionIsEmptyException();
        for (StudyGroup studyGroup : studyGroupCollection)
            maxID=Long.max(maxID, studyGroup.getId()) ;
        for (StudyGroup studyGroup : studyGroupCollection)
            if (maxID==studyGroup.getId())
                list.add(studyGroup);
        return list;
    }

    public Integer getSumArageMark() throws CollectionIsEmptyException {
        Integer Sum = Integer.valueOf(0);
        if (studyGroupCollection.isEmpty()) throw new CollectionIsEmptyException();
        for (StudyGroup studyGroup : studyGroupCollection)
                Sum=Integer.sum(Sum, studyGroup.getaverageMark()) ;
        return Sum;
    }

    public ArrayList<StudyGroup> FilterLessThanSemesterEnum(Semester argument) throws CollectionIsEmptyException {
        if (studyGroupCollection.isEmpty()) throw new CollectionIsEmptyException();
        Semester[] semesterArray= Semester.values();
        ArrayList<StudyGroup> list = new ArrayList<>();
        for (Semester semesterEnum :semesterArray )
        for (StudyGroup studyGroup : studyGroupCollection) {
            list.add(studyGroup);
            if (studyGroup.getsemesterEnum() == semesterEnum) break;
        }
            return list;
    }

    public void addToCollection(StudyGroup studyGroup) {
        studyGroupCollection.add(studyGroup);
    }


    public void removeFromCollection(StudyGroup studyGroup) {
        studyGroupCollection.remove(studyGroup);
    }

    public void removeGreater(StudyGroup studyGroupToCompare) {
        studyGroupCollection.removeIf(person -> person.compareTo(studyGroupToCompare) > 0);
    }

    public void clearCollection() {
        studyGroupCollection.clear();
    }


    public Long generateNextId() {
        if (studyGroupCollection.isEmpty()) return 1L;
        return studyGroupCollection.getLast().getId() + 1;
    }
    public Long generateNextCount() {
        Long count= Long.valueOf(0);
        if (studyGroupCollection.isEmpty()) return 1L;
        count=studyGroupCollection.getLast().getstudentsCount() + 1;
        return count;
    }

    public void saveCollection() {
        fileManager.writeCollection(studyGroupCollection);
        lastSaveTime = LocalDateTime.now();
    }

    private void loadCollection() {
        studyGroupCollection = fileManager.readCollection();
        lastInitTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        if (studyGroupCollection.isEmpty()) return "The collection is empty!";

        String info = "";
        for (StudyGroup studyGroup : studyGroupCollection) {
            info += studyGroup;
            if (studyGroup != studyGroupCollection.getLast()) info += "\n\n";
        }
        return info;
    }
}