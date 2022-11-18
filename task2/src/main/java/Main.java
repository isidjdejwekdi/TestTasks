import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static MCircle circle;
    private static ArrayList<MPoint> fPointArray;

    public static void main(String[] args) {

        if (args.length != 2){
            System.out.println("required 2 files as arguments");
            System.exit(1);
        }

        String f1 = args[0];
        String f2 = args[1];

        initDataFromFiles(f1, f2);

        for (MPoint point: fPointArray) {
            System.out.println(getPointPosition(point));
        }
    }

    private static void initDataFromFiles(String fileName1, String fileName2) {
        FileReader fr1 = null;
        FileReader fr2 = null;
        try {
            //read and parse file1
            fr1 = new FileReader(fileName1);
            Scanner scanner = new Scanner(fr1);
            String[] readDataLines = new String[2];

            int i = 0;
            while (scanner.hasNextLine()) {
                readDataLines[i] = scanner.nextLine();
                i++;
            }

            String[] circlePivotParam = readDataLines[0].split(" ");

            MPoint pivotPoint = new MPoint(Float.parseFloat(circlePivotParam[0]), Float.parseFloat(circlePivotParam[1]));
            float r = Float.parseFloat(readDataLines[1]);

            circle = new MCircle(r, pivotPoint);

            //read and parse file2
            fr2 = new FileReader(fileName2);
            scanner = new Scanner(fr2);

            fPointArray = new ArrayList<>();
            while(scanner.hasNextLine()){
                String[] buf = scanner.nextLine().split(" ");
                MPoint point = new MPoint(Float.parseFloat(buf[0]), Float.parseFloat(buf[1]));
                fPointArray.add(point);
            }

        }catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                if(fr1!= null && fr2!=null) {
                    fr1.close();
                    fr2.close();
                }
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    private static int getPointPosition(MPoint point){
        float c;
        c = calculateHypotenuse(circle, point);

        if (Math.abs(circle.getR() - c) < 0.001f)
            return 0;
        else if (c > circle.getR())
            return 2;
        else
            return 1;
    }

    public static float calculateHypotenuse(MCircle circle, MPoint point) {
        float a = point.getX() - circle.getPivot().getX();
        float b = point.getY() - circle.getPivot().getY();

        return  (float)Math.sqrt(a * a + b * b);
    }
}

