package com.example.bountyhunterapi;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BountyHunterAPI {
    private Context context;
//    private SharedPreferences preferences = context.getSharedPreferences("MY_APP",Context.MODE_PRIVATE);

    public BountyHunterAPI(Context context){
        this.context= context;
    }

    public void registerUser(User user) {
        RetrofitServices service = RetrofitClientInstance.getRetrofitInstance(context).create(RetrofitServices.class);
        Call<Void> call = service.registerUser(user);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.code() == 201) {
                    Toast.makeText(context, "Your account was successfully registered", Toast.LENGTH_LONG);
                    return;
                } else if (response.code() == 500) {
                    Toast.makeText(context, "An error occurred when trying to register your account \n Please try again", Toast.LENGTH_LONG);
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(context, "Failed to connect to the server \n Please check the internet connection of your device", Toast.LENGTH_LONG);
            }
        });
    }

    public void loginUser(String username, String password) {
        RetrofitServices service = RetrofitClientInstance.getRetrofitInstance(context).create(RetrofitServices.class);
        Call<Token> call = service.loginUser(username, password);

        call.enqueue(new Callback<Token>() {
            @Override
            public void onResponse(Call<Token> call, Response<Token> response) {
                if(response.code()==200){
                    Toast.makeText(context, response.body().toString(), Toast.LENGTH_LONG).show();
                    //preferences.edit().putString("TOKEN",response.body().getToken()).apply();
                    return;
                } else if (response.code()==401){
                    Toast.makeText(context, "The password you entered was incorrect", Toast.LENGTH_LONG).show();
                    return;
                } else if (response.code()==404){
                    Toast.makeText(context, "The password you entered was incorrect", Toast.LENGTH_LONG).show();
                    return;
                }


            }

            @Override
            public void onFailure(Call<Token> call, Throwable t) {
                Toast.makeText(context, "Failed to connect to the server \n Please check the internet connection of your device", Toast.LENGTH_LONG).show();
            }
        });
    }

    public User getUser(int userID) {
        RetrofitServices service = RetrofitClientInstance.getRetrofitInstance(context).create(RetrofitServices.class);

        final User[] retrievedUser = new User[1];

        String token  = ""; //preferences.getString("TOKEN",null);
        Call<User> call = service.getUser(token,userID);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.code() == 200) {
                    Toast.makeText(context, "User account was found", Toast.LENGTH_LONG);
                    retrievedUser[0] = new User(response.body().getId(),response.body().getFirstName(),response.body().getLastName(),response.body().getUsername(),response.body().getPassword(),response.body().getEmail(),response.body().isActive(),response.body().isVerified(),response.body().getCreated_at(),response.body().getUpdated_at());
                    return;
                } else if (response.code() == 404) {
                    Toast.makeText(context, "Could not find the user account with the specified username \n Please try again", Toast.LENGTH_LONG);
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(context, "Failed to connect to the server \n Please check the internet connection of your device", Toast.LENGTH_LONG);

            }
        });

        return retrievedUser[0];
    }

    public void updateUser(int userID, User updateUser) {
        RetrofitServices service = RetrofitClientInstance.getRetrofitInstance(context).create(RetrofitServices.class);

        String token  = ""; //preferences.getString("TOKEN",null);
        Call<User> call = service.updateUser(token,userID, updateUser);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(context, "Failed to connect to the server \n Please check the internet connection of your device", Toast.LENGTH_LONG);

            }
        });
    }

    public void deleteUser(int userID) {

        RetrofitServices service = RetrofitClientInstance.getRetrofitInstance(context).create(RetrofitServices.class);

        String token  = ""; //preferences.getString("TOKEN",null);
        Call<Void> call = service.deleteUser(token,userID);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.code() == 204) {
                    Toast.makeText(context, "Your account was successfully deleted", Toast.LENGTH_LONG);
                    return;
                } else if (response.code() == 500) {
                    Toast.makeText(context, "An error occurred when trying to delete account \n Please try again", Toast.LENGTH_LONG);
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toast.makeText(context, "Failed to connect to the server \n Please check the internet connection of your device", Toast.LENGTH_LONG);
            }
        });

    }

    public void searchUser(String username) {
        RetrofitServices service = RetrofitClientInstance.getRetrofitInstance(context).create(RetrofitServices.class);

        String token  = ""; //preferences.getString("TOKEN",null);
        Call<UserList> call = service.searchUser(token,username);

        call.enqueue(new Callback<UserList>() {
            @Override
            public void onResponse(Call<UserList> call, Response<UserList> response) {
                if (response.code() == 200) {
                    Toast.makeText(context, "User account was found", Toast.LENGTH_LONG);
                    return;
                } else if (response.code() == 404) {
                    Toast.makeText(context, "Could not find the user account with the specified username \n Please try again", Toast.LENGTH_LONG);
                }
            }

            @Override
            public void onFailure(Call<UserList> call, Throwable t) {
                Toast.makeText(context, "Failed to connect to the server \n Please check the internet connection of your device", Toast.LENGTH_LONG);

            }
        });
    }

    public void resetPassoword(int userID){
        RetrofitServices service = RetrofitClientInstance.getRetrofitInstance(context).create(RetrofitServices.class);

        String token  = ""; //preferences.getString("TOKEN",null);
        service.resetPassword(token,userID);
    };
}
