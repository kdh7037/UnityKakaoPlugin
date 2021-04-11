using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Plugin : MonoBehaviour
{
#if UNITY_ANDROID
    AndroidJavaObject kotlin;
#endif
    RectTransform pos;
    public GameObject btn_kakao;
    public GameObject btn_another;

    private void Awake()
    {
#if UNITY_ANDROID
        kotlin = new AndroidJavaObject("패키지.uplugin.KakaoPlugin");
        btn_kakao = transform.Find("Panel_Menu/Button_Kakao").gameObject;
        btn_another = transform.Find("Panel_Menu/Button_Another").gameObject;
        Destroy(btn_kakao);
        pos = btn_another.GetComponent<RectTransform>();
        pos.anchoredPosition = new Vector3(0, pos.localPosition.y, 0);
#endif

    }

    public void FeedTemplate()
    {
#if UNITY_ANDROID
        kotlin.Call("FeedTemplate");
#endif
    }

    public void AnotherApp()
    {
        Application.OpenURL("사이트");
    }
}
