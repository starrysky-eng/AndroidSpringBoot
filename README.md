# AndroidSpringBoot
### **SpringBoot Connect To MySql**

自动生成表

@Entity 用Entity修饰实体类并同时根据类中的成员变数生成表与列 表名自动以类名显示

**要达到以上操作还需要以下几点**

1. application.properties文件中的设置必须要有以下几点

```jsx
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update
```

 2.  启动类

```jsx
@EntityScan(basePackages = ["com.example.DIM.model"])
```

### Android Connect To SpringBoot Use RetrofitLibrary（レトロフィット）

封装　カプセル化

dataのcreate update read delete を一つのinterfaceとして定義し、レトロフィットのcreate関数でinterfaceを実装し、interfaceのエンティティが戻り値として、実際の機能を持つようにまりました。このエンティティのエンキュー関数を使ってspringbootのcontrollerの中の関数を呼び出す

接続方：SpringBootと接続なので、まずアンドロイド側でもSpringBootと同じくデーターエンティティクラスとCURD interfaceを作る、次は**レトロフィット**実体を作成し、ドットCreate関数にCURD interfaceを引数として渡して、interface型のエンティティがreturnされる、このinterface型の**エンティティ**を使って**エンキュー**中のcallback
### JAVA 
```java
public class WeatherRepositoryImplRetrofit2 implements WeatherRepository {
public static final String TAG = WeatherRepositoryImplRetrofit2.class.getSimpleName();
private final WeatherService service;

public WeatherRepositoryImplRetrofit2() {
    final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(new Uri.Builder().scheme(SCHEME).authority(AUTHORITY).build().toString())
            .client(new OkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    service = retrofit.create(WeatherService.class);
}

@Override
public void getWeather(final RequestCallback callback) {
    service.getWeather(130010).enqueue(new Callback<Weather>() {
        @Override
        public void onResponse(Call<Weather> call, Response<Weather> response) {
            Log.d(TAG, "result: " + response.body().toString());
            callback.success(response.body());
        }

        @Override
        public void onFailure(Call<Weather> call, Throwable error) {
            callback.error(error);
        }
    });
}

private interface WeatherService {
    @GET(PATH)
    Call<Weather> getWeather(@Query("city") int city);
}
}
```
### KOTLIN
```kotlin
class RetrofitEntity {
        val retrofit: Retrofit by lazy {
        Retrofit.Builder().apply {
            baseUrl("http://192.168.2.101:8090")
            addConverterFactory(GsonConverterFactory.create(Gson()))
        }.build()
    }
}

interface CallBackEndAPI {
    @POST("/DIM/save")
    fun save(@Body dimModel: DIMModel):Call<Void>
}

class DIMModel {
    val id = 0
    var name = ""
    var password = ""
}

val name = binding.editTextNumber2.text.toString()
val passWord = binding.editTextTextPassword.text.toString()
val userMessage = DIMModel()

userMessage.name = name
userMessage.password = passWord

val retrofitEntity = RetrofitEntity()
val callBackEndAPI = **retrofitEntity.retrofit.create(CallBackEndAPI::class.java)**

callBackEndAPI.save(userMessage)
              .**enqueue**(object: Callback<**Void**>{
               override fun onResponse(call: Call<**Void**>, response: Response<**Void**>) {
                   Toast.makeText(activity,"Save Successful!!",Toast.LENGTH_SHORT).show()
               }

               override fun onFailure(call: Call<**Void**>, t: Throwable) {
                   Toast.makeText(activity,"Save Failed!!",Toast.LENGTH_SHORT).show()
                   Logger.getLogger(CallBackEndAPI::class.java.name).log(Level.SEVERE,"Error",t)
               }
           })
