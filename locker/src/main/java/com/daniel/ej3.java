package com.daniel;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

class AccessControl {
    AtomicInteger cont = new AtomicInteger();
    public Integer connect(){
        cont.updateAndGet(concurrent ->{
            if (concurrent<5) {
                return concurrent+1;
            }
            return concurrent;
        });
    }

    public void disconnect(){
        cont.updateAndGet(concurrent ->{
            if (concurrent>0) {
                return concurrent-1;
            }
            return concurrent;
        });
    }
}


public class ej3{
    public static void main(String[] args) {
        AccessControl accessControl = new AccessControl();
        try (var executor = Executors.newSingleThreadExecutor()){
            for (int i = 0; i < 100; i++) {
                executor.submit(()->{
                    for (int j = 0; j < 100; j++) {
                        System.out.println(accessControl.connect());
                    }
                });
            }
        }
    }
}
