package com.example.demo.test02.stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 流式运算
 *
 * @author FLY
 * @date 2020-05-25 10:07
 */
public class T1 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 5, 6, 523, 21, 55);
        Stream<Integer> stream = list.stream();//串行流
        Stream<Integer> integerStream = list.parallelStream();//并行流
        Stream<String> stream2 = Stream.of("aaa", "bbb");
        stream2.forEach(System.out::println);
        Stream.generate(() -> Math.random() * 10).limit(5).forEach(System.out::println);
        Stream<Integer> stream3 = list.stream().filter(x -> {
            System.out.println("函数执行" + x);
            return x > 10;
        });

        stream3.forEach(System.out::println);

        System.out.println("=======================================================");
        Stream<Integer> stream4 = list.stream().skip(0).limit(3);
        stream4.forEach(System.out::println);

        System.out.println("=======================================================");
        List<String> list3 = Arrays.asList("aa", "bb", "cc");
        Stream<String> stream5 = list3.stream().flatMap(l -> {
            String[] strings = l.split("");
            return Arrays.stream(strings);
        });
        stream5.forEach(System.out::println);

        System.out.println("=======================================================");
        List<Integer> list2 = Arrays.asList(1, 3, 2, 6, 8, 3, 9);
        Optional<Integer> first = list2.stream().findAny();
        Optional<Integer> first1 = list2.stream().findAny();
        System.out.println(first.get());
        Optional<Integer> max = list2.stream().max(Integer::compareTo);
        System.out.println(max.get());
        Optional<Integer> min = list2.stream().min(Integer::compareTo);
        System.out.println(min.get());
        Integer reduce = list2.stream().reduce(0, (x, y) -> x + y);
        System.out.println(reduce);
        Optional<Integer> reduce2 = list2.stream().reduce((x, y) -> x + y);
        System.out.println(reduce2.get());

        IntSummaryStatistics sum = list2.stream().collect(Collectors.summarizingInt(item -> item));
        System.out.println(sum);
    }
}
