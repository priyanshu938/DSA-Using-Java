class Tower_Of_Hanoi{
    public static void main(String[] args) {
        toh(3,'A','B','C');
    }
    static void toh(int n,char A,char B,char C){
        if(n==1){
            System.out.println("Move 1 from Tower "+A+ " to Tower "+C);
            return;
        }
        toh(n-1,A,C,B);
        System.out.println("Move "+n+ " from Tower "+A+" to Tower "+C);
        toh(n-1,B,A,C);
    }
}