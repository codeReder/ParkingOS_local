package com.media;

public class H264Decoder {
	
	 private static H264Decoder uniqueInstance = null;
	 
	    private H264Decoder() {
	       // Exists only to defeat instantiation.
	    }
	 
	    public static H264Decoder getInstance() {
	       if (uniqueInstance == null) {
	           uniqueInstance = new H264Decoder();
	           uniqueInstance.init();
	       }
	       return uniqueInstance;
	    }
	
	/**
	 * éæ¿îéï¿?
	 * @return
	 */
	public native int init();
	
	
	public native int add(int decodeType);
	
	/**
	 * çï½ç?
	 * @param src éç·îH264ç¼æ «çé¨å®îæ£°ææé¹ï¿?
	 * @param length éç·îH264ç¼æ «çé¨å®îæ£°ææé¹î¾æ®é?å®å®³
	 * @param dst çï½çéåº£æ®yuvçåî¶éçåµ
	 * @param wah çåî¶é¨å«çéå­îéä¾?ç®æ´ï¸½æç¼ï¿½
	 * @return
	 */
	public native synchronized  int decode(int handle,byte[] src, int length, byte[] dst,int[] wah);
	
	/**
	 * é²å©æ?
	 */
	public native void release(int handle);
	
	static {
		System.loadLibrary("H264Decoder");
	}
}
