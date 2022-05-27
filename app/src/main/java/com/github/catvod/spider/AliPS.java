package com.github.catvod.spider;

import android.content.Context;
import com.github.catvod.spider.merge.I7;
import com.github.catvod.spider.merge.TUn;
import com.github.catvod.spider.merge.U;
import com.github.catvod.spider.merge.We;
import com.github.catvod.spider.merge.uX;
import com.github.catvod.spider.merge.yi;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class AliPS extends I7 {
  private static Pattern A = Pattern.compile(TUn.d("58091910351F4A3D42386A1B071643052905091403003705060443072A012C4E1E386A372E3D4F396E45"));
  
  private We ed;
  
  protected void A(Context paramContext) {
    super.A(paramContext);
    We we = new We();
    this.ed = we;
    we.init(paramContext);
  }
  
  protected String V(String paramString) {
    String str;
    try {
      if (A.matcher(paramString).find())
        return this.ed.detailContent(Collections.singletonList(paramString)); 
      Pattern pattern = A;
      StringBuilder stringBuilder = new StringBuilder();
      this();
      stringBuilder.append(TUn.d("1815191436565F4E1A133242110D04142402030E184A26031D"));
      stringBuilder.append(paramString);
      Matcher matcher = pattern.matcher(U.x(stringBuilder.toString(), null));
      boolean bool = matcher.find();
      if (!bool)
        return ""; 
      str = this.ed.detailContent(Collections.singletonList(matcher.group(1)));
    } catch (Exception exception) {
      exception.printStackTrace();
      str = "";
    } 
    return str;
  }
  
  protected String ed(String paramString1, String paramString2, List<String> paramList) {
    return this.ed.playerContent(paramString1, paramString2, paramList);
  }
  
  protected String uK(String paramString, boolean paramBoolean) {
    try {
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      this();
      hashMap.put(TUn.d("47"), TUn.d("96F7EA80FEDA95C5D4"));
      hashMap.put(TUn.d("41"), TUn.d("98C6EB8DE7FD"));
      jSONArray = new JSONArray();
      this();
      for (Map.Entry<Object, Object> entry : hashMap.entrySet()) {
        String str = (String)entry.getValue();
        StringBuilder stringBuilder = new StringBuilder();
        this();
        stringBuilder.append(TUn.d("1815191436565F4E1A133242110D04142402030E184A26031D4E1E01241E1309520F78"));
        stringBuilder.append(URLEncoder.encode(paramString));
        stringBuilder.append(TUn.d("561550"));
        stringBuilder.append((String)entry.getKey());
        for (yi yi : uX.F(U.x(stringBuilder.toString(), null)).r(TUn.d("0600034937030741534424"))) {
          String str1 = yi.v8(TUn.d("04040014290D0404")).XW().trim();
          if (str1.contains(paramString)) {
            JSONObject jSONObject1 = new JSONObject();
            this();
            jSONObject1.put(TUn.d("060E093B2C08"), yi.P(TUn.d("18130802")));
            String str2 = TUn.d("060E093B2B0D1D04");
            StringBuilder stringBuilder2 = new StringBuilder();
            this();
            stringBuilder2.append(TUn.d("2B"));
            stringBuilder2.append(str);
            stringBuilder2.append(TUn.d("2D41"));
            stringBuilder2.append(str1);
            jSONObject1.put(str2, stringBuilder2.toString());
            StringBuilder stringBuilder1 = new StringBuilder();
            this();
            stringBuilder1.append(TUn.d("1815191436565F4E1A133242110D04142402030E184A26031D"));
            stringBuilder1.append(yi.v8(TUn.d("0600034926031C415344330D1E4C0E053708")).P(TUn.d("0409180927")));
            jSONObject1.put(TUn.d("060E093B350513"), stringBuilder1.toString());
            jSONArray.put(jSONObject1);
          } 
        } 
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
      return "";
    } 
    JSONObject jSONObject = new JSONObject();
    this();
    JSONArray jSONArray;
    jSONObject.put(TUn.d("1C081E10"), jSONArray);
    return jSONObject.toString();
  }
}
