package com.product.bj.calendar_giant_version;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class CalendarFragment extends Fragment
{
    int calendarPositonCount;

    public CalendarFragment (int inputCalendarPositonCount , int inputPageHeight , int inputPageWidth , String inputPackageName , Context inputContext)
    {
        calendarPositonCount = inputCalendarPositonCount;
        pageHeight = inputPageHeight;
        pageWidth = inputPageWidth;
        packageName = inputPackageName;
        context = inputContext;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View returnCalendarFragment = inflater.inflate(R.layout.fragment_calendar , container , false);
        calendarFragment = returnCalendarFragment;

        //TODO 調整DayBlock的width,height
        setDefaultRowWidthHeight();
        setCalendarRowHeight();

        return returnCalendarFragment;
    }


    //要使用的View
    View calendarFragment;

    //要使用的packageName
    String packageName;

    //要使用的context
    Context context;

    //TODO 基本數值
    int pageHeight;
    int pageWidth;

    //DayBlock的各項數值
    int defaultRowHeight;
    int dayBlockCommonHeight;
    int dayBlockCommonWidth;

    //TODO 實做調整CalendarPage的版面
    private void setDefaultRowWidthHeight()
    {
        int commonWidth = (int)(pageWidth/7); //前面6個dayBlock都使用commonWidth
        int commonHeight = (int)(pageHeight*0.059);

        RelativeLayout sundayDayBlock = (RelativeLayout)calendarFragment.findViewById(R.id.Sunday);
        ViewGroup.LayoutParams params1 = sundayDayBlock.getLayoutParams();
        params1.width = commonWidth;
        params1.height = commonHeight;
        sundayDayBlock.setLayoutParams(params1);

        RelativeLayout mondayDayBlock = (RelativeLayout)calendarFragment.findViewById(R.id.Monday);
        ViewGroup.LayoutParams params2 = mondayDayBlock.getLayoutParams();
        params2.width = commonWidth;
        params2.height = commonHeight;
        mondayDayBlock.setLayoutParams(params1);

        RelativeLayout tuesdayDayBlock = (RelativeLayout)calendarFragment.findViewById(R.id.Tuesday);
        ViewGroup.LayoutParams params3 = tuesdayDayBlock.getLayoutParams();
        params3.width = commonWidth;
        params3.height = commonHeight;
        tuesdayDayBlock.setLayoutParams(params3);

        RelativeLayout wednesdayDayBlock = (RelativeLayout)calendarFragment.findViewById(R.id.Wednesday);
        ViewGroup.LayoutParams params4 = wednesdayDayBlock.getLayoutParams();
        params4.width = commonWidth;
        params4.height = commonHeight;
        wednesdayDayBlock.setLayoutParams(params4);

        RelativeLayout thursdayDayBlock = (RelativeLayout)calendarFragment.findViewById(R.id.Thursday);
        ViewGroup.LayoutParams params5 = thursdayDayBlock.getLayoutParams();
        params5.width = commonWidth;
        params5.height = commonHeight;
        thursdayDayBlock.setLayoutParams(params5);

        RelativeLayout fridayDayBlock = (RelativeLayout)calendarFragment.findViewById(R.id.Friday);
        ViewGroup.LayoutParams params6 = fridayDayBlock.getLayoutParams();
        params6.width = commonWidth;
        params6.height = commonHeight;
        fridayDayBlock.setLayoutParams(params6);

        RelativeLayout saturdayDayBlock = (RelativeLayout)calendarFragment.findViewById(R.id.Saturday);
        ViewGroup.LayoutParams params7 = saturdayDayBlock.getLayoutParams();
        params7.width = pageWidth - commonWidth*6;
        params7.height = commonHeight;
        saturdayDayBlock.setLayoutParams(params7);

        dayBlockCommonWidth = commonWidth;
        defaultRowHeight = commonHeight;
    }

    private void setCalendarRowHeight()
    {
        int commonHeight = (int)(pageHeight*0.941/6);
        dayBlockCommonHeight = commonHeight;

        String IDfoo;

        for(int i=1; i<=35; ++i)
        {
            IDfoo = "DayBlock"+Integer.toString(i);
            int resID = getResources().getIdentifier(IDfoo,"id",getActivity().getPackageName());
            RelativeLayout dayBlock = (RelativeLayout)calendarFragment.findViewById(resID);
            ViewGroup.LayoutParams dayBlockParams = dayBlock.getLayoutParams();
            dayBlockParams.height = commonHeight;
        }

        commonHeight = pageHeight - defaultRowHeight - dayBlockCommonHeight*5;

        for(int i=36; i<=42; ++i)
        {
            IDfoo = "DayBlock"+Integer.toString(i);
            int resID = getResources().getIdentifier(IDfoo,"id",getActivity().getPackageName());
            RelativeLayout dayBlock = (RelativeLayout)calendarFragment.findViewById(resID);
            ViewGroup.LayoutParams dayBlockParams = dayBlock.getLayoutParams();
            dayBlockParams.height = commonHeight;
        }

    }
}
