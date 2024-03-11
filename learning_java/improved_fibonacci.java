class improved_fibonacci {
    static final int MAX_INDEX = 100;
    /*
     * Print out the first few Fibonacci numbers.
     * Mark the evens with a *
     */
    public static void main(String[] args){
        long lo = 1;
        long hi =1;
        String mark;
        System.out.println("1: " + lo);
        for (int i = 2; i <= MAX_INDEX; i++) {
            if (hi % 2 ==0)
                mark = " *";
            else
                mark = "";
            System.out.println(i + ": " + hi + mark);
            hi = lo + hi;
            lo = hi - lo;
        }
    }
}
