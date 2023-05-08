package util;

import com.amazonaws.services.lambda.runtime.LambdaLogger;

public class Logger {
    private final LambdaLogger lambdaLogger;

    public Logger(LambdaLogger lambdaLogger) {
        this.lambdaLogger = lambdaLogger;

    }

    public void log(String message) {
        lambdaLogger.log(message + "\n");
    }

}
