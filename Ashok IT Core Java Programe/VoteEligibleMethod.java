public class VoteEligibleMethod {

    boolean voteEligibility(int age){
        return age>=18;
    }
    public static void main(String[] args) {
        VoteEligibleMethod v = new VoteEligibleMethod();
        int age = 16;
        boolean b = v.voteEligibility(age);
        System.out.println(b);
    }
}
