package net.xonich.collections;

public class Demo4 {

    public static void main(String[] args) {

        Data data = new Data(12, "test");
        printInfo(data);
        Demo4.<Data>printInfoGeneric(data);
        Demo4.<String>printInfoGeneric("test");
        Demo4.<Integer>printInfoGeneric(42);
    }

    public static <T> void printInfoGeneric(T d) {
        System.out.println("T: type = " + d.getClass() + " state = " + d);
    }

    public static void printInfo(Data d) {

        System.out.println("Data: type = " + d.getClass() + " state = " + d);
    }

    public static void printInfo(String d) {

        System.out.println("String: type = " + d.getClass() + " state = " + d);
    }

    public static void printInfo(Object d) {

        System.out.println("Object: type = " + d.getClass() + " state = " + d);
    }

    public static class Data {
        int num;
        String str;

        public Data(int num, String str) {
            this.str = str;
            this.num = num;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "num=" + num +
                    ", str='" + str + '\'' +
                    '}';
        }
    }
}
