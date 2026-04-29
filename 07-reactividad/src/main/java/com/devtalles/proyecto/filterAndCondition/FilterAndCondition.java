package com.devtalles.proyecto.filterAndCondition;

import io.reactivex.rxjava3.core.Observable;

public class FilterAndCondition {
    public static void main(String[] args) {
        //filter
        Observable<Integer> ages = Observable.just(11, 12, 13, 20, 30, 12, 14, 18, 60, 70);

//        ages.filter(age->age >= 21).subscribe(System.out::println);

        //distinct
//        ages.distinct().subscribe(System.out::println);

//        ages.take(4).subscribe(System.out::println);

        ages.takeWhile(age -> age < 21)
                .subscribe(System.out::println);
    }
}
