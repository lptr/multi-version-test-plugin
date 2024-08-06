package org.example;

import org.gradle.api.Project;
import org.gradle.api.tasks.compile.JavaCompile;

public class SharedPluginCode {
    public String getMessage() {
        return "Hello from common 'org.example.Shared'";
    }

    public void apply(Project project, ProjectConfiguratorShim configurator) {
        project.getTasks().register("sharedGreeting", task -> {
            task.doLast(s -> System.out.println(getMessage()));
        });

        project.getTasks().withType(JavaCompile.class, task -> {
            configurator.configureJavaCompile(task);
            task.doFirst(s -> System.out.println("Configuring JavaCompile task: " + task.getName()));
        });
    }

    public interface ProjectConfiguratorShim {
        void configureJavaCompile(JavaCompile task);
    }
}
