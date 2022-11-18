import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Main {

    private static final List<Integer> dataList = new ArrayList<>();

    public static void main(String[] args) {

        if (args.length != 1){
            System.out.println("filename required");
            System.exit(1);
        }

        String filename = args[0];
        try {
            initDataFromFile(filename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
        System.out.println(calculateSteps());
    }

    private static void initDataFromFile(String filename) throws FileNotFoundException {

        FileReader fr = new FileReader(filename);
        Scanner scanner = new Scanner(fr);

        while (scanner.hasNextLine()) {
            dataList.add(Integer.parseInt(scanner.nextLine()));
        }
    }

    private static int calculateSteps() {
        int res = 0;
        Collections.sort(dataList);
        int med = dataList.get(dataList.size() / 2);

        for (Integer num : dataList) {
            res += Math.abs(med - num);
        }
        return res;
    }
}

