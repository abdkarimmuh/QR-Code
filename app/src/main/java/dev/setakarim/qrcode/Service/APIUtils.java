package dev.setakarim.qrcode.Service;

public class APIUtils {

    private static final String BASE_URL = "http://192.168.100.6:8080";

    public static APIService getAPIService() {

        return RetrofitNetwork.getClient(BASE_URL).create(APIService.class);
    }
}
