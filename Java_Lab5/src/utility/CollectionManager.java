package utility;

import data.Person;
import exceptions.CollectionIsEmptyException;

import java.time.LocalDateTime;
import java.util.*;

public class CollectionManager {
    private ArrayList<Person> personCollection =  new ArrayList<>();
    private LocalDateTime lastInitTime;
    private LocalDateTime lastSaveTime;
    private FileManager fileManager;

    public CollectionManager(FileManager fileManager) {
        this.lastInitTime = null;
        this.lastSaveTime = null;
        this.fileManager = fileManager;

        loadCollection();
    }

    public ArrayList<Person> getCollection() {
        return personCollection;
    }

    public LocalDateTime getLastInitTime() {
        return lastInitTime;
    }

    public LocalDateTime getLastSaveTime() {
        return lastSaveTime;
    }

    public String collectionType() {
        return personCollection.getClass().getName();
    }

    public int collectionSize() {
        return personCollection.size();
    }

    public Person getFirst() {
        if (personCollection.isEmpty()) return null;
        return personCollection.get(0);
    }

    public Person getLast() {
        if (personCollection.isEmpty()) return null;
        return personCollection.get(personCollection.size()-1);
    }

    public Person getById(Long id) {
        for (Person person : personCollection) {
            if (person.getId().equals(id)) return person;
        }
        return null;
    }

    public Person getByValue(Person personToFind) {
        for (Person person : personCollection) {
            if (person.equals(personToFind)) return person;
        }
        return null;
    }

    public double maxHeight() throws CollectionIsEmptyException {
        double maxheight = 0;
        if (personCollection.isEmpty()) throw new CollectionIsEmptyException();
        for (Person person : personCollection) {
            if (maxheight > person.getHeight())
                maxheight = person.getHeight();
        }
        return maxheight ;
    }

    public String minNationlity() throws CollectionIsEmptyException {
        if (personCollection.isEmpty()) throw new CollectionIsEmptyException();

        Person minNationlity = getFirst();
        for (Person person : personCollection) {
            if (person.getNationality().compareTo(minNationlity.getNationality()) == 1) {
                minNationlity = person;
            }
        }
        return minNationlity.toString();
    }
    public List<Double> FilterGreaterThanHeight() throws CollectionIsEmptyException {
        double maxheight = 0;
        List<Double> list = new ArrayList<Double>();
        if (personCollection.isEmpty()) throw new CollectionIsEmptyException();
        for (Person person : personCollection) {
            maxheight = person.getHeight();
            list.add(maxheight);;
        }
        Collections.sort(list);
        return list;
    }

    public void addToCollection(Person person) {
        personCollection.add(person);
    }


    public void removeFromCollection(Person person) {
        personCollection.remove(person);
    }

    public void removeGreater(Person personToCompare) {
        personCollection.removeIf(person -> person.compareTo(personToCompare) > 0);
    }

    public void clearCollection() {
        personCollection.clear();
    }


    public Long generateNextId() {
        if (personCollection.isEmpty()) return 1L;
        return personCollection.get(personCollection.size()-1).getId() + 1;
    }

    public void saveCollection() {
        fileManager.writeCollection(personCollection);
        lastSaveTime = LocalDateTime.now();
    }

    private void loadCollection() {
        personCollection = fileManager.readCollection();
        lastInitTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        if (personCollection.isEmpty()) return "The collection is empty!";

        String info = "";
        for (Person person : personCollection) {
            info += person;
            if (person != personCollection.get(personCollection.size()-1)) info += "\n\n";
        }
        return info;
    }
}