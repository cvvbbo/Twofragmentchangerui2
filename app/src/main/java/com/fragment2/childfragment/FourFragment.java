package com.fragment2.childfragment;

import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.fragment2.BaseFragment;
import com.fragment2.Myinterface;
import com.fragment2.R;
import com.fragment2.bean.clickbean;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by xiong on 2017/12/12.
 */

public class FourFragment extends BaseFragment {

    private String localname=null;


    private Button bt;

    public static Myinterface.changerThirdFragment  changerThirdFragment;

    //因为这个调用了别人家的方法，所以在别人家的类里面要初始化一下！！
    public static void getThirdFragment(Myinterface.changerThirdFragment changerThirdFragment){
        FourFragment.changerThirdFragment=changerThirdFragment;
    }


    @Override
    public int getlayout() {
        return R.layout.fragment_four;
    }




    @Override
    public void initview() {
        Log.e("--当前的类名是--",getClass().getSimpleName());
        localname=getClass().getSimpleName();

        //这个方法能注释掉是因为thirdFragment方法没有调用Fourfragment里面的方法
       //ThirdFragment.getFourFragment(this);

        bt = (Button) view.findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //1.怎么拿到上一个view的控件？
                //getChildFragmentManager().popBackStack(0);

                Log.e("---",localname);
               EventBus.getDefault().post(new clickbean(localname));

                changerThirdFragment.ThirdFragmentCallback();

            }
        });

    }


}
