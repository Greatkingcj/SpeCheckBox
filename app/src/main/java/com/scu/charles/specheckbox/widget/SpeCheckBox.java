package com.scu.charles.specheckbox.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import com.scu.charles.specheckbox.R;

/**
 * Created by charles on 2016/7/12.
 */
public class SpeCheckBox extends LinearLayout{

    private LinearLayout ll_checkbox1;
    private LinearLayout ll_checkbox2;
    private LinearLayout ll_checkbox3;
    private CheckBox cb_checkbox1;
    private CheckBox cb_checkbox2;
    private CheckBox cb_checkbox3;
    //返回选择的状态
    private int state=2;

    public SpeCheckBox(Context context) {
        super(context);
        initView(context);
    }

    public SpeCheckBox(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public SpeCheckBox(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    /**
     * 初始化试图
     */
    private void initView(Context context){
        View.inflate(context, R.layout.chose_checkbox_view, this);
        ll_checkbox1 = (LinearLayout) this.findViewById(R.id.ll_checkbox1);
        ll_checkbox2 = (LinearLayout) this.findViewById(R.id.ll_checkbox2);
        ll_checkbox3 = (LinearLayout) this.findViewById(R.id.ll_checkbox3);
        cb_checkbox1 =(CheckBox) this.findViewById(R.id.cb_checkbox1);
        cb_checkbox2 =(CheckBox) this.findViewById(R.id.cb_checkbox2);
        cb_checkbox3 =(CheckBox) this.findViewById(R.id.cb_checkbox3);

        cb_checkbox1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if(cb_checkbox1.isChecked()){
                    cb_checkbox2.setChecked(true);
                    cb_checkbox3.setChecked(true);
                    state=2;
                }else{
                    cb_checkbox2.setChecked(false);
                    cb_checkbox3.setChecked(false);
                    state=2;
                }
            }
        });
        cb_checkbox2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if(cb_checkbox2.isChecked()){
                    if(cb_checkbox3.isChecked()){
                        cb_checkbox1.setChecked(true);
                        state=2;
                    }
                    else{
                        cb_checkbox1.setChecked(false);
                        state = 0;
                    }
                }else{
                    cb_checkbox1.setChecked(false);
                    if(cb_checkbox3.isChecked()){
                        state = 1;
                    }else{
                        state = 2;
                    }

                }
            }
        });

        cb_checkbox3.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if(cb_checkbox3.isChecked()){
                    if(cb_checkbox2.isChecked()){
                        cb_checkbox1.setChecked(true);
                        state =2;
                    }
                    else{
                        cb_checkbox1.setChecked(false);
                        state=1;
                    }
                }else{
                    cb_checkbox1.setChecked(false);
                    if(cb_checkbox2.isChecked()){
                        state = 0;
                    }else{
                        state = 2;
                    }

                }
            }
        });
    }

    public int getState(){
        return state;
    }

}
