package network;

import java.util.List;

import model.Landscapes;
import retrofit2.Call;
import retrofit2.http.GET;

public interface APiInterface {

    @GET("/list/")
    Call<List<Landscapes>> getLandscapes();

}
