package de.danshu93.playground;

import java.util.HashMap;
import java.util.Map;

class Playground {

    // just playing with lambda expressions

    private interface Lambdaable {
        public String transform(String master, String... vars);
    }

    private static enum StringOperation {
        CONCAT, REMOVE, REGEX_MATCHES;

        private static Map<StringOperation, Lambdaable> STRING_OPERATION_2_LAMBDAABLE =
            new HashMap<StringOperation, Lambdaable>();

        static {
            STRING_OPERATION_2_LAMBDAABLE.put(StringOperation.CONCAT, (master, vars) -> {
                StringBuilder result = new StringBuilder(master);
                for (String var : vars) {
                    result.append(var);
                }
                return result.toString();
            });
            STRING_OPERATION_2_LAMBDAABLE.put(StringOperation.REMOVE, (master, vars) -> {
                String result = master;
                for (String var : vars) {
                    result = result.replaceAll(var, "");
                }
                return result.toString();
            });

            STRING_OPERATION_2_LAMBDAABLE.put(StringOperation.REGEX_MATCHES, (master, vars) -> {
                for (String var : vars) {
                    if (!master.matches(var)) {
                        return String.valueOf(false);
                    }
                }
                return String.valueOf(true);
            });
        }

        private Lambdaable asLambdaable() {
            return STRING_OPERATION_2_LAMBDAABLE.get(this);
        }

    }

    public static void main(String[] args) {
        System.out.println(StringOperation.REGEX_MATCHES.asLambdaable().transform("test", "test2"));
    }
}
