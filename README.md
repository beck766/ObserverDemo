# ObserverDemo
练习观察者模式在android中的简单应用

观察者模式就是：当一个对象的状态发送改变时，所有依赖于它的对象都能得到通知并被自动更新。

效果是当点击ThirdActivity中的按钮时，执行ObserverManager.getInstance().notifyObserver("观察者请刷新信息");
然后所有添加到监听队列的Activity都会更新数据，ObserverManager.getInstance().add(this)就是添加到监听队列的方法，更新操作执行在observerUpData(String content)方法中。
