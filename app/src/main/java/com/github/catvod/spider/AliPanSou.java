package com.github.catvod.spider;

import android.content.Context;
import com.github.catvod.crawler.Spider;
import com.github.catvod.spider.merge.IK;
import com.github.catvod.spider.merge.UI;
import com.github.catvod.spider.merge.ae;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class AliPanSou extends Spider {
  private static final Pattern l = Pattern.compile("(https:\\/\\/www.aliyundrive.com\\/s\\/[^\\\"]+)");
  
  private Ali g;
  
  public String detailContent(List<String> paramList) {
    String str;
    try {
      String str1 = paramList.get(0);
      Pattern pattern = l;
      if (pattern.matcher(str1).find())
        return this.g.detailContent(paramList); 
      StringBuilder stringBuilder = new StringBuilder();
      this();
      stringBuilder.append("https://www.alipansou.com");
      stringBuilder.append(paramList.get(0));
      Matcher matcher = pattern.matcher(ae.V(stringBuilder.toString(), null));
      boolean bool = matcher.find();
      if (!bool)
        return ""; 
      paramList.set(0, matcher.group(1));
      str = this.g.detailContent(paramList);
    } catch (Exception exception) {
      exception.printStackTrace();
      str = "";
    } 
    return str;
  }
  
  public void init(Context paramContext) {
    super.init(paramContext);
    Ali ali = new Ali();
    this.g = ali;
    ali.init(paramContext);
  }
  
  public String playerContent(String paramString1, String paramString2, List<String> paramList) {
    return this.g.playerContent(paramString1, paramString2, paramList);
  }
  
  public String searchContent(String paramString, boolean paramBoolean) {
    try {
      HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
      this();
      hashMap.put("7", ");
      hashMap.put("1", ");
      jSONArray = new JSONArray();
      this();
      for (Map.Entry<Object, Object> entry : hashMap.entrySet()) {
        String str2 = (String)entry.getKey();
        String str1 = (String)entry.getValue();
        StringBuilder stringBuilder = new StringBuilder();
        this();
        stringBuilder.append("https://www.alipansou.com/search?k=");
        stringBuilder.append(URLEncoder.encode(paramString));
        stringBuilder.append("&t=");
        stringBuilder.append(str2);
        for (IK iK : UI.g(ae.V(stringBuilder.toString(), null)).o("van-row > a")) {
          String str = iK.Xq("template").H().trim();
          if (str.contains(paramString)) {
            JSONObject jSONObject1 = new JSONObject();
            this();
            jSONObject1.put("vod_id", iK.dV("href"));
            StringBuilder stringBuilder1 = new StringBuilder();
            this();
            stringBuilder1.append("[");
            stringBuilder1.append(str1);
            stringBuilder1.append("] ");
            stringBuilder1.append(str);
            jSONObject1.put("vod_name", stringBuilder1.toString());
            stringBuilder1 = new StringBuilder();
            this();
            stringBuilder1.append("https://www.alipansou.com");
            stringBuilder1.append(iK.Xq("van-col > van-card").dV("thumb"));
            jSONObject1.put("vod_pic", stringBuilder1.toString());
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
    jSONObject.put("list", jSONArray);
    return jSONObject.toString();
  }
}
