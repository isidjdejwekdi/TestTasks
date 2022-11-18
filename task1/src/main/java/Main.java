public class Main {
    public static int n;
    public static int m;
    public static int[] arr;

    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("2 argument required");
            System.exit(1);
        }

        n = Integer.parseInt(args[0]);
        m = Integer.parseInt(args[1]);

        System.out.println("n = " + n);
        System.out.println("m = " + m);

        if (m < 2) {
            System.out.println("length of interval cannot be lower than 2");
            return;
        }
        arr = fillArray();

        try {
            System.out.println(calculatePath());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static int[] fillArray() {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i + 1;
        }
        return array;
    }

    public static String calculatePath() throws Exception {
        String path = "";
        int firstElementOfArray = arr[0];
        int lastElementOfInterval = 0;
        int lastIndexOfInterval;
        int startIndexOfNewInterval = 0;

            while (lastElementOfInterval != firstElementOfArray) {

                lastIndexOfInterval = stepWithCircleIndex(startIndexOfNewInterval, m, n - 1);// step = length of intervals
                lastElementOfInterval = arr[lastIndexOfInterval];
                path += arr[startIndexOfNewInterval];
                startIndexOfNewInterval = lastIndexOfInterval;

            }
        return path;
    }

    public static int stepWithCircleIndex(int startIndex, int step, int maxIndex) throws Exception {
        if (startIndex > maxIndex) throw new Exception("startIndex cannot be greater than maxIndex");
        int i = 0;
        int idx = startIndex;
        do {
            idx++;
            if (idx > maxIndex) {
                idx = 0;
            }

            i++;
        } while (i < step - 1);
        return idx;
    }
}

