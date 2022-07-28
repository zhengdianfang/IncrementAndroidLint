package com.zhengdianfang.linthooks

import java.io.IOException

object GitDiffUtils {

    fun getDiffFiles(): List<String> {
        val exec = Runtime.getRuntime().exec("git diff --name-only")
        val inputStream = exec.inputStream
        try {
            return inputStream.reader().readLines()
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            inputStream.close()
        }
        return emptyList()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println("========")
        println(getDiffFiles())
    }
}