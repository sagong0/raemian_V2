package raemian.common.service;

import java.util.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Service
public class SmsApiService {
	private String service_id = "ncp:sms:kr:318002747651:raemian";
	private String access_key = "ocUNXmdgtCs589Vk9WDq";
	private String security_key ="QtGAhRfAJLLSfHVXn4bgrEwDjppobjnMwTGuW9JF";
	private String service = "SMS";	// SMS,LMS,MMS
	private String url = "https://sens.apigw.ntruss.com/sms/v2/services/"+service_id+"/messages";
	private String url2 = "/sms/v2/services/"+service_id+"/messages";	//SHA 암호화에서 사용.
	// 오늘 날짜
	private String timestamp = Long.toString(System.currentTimeMillis()); //발송시간 1625245221 2023-00-00
	
	
	public String smsApiService(int securityNo, String mtel) throws Exception {
		
		JSONObject code1 = new JSONObject();
		JSONObject code2 = new JSONObject();
		JSONArray code3 = new JSONArray();
		
		code1.put("type", service);
		code1.put("countryCode","82");
		code1.put("from", "01047542394");
		code1.put("contentType" ,"COMM");
		code1.put("content","이벤트 내용발송");	// 관리자가 확인하는 메세지 내용
		code2.put("content", securityNo);	//클라이언트가 받을 메세지 내용.
		code2.put("to", mtel);
		
		code3.add(code2);
		code1.put("messages",code3);
		
		String data = code1.toString();	//해당 배열을 문자화로 변경.
		//System.out.println(data);
		OkHttpClient client = new OkHttpClient();
		
		Request req = new Request.Builder()
				.addHeader("x-ncp-apigw-timestamp", timestamp)
				.addHeader("x-ncp-iam-access-key", access_key)
				.addHeader("x-ncp-apigw-signature-v2", makese())	// SHA로 변환된 값을 적용.
				.url(url)
				.post(RequestBody.create(MediaType.parse("application/json"),data))	//POST로 전송.
				.build();	// curl 요청사항 제작.
		Response res = client.newCall(req).execute();	//Naver API로 전송 실행 및 return 내용을 받음.
		String result = res.body().string();	//문자열로 확인.
		System.out.println(result);
		
		
		if(result.indexOf("202") > 0) {
			return "ok"+securityNo;
		}
		return "cancel"+securityNo;
	}
	
	// 암호화 코드 변경 class -> Base64
	public String makese() {
		String sp = " ";
		String line = "\n";
		
		String msg = new StringBuilder()
				.append("POST")
				.append(sp)
				.append(url2)
				.append(line)
				.append(timestamp)
				.append(line)
				.append(access_key)
				.toString();
		SecretKeySpec key;
		String base64 = "";
		try {
			key = new SecretKeySpec(security_key.getBytes("UTF-8"), "HmacSHA256");
			Mac mac = Mac.getInstance("HmacSHA256");
			mac.init(key);
			
			byte[] rawHmac = mac.doFinal(msg.getBytes("UTF-8"));
			base64 = Base64.getEncoder().encodeToString(rawHmac);
		}
		catch(Exception e) {
			System.out.println("암호화 오류발생 !!");
			base64 = null;
			e.printStackTrace();
		}
		return base64;
	}
}
