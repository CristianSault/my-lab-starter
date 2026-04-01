package part2;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {


    static void main() {
        var bigMacs = loadData();

        // 1st: convert to Stream<BigMac>
        // 2nd: filter by year 2022 AND country = Canada
        // 3rd: convert to List<BigMac>
        // 4th: get the first BigMac in this List<BigMac> (there's a "repeated" case in september)
        System.out.println(bigMacs.stream().filter(bigMac -> (bigMac.year() == 2022 && bigMac.country().equals("Canada"))).toList().getFirst());

        // 1st: convert to Stream<BigMac>
        // 2nd: filter by country = Canada
        // 3rd: convert to List<BigMac>
        List<BigMac> caList = bigMacs.stream().filter(bigMac -> bigMac.country().equals("Canada")).toList();
        System.out.println("\n" + "-".repeat(100) + "\n" + caList.size());
        caList.forEach(IO::println);

        // 1st: convert to Stream<BigMac>
        // 2nd: map to Stream<String> coinciding with the format “<country>: <currency>” (e.g. “Canada: CAD”)
        // 3rd: get rid of duplicates
        // 4th: sort it alphabetically
        // 5th: convert to List<String>
        List<String> formatList = bigMacs.stream().map(bigMac -> "%s: %s".formatted(bigMac.country(), bigMac.currency())).distinct().sorted().toList();
        System.out.println("\n" + "-".repeat(100) + "\n" + formatList.size());
        formatList.forEach(IO::println);

        // 1st: convert to Stream<BigMac>
        // 2nd: filter by year between 2018 and 2022 (last 5 recent years)
        // 3rd: convert to List<BigMac>
        List<BigMac> fiveYearsList = bigMacs.stream().filter(bigMac -> (bigMac.year() >= 2018 && bigMac.year() <= 2022)).toList();
        System.out.println("\n" + "-".repeat(100) + "\n" + fiveYearsList.size());
        fiveYearsList.forEach(IO::println);

        // 1st: convert to Stream<BigMac>
        // 2nd: filter by year = 2022 AND UsdPrice < $2.0
        // 3rd: convert to List<BigMac>
        List<BigMac> cheap2022List = bigMacs.stream().filter(bigMac -> (bigMac.year() == 2022 && bigMac.usdPrice() < 2.0)).toList();
        System.out.println("\n" + "-".repeat(100) + "\n" + cheap2022List.size());
        cheap2022List.forEach(IO::println);

        System.out.println("\n" + "-".repeat(100) + "\n");
        // 1st: convert to Stream<BigMac>
        // 2nd: filter by year = 2022
        // 3rd: get rid of duplicates
        // 4th: map to bigMac.usdPrice() (Stream<Double> or DoubleStream)
        // 5th: get the average of all these records (with DoubleStream.average() returning OptionalDouble)
        // 6th: return the calculated average or 0.0 if isPresent() -> false
        System.out.println(bigMacs.stream().filter(bigMac -> bigMac.year() == 2022).distinct().mapToDouble(BigMac::usdPrice).average().orElse(0.0));
    }

    public static List<BigMac> loadData() {
        try(var lines = Files.lines(Path.of("BigMacPrices.csv"))) {
            return lines.map(Main::parseCsvLine)
                    .toList();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Parse a CSV line into a BigMac record. The expected format is:
     * year,currency,country,localPrice,exchangeRate,usdPrice
     * @param line the CSV line to parse
     * @return a BigMac record containing the data from the CSV line
     */
    public static BigMac parseCsvLine(String line) {
        var values = line.split(",");
        return new BigMac(
                Integer.parseInt(values[0].substring(0,4)),
                values[1],
                values[2],
                Double.parseDouble(values[3]),
                Double.parseDouble(values[4]),
                Double.parseDouble(values[5]));
    }
}
