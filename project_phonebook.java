import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PhoneBook {
    private static HashMap<String, ArrayList<Integer>> phoneBook = new HashMap<>();

    public void add(String name, Integer phoneNum) {

        if (phoneBook.containsKey(name)) {
            ArrayList<Integer> List1 = phoneBook.get(name);
            List1.add(phoneNum);

        } else {
            ArrayList<Integer> List1 = new ArrayList<Integer>();
            List1.add(phoneNum);

            phoneBook.put(name, List1);
        }

    }

    public ArrayList<Integer> find(String name) {

        if (phoneBook.containsKey(name)) {
            return phoneBook.get(name);

        } else {
            ArrayList<Integer> List1 = new ArrayList<Integer>();
            return List1;
        }

    }

    public static HashMap<String, ArrayList<Integer>> getPhoneBook() {

        return phoneBook;

    }

}

public class project_phonebook {
    public static void main(String[] args) {
        String name1;
        String name2;
        String name3;
        int phone1;
        int phone2;
        int phone3;

        name1 = "Ivanov";
        name2 = "Petrov";
        name3 = "Randy";
        phone1 = 123456;
        phone2 = 654321;
        phone3 = 777777;

        PhoneBook myPhoneBook = new PhoneBook();
        myPhoneBook.add(name1, phone1);
        myPhoneBook.add(name1, phone2);
        myPhoneBook.add(name2, phone2);
        myPhoneBook.add(name3, phone1);
        myPhoneBook.add(name3, phone2);
        myPhoneBook.add(name3, phone3);

        HashMap<String, ArrayList<Integer>> ThisBook = PhoneBook.getPhoneBook();
        List<Map.Entry<String, ArrayList<Integer>>> list = new ArrayList<>(ThisBook.entrySet());
        Collections.sort(list, new EntryComparator());
        for (Map.Entry<String, ArrayList<Integer>> entry : list) {
            System.out.println(entry);
        }

    }

    private static class EntryComparator
            implements Comparator<Map.Entry<String, ArrayList<Integer>>> {
        public int compare(Map.Entry<String, ArrayList<Integer>> left,
                Map.Entry<String, ArrayList<Integer>> right) {
            return Integer.compare(right.getValue().size(), left.getValue().size());
        }
    }

}