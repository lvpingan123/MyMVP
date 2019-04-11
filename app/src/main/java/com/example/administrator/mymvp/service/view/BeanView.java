package com.example.administrator.mymvp.service.view;

import com.example.administrator.mymvp.service.entity.Bean;

public interface BeanView extends View {
    void onSuccess(Bean bean);
    void onError(String error);
}
