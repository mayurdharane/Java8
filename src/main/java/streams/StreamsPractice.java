package streams;

import model.Car;
import model.Trader;
import model.Transaction;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

public class StreamsPractice {

    public static void main(String[] args) {

        Trader rauol = new Trader("Rauol", "cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "cambridge");
        Trader brian = new Trader("Brian", "cambridge");
        Trader mayur = new Trader("Mayur", "Pune");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(rauol, 2012, 1000),
                new Transaction(rauol, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950),
                new Transaction(mayur, 2010, 1500)
        );

        Stream.iterate(new int[]{0,1},t -> new int[] {t[1],t[0]+t[1]})
                .limit(10)
                .map(t -> t[0])
                .forEach(System.out::print);
                //.forEach(t -> System.out.println("("+ t[0]+","+t[1] +")"));


        transactions(transactions);


        String[] names1 = {"mayur","pranav","priya","avantika"};

        long count1 = Arrays.stream(names1).map(s -> s.split(""))
                .flatMap(Arrays::stream)
                .count();
        System.out.println(count1);


        System.exit(-1);

        List<Stream<String>> streamList = Arrays.stream(names1)
                .map(w -> w.split(""))
                .map(Arrays::stream)
                .distinct()
                .collect(toList());
        System.out.println(streamList);

        List<String> collect1 = Arrays.stream(names1)
                .map(w -> w.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList());
        System.out.println(collect1);



        transactions.stream().distinct().map(t -> t.getTrader().getName()).map(String::length).collect(toList());


        List<Integer> nameLength = transactions.stream().distinct().map(t -> t.getTrader().getName()).map(String::length).collect(toList());
        System.out.println("nameLength"+nameLength);

        transactions.stream().map(t -> t).distinct().skip(3).limit(3).forEach(t-> System.out.println(t.toString()));


        transactions.stream().distinct().forEach(t -> System.out.println("--"+t.toString()));


        Map<Integer, List<Transaction>> transactionByYear = transactions.stream().collect(groupingBy(Transaction::getYear));
        System.out.println(transactionByYear);


        Map<Integer, Optional<Transaction>> map = transactions.stream().collect(groupingBy(Transaction::getYear, maxBy(comparingInt(Transaction::getValue))));
        System.out.println(map);

        Comparator<Transaction> transactionComparator = Comparator.comparing(Transaction::getValue);

        Optional<Transaction> max = transactions.stream().max(transactionComparator);
        System.out.println(max);

        Optional<Transaction> optionalTransaction = transactions.stream().collect(maxBy(transactionComparator));
        Transaction transaction = optionalTransaction.get();
        System.out.println(transaction);

        IntSummaryStatistics totalValue = transactions.stream().collect(summarizingInt(Transaction::getValue));
        System.out.println(totalValue);


        String names = transactions.stream().map(Transaction::getTrader).map(Trader::getName).distinct().collect(joining(","));
        System.out.println(names);


        List<Transaction> count = transactions.stream().collect(toList());
        Set<Transaction> collect = transactions.stream().collect(toSet());
//        collect.forEach(System.out::println);
//        System.out.println(count.size());


        //streams1(transactions);




    }

    private static void transactions(List<Transaction> transactions) {
        //transaction in 2011
        System.out.println("transaction in 2011");
        transactions.stream().filter(t -> t.getYear() == 2011).map(Transaction::getValue).sorted().forEach(System.out::println);

        //Unique cities
        System.out.println("Unique cities");
        transactions.stream().map(t -> t.getTrader().getCity()).distinct().forEach(System.out::println);

        //all traders from cambridge
        System.out.println("all traders from cambridge");
        transactions.stream().filter(t -> t.getTrader().getCity().equals("cambridge")).map(t -> t.getTrader().getName()).distinct().sorted().forEach(System.out::println);

        //all traders
        System.out.println("all traders");
        String reduce = transactions.stream().map(t -> t.getTrader().getName()).distinct().sorted(String::compareTo).reduce("", (n1, n2) -> n1 + n2);
        System.out.println("all traders : "+ reduce);
        Integer.parseInt()

        //any trader in milan
        System.out.println("any trader in milan");
        Optional<Transaction> milan = transactions.stream().filter(t -> t.getTrader().getCity().equals("Milan")).findAny();
        boolean milan1 = transactions.stream().anyMatch(t -> t.getTrader().getCity().equals("Milan"));
        System.out.println("any trader in milan : " + milan1);

        //all transaction from cambridge
        System.out.println("all transaction from cambridge");
        transactions.stream().filter(t-> t.getTrader().getCity().equals("cambridge")).map(t-> t.getValue()).sorted().forEach(System.out::println);


        //highest value of transaction
        Optional<Integer> reduce1 = transactions.stream().map(t -> t.getValue()).reduce(Integer::max);
        System.out.println("highest transaction : "+reduce1.get());


        //min value of transaction
        Optional<Integer> min = transactions.stream().map(t -> t.getValue()).reduce(Integer::min);
        System.out.println("lowest transaction : "+min.get());
    }

    private static void streams1(List<Transaction> transactions) {
        //Find all transaction 2011 and sort

        List<Transaction> list = transactions.stream().filter(transaction -> transaction.getYear() == 2011)
                .collect(toList());

        list.sort((o1, o2) -> o1.getValue() - o2.getValue());
        System.out.println(list);


        //Find all unique city for traders
        List<String> citylist = transactions.stream().map(transaction -> transaction.getTrader().getCity()).distinct().collect(toList());
        System.out.println(citylist);

        //Find all  traders from Cambridge

        List<Trader> traderList = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("cambridge"))
                .distinct().sorted(comparing(Trader::getName)).collect(toList());
        System.out.println(traderList);

        List<Trader> milan = transactions.stream().map(Transaction::getTrader).filter(trader -> trader.getCity().equals("Milan")).distinct().collect(toList());
        System.out.println(milan);


        List<Integer> cambridgeTransactions = transactions.stream().filter(transaction -> transaction.getTrader().getCity().equals("cambridge")).map(Transaction::getValue).sorted().collect(toList());
        System.out.println(cambridgeTransactions);

        Optional<Integer> maxTransactionValue = transactions.stream().map(Transaction::getValue).reduce(Integer::max);
        System.out.println(maxTransactionValue);

        Optional<Integer> minTransactionValue = transactions.stream().map(Transaction::getValue).reduce(Integer::min);
        System.out.println(minTransactionValue);

        Optional<Transaction> transaction = transactions.stream().reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2);
        System.out.println(transaction);

        Optional<Transaction> minTransaction = transactions.stream().min(comparing(Transaction::getValue));
        System.out.println(minTransaction);

        int sum = transactions.stream().mapToInt(Transaction::getValue).sum();
        System.out.println(sum);

        int sum1 = transactions.stream().mapToInt(Transaction::getValue).sum();
        System.out.println(sum1);

        OptionalDouble min1 = transactions.stream().mapToDouble(Transaction::getValue).min();
        System.out.println(min1.getAsDouble());

        Optional<Transaction> min = transactions.stream().min(comparing(Transaction::getValue));
        System.out.println(min.get().getValue());

        long uniqueWords = 0;
        try (Stream<String> lines = Files.lines(Paths.get("src/main/java/model/Test.txt"), Charset.defaultCharset())) {

            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" "))).distinct().count();
            System.out.println("uniqueWords::" + uniqueWords);

        } catch (IOException e) {
        }

        Stream.iterate(10, i -> i + 10).limit(5).forEach(System.out::println);


        int[] a1 = {0, 1};
        Stream.iterate(a1, arr -> new int[]{arr[1], arr[0] + arr[1]}).limit(10).forEach(arr -> {
            System.out.println(arr[0] + "," + arr[1]);
        });

        Supplier<Car> carSupplier = Car::new;
        Stream.generate(carSupplier).limit(2).forEach(System.out::println);
    }
}
