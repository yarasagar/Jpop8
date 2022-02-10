package rxjava;

import io.reactivex.Observable;

public class DeferExample {
    private static int start = 5, count = 2;
    public static void main(String[] args) {
        withOutDefer();
        withDefer();
    }

    private static void withDefer() {
//        Observable<Integer> observable = Observable.defer(() -> Observable.range(start, count));
        Observable<Integer> observable = Observable.defer(() -> {
            System.out.println("start = "+start+" count = "+count);
            return Observable.range(start, count);
        });
        observable.subscribe(item -> System.out.println("Observable 1: "+item));
        count = 4;
        observable.subscribe(item -> System.out.println("Observable 2: "+item));
    }

    private static void withOutDefer() {
        Observable<Integer> observable = Observable.range(start, count);
        observable.subscribe(item -> System.out.println("Observable 1: "+item));
        count = 3;
        observable.subscribe(item -> System.out.println("Observable 2: "+item));
    }
}
