package com.lin.observerdemo;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by beck on 2018/5/9.
 * 管理类
 */

public class ObserverManager implements SubjectListener {
    private static final String TAG = "ObserverManager";
    private static ObserverManager observerManager;
    //观察者接口集合
    private List<ObserverListener> list = new ArrayList<>();

    public static ObserverManager getInstance() {
        if (observerManager == null) {
            synchronized (ObserverManager.class) {
                if (observerManager == null) {
                    observerManager = new ObserverManager();
                }
            }
        }
        return observerManager;
    }

    /**
     * 加入监听队列
     */
    @Override
    public void add(ObserverListener observerListener) {
        synchronized (this) {
            if (!list.contains(observerListener)) {
                list.add(observerListener);
                Log.i(TAG, "add: ");
            }
        }
    }

    /**
     * 通知观察者刷新数据
     *
     * @param content
     */
    @Override
    public void notifyObserver(String content) {
        if (list == null || list.size() == 0) {
            Log.i(TAG, "notifyObserver: ");
            return;
        }
        for (ObserverListener observerListener : list
                ) {
            observerListener.observerUpData(content);
            Log.i(TAG, "notifyObserver: content:" + content);
        }
    }

    /**
     * 监听队列中移除
     *
     * @param observerListener
     */
    @Override
    public void remove(ObserverListener observerListener) {
        if (list == null || list.size() == 0) {
            return;
        }
        if (list.contains(observerListener)) {
            list.remove(observerListener);
        }
    }
}
