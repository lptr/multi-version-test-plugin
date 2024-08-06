package org.example;

import org.gradle.api.Project;
import org.gradle.api.tasks.compile.JavaCompile;

public class SharedPluginCode {
    public void apply(Project project, ProjectConfiguratorShim configurator) {
        project.getTasks().register("greeting", task -> {
            task.doLast(s -> System.out.println("Hello from plugin 'org.example.greeting'"));
        });

        project.getTasks().withType(JavaCompile.class, task -> {
            System.out.println("Configuring JavaCompile task: " + task.getName());
            configurator.configureJavaCompile(task);
        });
    }

    public interface ProjectConfiguratorShim {
        void configureJavaCompile(JavaCompile task);
    }
}
