package framework.util;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.ThreadContext;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.Predicate;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Logger {

    @Getter
    private static final org.apache.logging.log4j.Logger logg = LogManager.getLogger();

    public static synchronized void startTestCase(String testCaseName) {
        testCaseName = testCaseName.replaceAll("[^a-zA-Z0-9]", "_").replaceAll("_+", "");
        startLog(System.getProperty("user.dir"), testCaseName);
        info("\n\n********** Execution started : " + testCaseName + " ********\n");
    }

    public static void startLog(String path, String testCaseName) {
        Predicate<File> filterFile = file -> file.isFile() && file.getName().endsWith(".log") && file.getName().contains(testCaseName);
        int noOfFiles = (int) Arrays.stream(Objects.requireNonNull(new File(path).listFiles()))
                .filter(filterFile)
                .count();
        noOfFiles++;
        ThreadContext.put("logFileName", String.format("%s_%s", testCaseName, noOfFiles));
    }

    public static void info(String message) {
        getLogg().info(getCallInfo() + message);
    }

    private static String getCallInfo() {
        String className = Thread.currentThread().getStackTrace()[3].getClassName();
        String methodName = Thread.currentThread().getStackTrace()[3].getMethodName();
        int lineNumber = Thread.currentThread().getStackTrace()[3].getLineNumber();
        return String.format("%s: %s: %s: ==> ", className, methodName, lineNumber);
    }
}
