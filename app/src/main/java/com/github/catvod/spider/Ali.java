package com.github.catvod.spider;

import android.content.Context;
import android.net.UrlQuerySanitizer;
import android.text.TextUtils;
import com.github.catvod.crawler.Spider;
import com.github.catvod.crawler.SpiderDebug;
import com.github.catvod.spider.merge.a6;
import com.github.catvod.spider.merge.ae;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;
import okhttp3.Call;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Ali extends Spider {
  private static Pattern HL;
  
  private static long J = 0L;
  
  private static Pattern cY;
  
  private static Map<String, String> dV = new HashMap<String, String>();
  
  private static String g = "";
  
  private static long l;
  
  private static Map<String, Map<String, String>> lN;
  
  private static ReentrantLock q3;
  
  private static Map<String, Long> rl = new HashMap<String, Long>();
  
  private static long zJ;
  
  static {
    cY = Pattern.compile("(https:\\/\\/www.aliyundrive.com\\/s\\/[^\\\"]+)");
    HL = Pattern.compile("www.aliyundrive.com\\/s\\/([^\\/]+)(\\/folder\\/([^\\/]+))?");
    lN = new HashMap<String, Map<String, String>>();
    q3 = new ReentrantLock();
    zJ = 0L;
  }
  
  private static String HL(String paramString1, String paramString2, String paramString3) {
    String str;
    try {
      JSONObject jSONObject2 = new JSONObject();
      this();
      jSONObject2.put("share_id", paramString1);
      jSONObject2.put("category", "live_transcoding");
      jSONObject2.put("file_id", paramString3);
      jSONObject2.put("template_id", "");
      HashMap<String, String> hashMap = g();
      hashMap.put("x-share-token", paramString2);
      hashMap.put("authorization", g);
      JSONObject jSONObject1 = new JSONObject();
      this(rl("https://api.aliyundrive.com/v2/file/get_share_link_video_preview_play_info", jSONObject2.toString(), hashMap));
      ArrayList<String> arrayList = new ArrayList();
      this();
      arrayList.add("FHD");
      arrayList.add("HD");
      arrayList.add("SD");
      JSONArray jSONArray = jSONObject1.getJSONObject("video_preview_play_info").getJSONArray("live_transcoding_task_list");
      Iterator<String> iterator = arrayList.iterator();
      String str1 = "";
      while (true) {
        if (iterator.hasNext()) {
          String str4 = iterator.next();
          if (str1.isEmpty()) {
            byte b1;
            for (b1 = 0; b1 < jSONArray.length(); b1++) {
              JSONObject jSONObject = jSONArray.getJSONObject(b1);
              if (jSONObject.getString("template_id").equals(str4)) {
                str1 = jSONObject.getString("url");
                continue;
              } 
            } 
            continue;
          } 
        } 
        if (TextUtils.isEmpty(str1))
          str1 = jSONArray.getJSONObject(0).getString("url"); 
        HashMap<Object, Object> hashMap2 = new HashMap<Object, Object>();
        this();
        ae.Yl(str1, g(), hashMap2);
        String str2 = ae.cY(hashMap2);
        str1 = ae.V(str2, g());
        StringBuilder stringBuilder = new StringBuilder();
        this();
        stringBuilder.append(str2.substring(0, str2.lastIndexOf("/")));
        stringBuilder.append("/");
        String str3 = stringBuilder.toString();
        ArrayList<String> arrayList1 = new ArrayList();
        this();
        HashMap<Object, Object> hashMap1 = new HashMap<Object, Object>();
        this();
        String[] arrayOfString = str1.split("\n");
        int i = arrayOfString.length;
        int j = 0;
        byte b = 0;
        while (b < i) {
          String str4;
          String str5 = arrayOfString[b];
          int k = j;
          str1 = str5;
          if (str5.contains("x-oss-expires")) {
            k = j + 1;
            StringBuilder stringBuilder1 = new StringBuilder();
            this();
            stringBuilder1.append(str3);
            stringBuilder1.append(str5);
            str5 = stringBuilder1.toString();
            stringBuilder1 = new StringBuilder();
            this();
            stringBuilder1.append("");
            stringBuilder1.append(k);
            hashMap1.put(stringBuilder1.toString(), str5);
            stringBuilder1 = new StringBuilder();
            this();
            stringBuilder1.append(Proxy.localProxyUrl());
            stringBuilder1.append("?do=ali&type=media&share_id=");
            stringBuilder1.append(paramString1);
            stringBuilder1.append("&file_id=");
            stringBuilder1.append(paramString3);
            stringBuilder1.append("&media_id=");
            stringBuilder1.append(k);
            str4 = stringBuilder1.toString();
          } 
          arrayList1.add(str4);
          b++;
          j = k;
        } 
        lN.put(paramString3, hashMap1);
        return TextUtils.join("\n", arrayList1);
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
      str = "";
    } 
    return str;
  }
  
  protected static long J() {
    return System.currentTimeMillis() / 1000L + zJ;
  }
  
  private static void cY() {
    long l = J();
    if (g.isEmpty() || l - l <= 600L)
      try {
        JSONObject jSONObject1 = new JSONObject();
        this();
        jSONObject1.put("refresh_token", "ef71027a63114edd917d606babe33b4a");
        JSONObject jSONObject2 = new JSONObject();
        this(rl("https://api.aliyundrive.com/token/refresh", jSONObject1.toString(), g()));
        StringBuilder stringBuilder = new StringBuilder();
        this();
        stringBuilder.append(jSONObject2.getString("token_type"));
        stringBuilder.append(" ");
        stringBuilder.append(jSONObject2.getString("access_token"));
        g = stringBuilder.toString();
        long l1 = jSONObject2.getLong("expires_in");
        J = l1;
        l = l + l1;
      } catch (JSONException jSONException) {
        SpiderDebug.log((Throwable)jSONException);
      }  
  }
  
  private static HashMap<String, String> g() {
    HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
    hashMap.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.54 Safari/537.36");
    hashMap.put("Referer", "https://www.aliyundrive.com/");
    return (HashMap)hashMap;
  }
  
  private static String l(String paramString1, String paramString2) {
    // Byte code:
    //   0: ldc com/github/catvod/spider/Ali
    //   2: monitorenter
    //   3: invokestatic J : ()J
    //   6: lstore_2
    //   7: getstatic com/github/catvod/spider/Ali.dV : Ljava/util/Map;
    //   10: aload_0
    //   11: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   16: checkcast java/lang/String
    //   19: astore #4
    //   21: getstatic com/github/catvod/spider/Ali.rl : Ljava/util/Map;
    //   24: aload_0
    //   25: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   30: checkcast java/lang/Long
    //   33: astore #5
    //   35: aload #4
    //   37: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   40: ifne -> 69
    //   43: aload #5
    //   45: invokevirtual longValue : ()J
    //   48: lstore #6
    //   50: lload #6
    //   52: lload_2
    //   53: lsub
    //   54: ldc2_w 600
    //   57: lcmp
    //   58: ifle -> 69
    //   61: ldc com/github/catvod/spider/Ali
    //   63: monitorexit
    //   64: aload #4
    //   66: astore_0
    //   67: aload_0
    //   68: areturn
    //   69: new org/json/JSONObject
    //   72: astore #5
    //   74: aload #5
    //   76: invokespecial <init> : ()V
    //   79: aload #5
    //   81: ldc 'share_id'
    //   83: aload_0
    //   84: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   87: pop
    //   88: aload #5
    //   90: ldc_w 'share_pwd'
    //   93: aload_1
    //   94: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   97: pop
    //   98: new org/json/JSONObject
    //   101: astore #4
    //   103: aload #4
    //   105: ldc_w 'https://api.aliyundrive.com/v2/share_link/get_share_token'
    //   108: aload #5
    //   110: invokevirtual toString : ()Ljava/lang/String;
    //   113: invokestatic g : ()Ljava/util/HashMap;
    //   116: invokestatic rl : (Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;
    //   119: invokespecial <init> : (Ljava/lang/String;)V
    //   122: aload #4
    //   124: ldc_w 'share_token'
    //   127: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   130: astore_1
    //   131: aload #4
    //   133: ldc_w 'expires_in'
    //   136: invokevirtual getLong : (Ljava/lang/String;)J
    //   139: lstore #6
    //   141: getstatic com/github/catvod/spider/Ali.rl : Ljava/util/Map;
    //   144: aload_0
    //   145: lload_2
    //   146: lload #6
    //   148: ladd
    //   149: invokestatic valueOf : (J)Ljava/lang/Long;
    //   152: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   157: pop
    //   158: getstatic com/github/catvod/spider/Ali.dV : Ljava/util/Map;
    //   161: aload_0
    //   162: aload_1
    //   163: invokeinterface put : (Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   168: pop
    //   169: ldc com/github/catvod/spider/Ali
    //   171: monitorexit
    //   172: aload_1
    //   173: astore_0
    //   174: goto -> 67
    //   177: astore_0
    //   178: aload_0
    //   179: invokestatic log : (Ljava/lang/Throwable;)V
    //   182: ldc com/github/catvod/spider/Ali
    //   184: monitorexit
    //   185: ldc ''
    //   187: astore_0
    //   188: goto -> 67
    //   191: astore_0
    //   192: ldc com/github/catvod/spider/Ali
    //   194: monitorexit
    //   195: aload_0
    //   196: athrow
    // Exception table:
    //   from	to	target	type
    //   3	50	177	org/json/JSONException
    //   3	50	191	finally
    //   69	169	177	org/json/JSONException
    //   69	169	191	finally
    //   178	182	191	finally
  }
  
  public static Object[] proxyM3U8(Map<String, String> paramMap) {
    try {
      String str2 = paramMap.get("share_id");
      String str1 = paramMap.get("file_id");
      ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream();
      this(HL(str2, l(str2, ""), str1).getBytes());
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = Integer.valueOf(200);
      arrayOfObject[1] = "application/octet-stream";
      arrayOfObject[2] = byteArrayInputStream;
    } catch (Exception exception) {
      exception.printStackTrace();
      exception = null;
    } 
    return (Object[])exception;
  }
  
  public static Object[] proxyMedia(Map<String, String> paramMap) {
    try {
      String str2 = paramMap.get("share_id");
      String str3 = paramMap.get("file_id");
      String str4 = paramMap.get("media_id");
      String str5 = l(str2, "");
      q3.lock();
      String str1 = (String)((Map)lN.get(str3)).get(str4);
      UrlQuerySanitizer urlQuerySanitizer = new UrlQuerySanitizer();
      this(str1);
      Long long_ = new Long();
      this(urlQuerySanitizer.getValue("x-oss-expires"));
      if (long_.longValue() - J() <= 60L) {
        HL(str2, str5, str3);
        str1 = (String)((Map)lN.get(str3)).get(str4);
      } 
      q3.unlock();
      a6.V v = new a6.V() {
          protected void onFailure(Call param1Call, Exception param1Exception) {}
          
          protected void onResponse(Response param1Response) {}
        };
      super();
      ae.rl(ae.J(), str1, null, g(), (a6)v);
      InputStream inputStream = ((Response)v.getResult()).body().byteStream();
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = Integer.valueOf(200);
      arrayOfObject[1] = "video/MP2T";
      arrayOfObject[2] = inputStream;
    } catch (Exception exception) {
      exception.printStackTrace();
      exception = null;
    } 
    return (Object[])exception;
  }
  
  private static String rl(String paramString1, String paramString2, Map<String, String> paramMap) {
    a6.J j = new a6.J() {
        protected void onFailure(Call param1Call, Exception param1Exception) {
          param1Exception.printStackTrace();
        }
        
        protected void onResponse(String param1String) {}
      };
    ae.zJ(ae.J(), paramString1, paramString2, paramMap, (a6)j);
    return (String)j.getResult();
  }
  
  public static Object[] vod(Map<String, String> paramMap) {
    String str = paramMap.get("type");
    return str.equals("m3u8") ? proxyM3U8(paramMap) : (str.equals("media") ? proxyMedia(paramMap) : null);
  }
  
  protected void dV() {
    try {
      JSONObject jSONObject = new JSONObject();
      this(ae.V("http://worldtimeapi.org/api/timezone/Asia/Shanghai", null));
      zJ = jSONObject.getLong("unixtime") - System.currentTimeMillis() / 1000L;
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  public String detailContent(List<String> paramList) {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_1
    //   3: iconst_0
    //   4: invokeinterface get : (I)Ljava/lang/Object;
    //   9: checkcast java/lang/String
    //   12: invokevirtual trim : ()Ljava/lang/String;
    //   15: astore_3
    //   16: getstatic com/github/catvod/spider/Ali.HL : Ljava/util/regex/Pattern;
    //   19: aload_3
    //   20: invokevirtual matcher : (Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   23: astore_1
    //   24: aload_1
    //   25: invokevirtual find : ()Z
    //   28: istore #4
    //   30: iload #4
    //   32: ifne -> 40
    //   35: ldc ''
    //   37: astore_1
    //   38: aload_1
    //   39: areturn
    //   40: aload_1
    //   41: iconst_1
    //   42: invokevirtual group : (I)Ljava/lang/String;
    //   45: astore #5
    //   47: aload_1
    //   48: invokevirtual groupCount : ()I
    //   51: iconst_3
    //   52: if_icmpne -> 133
    //   55: aload_1
    //   56: iconst_3
    //   57: invokevirtual group : (I)Ljava/lang/String;
    //   60: astore_1
    //   61: new org/json/JSONObject
    //   64: astore #6
    //   66: aload #6
    //   68: invokespecial <init> : ()V
    //   71: aload #6
    //   73: ldc 'share_id'
    //   75: aload #5
    //   77: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   80: pop
    //   81: new org/json/JSONObject
    //   84: astore #7
    //   86: aload #7
    //   88: ldc_w 'https://api.aliyundrive.com/adrive/v3/share_link/get_share_by_anonymous'
    //   91: aload #6
    //   93: invokevirtual toString : ()Ljava/lang/String;
    //   96: invokestatic g : ()Ljava/util/HashMap;
    //   99: invokestatic rl : (Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Ljava/lang/String;
    //   102: invokespecial <init> : (Ljava/lang/String;)V
    //   105: aload #7
    //   107: ldc_w 'file_infos'
    //   110: invokevirtual getJSONArray : (Ljava/lang/String;)Lorg/json/JSONArray;
    //   113: astore #8
    //   115: aload #8
    //   117: invokevirtual length : ()I
    //   120: istore #9
    //   122: iload #9
    //   124: ifne -> 139
    //   127: ldc ''
    //   129: astore_1
    //   130: goto -> 38
    //   133: ldc ''
    //   135: astore_1
    //   136: goto -> 61
    //   139: aload_1
    //   140: invokestatic isEmpty : (Ljava/lang/CharSequence;)Z
    //   143: ifne -> 209
    //   146: iconst_0
    //   147: istore #9
    //   149: iload #9
    //   151: aload #8
    //   153: invokevirtual length : ()I
    //   156: if_icmpge -> 627
    //   159: aload #8
    //   161: iload #9
    //   163: invokevirtual getJSONObject : (I)Lorg/json/JSONObject;
    //   166: astore #6
    //   168: aload #6
    //   170: ldc 'file_id'
    //   172: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   175: aload #6
    //   177: ldc 'file_id'
    //   179: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   182: invokevirtual equals : (Ljava/lang/Object;)Z
    //   185: istore #4
    //   187: iload #4
    //   189: ifeq -> 203
    //   192: aload #6
    //   194: ifnonnull -> 624
    //   197: ldc ''
    //   199: astore_1
    //   200: goto -> 38
    //   203: iinc #9, 1
    //   206: goto -> 149
    //   209: aload #8
    //   211: iconst_0
    //   212: invokevirtual getJSONObject : (I)Lorg/json/JSONObject;
    //   215: astore #6
    //   217: aload #6
    //   219: ldc 'file_id'
    //   221: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   224: astore_1
    //   225: new org/json/JSONObject
    //   228: astore #8
    //   230: aload #8
    //   232: invokespecial <init> : ()V
    //   235: aload #8
    //   237: ldc_w 'vod_id'
    //   240: aload_3
    //   241: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   244: pop
    //   245: aload #8
    //   247: ldc_w 'vod_name'
    //   250: aload #7
    //   252: ldc_w 'share_name'
    //   255: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   258: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   261: pop
    //   262: aload #8
    //   264: ldc_w 'vod_pic'
    //   267: aload #7
    //   269: ldc_w 'avatar'
    //   272: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   275: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   278: pop
    //   279: aload #8
    //   281: ldc_w 'vod_content'
    //   284: aload_3
    //   285: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   288: pop
    //   289: aload #8
    //   291: ldc_w 'vod_play_from'
    //   294: ldc_w '
    //   297: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   300: pop
    //   301: new java/util/ArrayList
    //   304: astore_3
    //   305: aload_3
    //   306: invokespecial <init> : ()V
    //   309: aload #6
    //   311: ldc_w 'type'
    //   314: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   317: ldc_w 'folder'
    //   320: invokevirtual equals : (Ljava/lang/Object;)Z
    //   323: ifeq -> 477
    //   326: aload #5
    //   328: ldc ''
    //   330: invokestatic l : (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   333: astore #7
    //   335: new java/util/HashMap
    //   338: astore #6
    //   340: aload #6
    //   342: invokespecial <init> : ()V
    //   345: aload_0
    //   346: aload #6
    //   348: aload #5
    //   350: aload #7
    //   352: aload_1
    //   353: invokevirtual listFiles : (Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   356: new java/util/ArrayList
    //   359: astore_1
    //   360: aload_1
    //   361: aload #6
    //   363: invokeinterface keySet : ()Ljava/util/Set;
    //   368: invokespecial <init> : (Ljava/util/Collection;)V
    //   371: aload_1
    //   372: invokestatic sort : (Ljava/util/List;)V
    //   375: aload_1
    //   376: invokeinterface iterator : ()Ljava/util/Iterator;
    //   381: astore_1
    //   382: aload_1
    //   383: invokeinterface hasNext : ()Z
    //   388: ifeq -> 521
    //   391: aload_1
    //   392: invokeinterface next : ()Ljava/lang/Object;
    //   397: checkcast java/lang/String
    //   400: astore #5
    //   402: aload #6
    //   404: aload #5
    //   406: invokeinterface get : (Ljava/lang/Object;)Ljava/lang/Object;
    //   411: checkcast java/lang/String
    //   414: astore #7
    //   416: new java/lang/StringBuilder
    //   419: astore #10
    //   421: aload #10
    //   423: invokespecial <init> : ()V
    //   426: aload #10
    //   428: aload #5
    //   430: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: pop
    //   434: aload #10
    //   436: ldc_w '$'
    //   439: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: pop
    //   443: aload #10
    //   445: aload #7
    //   447: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: pop
    //   451: aload_3
    //   452: aload #10
    //   454: invokevirtual toString : ()Ljava/lang/String;
    //   457: invokeinterface add : (Ljava/lang/Object;)Z
    //   462: pop
    //   463: goto -> 382
    //   466: astore_1
    //   467: aload_1
    //   468: invokestatic log : (Ljava/lang/Throwable;)V
    //   471: ldc ''
    //   473: astore_1
    //   474: goto -> 38
    //   477: aload #6
    //   479: ldc_w 'type'
    //   482: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   485: ldc_w 'file'
    //   488: invokevirtual equals : (Ljava/lang/Object;)Z
    //   491: ifeq -> 618
    //   494: aload #6
    //   496: ldc 'category'
    //   498: invokevirtual getString : (Ljava/lang/String;)Ljava/lang/String;
    //   501: ldc_w 'video'
    //   504: invokevirtual equals : (Ljava/lang/Object;)Z
    //   507: istore #4
    //   509: iload #4
    //   511: ifeq -> 618
    //   514: ldc_w 'root'
    //   517: astore_1
    //   518: goto -> 326
    //   521: new java/util/ArrayList
    //   524: astore_1
    //   525: aload_1
    //   526: invokespecial <init> : ()V
    //   529: iload_2
    //   530: istore #9
    //   532: iload #9
    //   534: iconst_4
    //   535: if_icmpge -> 558
    //   538: aload_1
    //   539: ldc_w '#'
    //   542: aload_3
    //   543: invokestatic join : (Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;
    //   546: invokeinterface add : (Ljava/lang/Object;)Z
    //   551: pop
    //   552: iinc #9, 1
    //   555: goto -> 532
    //   558: aload #8
    //   560: ldc_w 'vod_play_url'
    //   563: ldc_w '$$$'
    //   566: aload_1
    //   567: invokestatic join : (Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;
    //   570: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   573: pop
    //   574: new org/json/JSONObject
    //   577: astore #6
    //   579: aload #6
    //   581: invokespecial <init> : ()V
    //   584: new org/json/JSONArray
    //   587: astore_1
    //   588: aload_1
    //   589: invokespecial <init> : ()V
    //   592: aload_1
    //   593: aload #8
    //   595: invokevirtual put : (Ljava/lang/Object;)Lorg/json/JSONArray;
    //   598: pop
    //   599: aload #6
    //   601: ldc_w 'list'
    //   604: aload_1
    //   605: invokevirtual put : (Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   608: pop
    //   609: aload #6
    //   611: invokevirtual toString : ()Ljava/lang/String;
    //   614: astore_1
    //   615: goto -> 38
    //   618: ldc ''
    //   620: astore_1
    //   621: goto -> 38
    //   624: goto -> 225
    //   627: aconst_null
    //   628: astore #6
    //   630: goto -> 192
    // Exception table:
    //   from	to	target	type
    //   2	30	466	java/lang/Exception
    //   40	61	466	java/lang/Exception
    //   61	122	466	java/lang/Exception
    //   139	146	466	java/lang/Exception
    //   149	187	466	java/lang/Exception
    //   209	225	466	java/lang/Exception
    //   225	326	466	java/lang/Exception
    //   326	382	466	java/lang/Exception
    //   382	463	466	java/lang/Exception
    //   477	509	466	java/lang/Exception
    //   521	529	466	java/lang/Exception
    //   538	552	466	java/lang/Exception
    //   558	615	466	java/lang/Exception
  }
  
  public void init(Context paramContext) {
    super.init(paramContext);
    dV();
  }
  
  public void listFiles(Map<String, String> paramMap, String paramString1, String paramString2, String paramString3) {
    try {
      HashMap<String, String> hashMap = g();
      hashMap.put("x-share-token", paramString2);
      JSONObject jSONObject = new JSONObject();
      this();
      jSONObject.put("image_thumbnail_process", "image/resize,w_160/format,jpeg");
      jSONObject.put("image_url_process", "image/resize,w_1920/format,jpeg");
      jSONObject.put("limit", 200);
      jSONObject.put("order_by", "updated_at");
      jSONObject.put("order_direction", "DESC");
      jSONObject.put("parent_file_id", paramString3);
      jSONObject.put("share_id", paramString1);
      jSONObject.put("video_thumbnail_process", "video/snapshot,t_1000,f_jpg,ar_auto,w_300");
      paramString3 = "";
      ArrayList<String> arrayList = new ArrayList();
      this();
      for (byte b = 1;; b++) {
        if (b > 50 || (b >= 2 && TextUtils.isEmpty(paramString3))) {
          for (String str : arrayList) {
            try {
              listFiles(paramMap, paramString1, paramString2, str);
            } catch (Exception exception) {
              continue;
            } 
          } 
          return;
        } 
        jSONObject.put("marker", paramString3);
        JSONObject jSONObject1 = new JSONObject();
        this(rl("https://api.aliyundrive.com/adrive/v3/file/list", jSONObject.toString(), (Map<String, String>)str));
        JSONArray jSONArray = jSONObject1.getJSONArray("items");
        for (byte b1 = 0; b1 < jSONArray.length(); b1++) {
          JSONObject jSONObject2 = jSONArray.getJSONObject(b1);
          if (jSONObject2.getString("type").equals("folder")) {
            arrayList.add(jSONObject2.getString("file_id"));
          } else if (jSONObject2.getString("mime_type").contains("video")) {
            String str1 = jSONObject2.getString("name").replace("#", "_").replace("$", "_");
            StringBuilder stringBuilder = new StringBuilder();
            this();
            stringBuilder.append(paramString1);
            stringBuilder.append("+");
            stringBuilder.append(paramString2);
            stringBuilder.append("+");
            stringBuilder.append(jSONObject2.getString("file_id"));
            exception.put(str1, stringBuilder.toString());
          } 
        } 
        paramString3 = jSONObject1.getString("next_marker");
      } 
    } catch (Exception exception) {
      exception.printStackTrace();
    } 
  }
  
  public String playerContent(String paramString1, String paramString2, List<String> paramList) {
    String str;
    try {
      cY();
      String[] arrayOfString = paramString2.split("\\+");
      paramString1 = arrayOfString[0];
      paramString2 = arrayOfString[1];
      String str1 = arrayOfString[2];
      StringBuilder stringBuilder = new StringBuilder();
      this();
      stringBuilder.append(Proxy.localProxyUrl());
      stringBuilder.append("?do=ali&type=m3u8&share_id=");
      stringBuilder.append(paramString1);
      stringBuilder.append("&file_id=");
      stringBuilder.append(str1);
      paramString1 = stringBuilder.toString();
      JSONObject jSONObject = new JSONObject();
      this();
      jSONObject.put("parse", "0");
      jSONObject.put("playUrl", "");
      jSONObject.put("url", paramString1);
      jSONObject.put("header", "");
      paramString1 = jSONObject.toString();
    } catch (Exception exception) {
      exception.printStackTrace();
      SpiderDebug.log(exception);
      str = "";
    } 
    return str;
  }
  
  public String searchContent(String paramString, boolean paramBoolean) {
    String str;
    try {
      String str1 = paramString.trim();
      paramBoolean = cY.matcher(str1).find();
      if (!paramBoolean)
        return ""; 
      JSONArray jSONArray = new JSONArray();
      this();
      JSONObject jSONObject = new JSONObject();
      this();
      jSONObject.put("vod_id", str1);
      jSONObject.put("vod_name", str1);
      jSONArray.put(jSONObject);
      jSONObject = new JSONObject();
      this();
      jSONObject.put("list", jSONArray);
      str = jSONObject.toString();
    } catch (Exception exception) {
      exception.printStackTrace();
      str = "";
    } 
    return str;
  }
}
