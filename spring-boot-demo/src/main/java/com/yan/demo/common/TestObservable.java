package com.yan.demo.common;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;

/**
 * Created by yan on  26/09/2018.
 */
public class TestObservable {
    //观察者模式（推送）
    public static void main(String[] args) {
        //发布者
        MyObservable observable = new MyObservable();
        //增加订阅者
        observable.addObserver((o, value) ->
                System.out.println(value)
        );
        observable.setChanged();
        observable.notifyObservers("Hello,World");

        pullIterator();
    }

    public static class MyObservable extends Observable {
        @Override
        protected synchronized void setChanged() {
            super.setChanged();
        }
    }

    //拉模式
    private static void pullIterator() {
        System.out.println("pull start");
        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5);
        Iterator<Integer> iterator = values.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
