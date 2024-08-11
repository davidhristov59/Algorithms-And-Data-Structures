package OpenBucketHashTable;

import java.util.Scanner;

public class RedCross {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        OBHT<String, Integer> bloodgroups = new OBHT<>(11);

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] parts = line.split("\\s+");

            String name = parts[0];
            String blood_type = parts[1];

            //if someone enters 'A1+', 'A1-', 'A1$', or 'A1--', they all get treated as 'A1+' for the purpose of counting the occurrences of each blood group.
            blood_type = blood_type.replace("$", "").replace("-","+");

            Integer count = bloodgroups.search(blood_type); //search metodot vo OBHT vraka int
            //barame krvna grupa

            if(count != null){
                bloodgroups.insert(blood_type, count + 1);//ako ne e null go inkrementirame count-ot. Updates the value in the hash table for that blood group.
            }
            else {
                bloodgroups.insert(blood_type, 1);
                //If the blood group doesn't exist (count is null), it means it's encountered
                // for the first time. In this case, it inserts the blood group into the hash
                // table with a count of 1.
            }
        }

        String[] expectedBloodGroups = {"A+", "B-$", "0+", "A-$", };

        for(String bloodgroup:expectedBloodGroups){
            Integer count = bloodgroups.search(bloodgroup);
            if(count != null){
                System.out.println(bloodgroup + "=" + count);
            }
            else {
                System.out.println(bloodgroup + "=0");
            }
        }

    }
}
