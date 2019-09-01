package com.stepyen.simplebase

import android.app.Application
import android.content.Context
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.stepyen.xui.XUI
import com.stepyen.xutil.XUtil
import com.xuexiang.xupdate.XUpdate
import com.xuexiang.xupdate.entity.UpdateError
import com.xuexiang.xupdate.listener.OnUpdateFailureListener

/**
 * date：2019-09-01
 * author：stepyen
 * description：
 *
 */
class App: Application() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)

    }

    override fun onCreate() {
        super.onCreate()
        Logger.addLogAdapter(AndroidLogAdapter())
        XUI.init(this);
        XUtil.init(this);
//                initUpdate(this);


    }

    private fun initUpdate(application: Application) {
        XUpdate.get()
            .debug(true)
            .isWifiOnly(false)                                               //默认设置只在wifi下检查版本更新
            .isGet(true)                                                    //默认设置使用get请求检查版本
            .isAutoMode(false)                                              //默认设置非自动模式，可根据具体使用配置
            .setOnUpdateFailureListener {
                //                        if (error.getCode() != CHECK_NO_NEW_VERSION) {          //对不同错误进行处理
                //                            ToastUtils.toast(error.toString());
                //                        }
            }
            .supportSilentInstall(true)                                     //设置是否支持静默安装，默认是true
            .setIUpdateHttpService(OKHttpUpdateHttpService())           //这个必须设置！实现网络请求功能。
            .init(application)                                                    //这个必须初始化
    }
}