package com.github.dahalibut.textflowers.services

import com.intellij.openapi.project.Project
import com.github.dahalibut.textflowers.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
