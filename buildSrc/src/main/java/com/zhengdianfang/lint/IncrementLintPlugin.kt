package com.zhengdianfang.lint

import org.gradle.api.Plugin
import org.gradle.api.Project

open class IncrementLintPlugin : Plugin<Project> {
    private val incrementLintVersion = "com.zhengdianfang.lint:lint:1.0.0"

    override fun apply(project: Project) {
        println("IncrementLintPlugin ======== started")
        project.configurations.forEach {
            println("configuration name========= ${it.name}")
        }
//        val configuration = project.configurations.detachedConfiguration(
//            project.dependencies.create(
//                mapOf(
//                    "group" to "com.android.tools.lint",
//                    "name" to "lint-gradle",
//                    "version" to "30.2.0",
//                )
//            )
//        )
        val configuration = project.configurations.getByName("lintChecks")
        println("find configuration name========= ${configuration.name}")

        configuration.incoming.beforeResolve {
            configuration.dependencies.add(project.dependencies.create(incrementLintVersion))
        }
        configuration.incoming.afterResolve {
            println("lint incoming path21 = " + configuration.files.map { it.absolutePath })
        }
    }
}