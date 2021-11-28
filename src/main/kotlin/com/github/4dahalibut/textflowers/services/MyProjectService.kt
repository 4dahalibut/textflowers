package com.github.4dahalibut.textflowers.services

import com.intellij.openapi.project.Project
import com.github.4dahalibut.textflowers.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
