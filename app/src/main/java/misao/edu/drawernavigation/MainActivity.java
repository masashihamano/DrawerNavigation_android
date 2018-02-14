package misao.edu.drawernavigation;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout ;
    ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        drawerLayout = (DrawerLayout) findViewById( R.id.dl );

        actionBarDrawerToggle = new ActionBarDrawerToggle( MainActivity.this,drawerLayout,R.string.open,R.string.close );

        //falseにすると左上のtoggleが無効になる、消去しても作動する
        actionBarDrawerToggle.setDrawerIndicatorEnabled( true );

        //ハンバーガーを矢印に変更する、削除しても作動するがハンバーガーのまま
        drawerLayout.addDrawerListener( actionBarDrawerToggle );

        //矢印をハンバーガーに変更する、削除しても作動するが矢印のまま
        actionBarDrawerToggle.syncState();

        //falseにするとtoggleが表示されない、削除してもtoggleが表示されないが作動する
        getSupportActionBar().setDisplayHomeAsUpEnabled( true );

        NavigationView navigationView = (NavigationView) findViewById( R.id.nav_view );
        navigationView.setNavigationItemSelectedListener( new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.myprofile) {
                    Toast.makeText( MainActivity.this, "My Profile", Toast.LENGTH_SHORT ).show();
                }
                else if (id==R.id.mysettings)
                {
                    Toast.makeText( MainActivity.this,"settings",Toast.LENGTH_SHORT ).show();
                }
                else  if (id==R.id.mycheck)
                {
                    Toast.makeText( MainActivity.this,"check",Toast.LENGTH_SHORT ).show();
                }
                return false;
            }
        } );

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        return actionBarDrawerToggle.onOptionsItemSelected( item );
    }

}

/*
・main.xmlに id「android:id="@+id/dl"」　をつける
・build.gradle(project)のallprojectsに以下を追加→sync now
--------
maven {
    url 'https://maven.google.com'
}
--------
・build.gradle(Module)のdependenciesに以下の2つを追加→sync now
------
compile 'com.android.support:design:26.1.0'
compile 'de.hdodenhof:circleimageview:2.2.0'
------
・main.xmlをConstraintLayoutからDrawerLayout書き換える
・main.xmlにてNavigationViewを作成

・res→New→Directory→menuを作成、そのmenuの中にresourceファイル(navigation_menu.xml)を作成
・layoutの中にresourceファイル(navigation_header.xml)を作成
・res→drawable→New→VectorAssetからアイコンを作る

・navigation_header.xmlをConstraintLayoutからLinearLayoutに書き換える
・navigation_header.xmlの中に<de.hdodenhof.circleimageview.CircleImageViewを入れる

・navigation_menu.xmlに各アイコンのid,title,icon名をitemで作成

・res→values→string.xmlを開いて"open","close"を設定

 */