package rxjava;

import io.reactivex.Observable;
import io.reactivex.Observer;

public class MapVSFlatMap {
    public static void main(String[] args) {
        mapExample();
        flatMapExample();
        mapWithReturnObservable();
    }

    private static void mapWithReturnObservable() {
        Observable<String> observer = Observable.just("one","two","three");
        observer
                .map(item -> Observable.fromArray(item.split("")))
                .subscribe(System.out::println);
    }

    private static void flatMapExample() {
        Observable<String> observer = Observable.just("one","two","three");
        observer
                .flatMap(item -> Observable.fromArray(item.split("")))
                .subscribe(System.out::print);
        System.out.println();
    }

    private static void mapExample() {
        Observable<String> observer = Observable.just("one","two","three");
        observer
                .map(item -> item.toUpperCase())
                .subscribe(System.out::println);
    }
}
