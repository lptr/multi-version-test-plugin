package org.example;

import org.gradle.api.Project;
import org.gradle.api.Plugin;

public class MultiVersionTestPluginPlugin implements Plugin<Project> {
    public void apply(Project project) {
        new SharedPluginCode().apply(project, javaCompile -> {
            javaCompile.getOptions().getEncoding().set("UTF-8");
        });
    }
}
