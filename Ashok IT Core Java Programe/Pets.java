import java.util.Arrays;

public class Pets {
    int id;
    String name;

    Pets[] petsData() {
        Pets p1 = new Pets();
        p1.id = 101;
        p1.name = "Cow";

        Pets p2 = new Pets();
        p2.id = 102;
        p2.name = "Dog";

        Pets p3 = new Pets();
        p3.id = 103;
        p3.name = "Cat";

        Pets[] arr = { p1, p2, p3 };
        return arr;
    }

    // Override toString method to provide custom string representation
    @Override
    public String toString() {
        return id+" "+name;
    }

    public static void main(String[] args) {
        Pets p = new Pets();
        Pets[] arr = p.petsData(); // Calling petsData() without passing any arguments

        // Approach 1
        for(Pets pet:arr){
            System.out.println(pet.id+" "+pet.name);
        }

        System.out.println("----------------------------------");

        // Approach 2
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i].id+" "+arr[i].name);
        }

        // Approach 3
        System.out.println(Arrays.toString(arr));
    }
}
