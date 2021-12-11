package com.my4tb.java8.stream;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StreamTest12 {

    private static class Scheduler {

        Scheduler(String outerId, String handler) {
            this.outerId = outerId;
            this.handler = handler;
        }

        String outerId;
        String handler;

        boolean matchCondition() {
            return handler != null;
        }
    }

    public static void main(String[] args) {

        List<Scheduler> schedulers = Arrays.asList(
                new Scheduler("o1", "h1"),
                new Scheduler("o2", "h2"),
                new Scheduler("o3", null)
        );
        HashMap<Object, Object> rst = schedulers.stream()
                .filter(Scheduler::matchCondition)
                .collect(HashMap::new, (m, s) -> m.put(s.outerId, s.handler), Map::putAll);
        System.out.println("rst = " + rst);
    }

}
