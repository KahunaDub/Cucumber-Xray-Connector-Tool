package utils;

import cucumber.api.junit.Cucumber;
import cucumber.runtime.Runtime;
import cucumber.runtime.RuntimeOptions;
import cucumber.runtime.io.ResourceLoader;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;
import utils.listeners.Listener;

import java.io.IOException;

import static utils.Constant.IMPORTED_SCENARIO_DIRECTORY;

public class MyCucumber extends Cucumber {
    public MyCucumber(Class clazz) throws InitializationError, IOException {
        super(clazz);
    }

    @Override
    public Runtime createRuntime(ResourceLoader resourceLoader, ClassLoader classLoader, RuntimeOptions runtimeOptions) throws InitializationError, IOException {
        Helper.makeDirectory(IMPORTED_SCENARIO_DIRECTORY);
        Helper.importTestsFromJIRA(Constant.JIRA_ISSUE_KEYS);
        return super.createRuntime(resourceLoader, classLoader, runtimeOptions);
    }

    @Override
    public void run(RunNotifier notifier) {
        notifier.addListener(new Listener());
        super.run(notifier);
    }
}
