package com.github.catvod.spider;

import android.content.Context;
import com.github.catvod.spider.merge.I7;
import com.github.catvod.spider.merge.S;
import com.github.catvod.spider.merge.TUn;
import com.github.catvod.spider.merge.We;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class Push extends I7 {
  private We A;
  
  protected void A(Context paramContext) {
    super.A(paramContext);
    We we = new We();
    this.A = we;
    we.init(paramContext);
  }
  
  protected String V(String paramString) {
    try {
      StringBuilder stringBuilder;
      if (this.A.oj(paramString))
        return this.A.detailContent(Collections.singletonList(paramString)); 
      boolean bool = S.O(paramString);
      String str1 = TUn.d("1C081E10");
      String str2 = TUn.d("97CAE681C8DF96F3C082D1D254");
      String str3 = TUn.d("060E093B3500111832113700");
      String str4 = TUn.d("060E093B35001118320237031D");
      String str5 = TUn.d("04181D011A02110C08");
      String str6 = TUn.d("1815191436565F4E1D0D2642020C0F4A270803150C102C0F5E0202096A0E1A094255215C12515F00750A45560B54245842535D55235542020C06245941515A0121421A110803");
      String str7 = TUn.d("060E093B350513");
      String str8 = TUn.d("060E093B2B0D1D04");
      String str9 = TUn.d("060E093B2C08");
      if (bool) {
        JSONObject jSONObject1 = new JSONObject();
        this();
        JSONArray jSONArray = new JSONArray();
        this();
        JSONObject jSONObject2 = new JSONObject();
        this();
        jSONObject2.put(str9, paramString);
        jSONObject2.put(str8, paramString);
        jSONObject2.put(str7, str6);
        jSONObject2.put(str5, TUn.d("95CFF582FFFC"));
        jSONObject2.put(TUn.d("060E093B3C091113"), "");
        jSONObject2.put(TUn.d("060E093B241E1500"), "");
        jSONObject2.put(TUn.d("060E093B37091D001F0F36"), "");
        jSONObject2.put(TUn.d("060E093B240F040E1F"), "");
        jSONObject2.put(TUn.d("060E093B210502040E102A1E"), "");
        jSONObject2.put(TUn.d("060E093B26031E15080A31"), "");
        jSONObject2.put(str4, TUn.d("1A19"));
        stringBuilder = new StringBuilder();
        this();
        stringBuilder.append(str2);
        stringBuilder.append(paramString);
        jSONObject2.put(str3, stringBuilder.toString());
        jSONArray.put(jSONObject2);
        jSONObject1.put(str1, jSONArray);
        return jSONObject1.toString();
      } 
      if (S.vH(paramString)) {
        JSONObject jSONObject1 = new JSONObject();
        this();
        JSONArray jSONArray = new JSONArray();
        this();
        JSONObject jSONObject2 = new JSONObject();
        this();
        jSONObject2.put(str9, paramString);
        jSONObject2.put((String)stringBuilder, paramString);
        jSONObject2.put(str7, str6);
        jSONObject2.put(str5, TUn.d("97FAD98CFAF2"));
        jSONObject2.put(str4, TUn.d("000D0C1D201E"));
        stringBuilder = new StringBuilder();
        this();
        stringBuilder.append(str2);
        stringBuilder.append(paramString);
        jSONObject2.put(str3, stringBuilder.toString());
        jSONArray.put(jSONObject2);
        jSONObject1.put(str1, jSONArray);
        return jSONObject1.toString();
      } 
      if (paramString.startsWith(TUn.d("181519147F435F")) || paramString.startsWith(TUn.d("1815191436565F4E"))) {
        JSONObject jSONObject1 = new JSONObject();
        this();
        JSONArray jSONArray = new JSONArray();
        this();
        JSONObject jSONObject2 = new JSONObject();
        this();
        jSONObject2.put(str9, paramString);
        jSONObject2.put((String)stringBuilder, paramString);
        jSONObject2.put(str7, str6);
        jSONObject2.put(str5, TUn.d("97DCFC8DE4D9"));
        jSONObject2.put(str4, TUn.d("00001F1720"));
        stringBuilder = new StringBuilder();
        this();
        stringBuilder.append(str2);
        stringBuilder.append(paramString);
        jSONObject2.put(str3, stringBuilder.toString());
        jSONArray.put(jSONObject2);
        jSONObject1.put(str1, jSONArray);
        return jSONObject1.toString();
      } 
    } finally {}
    return "";
  }
  
  protected String ed(String paramString1, String paramString2, List<String> paramList) {
    String str = TUn.d("1A19");
    try {
      if (paramString1.equals(TUn.d("110D041D35")))
        return this.A.playerContent(paramString1, paramString2, paramList); 
      boolean bool = paramString1.equals(str);
      String str1 = TUn.d("051301");
      String str2 = TUn.d("00001F1720");
      if (bool) {
        JSONObject jSONObject = new JSONObject();
        this();
        jSONObject.put(str2, 1);
        jSONObject.put(str, TUn.d("41"));
        jSONObject.put(str1, paramString2);
        return jSONObject.toString();
      } 
      bool = paramString1.equals(str2);
      str = TUn.d("000D0C1D101E1C");
      if (bool) {
        JSONObject jSONObject = new JSONObject();
        this();
        jSONObject.put(str2, 1);
        jSONObject.put(str, "");
        jSONObject.put(str1, paramString2);
        return jSONObject.toString();
      } 
      if (paramString1.equals(TUn.d("000D0C1D201E"))) {
        JSONObject jSONObject = new JSONObject();
        this();
        jSONObject.put(str2, 0);
        jSONObject.put(str, "");
        jSONObject.put(str1, paramString2);
        return jSONObject.toString();
      } 
    } finally {}
    return "";
  }
}
