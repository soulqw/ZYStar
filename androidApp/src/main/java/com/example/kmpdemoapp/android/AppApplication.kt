package com.example.kmpdemoapp.android

import android.app.Application


class AppApplication:Application() {
    override fun onCreate() {
        super.onCreate()

//        // 获取默认的时区规则提供者
//        val shanghaiRules: ZoneRules? = ZoneRulesProvider.getRules("Asia/Shanghai", false)
//        if (shanghaiRules != null) {
//            // 注册东八区的时区规则
//            ZoneRulesProvider.registerProvider(TzdbZoneRulesProvider().apply {
//
//            })
//        }
    }
}