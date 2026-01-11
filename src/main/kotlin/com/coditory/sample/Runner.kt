package com.coditory.sample

import com.coditory.klog.Klog

object Runner {
    private val log = Klog.logger<Runner>()

    @JvmStatic
    fun main(args: Array<String>) {
        log.info { "Hello world!!!" }
        Klog.stopAndFlush()
    }
}
