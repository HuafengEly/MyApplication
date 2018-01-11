package com.example.administrator.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Log.d("MainActivity启动了","Task id is "+getTaskId());
        setContentView(R.layout.first_layout);  //给当前活动加载一个布局
        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*
                启动活动的最佳写法
                 */
                SecondActivity.actionStart(MainActivity.this,"data1","data2");


                //Toast.makeText(MainActivity.this,"You clicked Button 1",Toast.LENGTH_SHORT).show();
                //finish(); //销毁活动
                /*
                使用显式intent启动活动

                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);*/

                /*
                使用隐式intent启动活动

                Intent intent = new Intent("com.example.administrator.myapplication.ACTION_START");
                intent.addCategory("com.example.administrator.myapplication.MY_CATEGORY");
                startActivity(intent);*/

                /*
                启动系统浏览器打开百度

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);*/

                /*
                使用intent调用拨号界面拨打10086

                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);*/

                /*
                使用intent传递数据

                String data = "Hello SecondActivity";
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("extra_data",data);
                startActivity(intent);*/

                /*
                数据返回给上一个活动
                启动
                接收参数

                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivityForResult(intent ,1);*/

                /*
                探究活动的启动模式

                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);*/
            }
        });
    }

    @Override
    /*
    接收result的数据
     */
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 1:
                if (resultCode == RESULT_OK){
                    String returndDara = data.getStringExtra("data_return");
                    Log.d("MainActivity",returndDara);
                }
                break;
            default:
        }
    }

    @Override
    /*
    让菜单显示出来
     */
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this,"You clicked Add",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this,"You clicked Remove",Toast.LENGTH_SHORT).show();
                break;
            default:
        }
    return true;
    }
}
