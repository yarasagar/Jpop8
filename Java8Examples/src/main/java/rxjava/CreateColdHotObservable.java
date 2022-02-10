package rxjava;

import io.reactivex.Observable;

import static java.lang.Thread.sleep;

public class CreateColdHotObservable {
    public static void main(String[] args) {
        createColdObservable();
    }

    private static void createColdObservable() {
        Observable<Integer> observable = Observable.just(1,2,3,4,5);
        observable.subscribe(item -> System.out.println("Observer 1: "+item));
        pause(3000);
        observable.subscribe(item -> System.out.println("Observer 2: "+item));
    }

    private static void pause(int duration) {
        try{
            sleep(duration);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
