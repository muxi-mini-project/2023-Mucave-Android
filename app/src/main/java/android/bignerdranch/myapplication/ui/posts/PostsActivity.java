package android.bignerdranch.myapplication.ui.posts;

import android.bignerdranch.myapplication.ReusableTools.BaseActivity;
import android.bignerdranch.myapplication.R;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;


public class PostsActivity extends BaseActivity {
    public static Intent newIntent(Context packageContext) {
        Intent intent = new Intent(packageContext, PostsActivity.class);
        return intent;
    }

    protected Fragment createFragment() {
        return new PostsFragment();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_posts);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.layout_home);//此处为layout_home的id
        if (fragment == null) {//即如果posts_fragment为空，创建一个
            fragment = createFragment();
            fm.beginTransaction()
                    .add(R.id.layout_home, fragment)
                    .commit();
        }
    }
}