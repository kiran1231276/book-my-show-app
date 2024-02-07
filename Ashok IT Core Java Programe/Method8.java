class Doctor{
    String doctorName;
    int DoctorAge;
}

public class Method8 {
    public static void main(String[] args) {

        Method8 s = new Method8();
        Doctor d = new Doctor();
        d.doctorName = "Rahul";
        d.DoctorAge = 36;

        s.printData(d);
    }
    void printData(Doctor d){
        System.out.println(d.doctorName+" "+d.DoctorAge);
    }
}
