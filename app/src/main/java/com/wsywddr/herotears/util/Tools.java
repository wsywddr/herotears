package com.wsywddr.herotears.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Environment;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Tools {
	private static final String TAG = "BabyInfoEditActivity";

	public Tools() {
		setDictCodes();
		setDictCountry();
		setdictCountryByCode();
	}
	
	/**
	 * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
	 */
	// public static int px2dip(DBContext context, float pxValue) {
	// final float scale = context.getResources().getDisplayMetrics().density;
	// return (int) (pxValue / scale + 0.5f);
	// }
	// /**文件上传服务器
	// * param imageFile
	// */
	// public static boolean uploadFile(File imageFile,Map<String, String>
	// params) {
	// Log.i(TAG, "upload start");
	// Log.i(TAG, "upload"+imageFile);
	// try {
	// String requestUrl = "http://www.ismartrabbit.com/appFileUpload";
	// // Map<String, String> params = new HashMap<String, String>();
	// // params.put("username", "user1");
	// // params.put("pwd", "111111");
	//
	// FormFile formfile = new FormFile(imageFile.getName(), imageFile, "file",
	// "application/octet-stream");
	//
	// if(SocketHttpRequester.post(requestUrl, params, formfile)){
	// Log.i(TAG, "upload success");
	// return true;
	// }
	// else{
	// Log.i(TAG, "upload error, return value is not 200.");
	// }
	// } catch (Exception e) {
	// Log.i(TAG, "upload error");
	// e.printStackTrace();
	// }
	// Log.i(TAG, "upload end");
	// return false;
	// }
	//

	/**
	 * 将Bitmap 以文件路径形式保存到SD卡上，取出时直接用这个文件路径就行了。 拿到文件路径就可以File file = new
	 * File（文件路径），然后就可以把这个File上传服务器
	 * 
	 * param path
	 * param photoName
	 * param photoBitmap
	 */

	public static void savePhotoToSDCard(String path, String photoName,

	Bitmap photoBitmap) {

		if (Environment.getExternalStorageState().equals(

		Environment.MEDIA_MOUNTED)) {

			File dir = new File(path);

			if (!dir.exists()) {
				dir.mkdirs();
			}

			File photoFile = new File(path, photoName); // 在指定路径下创建文件

			System.out.println(photoFile);

			FileOutputStream fileOutputStream = null;

			try {

				fileOutputStream = new FileOutputStream(photoFile);
				System.out.println(photoFile
						+ "................................");
				if (photoBitmap != null) {

					if (photoBitmap.compress(Bitmap.CompressFormat.PNG, 40,

					fileOutputStream)) {

						fileOutputStream.flush();

					}

				}

			} catch (FileNotFoundException e) {

				photoFile.delete();

				e.printStackTrace();

			} catch (IOException e) {

				photoFile.delete();

				e.printStackTrace();

			} finally {

				try {
					if (fileOutputStream == null)

					if (fileOutputStream != null)
						fileOutputStream.close();

				} catch (IOException e) {

					e.printStackTrace();

				}

			}

		}

	}
	/**
	 * 
	 * 将Bitmap 以文件路径形式保存到SD卡上，取出时直接用这个文件路径就行了。 拿到文件路径就可以File file = new
	 * File（文件路径），然后就可以把这个File上传服务器
	 *  pathString
	 */
	public static void savePhotoToSDCardTwo(String path, String pathString,

			Bitmap photoBitmap) {

				if (Environment.getExternalStorageState().equals(

				Environment.MEDIA_MOUNTED)) {

					File dir = new File(path);

					if (!dir.exists()) {
						dir.mkdirs();
					}
					String photoName = Tools.createFileName();
					File photoFile = new File(path, photoName); // 在指定路径下创建文件

					System.out.println(photoFile);

					FileOutputStream fileOutputStream = null;

					try {

						fileOutputStream = new FileOutputStream(photoFile);
						System.out.println(photoFile
								+ "................................");
						if (photoBitmap != null) {

							if (photoBitmap.compress(Bitmap.CompressFormat.PNG, 40,

							fileOutputStream)) {

								fileOutputStream.flush();

							}

						}

					} catch (FileNotFoundException e) {

						photoFile.delete();

						e.printStackTrace();

					} catch (IOException e) {

						photoFile.delete();

						e.printStackTrace();

					} finally {

						try {
							if (fileOutputStream == null)

							if (fileOutputStream != null)
								fileOutputStream.close();

						} catch (IOException e) {

							e.printStackTrace();

						}

					}

				}

			}
	

	/**
	 * 获取当前时间给不同文件命名
	 * return
	 */
	public static String createFileName() {

		String fileName = "";

		Date date = new Date(System.currentTimeMillis()); // 系统当前时间

		SimpleDateFormat dateFormat = new SimpleDateFormat(

		"'IMG'_yyyyMMdd_HHmmss");

		fileName = dateFormat.format(date) + ".jpg";

		return fileName;

	}

	/**
	 * 调用此方法传入bitmap即可转换成圆形图片的bitmap 转换图片成圆形
	 * param bitmap
	 *            传入Bitmap对象
	 * return
	 */
	public static Bitmap toRoundBitmap(Bitmap bitmap) {
		int width = bitmap.getWidth();
		int height = bitmap.getHeight();
		float roundPx;
		float left, top, right, bottom, dst_left, dst_top, dst_right, dst_bottom;
		if (width <= height) {
			roundPx = width / 2;
			top = 0;
			bottom = width;
			left = 0;
			right = width;
			height = width;
			dst_left = 0;
			dst_top = 0;
			dst_right = width;
			dst_bottom = width;
		} else {
			roundPx = height / 2;
			float clip = (width - height) / 2;
			left = clip;
			right = width - clip;
			top = 0;
			bottom = height;
			width = height;
			dst_left = 0;
			dst_top = 0;
			dst_right = height;
			dst_bottom = height;
		}
		Bitmap output = Bitmap.createBitmap(width, height, Config.ARGB_8888);
		Canvas canvas = new Canvas(output);
		final int color = 0xff424242;
		final Paint paint = new Paint();
		final Rect src = new Rect((int) left, (int) top, (int) right,
				(int) bottom);
		final Rect dst = new Rect((int) dst_left, (int) dst_top,
				(int) dst_right, (int) dst_bottom);
		final RectF rectF = new RectF(dst);
		paint.setAntiAlias(true);
		canvas.drawARGB(0, 0, 0, 0);
		paint.setColor(color);
		canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
		paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
		canvas.drawBitmap(bitmap, src, dst, paint);
		return output;
	}

	// 隐藏输入键
	public static void hideSoftInput(Context context,EditText edit) {
		Log.d("lx", "隐藏键盘输入...");
		InputMethodManager imm = (InputMethodManager)
				context.getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(edit.getWindowToken(), 0); //强制隐藏键盘  
	}
	
	public static void alwayHideSoftInput(Context context) {
		Log.d("lx", "隐藏键盘输入...");
		InputMethodManager imm = (InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);  
		   imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
//		InputMethodManager imm = (InputMethodManager)
//				context.getSystemService(Context.INPUT_METHOD_SERVICE);
//		imm.hideSoftInputFromWindow(edit.getWindowToken(), 0); //强制隐藏键盘  
	}
	// 显示输入键
		public static void viewSoftInput(Context context,EditText edit) {
			Log.d("lx", "显示键盘输入...");
			InputMethodManager imm = (InputMethodManager)
					context.getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.showSoftInput(edit,InputMethodManager.SHOW_FORCED); 
		}
	
	
	//手机区号
	public HashMap<String, String> dictCodes = new HashMap<String, String>();
	public HashMap<String, String> dictCountrys = new HashMap<String, String>();
	public HashMap<String, String> dictCountryByCode = new HashMap<String, String>();
	public void setdictCountryByCode() {
		dictCountryByCode.put("678", "瓦努阿图");
		dictCountryByCode.put("84", "越南");
		dictCountryByCode.put("593", "厄瓜多尔");
//		dictCountryByCode.put("1", "1");
		dictCountryByCode.put("213", "阿尔及利亚");
//		dictCountryByCode.put("1", "1");
		dictCountryByCode.put("58", "委内瑞拉");
		dictCountryByCode.put("1784", "圣文森特岛(英)");
		dictCountryByCode.put("1809", "多米尼加共和国");
		dictCountryByCode.put("49", "德国");
		dictCountryByCode.put("998", "乌兹别克斯坦共和国");
		dictCountryByCode.put("598", "乌拉圭");
		dictCountryByCode.put("45", "丹麦");
		dictCountryByCode.put("253", "吉布提");
		dictCountryByCode.put("1", "美国");
		dictCountryByCode.put("256", "乌干达");
		dictCountryByCode.put("380", "乌克兰");
		dictCountryByCode.put("251", "埃塞俄比亚");
		dictCountryByCode.put("34", "西班牙");
		dictCountryByCode.put("291", "厄里特里亚");
		dictCountryByCode.put("20", "埃及");
		dictCountryByCode.put("255", "坦桑尼亚");
		dictCountryByCode.put("372", "爱沙尼亚");
		dictCountryByCode.put("1868", "特立尼达和多巴哥");
		dictCountryByCode.put("886", "台湾");
		dictCountryByCode.put("688", "图瓦卢");
		dictCountryByCode.put("1473", "格林纳达");
		dictCountryByCode.put("995", "格鲁吉亚共和国");
		dictCountryByCode.put("594", "法属圭亚那");
		dictCountryByCode.put("241", "加蓬");
		dictCountryByCode.put("44", "英国");
		dictCountryByCode.put("33", "法国");
		dictCountryByCode.put("298", "法罗群岛");
		dictCountryByCode.put("500", "福克兰群岛");
		dictCountryByCode.put("679", "斐济");
		dictCountryByCode.put("691", "密克罗尼西亚");
		dictCountryByCode.put("358", "芬兰");
		dictCountryByCode.put("685", "西萨摩亚");
		dictCountryByCode.put("595", "巴拉圭");
		dictCountryByCode.put("245", "几内亚比绍");
		dictCountryByCode.put("1671", "关岛");
		dictCountryByCode.put("502", "危地马拉");
		dictCountryByCode.put("500", "福克兰群岛");
		dictCountryByCode.put("30", "希腊");
		dictCountryByCode.put("240", "赤道几内亚");
		dictCountryByCode.put("590", "瓜多罗普");
		dictCountryByCode.put("224", "几内亚");
		dictCountryByCode.put("220", "冈比亚");
		dictCountryByCode.put("299", "格陵兰岛");
		dictCountryByCode.put("350", "直布罗陀");
		dictCountryByCode.put("233", "加纳");
		dictCountryByCode.put("44", "英国");
		dictCountryByCode.put("262", "留尼旺岛");
		dictCountryByCode.put("40", "罗马尼亚");
		dictCountryByCode.put("43", "奥地利");
//		dictCountryByCode.put("1", "美国");
		dictCountryByCode.put("54", "阿根廷");
		dictCountryByCode.put("297", "阿鲁巴岛");
		dictCountryByCode.put("974", "卡塔尔");
		dictCountryByCode.put("61", "澳大利亚");
		dictCountryByCode.put("994", "阿塞拜疆");
		dictCountryByCode.put("387", "波斯尼亚和塞哥维那");
		dictCountryByCode.put("351", "葡萄牙");
		dictCountryByCode.put("680", "帕劳");
		dictCountryByCode.put("1268", "安提瓜和巴布达");
		dictCountryByCode.put("1809", "波多黎各");
		dictCountryByCode.put("971", "阿联酋");
		dictCountryByCode.put("970", "巴勒斯坦");
		dictCountryByCode.put("93", "阿富汗");
		dictCountryByCode.put("355", "阿尔巴尼亚");
		dictCountryByCode.put("244", "安哥拉");
		dictCountryByCode.put("595", "巴拉圭");
		dictCountryByCode.put("374", "亚美尼亚共和国");
		dictCountryByCode.put("599", "荷属安的列斯群岛");
		dictCountryByCode.put("267", "博茨瓦纳");
		dictCountryByCode.put("228", "多哥");
		dictCountryByCode.put("375", "白俄罗斯共和国");
		dictCountryByCode.put("1242", "巴哈马");
		dictCountryByCode.put("690", "托克鲁");
		dictCountryByCode.put("55", "巴西");
		dictCountryByCode.put("992", "塔吉克斯坦共和国");
		dictCountryByCode.put("975", "不丹");
		dictCountryByCode.put("66", "泰国");
		dictCountryByCode.put("676", "汤加");
		dictCountryByCode.put("216", "突尼斯");
		dictCountryByCode.put("993", "土库曼斯坦共和国");
		dictCountryByCode.put("1", "加拿大");
		dictCountryByCode.put("501", "伯利兹");
		dictCountryByCode.put("90", "土耳其");
		dictCountryByCode.put("226", "布基拉法索");
		dictCountryByCode.put("503", "萨尔瓦多");
		dictCountryByCode.put("359", "保加利亚");
		dictCountryByCode.put("973", "巴林");
		dictCountryByCode.put("239", "圣多美");
		dictCountryByCode.put("257", "布隆迪");
		dictCountryByCode.put("963", "叙利亚");
		dictCountryByCode.put("1246", "巴巴多斯");
		dictCountryByCode.put("268", "斯威士兰");
		dictCountryByCode.put("880", "孟加拉国");
		dictCountryByCode.put("32", "比利时");
		dictCountryByCode.put("673", "文莱");
		dictCountryByCode.put("591", "玻利维亚");
		dictCountryByCode.put("229", "贝宁");
		dictCountryByCode.put("590", "瓜多罗普");
		dictCountryByCode.put("420", "捷克");
		dictCountryByCode.put("249", "苏丹");
		dictCountryByCode.put("537", "塞浦路斯");
		dictCountryByCode.put("248", "塞舌尔");
		dictCountryByCode.put("61", "澳大利亚");
		dictCountryByCode.put("46", "瑞典");
		dictCountryByCode.put("290", "圣赫勒拿");
		dictCountryByCode.put("238", "佛得角");
		dictCountryByCode.put("53", "古巴");
		dictCountryByCode.put("65", "新加坡");
		dictCountryByCode.put("47", "挪威");
		dictCountryByCode.put("386", "斯洛文尼亚");
		dictCountryByCode.put("232", "塞拉利昂");
		dictCountryByCode.put("421", "斯洛伐克");
		dictCountryByCode.put("221", "塞内加尔");
		dictCountryByCode.put("378", "圣马力诺");
		dictCountryByCode.put("252", "索马里");
		dictCountryByCode.put("597", "苏里南");
		dictCountryByCode.put("225", "科特迪瓦");
		dictCountryByCode.put("381", "南斯拉夫");
		dictCountryByCode.put("242", "刚果");
		dictCountryByCode.put("7", "俄罗斯联邦");
		dictCountryByCode.put("41", "瑞士");
		dictCountryByCode.put("236", "中非");
		dictCountryByCode.put("250", "卢旺达");
		dictCountryByCode.put("61", "澳大利亚");
		dictCountryByCode.put("243", "扎伊尔");
		dictCountryByCode.put("506", "哥斯达黎加");
		dictCountryByCode.put("57", "哥伦比亚");
		dictCountryByCode.put("237", "喀麦隆");
		dictCountryByCode.put("86", "中国");
		dictCountryByCode.put("682", "科克群岛");
		dictCountryByCode.put("966", "沙特阿拉伯");
		dictCountryByCode.put("56", "智利");
		dictCountryByCode.put("677", "所罗门群岛");
		dictCountryByCode.put("371", "拉脱维亚");
		dictCountryByCode.put("352", "卢森堡");
		dictCountryByCode.put("370", "立陶宛");
		dictCountryByCode.put("218", "利比亚");
		dictCountryByCode.put("266", "莱索托");
		dictCountryByCode.put("231", "利比里亚");
		dictCountryByCode.put("261", "马达加斯加");
		dictCountryByCode.put("692", "马绍尔群岛");
		dictCountryByCode.put("590", "瓜多罗普");
		dictCountryByCode.put("389", "马其顿");
		dictCountryByCode.put("377", "摩纳哥");
		dictCountryByCode.put("373", "摩尔多瓦");
		dictCountryByCode.put("230", "毛里求斯");
		dictCountryByCode.put("52", "墨西哥");
		dictCountryByCode.put("258", "莫桑比克");
		dictCountryByCode.put("976", "蒙古");
		dictCountryByCode.put("95", "缅甸");
		dictCountryByCode.put("853", "澳门");
		dictCountryByCode.put("222", "毛里塔尼亚");
		dictCountryByCode.put("596", "马提尼克");
		dictCountryByCode.put("356", "马耳他");
		dictCountryByCode.put("1664", "蒙特塞拉特岛");
		dictCountryByCode.put("234", "尼日利亚");
		dictCountryByCode.put("505", "尼加拉瓜");
		dictCountryByCode.put("31", "荷兰");
		dictCountryByCode.put("264", "纳米比亚");
		dictCountryByCode.put("687", "新咯里多尼亚群岛");
		dictCountryByCode.put("227", "尼日尔");
		dictCountryByCode.put("64", "新西兰");
		dictCountryByCode.put("683", "纽埃岛");
		dictCountryByCode.put("977", "尼泊尔");
		dictCountryByCode.put("47", "挪威");
		dictCountryByCode.put("968", "阿曼");
		dictCountryByCode.put("48", "波兰");
		dictCountryByCode.put("508", "圣皮埃尔岛密克隆岛(法)");
		dictCountryByCode.put("63", "菲律宾");
		dictCountryByCode.put("92", "巴基斯坦");
		dictCountryByCode.put("51", "秘鲁");
		dictCountryByCode.put("689", "法属玻利尼西亚");
		dictCountryByCode.put("675", "巴布亚新几内亚");
		dictCountryByCode.put("507", "巴拿马");
		dictCountryByCode.put("852", "香港");
		dictCountryByCode.put("27", "南非");
		dictCountryByCode.put("504", "洪都拉斯");
		dictCountryByCode.put("385", "科罗地亚");
		dictCountryByCode.put("509", "海地");
		dictCountryByCode.put("36", "匈牙利");
		dictCountryByCode.put("260", "赞比亚");
		dictCountryByCode.put("62", "印度尼西亚");
		dictCountryByCode.put("263", "津巴布韦");
		dictCountryByCode.put("972", "以色列");
		dictCountryByCode.put("44", "英国");
		dictCountryByCode.put("91", "印度");
		dictCountryByCode.put("246", "迪戈加西亚");
		dictCountryByCode.put("964", "伊拉克");
		dictCountryByCode.put("98", "伊朗");
		dictCountryByCode.put("354", "冰岛");
		dictCountryByCode.put("967", "也门");
		dictCountryByCode.put("39", "意大利");
		dictCountryByCode.put("44", "英国");
		dictCountryByCode.put("262", "留尼旺岛");
		dictCountryByCode.put("81", "日本");
		dictCountryByCode.put("962", "约旦");
		dictCountryByCode.put("1876", "牙买加");
		dictCountryByCode.put("686", "基里巴斯");
		dictCountryByCode.put("855", "柬埔寨");
		dictCountryByCode.put("996", "吉尔吉斯坦共和国");
		dictCountryByCode.put("254", "肯尼亚");
		dictCountryByCode.put("850", "朝鲜");
		dictCountryByCode.put("82", "韩国");
		dictCountryByCode.put("269", "科摩罗");
		dictCountryByCode.put("965", "科威特");
		dictCountryByCode.put("1345", "开曼群岛");
		dictCountryByCode.put("327", "哈萨克斯坦");
		dictCountryByCode.put("856", "老挝");
		dictCountryByCode.put("1758", "圣卢西亚");
		dictCountryByCode.put("961", "黎巴嫩");
		dictCountryByCode.put("423", "列支敦士登");
		dictCountryByCode.put("94", "斯里兰卡");
	}
	public void setDictCodes(){
		dictCodes.put("IL", "972");
		dictCodes.put("AF", "93");
		dictCodes.put("AL", "355");
		dictCodes.put("DZ", "213");
		dictCodes.put("AS", "1");
		dictCodes.put("AO", "244");
		dictCodes.put("AG", "1268");
		dictCodes.put("AR", "54");
		dictCodes.put("AM", "374");
		dictCodes.put("AW", "297");
		dictCodes.put("AU", "61");
		dictCodes.put("AT", "43");
		dictCodes.put("AZ", "994");
		dictCodes.put("BS", "1242");
		dictCodes.put("BH", "973");
		dictCodes.put("BD", "880");
		dictCodes.put("BB", "1246");
		dictCodes.put("BY", "375");
		dictCodes.put( "BE", "32");
		dictCodes.put( "BZ", "501");
		dictCodes.put("BJ", "229");
		dictCodes.put("BT", "975");
		dictCodes.put("BA", "387");
		dictCodes.put("BW", "267");
		dictCodes.put("BR", "55");
		dictCodes.put("IO", "246");
		dictCodes.put( "BG", "359");
		dictCodes.put("BF", "226");
		dictCodes.put("BI", "257");
		dictCodes.put("KH", "855");
		dictCodes.put( "CM", "237");
		dictCodes.put( "CA", "1");
		dictCodes.put("CV", "238");
		dictCodes.put("KY", "1345");
		dictCodes.put(  "CF", "236");
		dictCodes.put( "CL", "56");
		dictCodes.put( "CN", "86");
		dictCodes.put( "CX", "61");
		dictCodes.put( "CO", "57");
		dictCodes.put( "KM", "269");
		dictCodes.put( "CG", "242");
		dictCodes.put( "CK", "682");
		dictCodes.put( "CR", "506");
		dictCodes.put( "HR", "385");
		dictCodes.put( "CU", "53");
		dictCodes.put( "CY", "537");
		dictCodes.put( "CZ", "420");
		dictCodes.put( "DK", "45");
		dictCodes.put( "DJ", "253");
		dictCodes.put(  "DM", "1");
		dictCodes.put( "DO", "1809");
		dictCodes.put( "EC", "593");
		dictCodes.put( "EG", "20");
		dictCodes.put(  "SV", "503");
		dictCodes.put( "GQ", "240");
		dictCodes.put( "ER", "291");
		dictCodes.put( "EE", "372");
		dictCodes.put( "ET", "251");
		dictCodes.put( "FO", "298");
		dictCodes.put( "FJ", "679");
		dictCodes.put( "FI", "358");
		dictCodes.put( "FR", "33");
		dictCodes.put( "GF", "594");
		dictCodes.put( "PF", "689");
		dictCodes.put( "GA", "241");
		dictCodes.put( "GM", "220");
		dictCodes.put( "GE", "995");
		dictCodes.put( "DE", "49");
		dictCodes.put( "GH", "233");
		dictCodes.put("GI", "350");
		dictCodes.put("GR", "30");
		dictCodes.put("GL", "299");
		dictCodes.put(  "GD", "1473");
		dictCodes.put("GP", "590");
		dictCodes.put("GU", "1671");
		dictCodes.put("GT", "502");
		dictCodes.put("GN", "224");
		dictCodes.put("GW", "245");
		dictCodes.put("GY", "595");
		dictCodes.put("HT", "509");
		dictCodes.put("HN", "504");
		dictCodes.put("HU", "36");
		dictCodes.put("IS", "354");
		dictCodes.put("IN", "91");
		dictCodes.put("ID", "62");
		dictCodes.put("IQ", "964");
		dictCodes.put("IL", "972");
		dictCodes.put("IT", "39");
		dictCodes.put("JM", "1876");
		dictCodes.put("JP", "81");
		dictCodes.put("JO", "962");
		dictCodes.put("KZ", "327");
		dictCodes.put("KE", "254");
		dictCodes.put("KI", "686");
		dictCodes.put("KW", "965");
		dictCodes.put("KG", "996");
		dictCodes.put("LV", "371");
		dictCodes.put("LB", "961");
		dictCodes.put("LS", "266");
		dictCodes.put("LR", "231");
		dictCodes.put("LI", "423");
		dictCodes.put("LT", "370");
		dictCodes.put("LU", "352");
		dictCodes.put("MG", "261");
		dictCodes.put("MT", "356");
		dictCodes.put("MH", "692");
		dictCodes.put("MQ", "596");
		dictCodes.put("MR", "222");
		dictCodes.put("MU", "230");
		dictCodes.put("YT", "262");
		dictCodes.put("MX", "52");
		dictCodes.put("MC", "377");
		dictCodes.put("MN", "976");
		dictCodes.put("ME", "382");
		dictCodes.put("MS", "1664");
		dictCodes.put("MM", "95");
		dictCodes.put("NA", "264");
		dictCodes.put("NP", "977");
		dictCodes.put("NL", "31");
		dictCodes.put("AN", "599");
		dictCodes.put("NC", "687");
		dictCodes.put("NZ", "64");
		dictCodes.put("NI", "505");
		dictCodes.put("NE", "227");
		dictCodes.put("NG", "234");
		dictCodes.put("NU", "683");
		dictCodes.put( "NF", "672");
		dictCodes.put("MP", "1");
		dictCodes.put("NO", "47");
		dictCodes.put("OM", "968");
		dictCodes.put("PK", "92");
		dictCodes.put("PW", "680");
		dictCodes.put("PA", "507");
		dictCodes.put("PG", "675");
		dictCodes.put("PY", "595");
		dictCodes.put("PE", "51");
		dictCodes.put("PH", "63");
		dictCodes.put("PL", "48");
		dictCodes.put("PT", "351");
		dictCodes.put("PR", "1809");
		dictCodes.put("QA", "974");
		dictCodes.put("RO", "40");
		dictCodes.put("RW", "250");
		dictCodes.put("WS", "685");
		dictCodes.put("SM", "378");
		dictCodes.put("SA", "966");
		dictCodes.put("SN", "221");
		dictCodes.put("RS", "381");
		dictCodes.put("SC", "248");
		dictCodes.put("SL", "232");
		dictCodes.put("SG", "65");
		dictCodes.put("SK", "421");
		dictCodes.put("SI", "386");
		dictCodes.put("SB", "677");
		dictCodes.put("ZA", "27");
		dictCodes.put("GS", "500");
		dictCodes.put("ES", "34");
		dictCodes.put("LK", "94");
		dictCodes.put("SD", "249");
		dictCodes.put("SR", "597");
		dictCodes.put("SZ", "268");
		dictCodes.put("SE", "46");
		dictCodes.put("CH", "41");
		dictCodes.put("TJ", "992");
		dictCodes.put("TH", "66");
		dictCodes.put("TG", "228");
		dictCodes.put("TK", "690");
		dictCodes.put("TO", "676");
		dictCodes.put("TT", "1868");
		dictCodes.put("TN", "216");
		dictCodes.put("TR", "90");
		dictCodes.put("TM", "993");
		dictCodes.put("TC", "1");
		dictCodes.put("TV", "688");
		dictCodes.put("UG", "256");
		dictCodes.put("UA", "380");
		dictCodes.put("AE", "971");
		dictCodes.put("GB", "44");
		dictCodes.put("US", "1");
		dictCodes.put("UY", "598");
		dictCodes.put("UZ", "998");
		dictCodes.put("VU", "678");
		dictCodes.put("WF", "681");
		dictCodes.put("YE", "967");
		dictCodes.put("ZM", "260");
		dictCodes.put("ZW", "263");
		dictCodes.put("BO", "591");
		dictCodes.put("BN", "673");
		dictCodes.put("CC", "61");
		dictCodes.put("CD", "243");
		dictCodes.put("CI", "225");
		dictCodes.put("FK", "500");
		dictCodes.put("GG", "44");
		dictCodes.put( "VA", "379");
		dictCodes.put("HK", "852");
		dictCodes.put("IR", "98");
		dictCodes.put("IM", "44");
		dictCodes.put("JE", "44");
		dictCodes.put("KP", "850");
		dictCodes.put("KR", "82");
		dictCodes.put("LA", "856");
		dictCodes.put("LY", "218");
		dictCodes.put("MO", "853");
		dictCodes.put("MK", "389");
		dictCodes.put("FM", "691");
		dictCodes.put("MD", "373");
		dictCodes.put( "MZ", "258");
		dictCodes.put("PS", "970");
		dictCodes.put("PN", "872");
		dictCodes.put("RE", "262");
		dictCodes.put("RU", "7");
		dictCodes.put("BL", "590");
		dictCodes.put("SH", "290");
		dictCodes.put("KN", "1");
		dictCodes.put("LC", "1758");
		dictCodes.put("MF", "590");
		dictCodes.put("PM", "508");
		dictCodes.put("VC", "1784");
		dictCodes.put("ST", "239");
		dictCodes.put("SO", "252");
		dictCodes.put("SJ", "47");
		dictCodes.put("SY", "963");
		dictCodes.put("TW", "886");
		dictCodes.put("TZ", "255");
		dictCodes.put("TL", "670");
		dictCodes.put("VE", "58");
		dictCodes.put( "VN", "84");
		dictCodes.put("VG", "1");
		dictCodes.put("VI", "1");
	}
	//设置对应的国家
	public void setDictCountry(){
		dictCountrys.put("IL", "以色列");
		dictCountrys.put("AF", "阿富汗");
		dictCountrys.put("AL", "阿尔巴尼亚");
		dictCountrys.put("DZ", "阿尔及利亚");
		dictCountrys.put("AS", "美国");
		dictCountrys.put("AO", "安哥拉");
		dictCountrys.put("AG", "安提瓜和巴布达");
		dictCountrys.put("AR", "阿根廷");
		dictCountrys.put("AM", "亚美尼亚共和国");
		dictCountrys.put("AW", "阿鲁巴岛");
		dictCountrys.put("AU", "澳大利亚");
		dictCountrys.put("AT", "奥地利");
		dictCountrys.put("AZ", "阿塞拜疆");
		dictCountrys.put("BS", "巴哈马");
		dictCountrys.put("BH", "巴林");
		dictCountrys.put("BD", "孟加拉国");
		dictCountrys.put("BB", "巴巴多斯");
		dictCountrys.put("BY", "白俄罗斯共和国");
		dictCountrys.put( "BE", "比利时");
		dictCountrys.put( "BZ", "伯利兹");
		dictCountrys.put("BJ", "贝宁");
		dictCountrys.put("BT", "不丹");
		dictCountrys.put("BA", "波斯尼亚和塞哥维那");
		dictCountrys.put("BW", "博茨瓦纳");
		dictCountrys.put("BR", "巴西");
		dictCountrys.put("IO", "迪戈加西亚");
		dictCountrys.put( "BG", "保加利亚");
		dictCountrys.put("BF", "布基拉法索");
		dictCountrys.put("BI", "布隆迪");
		dictCountrys.put("KH", "柬埔寨");
		dictCountrys.put( "CM", "喀麦隆");
		dictCountrys.put( "CA", "加拿大");
		dictCountrys.put("CV", "佛得角");
		dictCountrys.put("KY", "开曼群岛");
		dictCountrys.put("CF", "中非");
		dictCountrys.put("CL", "智利");
		dictCountrys.put("CN", "中国");
		dictCountrys.put("CX", "澳大利亚");
		dictCountrys.put("CO", "哥伦比亚");
		dictCountrys.put("KM", "科摩罗");
		dictCountrys.put("CG", "刚果");
		dictCountrys.put("CK", "科克群岛");
		dictCountrys.put("CR", "哥斯达黎加");
		dictCountrys.put("HR", "科罗地亚");
		dictCountrys.put("CU", "古巴");
		dictCountrys.put("CY", "塞浦路斯");
		dictCountrys.put("CZ", "捷克");
		dictCountrys.put("DK", "丹麦");
		dictCountrys.put("DJ", "吉布提");
//		dictCountrys.put("DM", "1");
		dictCountrys.put("DO", "多米尼加共和国");
		dictCountrys.put("EC", "厄瓜多尔");
		dictCountrys.put("EG", "埃及");
		dictCountrys.put("SV", "萨尔瓦多");
		dictCountrys.put("GQ", "赤道几内亚");
		dictCountrys.put("ER", "厄里特里亚");
		dictCountrys.put("EE", "爱沙尼亚");
		dictCountrys.put("ET", "埃塞俄比亚");
		dictCountrys.put("FO", "法罗群岛");
		dictCountrys.put("FJ", "斐济");
		dictCountrys.put("FI", "芬兰");
		dictCountrys.put("FR", "法国");
		dictCountrys.put("GF", "法属圭亚那");
		dictCountrys.put("PF", "法属玻利尼西亚");
		dictCountrys.put("GA", "加蓬");
		dictCountrys.put("GM", "冈比亚");
		dictCountrys.put("GE", "格鲁吉亚共和国");
		dictCountrys.put("DE", "德国");
		dictCountrys.put("GH", "加纳");
		dictCountrys.put("GI", "直布罗陀");
		dictCountrys.put("GR", "希腊");
		dictCountrys.put("GL", "格陵兰岛");
		dictCountrys.put("GD", "格林纳达");
		dictCountrys.put("GP", "瓜多罗普");
		dictCountrys.put("GU", "关岛");
		dictCountrys.put("GT", "危地马拉");
		dictCountrys.put("GN", "几内亚");
		dictCountrys.put("GW", "几内亚比绍");
		dictCountrys.put("GY", "巴拉圭");
		dictCountrys.put("HT", "海地");
		dictCountrys.put("HN", "洪都拉斯");
		dictCountrys.put("HU", "匈牙利");
		dictCountrys.put("IS", "冰岛");
		dictCountrys.put("IN", "印度");
		dictCountrys.put("ID", "印度尼西亚");
		dictCountrys.put("IQ", "伊拉克");
		dictCountrys.put("IL", "以色列");
		dictCountrys.put("IT", "意大利");
		dictCountrys.put("JM", "牙买加");
		dictCountrys.put("JP", "日本");
		dictCountrys.put("JO", "约旦");
		dictCountrys.put("KZ", "哈萨克斯坦");
		dictCountrys.put("KE", "肯尼亚");
		dictCountrys.put("KI", "基里巴斯");
		dictCountrys.put("KW", "科威特");
		dictCountrys.put("KG", "吉尔吉斯坦共和国");
		dictCountrys.put("LV", "拉脱维亚");
		dictCountrys.put("LB", "黎巴嫩");
		dictCountrys.put("LS", "莱索托");
		dictCountrys.put("LR", "利比里亚");
		dictCountrys.put("LI", "列支敦士登");
		dictCountrys.put("LT", "立陶宛");
		dictCountrys.put("LU", "卢森堡");
		dictCountrys.put("MG", "马达加斯加");
		dictCountrys.put("MT", "马耳他");
		dictCountrys.put("MH", "马绍尔群岛");
		dictCountrys.put("MQ", "马提尼克");
		dictCountrys.put("MR", "毛里塔尼亚");
		dictCountrys.put("MU", "毛里求斯");
		dictCountrys.put("YT", "留尼旺岛");
		dictCountrys.put("MX", "墨西哥");
		dictCountrys.put("MC", "摩纳哥");
		dictCountrys.put("MN", "蒙古");
//		dictCountrys.put("ME", "382");
		dictCountrys.put("MS", "蒙特塞拉特岛");
		dictCountrys.put("MM", "缅甸");
		dictCountrys.put( "NA", "纳米比亚");
		dictCountrys.put("NP", "尼泊尔");
		dictCountrys.put("NL", "荷兰");
		dictCountrys.put("AN", "荷属安的列斯群岛");
		dictCountrys.put("NC", "新咯里多尼亚群岛");
		dictCountrys.put("NZ", "新西兰");
		dictCountrys.put("NI", "尼加拉瓜");
		dictCountrys.put("NE", "尼日尔");
		dictCountrys.put("NG", "尼日利亚");
		dictCountrys.put("NU", "纽埃岛");
//		dictCountrys.put( "NF", "672");
//		dictCountrys.put("MP", "1");
		dictCountrys.put("NO", "挪威");
		dictCountrys.put("OM", "阿曼");
		dictCountrys.put("PK", "巴基斯坦");
		dictCountrys.put("PW", "帕劳");
		dictCountrys.put("PA", "巴拿马");
		dictCountrys.put("PG", "巴布亚新几内亚");
		dictCountrys.put("PY", "巴拉圭");
		dictCountrys.put("PE", "秘鲁");
		dictCountrys.put("PH", "菲律宾");
		dictCountrys.put("PL", "波兰");
		dictCountrys.put("PT", "葡萄牙");
		dictCountrys.put("PR", "波多黎各");
		dictCountrys.put("QA", "卡塔尔");
		dictCountrys.put("RO", "罗马尼亚");
		dictCountrys.put("RW", "卢旺达");
		dictCountrys.put("WS", "西萨摩亚");
		dictCountrys.put("SM", "圣马力诺");
		dictCountrys.put("SA", "沙特阿拉伯");
		dictCountrys.put("SN", "塞内加尔");
		dictCountrys.put("RS", "南斯拉夫");
		dictCountrys.put("SC", "塞舌尔");
		dictCountrys.put("SL", "塞拉利昂");
		dictCountrys.put("SG", "新加坡");
		dictCountrys.put("SK", "斯洛伐克");
		dictCountrys.put("SI", "斯洛文尼亚");
		dictCountrys.put("SB", "所罗门群岛");
		dictCountrys.put("ZA", "南非");
		dictCountrys.put("GS", "福克兰群岛");
		dictCountrys.put("ES", "西班牙");
		dictCountrys.put("LK", "斯里兰卡");
		dictCountrys.put("SD", "苏丹");
		dictCountrys.put("SR", "苏里南");
		dictCountrys.put("SZ", "斯威士兰");
		dictCountrys.put("SE", "瑞典");
		dictCountrys.put("CH", "瑞士");
		dictCountrys.put("TJ", "塔吉克斯坦共和国");
		dictCountrys.put("TH", "泰国");
		dictCountrys.put("TG", "多哥");
		dictCountrys.put("TK", "托克鲁");
		dictCountrys.put("TO", "汤加");
		dictCountrys.put("TT", "特立尼达和多巴哥");
		dictCountrys.put("TN", "突尼斯");
		dictCountrys.put("TR", "土耳其");
		dictCountrys.put("TM", "土库曼斯坦共和国");
//		dictCountrys.put("TC", "1");
		dictCountrys.put("TV", "图瓦卢");
		dictCountrys.put("UG", "乌干达");
		dictCountrys.put("UA", "乌克兰");
		dictCountrys.put("AE", "阿联酋");
		dictCountrys.put("GB", "英国");
		dictCountrys.put("US", "美国");
		dictCountrys.put("UY", "乌拉圭");
		dictCountrys.put("UZ", "乌兹别克斯坦共和国");
		dictCountrys.put("VU", "瓦努阿图");
//		dictCountrys.put("WF", "681");
		dictCountrys.put("YE", "也门");
		dictCountrys.put("ZM", "赞比亚");
		dictCountrys.put("ZW", "津巴布韦");
		dictCountrys.put("BO", "玻利维亚");
		dictCountrys.put("BN", "文莱");
		dictCountrys.put("CC", "澳大利亚");
		dictCountrys.put("CD", "扎伊尔");
		dictCountrys.put("CI", "科特迪瓦");
		dictCountrys.put("FK", "福克兰群岛");
		dictCountrys.put("GG", "英国");
//		dictCountrys.put("VA", "379");
		dictCountrys.put("HK", "香港");
		dictCountrys.put("IR", "伊朗");
		dictCountrys.put("IM", "英国");
		dictCountrys.put("JE", "英国");
		dictCountrys.put("KP", "朝鲜");
		dictCountrys.put("KR", "韩国");
		dictCountrys.put("LA", "老挝");
		dictCountrys.put("LY", "利比亚");
		dictCountrys.put("MO", "澳门");
		dictCountrys.put("MK", "马其顿");
		dictCountrys.put("FM", "密克罗尼西亚");
		dictCountrys.put("MD", "摩尔多瓦");
		dictCountrys.put( "MZ", "莫桑比克");
		dictCountrys.put("PS", "巴勒斯坦");
//		dictCountrys.put("PN", "872");
		dictCountrys.put("RE", "留尼旺岛");
		dictCountrys.put("RU", "俄罗斯联邦");
		dictCountrys.put("BL", "瓜多罗普");
		dictCountrys.put("SH", "圣赫勒拿");
//		dictCountrys.put("KN", "1");
		dictCountrys.put("LC", "圣卢西亚");
		dictCountrys.put("MF", "瓜多罗普");
		dictCountrys.put("PM", "圣皮埃尔岛密克隆岛(法)");
		dictCountrys.put("VC", "圣文森特岛(英)");
		dictCountrys.put("ST", "圣多美");
		dictCountrys.put("SO", "索马里");
		dictCountrys.put("SJ", "挪威");
		dictCountrys.put("SY", "叙利亚");
		dictCountrys.put("TW", "台湾");
		dictCountrys.put("TZ", "坦桑尼亚");
//		dictCountrys.put("TL", "670");
		dictCountrys.put("VE", "委内瑞拉");
		dictCountrys.put( "VN", "越南");
		dictCountrys.put("VG", "1");
		dictCountrys.put("VI", "1");
	}
	
	
	
	private static final double EARTH_RADIUS = 6378137.0;
	/**
	 * 根据两地的经纬度得到距离
	 * @param longitude1  经度
	 * @param latitude1
	 * @param longitude2
	 * @param latitude2
	 * @return返回单位是米
	 */
	public static double getDistance(double longitude1, double latitude1,
			double longitude2, double latitude2) {
		double Lat1 = rad(latitude1);
		double Lat2 = rad(latitude2);
		double a = Lat1 - Lat2;
		double b = rad(longitude1) - rad(longitude2);
		double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2)
				+ Math.cos(Lat1) * Math.cos(Lat2)
				* Math.pow(Math.sin(b / 2), 2)));
		s = s * EARTH_RADIUS;
		s = Math.round(s * 10000) / 10000;
		return s;
	}

	private static double rad(double d) {
		return d * Math.PI / 180.0;
	}
	
	/**
	 * 获取版本号
	 * @param context
	 * @return
	 */
	public static String getVersionCode(Context context) {
		String versionName = null;
		PackageManager pm = context.getPackageManager();
		PackageInfo pi;
		try {
			pi = pm.getPackageInfo(context.getPackageName(), 0);
			versionName = pi.versionName;
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		return versionName;
	}
	
	/**
	 * 获取项目的包名
	 * @param context
	 * @return
	 */
	public static String getPackageName(Context context) {
		String packageName = null;
		PackageManager pm = context.getPackageManager();
		PackageInfo pi;
		try {
			pi = pm.getPackageInfo(context.getPackageName(), 0);
			packageName = pi.packageName;
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		return packageName;
	}

	public static String cacheUrl(Context context) {
		return Environment.getExternalStorageDirectory() + "/Android/data/"+Tools.getPackageName(context)
				+"/cache/CityBao/";
	}
}
