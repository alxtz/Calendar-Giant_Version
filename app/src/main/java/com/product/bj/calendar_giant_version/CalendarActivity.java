package com.product.bj.calendar_giant_version;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class CalendarActivity extends AppCompatActivity
{
    //TODO 基本數值
    int screenWidth;
    int screenHeight;
    int statusBarHeight;
    int useHeight;

    //TODO 設定的數值
    int topBarHeight;
    int bottomBarHeight;
    int calendarViewPagerHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        Log.d("CalendarLog","This is Calendar Activity");

        //TODO 需要取得的數值:螢幕長寬,statusBar的height,useHeight
        getScreenSize();
        getStatusBarHeight();
        useHeight = screenHeight - statusBarHeight;

        //TODO 設定topBar的height,calendarView的height
        setTopBottomBarHeight();
        setCalendarViewPagerHeight();
    }

    private void getScreenSize()
    {
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        screenHeight = metrics.heightPixels;
        screenWidth = metrics.widthPixels;
        Log.d("CalendarLog" , "Screen height is : "+screenHeight);
        Log.d("CalendarLog" , "Screen width is : "+screenWidth);
    }

    private void getStatusBarHeight()
    {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0)
        {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        Log.d("CalendarLog" , "Height of status bar : "+result);
        statusBarHeight = result;
    }

    private void setTopBottomBarHeight()
    {
        int commonTopBottomBarHeight = (int)(useHeight*0.1);

        RelativeLayout topBar = (RelativeLayout) findViewById(R.id.TopBar);
        ViewGroup.LayoutParams topParams = topBar.getLayoutParams();
        topParams.height = commonTopBottomBarHeight;
        topBar.setLayoutParams(topParams);

        RelativeLayout bottomBar = (RelativeLayout) findViewById(R.id.BottomBar);
        ViewGroup.LayoutParams bottomParams = bottomBar.getLayoutParams();
        bottomParams.height = commonTopBottomBarHeight;
        bottomBar.setLayoutParams(bottomParams);

        topBarHeight = commonTopBottomBarHeight;
        bottomBarHeight = commonTopBottomBarHeight;
    }

    private void setCalendarViewPagerHeight()
    {
        int calendarVPHeight = (int)(useHeight*0.8);

        ViewPager calendarViewPager = (ViewPager)findViewById(R.id.CalendarViewPager);
        ViewGroup.LayoutParams calendarViewPagerParams = calendarViewPager.getLayoutParams();
        calendarViewPagerParams.height = calendarVPHeight;
        calendarViewPager.setLayoutParams(calendarViewPagerParams);

        calendarViewPagerHeight = calendarVPHeight;
    }
}
