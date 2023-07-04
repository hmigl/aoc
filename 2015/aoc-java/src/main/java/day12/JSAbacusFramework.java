package day12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JSAbacusFramework {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("src/main/java/day12/input.json"));
        Pattern p = Pattern.compile(".*?(-?\\d+).*");

        int sum = 0;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            Matcher m = p.matcher(line);
            if (m.matches()) {
                sum += Integer.parseInt(m.group(1));
            }
        }
        System.out.println(sum);
    }
}
