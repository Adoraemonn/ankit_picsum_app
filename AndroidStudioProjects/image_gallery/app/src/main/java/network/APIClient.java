package network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    public static String base_url = "https://picsum.photos";

    public static Retrofit getClient(){
        return new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static APiInterface apIinterface(){
        return getClient().create(APiInterface.class);
    }
}
