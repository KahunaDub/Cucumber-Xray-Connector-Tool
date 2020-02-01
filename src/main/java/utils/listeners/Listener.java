package utils.listeners;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.RunListener;
import utils.Helper;

import java.io.IOException;

public class Listener extends RunListener {

    @Override
    public void testStarted(Description description) {

    }

    @Override
    public void testFinished(Description description) {

    }

    @Override
    public void testRunStarted(Description description) {
    }

    @Override
    public void testRunFinished(Result result) throws IOException, InterruptedException {
        System.out.println(" test run finished");
        Helper.exportReportToJIRA();
    }
}