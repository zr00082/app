package com.example.bountyhunterapi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Class that acts as a factory method and creates a retrofit REST client instance
 */
public class RetrofitClientInstance {

    //Declare the retrofit object
    private static Retrofit retrofit;
    //URl of the site the JSON will be retrieved from
    private static final String BASE_URL ="";

    /**
     * Creates the instance of the retrofit client
     * @return The generated retrofit client
     */
    public static Retrofit getRetrofitInstance(){
        /**
         * if statement that creates a new retrofit instance if there isn't one already
         * (ensure there is only ever one instance of the retrofit client)
         */
        if (retrofit==null){
            //Creates new retrofit instance
            retrofit= new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;
    }

}
