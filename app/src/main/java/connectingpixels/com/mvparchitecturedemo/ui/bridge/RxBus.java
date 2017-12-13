package connectingpixels.com.mvparchitecturedemo.ui.bridge;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Func1;
import rx.subjects.BehaviorSubject;
import rx.subjects.Subject;

/**
 * Created by alpesh on 29/10/17.
 */

public class RxBus {

    private static RxBus instance;

    private final Subject<Object, Object> _bus = BehaviorSubject.create();

    public static RxBus getInstance() {
        if (instance == null) {
            instance = new RxBus();
        }
        return instance;
    }

    public void send(Object object) {
        _bus.onNext(object);
    }

    public Observable<Object> toObservable() {
        return _bus;
    }

    public Subscription subscribe(final Class filter, Subscriber<? super Object> subscriber) {
        return _bus.filter(new Func1<Object, Boolean>() {

            @Override
            public Boolean call(Object o) {
                return filter != null ? filter.isInstance(o) : true;
            }
        }).subscribe(subscriber);

    }

    public void unSubscribe(Subscription subscription) {
        if (subscription != null && !subscription.isUnsubscribed())
            subscription.unsubscribe();

    }
}
