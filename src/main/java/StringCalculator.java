import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String delimiter = "[,\n]";
        String numberString = numbers;

        // Check for custom delimiter
        if (numbers.startsWith("//")) {
            int delimiterIndex = numbers.indexOf("\n");
            delimiter = Pattern.quote(numbers.substring(2, delimiterIndex));
            numberString = numbers.substring(delimiterIndex + 1);
        }

        String[] parts = numberString.split(delimiter);
        int sum = 0;
        List<Integer> negatives = new ArrayList<>();

        for (String part : parts) {
            if (!part.isEmpty()) {
                int num = Integer.parseInt(part);
                if (num < 0) {
                    negatives.add(num);
                } else {
                    sum += num;
                }
            }
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("negative numbers not allowed: " + negatives.toString().replaceAll("[\\[\\]]", ""));
        }

        return sum;
    }
}
