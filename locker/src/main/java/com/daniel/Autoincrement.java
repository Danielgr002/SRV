package com.daniel;

import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicLong;

public class Autoincrement {
    public static void main(String[] args) {
        UniqueIDGenerator uniqueIDGenerator = new UniqueIDGenerator();
        try(var executor = Executors.newSingleThreadExecutor()){
            for (int i = 0; i < 10; i++) {
                executor.submit(()->{
                    for (int j = 0; j < 500; j++) {
                        System.out.println(uniqueIDGenerator.generateID());
                    }
                });
            }
        }
    }
}
class UniqueIDGenerator{
    AtomicLong id = new AtomicLong(1);
    public long generateID(){
        return id.incrementAndGet();
    }
}