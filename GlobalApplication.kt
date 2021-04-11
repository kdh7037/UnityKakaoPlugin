package kr.co.donghwa.donghwahero.uplugin

import android.app.Application
import com.kakao.auth.*

class GlobalApplication : Application() {
    class KakaoSdkAdapter : KakaoAdapter(){


        override fun getApplicationConfig(): IApplicationConfig {
            return IApplicationConfig { globalApplicationContext }
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        KakaoSDK.init(KakaoSdkAdapter())
    }

    companion object{
        private var instance : GlobalApplication? = null
        val globalApplicationContext:GlobalApplication
        get(){
            if(instance==null)
                throw IllegalThreadStateException("wow")

            return instance!!
        }
    }
}