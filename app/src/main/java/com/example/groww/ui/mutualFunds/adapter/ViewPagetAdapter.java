package com.example.groww.ui.mutualFunds.adapter;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.groww.ui.mutualFunds.DashboardFragment;
import com.example.groww.ui.mutualFunds.ExploreFragment;

public class ViewPagetAdapter extends FragmentStateAdapter {

    public ViewPagetAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new ExploreFragment();
            case 1:
                return new DashboardFragment();
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}


/*
Api Key :- 76DZ0JFNCT1X89C4
 */