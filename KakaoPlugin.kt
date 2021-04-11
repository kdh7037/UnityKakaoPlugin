package kr.co.donghwa.donghwahero.uplugin

import android.util.Log
import com.kakao.kakaolink.v2.KakaoLinkResponse
import com.kakao.kakaolink.v2.KakaoLinkService
import com.kakao.message.template.ButtonObject
import com.kakao.message.template.ContentObject
import com.kakao.message.template.FeedTemplate
import com.kakao.message.template.LinkObject
import com.kakao.network.ErrorResult
import com.kakao.network.callback.ResponseCallback
import com.unity3d.player.UnityPlayer
import com.unity3d.player.UnityPlayerActivity

class KakaoPlugin : UnityPlayerActivity(){
    fun FeedTemplate(){
        val template = FeedTemplate.newBuilder(
            ContentObject.newBuilder(
                "제목",
                "아이콘",
                LinkObject.newBuilder().apply{
                    setWebUrl("사이트")
                    setMobileWebUrl("사이트")
                }.build()
            ).setDescrption("설명").build()
        ).addButton(ButtonObject(
            "앱에서 보기", LinkObject.newBuilder()
                .setAndroidExecutionParams("key1=value1")
                .setIosExecutionParams("key1=value1")
                .build()
            )
        ).build()

        val ServerCallBack = HashMap<String, String>();

        KakaoLinkService.getInstance().sendDefault(UnityPlayer.currentActivity, template,
            ServerCallBack,object : ResponseCallback<KakaoLinkResponse>(){

                override fun onSuccess(result: KakaoLinkResponse?) {
                    Log.d("ppap", "성공함")
                }

                override fun onFailure(errorResult: ErrorResult?) {
                    Log.d("ppap", "실패함")
                }
            })
    }
}