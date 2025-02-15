package web_pro;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.security.spec.InvalidParameterSpecException;
import java.util.Arrays;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.codehaus.xfire.util.Base64;


/**
 * Servlet implementation class stepJiemi
 */
@WebServlet("/stepJiemi")
public class stepJiemi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public stepJiemi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(".............working........................");
		String sessionKey = request.getParameter("session_key").trim();
		String iv = request.getParameter("iv").trim();
		String encryptedData = request.getParameter("encryptedData").trim();
//		System.out.print("...."+code+"....");
		System.out.println("..sessionKey.."+sessionKey+"...");
		System.out.println(".iv.."+iv+".....");
		System.out.println(".encryptedData..."+encryptedData+"..............");
//		getUserInfo(encryptedData, sessionKey,iv, "UTF-8",1);
        PrintWriter JsonOut = response.getWriter();
	    JsonOut.println(getUserInfo(encryptedData, sessionKey,iv));
	    JsonOut.flush();
	    JsonOut.close();
		getUserInfo(encryptedData, sessionKey,iv);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public String getUserInfo(String encryptedData,String sessionkey,String iv){
//		System.out.println("encryptedData"+encryptedData);
//		System.out.println("sessionkey:"+sessionkey);
//		System.out.println("iv:"+iv);
        // 被加密的数据
        byte[] dataByte = Base64.decode(encryptedData);
        // 加密秘钥
        byte[] keyByte = Base64.decode(sessionkey);
        // 偏移量
        byte[] ivByte = Base64.decode(iv);
        try {
               // 如果密钥不足16位，那么就补足
            int base = 16;
            if (keyByte.length % base != 0) {
                int groups = keyByte.length / base + (keyByte.length % base != 0 ? 1 : 0);
                byte[] temp = new byte[groups * base];
                Arrays.fill(temp, (byte) 0);
                System.arraycopy(keyByte, 0, temp, 0, keyByte.length);
                keyByte = temp;
            }
            // 初始化
            Security.addProvider(new BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding","BC");
            SecretKeySpec spec = new SecretKeySpec(keyByte, "AES");
            AlgorithmParameters parameters = AlgorithmParameters.getInstance("AES");
            parameters.init(new IvParameterSpec(ivByte));
            cipher.init(Cipher.DECRYPT_MODE, spec, parameters);// 初始化
            byte[] resultByte = cipher.doFinal(dataByte);
            if (null != resultByte && resultByte.length > 0) {
                String result = new String(resultByte, "UTF-8");
                System.out.println(result);
                return result;
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidParameterSpecException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        }
        return null;
    }
	
	//===========================方法 2
//	 private final static String cipherString = "AES/CBC/PKCS5Padding";
//
//	    public static JSONObject decrypt(String encryptedData, String iv, String sessionKey) throws Exception {
//	        String jsonStr;
//	        try {
//	            BASE64Decoder base64Decoder = new BASE64Decoder();
//	            /**
//	             * 小程序加密数据解密算法
//	             * https://developers.weixin.qq.com/miniprogram/dev/api/signature.html#wxchecksessionobject
//	             * 1.对称解密的目标密文为 Base64_Decode(encryptedData)。
//	             * 2.对称解密秘钥 aeskey = Base64_Decode(session_key), aeskey 是16字节。
//	             * 3.对称解密算法初始向量 为Base64_Decode(iv)，其中iv由数据接口返回。
//	             */
//	            byte[] encryptedByte = base64Decoder.decodeBuffer(encryptedData);
//	            byte[] sessionKeyByte = base64Decoder.decodeBuffer(sessionKey);
//	            byte[] ivByte = base64Decoder.decodeBuffer(iv);
//	            /**
//	             * 以下为AES-128-CBC解密算法
//	             */
//	            SecretKeySpec skeySpec = new SecretKeySpec(sessionKeyByte, "AES");
//	            Cipher cipher = Cipher.getInstance(cipherString);
//	            IvParameterSpec ivParameterSpec = new IvParameterSpec(ivByte);
//	            cipher.init(Cipher.DECRYPT_MODE, skeySpec, ivParameterSpec);
//	            byte[] original = cipher.doFinal(encryptedByte);
//	            jsonStr = new String(original);
//	        } catch (Exception ex) {
//	            throw new Exception("Illegal Buffer");
//	        }
//	        JSONObject jsonObject = new JSONObject(jsonStr);
//	        return jsonObject;
//	    }
}
