package rxjava;

import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;

public class CreateObservable {
    public static void main(String[] args) {
        createObservableWithJust();
        createObservableFromIterable();
        createObservableUsingCreate();
    }

    private static void createObservableUsingCreate() {
        Observable<Integer> observable = Observable.create(emitter -> {
            emitter.onNext(10);
            emitter.onNext(11);
            emitter.onNext(12);
            emitter.onNext(13);
            emitter.onNext(null);
            emitter.onComplete();
        });
        observable.subscribe(item -> System.out.println(item),
                error -> System.out.println(error.getLocalizedMessage()),
                () -> System.out.println("Completed"));
    }

    private static void createObservableFromIterable() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        Observable<Integer> observable = Observable.fromIterable(list);
        observable.subscribe(System.out::print);
        System.out.println();
    }

    private static void createObservableWithJust() {
        Observable<Integer> observable = Observable.just(1,2,3,4,5);
        observable.subscribe(System.out::print);
        System.out.println();
    }
}
