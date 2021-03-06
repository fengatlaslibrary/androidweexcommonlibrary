/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-10-11上午9:47:19
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
package com.open.android.adapter;

import java.io.IOException;
import java.net.HttpURLConnection;

import android.content.Context;
import android.net.Uri;

import com.squareup.picasso.UrlConnectionDownloader;

/**
 *****************************************************************************************************************************************************************************
 * 
 * @author :fengguangjing
 * @createTime:2017-10-11上午9:47:19
 * @version:4.2.4
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public class RefererUrlConnectionDownloader extends UrlConnectionDownloader{
	protected String referer;
	
	public RefererUrlConnectionDownloader(Context context) {
		super(context);
	}
	
	public RefererUrlConnectionDownloader(Context context,String referer) {
		super(context);
		this.referer = referer;
	}
	
	@Override
    protected HttpURLConnection openConnection(Uri uri) throws IOException {
    	HttpURLConnection connection = super.openConnection(uri);
		if(referer!=null && referer.length()>0){
//    		connection.setRequestProperty("Referer", "http://m.mzitu.com/96554");
			if(referer.contains("m.mzitu.com")){
				//http://fm.shiyunjj.com/2017/1033/2.jpg
				if(uri.toString().contains("fm.shiyunjj.com")){
					connection.setRequestProperty("Referer", "http://www.mmjpg.com/mm/1446");
					connection.setRequestProperty("Host", "fm.shiyunjj.com");
					connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.76 Mobile Safari/537.36");
				}else if(uri.toString().contains("img.mmjpg.com")){
					connection.setRequestProperty("Referer", "http://m.mmjpg.com/mm/1033/1");
					connection.setRequestProperty("Host", "img.mmjpg.com");
					connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.76 Mobile Safari/537.36");
				}else if(uri.toString().contains("img.1985t.com")){
//        			connection.setRequestProperty("Referer", "http://m.mmjpg.com/mm/1033/1");
//        			connection.setRequestProperty("Host", "img.mmjpg.com");
					connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36");
				}else if(uri.toString().contains("i.meizitu.net")){
					connection.setRequestProperty("Referer", "http://m.mzitu.com/13689");
					connection.setRequestProperty("Host", "i.meizitu.net");
					connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.76 Mobile Safari/537.36");
				}else {
					connection.setRequestProperty("Referer", referer);
				}
			}else if(referer.contains("http://m.mm131.com/")){
				connection.setRequestProperty("Referer", referer);
				connection.setRequestProperty("Host", "img1.mm131.me");
			}
		}
        //Referer:http://m.mzitu.com/96554
        //User-Agent:Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Mobile Safari/537.36
        return connection;
    }

	public String getReferer() {
		return referer;
	}

	public void setReferer(String referer) {
		this.referer = referer;
	}
	

}
