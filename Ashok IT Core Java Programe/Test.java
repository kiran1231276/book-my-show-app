class Account {
    private int accId;
    private String name;

    public void setAccId(int acId){
        this.accId = acId;
    }

    int getAccId(){
        return this.accId;
    }

    public void setName(String name){
        this.name = name;
    }

    String getName(){
        return this.name;
    }
}

public class Test{
    public static void main(String[] args) {
        Account acc = new Account();
        acc.setAccId(1004);
        int accId = acc.getAccId();

        acc.setName("Kiran");
        String name = acc.getName();

        System.out.println(accId+" "+name);
    }
}
