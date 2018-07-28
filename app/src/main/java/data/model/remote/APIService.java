package data.model.remote;
import data.model.Post;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIService {

    @POST("/posts")
    @FormUrlEncoded
    Call<Post> savePost(@Field("first name") String firstName,
                        @Field("last name") String lastName,
                        @Field("phone") long phone,
                        @Field("address") String address,
                        @Field("restaurant name") String restaurantName,
                        @Field("request by") int requestBy);
}
