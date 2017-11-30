package com.newyulong.materialdesignstu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.newyulong.materialdesignstu.bean.News;
import com.newyulong.materialdesignstu.bean.User;
import com.newyulong.materialdesignstu.inter.NewsService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/11/28.
 */

public class RxJavaActivity extends AppCompatActivity {

    private String TAG = "RxJavaActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final List<Li> list1 = new ArrayList<>();
        list1.add(new Li("001", "yw"));
        list1.add(new Li("002", "sx"));
        list1.add(new Li("003", "yy"));

        final List<Li> list2 = new ArrayList<>();
        list2.add(new Li("004", "yw"));
        list2.add(new Li("005", "sx"));
        list2.add(new Li("006", "yy"));

        final List<Li> list3 = new ArrayList<>();
        list3.add(new Li("007", "yw"));
        list3.add(new Li("008", "sx"));
        list3.add(new Li("009", "yy"));


        final Student stu1 = new Student("zhang", 20, list1);

        Student stu2 = new Student("li", 23, list2);
        Student stu3 = new Student("wang", 26, list3);

        Observable.just(stu1,stu2,stu3)
                .flatMap(new Func1<Student, Observable<Li>>() {
                    @Override
                    public Observable<Li> call(Student student) {
                        return Observable.from(student.list);
                    }
                })
                .subscribe(new Action1<Li>() {
                    @Override
                    public void call(Li li) {
                        String liName = li.liName;
                    }
                });

//        Observable.just(stu1, stu2, stu3)
//                .flatMap(new Func1<Student, Observable<Li>>() {
//                    @Override
//                    public Observable<Li> call(Student student) {
//                        long id = Thread.currentThread().getId();
//                        Log.i(TAG, "Thread: " + id);
//                        return Observable.from(student.list);
//                    }
//                })
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Action1<Li>() {
//                    @Override
//                    public void call(Li li) {
//                        Log.i(TAG, li.id);
//                    }
//                });
//        long id = Thread.currentThread().getId();
//        Log.i(TAG, "MainThread -> " + id);

        Observer<String> observer = new Observer<String>() {
            @Override
            public void onCompleted() {
                Log.d(TAG,"onCompleted");
            }
            @Override
            public void onError(Throwable e) {
                Log.d(TAG,"onError");
            }

            @Override
            public void onNext(String s) {
                Log.d(TAG,s);
            }
        };

//        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
//            @Override
//            public void call(Subscriber<? super String> subscriber) {
//                subscriber.onNext("hello");
//                subscriber.onNext("li");
//                subscriber.onNext("ming");
//            }
//        });
//        observable.subscribe(observer);

//        Observable<String> observable = Observable.just("hi", "le", "ho");
//        observable.subscribe(observer);

//        Observable from = Observable.from(new String[]{"a", "b", "c"});
//        from.subscribe(observer);

//        Observable.just("hello","world")
//                .filter(new Func1<String, Boolean>() {
//                    @Override
//                    public Boolean call(String s) {
//                        return true;
//                    }
//                })
//                .subscribe(new Action1<String>() {
//                    @Override
//                    public void call(String s) {
//                        Log.d(TAG,s);
//                    }
//                });

        Observable.just("hello","hi")
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .filter(new Func1<String, Boolean>() {
                    @Override
                    public Boolean call(String s) {
                        Log.d(TAG,"filter thread: "+Thread.currentThread().getId());
                        return true;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<String>() {
                    @Override
                    public void call(String s) {
                        Log.d(TAG,"Thread: "+Thread.currentThread().getId()+"  "+s);
                    }
                });

        Retrofit retrofit = new Retrofit.Builder().baseUrl("").addConverterFactory(GsonConverterFactory.create()).build();

        final NewsService newsService = retrofit.create(NewsService.class);


        Observable.just("name")
                .flatMap(new Func1<String, Observable<User>>() {
                    @Override
                    public Observable<User> call(String s) {
                        return newsService.getUserInfo(s);
                    }
                })
                .subscribe(new Action1<User>() {
                    @Override
                    public void call(User user) {

                    }
                })
        ;


    }

    public class Student {
        public String name;
        public int age;

        public List<Li> list;

        public Student(String name, int age, List<Li> list) {
            this.name = name;
            this.age = age;
            this.list = list;
        }
    }

    public class Li {
        public String id;
        public String liName;

        public Li(String id, String liName) {
            this.id = id;
            this.liName = liName;
        }
    }

}
