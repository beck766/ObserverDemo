package com.lin.observerdemo;

/**
 * Created by beck on 2018/5/9.
 * 被观察者接口
 */

public interface SubjectListener {
    void add(ObserverListener observerListener);

    void notifyObserver(String content);

    void remove(ObserverListener observerListener);
}
