package com.example.lee.camera_demo;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import com.example.lee.camera_demo.model.PermissionFail;
import com.example.lee.camera_demo.model.PermissionSuccess;
import com.example.lee.camera_demo.util.PermissionUtil;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
/**
 * 开发6.0+权限时遇到的坑，网上找了好多方法，最终写成demo帮助理解
 * */
public class MainActivity extends AppCompatActivity {
    private final int PER_CAMERA = 3;
    @Bind(R.id.btn_camera)
    Button btnCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_camera)
    public void onViewClicked() {
        PermissionUtil.needPermission(this,PER_CAMERA, Manifest.permission.CAMERA);
    }
    @PermissionSuccess(requestCode = PER_CAMERA)
    private void grantPermissionSuccess(){
        Toast.makeText(this,"已开启相机权限",Toast.LENGTH_SHORT).show();
    }

    @PermissionFail(requestCode = PER_CAMERA)
    private void grantPersmissionFail(){
        Toast.makeText(this,"照相机权限被拒绝",Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        PermissionUtil.onRequestPermissionsResult(this,requestCode,permissions,grantResults);
    }
}
