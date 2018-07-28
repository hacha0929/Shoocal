package data.model.remote;
import java.io.IOException;

import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit=null;
    public static OkHttpClient okHttpClient=new OkHttpClient().newBuilder().addInterceptor(new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request originalRequest = chain.request();

            Request.Builder builder = originalRequest.newBuilder().header("Authorization",
                    Credentials.basic("admin", "1234"));

            Request newRequest = builder.build();
            return chain.proceed(newRequest);

        }
    }).build();

    public static Retrofit getClient(String baseurl)
    {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseurl)
//                    .client(okHttpClient)//to be commented when using fake api as Base Url
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
