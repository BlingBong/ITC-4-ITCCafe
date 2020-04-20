package com.example.itccafe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnTambahSticky, btnKurangSticky, btnTambahMi, btnKurangMi, btnTambahMiras, btnKurangMiras, btnBuy, btnReset;
    TextView tvJumlahSticky, tvJumlahMi, tvJumlahMiras, tvHarga, tvPurchased;

    int jumlahSticky = 0;
    int jumlahMi = 0;
    int jumlahMiras = 0;
    int totalHarga = 0;
    final int HARGA_STICKY = 100;
    final int HARGA_MI = 13000;
    final int HARGA_MIRAS = 69000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTambahSticky = findViewById(R.id.btn_tambahsticky);
        btnKurangSticky = findViewById(R.id.btn_kurangsticky);
        btnTambahMi = findViewById(R.id.btn_tambahmi);
        btnKurangMi = findViewById(R.id.btn_kurangmi);
        btnTambahMiras = findViewById(R.id.btn_tambahmiras);
        btnKurangMiras = findViewById(R.id.btn_kurangmiras);
        btnBuy = findViewById(R.id.btn_buy);
        btnReset = findViewById(R.id.btn_reset);

        tvJumlahSticky = findViewById(R.id.tv_jumlahsticky);
        tvJumlahMi = findViewById(R.id.tv_jumlahmi);
        tvJumlahMiras = findViewById(R.id.tv_jumlahmiras);
        tvHarga = findViewById(R.id.tv_harga);
        tvPurchased = findViewById(R.id.tv_purchased);

        btnTambahSticky.setOnClickListener(this);
        btnKurangSticky.setOnClickListener(this);
        btnTambahMi.setOnClickListener(this);
        btnKurangMi.setOnClickListener(this);
        btnTambahMiras.setOnClickListener(this);
        btnKurangMiras.setOnClickListener(this);
        btnBuy.setOnClickListener(this);
        btnReset.setOnClickListener(this);

        tvPurchased.setText("");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_tambahsticky:
                //operasinya disini
                tambahPesanan(R.id.btn_tambahsticky);
                break;
            case R.id.btn_kurangsticky:
                kurangPesanan(R.id.btn_kurangsticky);
                break;
            case R.id.btn_tambahmi:
                tambahPesanan(R.id.btn_tambahmi);
                break;
            case R.id.btn_kurangmi:
                kurangPesanan(R.id.btn_kurangmi);
                break;
            case R.id.btn_tambahmiras:
                tambahPesanan(R.id.btn_tambahmiras);
                break;
            case R.id.btn_kurangmiras:
                kurangPesanan(R.id.btn_kurangmiras);
                break;
            case R.id.btn_buy:
                tvPurchased.setText("Purchased");
                break;
            case R.id.btn_reset:
                reset();
                break;
        }
    }

    void reset(){
        jumlahSticky = 0;
        jumlahMi = 0;
        jumlahMiras = 0;
        totalHarga = 0;

        tvJumlahSticky.setText("0");
        tvJumlahMi.setText("0");
        tvJumlahMiras.setText("0");
        tvHarga.setText("Rp.0");
        tvPurchased.setText("");
    }

    void tambahPesanan(int asal){
        if(asal == R.id.btn_tambahsticky) {
            if (jumlahSticky < 10) {
                jumlahSticky++;
                totalHarga = totalHarga + HARGA_STICKY;

                tvJumlahSticky.setText("" + jumlahSticky);
                tvHarga.setText("Rp." + totalHarga);
            }
        }

        if(asal == R.id.btn_tambahmi) {
            if (jumlahMi < 10) {
                jumlahMi++;
                totalHarga = totalHarga + HARGA_MI;

                tvJumlahMi.setText("" + jumlahMi);
                tvHarga.setText("Rp." + totalHarga);
            }
        }

        if(asal == R.id.btn_tambahmiras) {
            if (jumlahMiras < 10) {
                jumlahMiras++;
                totalHarga = totalHarga + HARGA_MIRAS;

                tvJumlahMiras.setText("" + jumlahMiras);
                tvHarga.setText("Rp." + totalHarga);
            }
        }
    }

    void kurangPesanan(int asal){
        if(asal == R.id.btn_kurangsticky) {
            if (jumlahSticky > 0) {
                jumlahSticky--;
                totalHarga = totalHarga - HARGA_STICKY;

                tvJumlahSticky.setText("" + jumlahSticky);
                tvHarga.setText("Rp." + totalHarga);
            }
        }

        if(asal == R.id.btn_kurangmi) {
            if (jumlahMi > 0) {
                jumlahMi--;
                totalHarga = totalHarga - HARGA_MI;

                tvJumlahMi.setText("" + jumlahMi);
                tvHarga.setText("Rp." + totalHarga);
            }
        }

        if(asal == R.id.btn_kurangmiras) {
            if (jumlahMiras > 0) {
                jumlahMiras--;
                totalHarga = totalHarga - HARGA_MIRAS;

                tvJumlahMiras.setText("" + jumlahMiras);
                tvHarga.setText("Rp." + totalHarga);
            }
        }
    }
}
