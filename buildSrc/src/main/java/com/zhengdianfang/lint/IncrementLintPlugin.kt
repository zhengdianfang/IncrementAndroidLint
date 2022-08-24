package com.zhengdianfang.lint

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.ResolutionStrategy

open class IncrementLintPlugin : Plugin<Project> {
    private val incrementLintVersion = "com.zhengdianfang.lint:lint:1.0.0"

    override fun apply(project: Project) {
        val configuration = project.configurations.getByName("lintClassPath")
//        println("find configuration name========= ${configuration.name}")
        configuration.incoming.beforeResolve {
            configuration.dependencies.add(project.dependencies.create(incrementLintVersion))
        }
//        configuration.incoming.afterResolve {
//            println("lint incoming path21 = " + configuration.files.map { it.absolutePath })
//        }
        configuration.resolutionStrategy {
            it.sortArtifacts(ResolutionStrategy.SortOrder.CONSUMER_FIRST)
        }
    }
}