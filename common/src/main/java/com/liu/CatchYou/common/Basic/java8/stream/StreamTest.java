package com.liu.CatchYou.common.Basic.java8.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by simon.liu on 2017/8/11.
 */
public class StreamTest {
    public static void main(String[] args) {
        Trader lx = new Trader("lx", "zh");
        Trader mhg = new Trader("mhg", "sz");
        Trader jzc = new Trader("jzc", "cd");
        Trader ly = new Trader("ly","amc");

        List<Transaction> transactionList = Arrays.asList(
                new Transaction(lx, 2017, 200),
                new Transaction(mhg, 2017, 100),
                new Transaction(jzc, 2016,300),
                new Transaction(ly, 2016, 500)
        );

       List<Transaction> list = transactionList.
               stream().
               sorted(Comparator.comparing(Transaction::getValue)).
               filter(s -> s.getYear() == 2017).collect(Collectors.<Transaction>toList());
       for(Transaction transaction : list) {
           System.out.println(transaction.getTrader().getName());
       }

       String  广州 = transactionList.stream().
               map(Transaction::getTrader).
               map(Trader::getCity).
               distinct().
               reduce(",", (m,n) -> m + n );
        System.out.println(广州);
    }
}
